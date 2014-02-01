package com.gprojekt.untitledchat.dto;

/**
 * Created by Jochen on 01.02.14.
 */
public class ChatMessage {
    private long chatId;
    private String message;

    public ChatMessage() {
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
