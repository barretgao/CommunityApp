package com.yipu.communityapp.controller;

import org.springframework.stereotype.Controller;
import com.yipu.communityapp.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.yipu.communityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    //value is the path defined from the request URL. if they are in match, we can go to the next step
    @RequestMapping(value="/signup", method=RequestMethod.POST)
    //tell the client that the post request is successful
    @ResponseStatus(value = HttpStatus.CREATED)
    //@RequestBody will automatically bind the data body from the URL to the customer object using jackson
    public void signUp(@RequestBody User customer){
        userService.signUp(customer);
    }
}
