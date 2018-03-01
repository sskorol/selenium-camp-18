node {
    properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')), disableConcurrentBuilds(), disableResume(), [$class: 'RebuildSettings', autoRebuild: false, rebuildDisabled: true], parameters([booleanParam(defaultValue: true, description: '', name: 'START_SERVICES')]), [$class: 'ThrottleJobProperty', categories: [], limitOneJobWithMatchingParams: false, maxConcurrentPerNode: 0, maxConcurrentTotal: 0, paramsToUseForLimit: '', throttleEnabled: false, throttleOption: 'project']])

    try {
        stage('Checkout source code') {
            checkout scm
        }

        if (params.START_SERVICES) {
            stage('Start services') {
                dock.adjustEnv("sc18")
                sh "docker-compose up -d"
            }
        }

        stage('Run quality checks and tests') {
            sh './gradlew clean checkQualityMain checkQualityTest test'
        }
    } catch (ex) {
        echo "${ex}"
        currentBuild.result = 'UNSTABLE'
    } finally {
        if (params.START_SERVICES) {
            stage('Stop services') {
                sh "docker-compose down"
            }
        }

        stage('Publish Allure report') {
            publish.allureReport()
        }

        stage('Publish quality reports') {
            publish.checkstyleReport()
            publish.pmdReport()
            publish.findbugsReport()
        }
    }
}
