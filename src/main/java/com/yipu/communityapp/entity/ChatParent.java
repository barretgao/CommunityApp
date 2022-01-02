package com.yipu.communityapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ChatParent")
public class ChatParent implements Serializable {
    private static final long serialVersionUID = 7551999649936522523L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pid;

    @ManyToOne
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "ChatParent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReplyChild> replyChildList;

    private String postTime;

    private String postInfo;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getPostInfo() {
        return postInfo;
    }

    public void setPostInfo(String postInfo) {
        this.postInfo = postInfo;
    }

    public List<ReplyChild> getReplyChildList() {
        return replyChildList;
    }

    public void setReplyChildList(List<ReplyChild> replyChildList) {
        this.replyChildList = replyChildList;
    }

}
