package com.yipu.communityapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 2652327633296064143L;

    @Id
    private String email;

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Event> eventList;

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    // 不需要json返回？
    private List<ChatParent> chatParentList;

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    // 不需要json返回？
    private List<ReplyChild> replyChildList;

    private String firstName;

    private String lastName;

    private String password;

    private String roomNumber;

    private String phoneNumber;

    private String role;

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public List<ChatParent> getChatParentList() {
        return chatParentList;
    }

    public void setChatParentList(List<ChatParent> chatParentList) {
        this.chatParentList = chatParentList;
    }

    public List<ReplyChild> getReplyChildList() {
        return replyChildList;
    }

    public void setReplyChildList(List<ReplyChild> replyChildList) {
        this.replyChildList = replyChildList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
