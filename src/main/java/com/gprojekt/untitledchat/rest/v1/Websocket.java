package com.gprojekt.untitledchat.rest.v1;

import com.gprojekt.untitledchat.GlobalGson;
import com.gprojekt.untitledchat.dto.*;
import com.gprojekt.untitledchat.entities.User;
import com.gprojekt.untitledchat.services.ChatService;
import com.gprojekt.untitledchat.services.LoginService;
import com.gprojekt.untitledchat.services.SystemMessageService;
import com.gprojekt.untitledchat.services.UserCache;
import org.springframework.beans.factory.annotation.Autowired;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import java.util.Map;

/**
 * Created by Jochen on 01.02.14.
 */

public class Websocket {
    @Autowired
    LoginService loginService;

    @Autowired
    SystemMessageService systemMessageService;

    @Autowired
    ChatService chatService;

    @Autowired
    UserCache userCache;

    private Map<String, User> userMap;

    public Websocket() {
    }

    @OnMessage
    public void receiveMessage(String jsonMessage, Session session) {
        Message message = GlobalGson.get().fromJson(jsonMessage, Message.class);
        User user = this.userCache.get().get(session.getId());

        switch(message.getType()) {
            case CREATE_USER:
                this.loginService.createUser(GlobalGson.get().fromJson(message.getBody(), CreateUserMessage.class), session);
                break;
            case CREATE_USER_RETURN:
                throw new RuntimeException("Message type not supported");
            case NEED_CHALLENGE:
                this.loginService.needChallenge(message.getBody(), session);
                break;
            case CHALLENGE:
                throw new RuntimeException("Message type not supported");
            case LOGIN:
                this.loginService.login(message.getBody(), user);
                break;
            case LOGIN_RETURN:
                throw new RuntimeException("Message type not supported");
            case MESSAGE_SUBSCRIBE:
                SubscribeMessage subscribeMessage = GlobalGson.get().fromJson(message.getBody(), SubscribeMessage.class);
                this.systemMessageService.subscribe(subscribeMessage.getLastSystemMessageId(), user);
                this.chatService.subscribe(subscribeMessage.getChatsSubscriptions(), user);
                break;
            case SYSTEM_MESSAGE:
                this.systemMessageService.message(GlobalGson.get().fromJson(message.getBody(), SystemMessage.class), user);
                break;
            case CHAT_MESSAGE:
                this.chatService.message(GlobalGson.get().fromJson(message.getBody(), ChatMessage.class), user);
                break;
            case CREATE_CHAT:
                this.chatService.createChat(user);
                break;
            case CREATE_CHAT_RESPONSE:
                throw new RuntimeException("Message type not supported");
        }
    }
}
