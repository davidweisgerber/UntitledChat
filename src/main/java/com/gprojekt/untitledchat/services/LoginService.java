package com.gprojekt.untitledchat.services;

import com.gprojekt.untitledchat.dto.CreateUserMessage;
import com.gprojekt.untitledchat.entities.User;

import javax.websocket.Session;

/**
 * Created with IntelliJ IDEA.
 * User: Weisgerber
 * Date: 01.02.14
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
public interface LoginService {
    boolean login(String username, String password);

    void createUser(CreateUserMessage message, Session session);

    void needChallenge(String username, Session session);

    void login(String signedGUID, User user);
}
