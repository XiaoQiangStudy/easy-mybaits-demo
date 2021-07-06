package com.example.easymybaitsdemo.dao;

import com.example.easymybaitsdemo.model.User;

import java.util.List;

public interface UserMapper {
    int addUser(User user);
    int deleteUser(Integer id);
    int updateUser(User user);
    User getUserById(Integer id);
    List<User> getAllUsers();
}
