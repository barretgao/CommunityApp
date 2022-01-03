package com.yipu.communityapp.dao;

import com.yipu.communityapp.entity.Event;
import com.yipu.communityapp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


@Repository
public class EventDao {
    @Autowired
    SessionFactory sessionFactory;

    public void saveEvent(Event event){
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(event);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if(session !=null) {
                session.close();
            }
        }
    }

    public List<Event> getEvent(String email) {
        Session session = sessionFactory.openSession();
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Event> cq = cb.createQuery(Event.class);
            cq.from(Event.class);
            return session.createQuery(cq).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    public List<Event> getEventByType(String type) {
        Session session = sessionFactory.openSession();
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Event> cq = cb.createQuery(Event.class);
            Root<Event> root = cq.from(Event.class);
            cq.select(root).where(cb.like(root.get("type"), type));
            Query<Event> query = session.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Event> getEventByTitle(String title) {
        Session session = sessionFactory.openSession();
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Event> cq = cb.createQuery(Event.class);
            Root<Event> root = cq.from(Event.class);
            cq.select(root).where(cb.like(root.get("title"), "%" + title + "%"));
            Query<Event> query = session.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public boolean edit(String email, int eid, Event newEvent) {
        boolean successEdit = false;

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Event event = session.get(Event.class, eid);
            if (event != null && event.getUser().getEmail().equals(email)) {
                event.replace(newEvent);
                successEdit = true;
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return successEdit;
    }
}
