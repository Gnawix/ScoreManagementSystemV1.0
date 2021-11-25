package com.sms.service;

import com.sms.dao.UserMapper;
import com.sms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryUser(String username){
        return userMapper.queryUser(username);
    }

    public int updatePassword(String username, String password){
        return userMapper.updatePassword(username, password);
    }
}
