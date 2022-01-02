package com.yipu.communityapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ReplyChild")
public class ReplyChild implements Serializable {
    private static final long serialVersionUID = 2455760938054036111L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonIgnore
    private ChatParent chatParent;

    private String replyTime;

    private String replyInfo;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ChatParent getChatParent() {
        return chatParent;
    }

    public void setChatParent(ChatParent chatParent) {
        this.chatParent = chatParent;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyInfo() {
        return replyInfo;
    }

    public void setReplyInfo(String replyInfo) {
        this.replyInfo = replyInfo;
    }

}