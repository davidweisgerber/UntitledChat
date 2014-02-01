package com.gprojekt.untitledchat.services;

import com.gprojekt.untitledchat.dto.ChatMessage;
import com.gprojekt.untitledchat.dto.SubscribeChatMessage;
import com.gprojekt.untitledchat.entities.User;

/**
 * Created by Jochen on 01.02.14.
 */
public interface ChatService {
    void subscribe(SubscribeChatMessage[] chatsSubscriptions, User user);

    void message(ChatMessage chatMessage, User user);

    void createChat(User user);
}
