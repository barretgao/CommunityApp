package com.yipu.communityapp.dao;

import com.yipu.communityapp.entity.Authorities;
import com.yipu.communityapp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void signUp(User user) {
        Session session = null;
        Authorities authorities = new Authorities();
        authorities.setEmail(user.getEmail());
        authorities.setAuthorities("ROLE_USER");

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }
    }

    public User getUser(String email) {
        User user = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            user = session.get(User.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return user;
    }

    public String getRole(String email) {
        User user = getUser(email);
        return user.getRole();
    }

}
