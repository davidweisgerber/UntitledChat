package com.gprojekt.untitledchat.services;

import com.gprojekt.untitledchat.dao.UserDAO;
import com.gprojekt.untitledchat.dto.CreateUserMessage;
import com.gprojekt.untitledchat.dto.Message;
import com.gprojekt.untitledchat.dto.MessageType;
import com.gprojekt.untitledchat.entities.User;
import com.gprojekt.untitledchat.entities.UserState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.*;
import javax.websocket.Session;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Weisgerber
 * Date: 01.02.14
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
@Component
public class LoginServiceImpl implements LoginService {
    KeyFactory keyFactory;

    LoginServiceImpl(){
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public void createUser(CreateUserMessage message, Session session) {
        User my_user = new User(message.getUsername(),message.getBase64PublicKey());
        try {
            my_user.setUserState(UserState.LOGIN_USER);
            session.getBasicRemote().sendText((new Message(MessageType.CREATE_USER_RETURN, Long.toString(my_user.getId()))).getJson());
        } catch (IOException e) {
            my_user.setUserState(UserState.NOT_CONNECTED_USER);
            e.printStackTrace();
        }
    }

    @Override
    public void needChallenge(String username, Session session) {
        User my_user = userDAO.getByUsername(username);
        my_user.setChallenge(UUID.randomUUID().toString());
        try {
            my_user.setUserState(UserState.LOGIN_USER);
            session.getBasicRemote().sendText((new Message(MessageType.CHALLENGE, my_user.getChallenge())).getJson());
        } catch (IOException e) {
            my_user.setUserState(UserState.NOT_CONNECTED_USER);
            e.printStackTrace();
        }
    }

    @Override
    public void login(String signedGUID, User user) {
        if(user.getUserState() == UserState.LOGIN_USER){
            byte[] cipherText = null;
            if(user.getChallenge() != null){
                try {
                    byte dataPrivateKey[] = DatatypeConverter.parseBase64Binary(user.getBase64PublicKey());
                    KeySpec privateKeySpec = new PKCS8EncodedKeySpec(dataPrivateKey);
                    PublicKey key = keyFactory.generatePublic(privateKeySpec);
                    // get an RSA cipher object and print the provider
                    final Cipher cipher = Cipher.getInstance("RSA");
                    // encrypt the plain text using the public key
                    cipher.init(Cipher.ENCRYPT_MODE ,key);
                    cipherText = cipher.doFinal(signedGUID.getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(cipherText != null){
                    String planeGUID = new String(cipherText);
                    if(planeGUID.compareTo(user.getChallenge()) == 0){
                        user.setChallenge(null);
                        user.setUserState(UserState.LOGIN_USER_SUCCESS);
                    }
                }
            }
            user.setChallenge(null);
            user.setUserState(UserState.NOT_CONNECTED_USER);
        }
    }
}
