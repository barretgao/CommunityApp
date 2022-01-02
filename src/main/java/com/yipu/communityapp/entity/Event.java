package com.yipu.communityapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "Event")
public class Event implements Serializable {

    private static final long serialVersionUID = 8436097833452420298L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eid;

    @ManyToOne
    @JsonIgnore
    private User user;

    private String title;

    private String type;

    private String postTime;
    // transfer timestamp to String, for example
    // String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

    private String info;


    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }










}
