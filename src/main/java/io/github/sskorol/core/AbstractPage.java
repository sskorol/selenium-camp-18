package io.github.sskorol.core;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.github.sskorol.listeners.BaseListener.getDriverMetaData;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@SuppressWarnings("JavadocType")
public abstract class AbstractPage implements Page {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public AbstractPage() {
        this.driver = getDriverMetaData()._1;
        this.wait = getDriverMetaData()._2;
    }

    protected String text(final By locator) {
        return waitFor(locator).getText();
    }

    protected void click(final By locator) {
        waitFor(locator).click();
    }

    protected void type(final By locator, final String text) {
        waitFor(locator).sendKeys(text);
    }

    @Step("Navigate to {url}")
    @SuppressWarnings("unchecked")
    @Override
    public <T extends Page> T open(final String url) {
        driver.get(url);
        return (T) this;
    }

    private WebElement waitFor(final By locator) {
        return wait.until(visibilityOfElementLocated(locator));
    }
}
