package com.gprojekt.untitledchat.services;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Weisgerber
 * Date: 01.02.14
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
public class LoginServiceImpl implements LoginService {

    @Override
    @Transactional
    public boolean login(String username, String password) {
        return false;
    }
}
