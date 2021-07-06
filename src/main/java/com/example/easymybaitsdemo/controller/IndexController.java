package com.example.easymybaitsdemo.controller;

import com.example.easymybaitsdemo.dao.UserMapper;
import com.example.easymybaitsdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping(path = "")
    public String index(){
        return "<h1>SpringBoot + Mybatis 极简示例</h1><hr><ul>" +
                "<li>getAllUsers: <a href=\"/user\" target=\"blank\">/user</a></li>" +
                "<li>getUserById: <a href=\"/user/1\" target=\"blank\">/user/{id}</a></li>" +
                "<li>addUser: <a href=\"/user/add?name=张无忌&age=18&email=Wuji@qq.com\" target=\"blank\">/user/add?name={name}&age={age}&email={email}</a></li>" +
                "<li>updateUser: <a href=\"/user/upd?id=1&name=令狐冲&age=19&email=Linghuchong@qq.com\" target=\"blank\">/user/upd?id={id}&name={name}&age={age}&email={email}</a></li>" +
                "<li>deleteUser: <a href=\"/user/del/1\" target=\"blank\">/user/del/{id}</a></li>" +
                "</ul>";
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getAllUsers(@PathVariable Integer id){
        return userMapper.getUserById(id);
    }

    @RequestMapping(path = "/user/add", method = RequestMethod.GET)
    public Integer addUser(@RequestParam String name, @RequestParam Integer age, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        return userMapper.addUser(user);
    }

    @RequestMapping(path = "/user/del/{id}", method = RequestMethod.GET)
    public Integer deleteUser(@PathVariable Integer id){
        return userMapper.deleteUser(id);
    }

    @RequestMapping(path = "/user/upd", method = RequestMethod.GET)
    public Integer updateUser(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age, @RequestParam String email){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        return userMapper.updateUser(user);
    }
}
