package com.gprojekt.untitledchat.dao;

import com.gprojekt.untitledchat.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Weisgerber
 * Date: 01.02.14
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/db-test.spring.xml")
public class UserJPADAOTest {
    @Autowired
    private UserJPADAO userDAO;

    public static User getUser() {
        return new User("username", "password");
    }

    @Test
    @Transactional
    public void testPersist() throws Exception {
        User user = this.userDAO.persist(getUser());

        assertTrue(user.getId() > 0);
    }

    @Test
    @Transactional
    public void testRemove() throws Exception {
        User user = this.userDAO.persist(getUser());
        this.userDAO.remove(user);
        assertTrue(this.userDAO.getById(user.getId()) == null);
    }

    @Test
    @Transactional
    public void testGetByUsername() throws Exception {
        User user = this.userDAO.persist(getUser());

        assertTrue(this.userDAO.getByUsername(user.getUsername()) == user);
    }

    @Test
    @Transactional
    public void testGetById() throws Exception {
        User user = this.userDAO.persist(getUser());

        assertTrue(this.userDAO.getById(user.getId()) == user);
    }
}
