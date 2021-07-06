package com.example.easymybaitsdemo.dao;

import com.example.easymybaitsdemo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    void addUser() {
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setEmail("zhangsan@qq.com");
        Integer effect =  userMapper.addUser(user);
        assertEquals(effect, 1);
    }

    @Test
    void deleteUser() {
        Integer effect =  userMapper.deleteUser(1);
        assertEquals(effect, 1);
    }

    @Test
    void updateUser() {
        User user = new User();
        user.setId(2);
        user.setName("李四");
        user.setAge(30);
        user.setEmail("Lishi@qq.com");
        Integer effect =  userMapper.updateUser(user);
        assertEquals(effect, 1);
    }

    @Test
    void getUserById() {
        User user = userMapper.getUserById(3);
        assertNotNull(user);
    }

    @Test
    void getAllUsers() {
        List<User> userList = userMapper.getAllUsers();
        assertTrue(userList.size() > 0);
    }
}