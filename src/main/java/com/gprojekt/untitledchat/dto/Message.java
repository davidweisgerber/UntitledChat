package com.gprojekt.untitledchat.dto;

import com.gprojekt.untitledchat.GlobalGson;

/**
 * Created by Jochen on 01.02.14.
 */
public class Message {
    private MessageType type;
    private String body;

    public Message() {
    }

    public Message(MessageType type,String body) {
        this.type = type;
        this.body = body;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getJson(){
        return GlobalGson.get().toJson(this, Message.class);
    }
}
