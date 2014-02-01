package com.gprojekt.untitledchat.dao;

import com.gprojekt.untitledchat.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
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

    @Test
    @Transactional
    public void testPersist() throws Exception {
        User user = new User("username", "password");
        user = this.userDAO.persist(user);

        assertTrue(user.getId() > 0);
    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testGetByUsername() throws Exception {

    }

    @Test
    public void testGetById() throws Exception {

    }
}
