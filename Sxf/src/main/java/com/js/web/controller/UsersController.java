package com.js.web.controller;

import com.js.Common.Users;
import com.js.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;
    @RequestMapping("/addusers")
    public void adduser() {
        Users users=new Users();
        users.setName("dsy");
        System.out.println("=========================");
        usersService.addService(users);
    }
}
