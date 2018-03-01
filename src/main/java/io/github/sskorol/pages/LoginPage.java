package io.github.sskorol.pages;

import io.github.sskorol.core.AbstractPage;
import io.github.sskorol.model.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static io.github.sskorol.core.PageFactory.at;
import static org.openqa.selenium.By.cssSelector;

@SuppressWarnings("JavadocType")
public class LoginPage extends AbstractPage {

    private final By inputUsername = cssSelector("[data-qa='username']");
    private final By inputPassword = cssSelector("[data-qa='password']");
    private final By buttonSignIn = cssSelector("[data-qa='submit']");

    @Step("Login with {user.username} / {user.password}.")
    public DashboardPage loginWith(final User user) {
        type(inputUsername, user.getUsername());
        type(inputPassword, user.getPassword());
        click(buttonSignIn);
        return at(DashboardPage.class);
    }

    @Override
    public String url() {
        return super.url() + "/login";
    }
}
