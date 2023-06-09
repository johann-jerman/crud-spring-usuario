package com.springcrud.spring.controller;

import com.springcrud.spring.dao.UserDao;
import com.springcrud.spring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    // GET ALL
    @RequestMapping(value = "api/user", method = RequestMethod.GET)
    public List<User> getAll(){
        return userDao.getAll();
    }

    //REGISTER
    @RequestMapping(value = "api/user/register", method = RequestMethod.POST)
    public void register(@RequestBody User user){
        userDao.register(user);
    }

    // DELETE
    @RequestMapping(value = "api/user/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        userDao.delete(id);
    }
}
