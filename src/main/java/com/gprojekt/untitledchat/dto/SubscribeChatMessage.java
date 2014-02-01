package com.gprojekt.untitledchat.dto;

/**
 * Created by Jochen on 01.02.14.
 */
public class SubscribeChatMessage {
    private long chatId;
    private long lastChatMessageId;

    public SubscribeChatMessage() {
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public long getLastChatMessageId() {
        return lastChatMessageId;
    }

    public void setLastChatMessageId(long lastChatMessageId) {
        this.lastChatMessageId = lastChatMessageId;
    }
}
