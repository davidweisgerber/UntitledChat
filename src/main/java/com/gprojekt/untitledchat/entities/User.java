package com.gprojekt.untitledchat.entities;

import javax.persistence.*;

/**
 * Created by Jochen on 01.02.14.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique=true)
    private String username;

    @Lob
    private String base64PublicKey;

    public User(String username, String base64PublicKey) {
        this.username = username;
        this.base64PublicKey = base64PublicKey;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBase64PublicKey() {
        return base64PublicKey;
    }

    public void setBase64PublicKey(String base64PublicKey) {
        this.base64PublicKey = base64PublicKey;
    }
}
