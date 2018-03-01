package io.github.sskorol.model;

import lombok.Data;

import java.util.List;

import static java.util.Collections.singletonList;

@Data
@SuppressWarnings("JavadocType")
public class User {

    private final String username;
    private final String password;
    private final List<Role> roles;

    @SuppressWarnings("MultipleStringLiterals")
    public static User admin() {
        return new User("admin", "admin", singletonList(Role.ADMIN));
    }
}
