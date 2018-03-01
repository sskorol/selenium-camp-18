package io.github.sskorol.model;

import java.util.LinkedList;

import static java.util.Collections.singletonList;

public class User {

    String username;
    String password;
    LinkedList<Role> roles;

    public User(String username, String password, LinkedList<Role> roles) {
        this.username = username;
        this.password = password;
        roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LinkedList<Role> getRoles() {
        return roles;
    }

    public static User admin() {
        return new User("admin", "admin", new LinkedList<>(singletonList(Role.admin)));
    }
}
