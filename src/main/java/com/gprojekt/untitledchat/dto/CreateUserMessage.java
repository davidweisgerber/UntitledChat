package com.gprojekt.untitledchat.dto;

/**
 * Created by Jochen on 01.02.14.
 */
public class CreateUserMessage {
    private long id;
    private String base64PublicKey;

    public CreateUserMessage() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBase64PublicKey() {
        return base64PublicKey;
    }

    public void setBase64PublicKey(String base64PublicKey) {
        this.base64PublicKey = base64PublicKey;
    }
}
