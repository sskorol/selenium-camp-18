package io.github.sskorol.model;

import java.util.List;

import static java.util.Collections.singletonList;

public class User {

    private final String username;
    private final String password;
    private final List<Role> roles;

    public User(final String username, final String password, final List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    @SuppressWarnings("MultipleStringLiterals")
    public static User admin() {
        return new User("admin", "admin", singletonList(Role.admin));
    }
}
