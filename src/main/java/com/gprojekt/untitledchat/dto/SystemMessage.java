package com.gprojekt.untitledchat.dto;

/**
 * Created by Jochen on 01.02.14.
 */
public class SystemMessage {
    private String username;
    private String message;

    public SystemMessage() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
