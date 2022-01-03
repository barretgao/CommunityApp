package com.yipu.communityapp.controller;

import com.yipu.communityapp.entity.User;
import org.springframework.stereotype.Controller;
import com.yipu.communityapp.entity.Event;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import com.yipu.communityapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.PathParam;
import java.util.List;


@Controller
public class EventController {
    @Autowired
    private EventService eventService;


    /*
       save the new event into the database
     */
    @RequestMapping(value = "/event/newEvent", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addEvent(@RequestBody Event event) {
        eventService.saveEvent(event);
    }

    /*
       load event from database.
     */
    @RequestMapping(value = "/event", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> getEvent() {
        return eventService.getEvent();
    }

    /*
       edit event.
     */
    @RequestMapping(value = "/event/{eid}/edit", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean editEvent(@PathVariable("eid") int eid, @RequestBody Event event){
        return eventService.editEvent(eid, event);
    }

    /*
     search event by type
     */
    @RequestMapping(value = "/event/search/type", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Event> searchEventByType(@RequestBody String type){
        return eventService.searchEventByType(type);
    }

    /*
     search event by title
     */
    @RequestMapping(value = "/event/search/title", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Event> searchEventByUser(@RequestBody String title){
        return eventService.searchEventByTitle(title);
    }

}
