package com.example;

public class User {
    private String username;
    private boolean authenticated;

    public User(String username) {
        this.username = username;
        this.authenticated = false;
    }

    public void login() {
        this.authenticated = true;
        System.out.println("Usuario " + username + " ha iniciado sesión.");
    }

    public void logout() {
        this.authenticated = false;
        System.out.println("Usuario " + username + " ha cerrado sesión.");
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getUsername() {
        return username;
    }
}
