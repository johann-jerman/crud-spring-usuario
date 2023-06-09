package com.springcrud.spring.dao;

import com.springcrud.spring.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    List<User> getUser(User user);

    void register(User user);

    void delete(Long id);
}
