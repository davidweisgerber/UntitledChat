package com.gprojekt.untitledchat.services;

import com.gprojekt.untitledchat.dao.UserDAO;
import com.gprojekt.untitledchat.entities.User;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Weisgerber
 * Date: 01.02.14
 * Time: 15:16
 * To change this template use File | Settings | File Templates.
 */
public class LoginServiceImplTest {

    private class UserFakeDAO implements UserDAO {

        @Override
        public User persist(User user) {
            return null;
        }

        @Override
        public void remove(User user) {

        }

        @Override
        public User getByUsername(String username) {
            return null;
        }

        @Override
        public User getById(long id) {
            return null;
        }
    }

    private LoginServiceImpl loginService;

    @Before
    public void setup() {
        this.loginService = new LoginServiceImpl();
        this.loginService.userDAO = null;
    }

    @Test
    public void testLogin() throws Exception {
        this.loginService.keyFactory
    }
}
