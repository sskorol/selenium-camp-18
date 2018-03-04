![selenium camp logo](http://seleniumcamp.com/wp-content/themes/selenium/images/logo-color.svg "Selenium Camp 2018")
# Selenium Camp 2018 - The essential tools for test code quality improvement 

This project provides [talk's](https://seleniumcamp.com/talk/the-essential-tools-for-test-code-quality-improvement) demos' implementation.

## Branches

There're several branches, which may help following the main idea of the talk:
1. **step1/full-rft**: contains lots of different violiations, which could be easily detected by [gradle-quality-plugin](https://github.com/xvik/gradle-quality-plugin). Use the following command to run them all:
```
./gradlew clean checkQualityMain checkQualityTest
```
2. **step2/sonar-support**: gradle-quality-plugin was replaced with [sonarqube](https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner+for+Gradle). Only `AttachmentUtils.class` violations left to emulate failures on Jenkins. Use the following command to run Sonar checks:
```
./gradlew clean sonarqube
```
Note that you have to set the following options in `gradle.properties`, which refer to your own Sonar server:
```
systemProp.sonar.host.url=...
systemProp.sonar.login=...
```
3. **step3/fix-violations**: all issues are fixed in this branch.
4. **master**: contains just a README.

## Git hooks

All key branches contain `pre-commit` hook file, which might be automatically installed into hidden **.git/hooks** directory to execute quality checks for each user's commit. Check **gradle/install-git-hooks.gradle** file for details. By default custom `copy` task depends on `build`. However, you can use your own trigger.

## Jenkins

**Jenkinsfile** uses shared library for Allure / quality reports generation. So you have to set it up on Jenkins pointing to [shared-libraries](https://github.com/sskorol/shared-libraries) sources. Or just use direct calls to corresponding plugins in pipeline.

## Docker

For this demo Jenkins and Docker were installed on the same Windows PC. So pay attention to **docker-compose.yml**, which might be a bit different for your OS. Created **Jenkinsfile** will work with slaves as well. However, if you gonna use remote docker instance, you may want to take a look at [Docker guide for Jenkins](https://jenkins.io/doc/book/pipeline/docker) and tune some pipeline steps.

Note that you have to pull [Selenoid](https://github.com/aerokube/selenoid) containers manually.
React AUT Dockerfile for building your own image will be published soon. Stay tuned.

## React application

There was used the following AUT on demo: [recycled-login-flow](https://github.com/tinavanschelt/recycled-login-flow).
Original verision is not tuned to be used with Docker. Modified sources will be published soon. Stay tuned.
