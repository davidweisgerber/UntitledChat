package com.gprojekt.untitledchat.dto;

import java.util.Date;

/**
 * Created by Jochen on 01.02.14.
 */
public class SubscribeMessage {
    private long lastSystemMessageId;
    private SubscribeChatMessage[] chatsSubscriptions;

    public SubscribeMessage() {
    }

    public long getLastSystemMessageId() {
        return lastSystemMessageId;
    }

    public void setLastSystemMessageId(long lastSystemMessageId) {
        this.lastSystemMessageId = lastSystemMessageId;
    }

    public SubscribeChatMessage[] getChatsSubscriptions() {
        return chatsSubscriptions;
    }

    public void setChatsSubscriptions(SubscribeChatMessage[] chatsSubscriptions) {
        this.chatsSubscriptions = chatsSubscriptions;
    }
}
