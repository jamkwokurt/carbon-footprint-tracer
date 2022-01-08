package com.example.carbonfootprint.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String username;

    public LoggedInUser(String username) {
        this.username = username;

    }

    public String getUsernameame() {
        return username;
    }
}