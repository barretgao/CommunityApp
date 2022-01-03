package com.yipu.communityapp.service;

import com.yipu.communityapp.dao.UserDao;
import com.yipu.communityapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void signUp(User user){
        user.setEnabled(true);
        userDao.signUp(user);
    }

    public User getUser(String email) {
        return userDao.getUser(email);
    }

    public String getRole(String email) {
        return userDao.getRole(email);
    }


}
