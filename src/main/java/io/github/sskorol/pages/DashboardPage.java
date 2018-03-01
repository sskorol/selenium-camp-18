package io.github.sskorol.pages;

import io.github.sskorol.core.AbstractPage;
import org.openqa.selenium.By;

import static org.apache.commons.lang3.StringUtils.substringBetween;
import static org.openqa.selenium.By.cssSelector;

public class DashboardPage extends AbstractPage {

    private final By labelWelcome = cssSelector("[data-qa='welcome']");

    public String username() {
        return substringBetween(text(labelWelcome), ", ", "!");
    }
}
