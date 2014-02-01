package com.gprojekt.untitledchat.dao;

import com.gprojekt.untitledchat.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created with IntelliJ IDEA.
 * User: Weisgerber
 * Date: 01.02.14
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserJPADAO implements UserDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public User persist(User user) {
        return this.em.merge(user);
    }

    @Override
    public void remove(User user) {
        this.em.remove(user);
    }

    @Override
    public User getByUsername(String username) {
        TypedQuery<User> query = this.em.createQuery("from User as u where u.username = :username", User.class);
        query.setParameter("username", username);

        try {
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public User getById(long id) {
        TypedQuery<User> query = this.em.createQuery("from User as u where u.id = :id", User.class);
        query.setParameter("id", id);

        try {
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
