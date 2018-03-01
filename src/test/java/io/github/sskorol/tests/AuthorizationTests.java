package io.github.sskorol.tests;

import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.model.User;
import io.github.sskorol.pages.DashboardPage;
import io.github.sskorol.pages.LoginPage;
import org.testng.annotations.Test;

import static io.github.sskorol.core.PageFactory.at;
import static io.github.sskorol.core.PageFactory.open;
import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthorizationTests {

    @DataSupplier
    public User adminProvider() {
        return User.admin();
    }

    @Test(dataProvider = "adminProvider")
    public void shouldSignInWithAdminCredentials(final User user) {
        open(LoginPage.class)
                .loginWith(user);

        assertThat(at(DashboardPage.class).username())
                .isEqualTo(capitalize(user.getUsername()));
    }
}
