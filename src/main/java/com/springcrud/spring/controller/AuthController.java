package com.springcrud.spring.controller;

import com.springcrud.spring.dao.UserDao;
import com.springcrud.spring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/user/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {

        if (!userDao.getUser(user).isEmpty()) {
            return "ok";
        } else {
            return "not ok";
        }
    }
}
