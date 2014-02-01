package com.gprojekt.untitledchat.dao;

import com.gprojekt.untitledchat.entities.User;

/**
 * Created with IntelliJ IDEA.
 * User: Weisgerber
 * Date: 01.02.14
 * Time: 15:03
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {
    User persist(User user);

    void remove(User user);

    User getByUsername(String username);

    User getById(long id);
}
