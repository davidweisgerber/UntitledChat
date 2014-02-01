package com.gprojekt.untitledchat.services;

import com.gprojekt.untitledchat.dao.UserDAO;
import com.gprojekt.untitledchat.dto.CreateUserMessage;
import com.gprojekt.untitledchat.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.websocket.Session;

/**
 * Created with IntelliJ IDEA.
 * User: Weisgerber
 * Date: 01.02.14
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public void createUser(CreateUserMessage message, Session session) {

    }

    @Override
    public void needChallenge(String username, Session session) {

    }

    @Override
    public void login(String signedGUID, User user) {

    }
}
