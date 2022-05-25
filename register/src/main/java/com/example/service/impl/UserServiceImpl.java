package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Boolean save(User user) {
        return userDao.insert(user) > 0;
    }

    @Override
    public List<User> getAll(){
        return userDao.selectList(null);
    }

    @Override
    public List<String> getAllName(){
        return userDao.getAllName();
    }

    @Override
    public User getByName(String name){
        return userDao.getByName(name);
    }
}
