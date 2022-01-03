package com.yipu.communityapp.service;

import com.yipu.communityapp.dao.UserDao;
import com.yipu.communityapp.dao.EventDao;

import com.yipu.communityapp.entity.Event;
import com.yipu.communityapp.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventDao eventDao;

    @Autowired
    private UserService userService;


    @Autowired
    public void saveEvent(Event event){

        //pass the security check
        Authentication loggedInuser = SecurityContextHolder.getContext().getAuthentication();

        String username = loggedInuser.getName();

        User user = userService.getUser(username);

        eventDao.saveEvent(event);
    }

    @Autowired
    public List<Event> getEvent() {
        //pass the security check
        Authentication loggedInuser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInuser.getName();
        return eventDao.getEvent(username);
    }

    @Autowired
    public boolean editEvent(int eid, Event newEvent) {
        //pass the security check
        Authentication loggedInuser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInuser.getName();
        return eventDao.edit(username, eid, newEvent);
    }

    @Autowired
    public List<Event> searchEventByType(String type) {
        return eventDao.getEventByType(type);
    }

    @Autowired
    public List<Event> searchEventByTitle(String title) {
        return eventDao.getEventByTitle(title);
    }

}
