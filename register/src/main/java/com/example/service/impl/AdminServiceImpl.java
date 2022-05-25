package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.AdminDao;
import com.example.domain.Admin;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> getAdmin(){
        return adminDao.selectList(null);
    }

    @Override
    public List<String> getAdminName(){
        return adminDao.getAdminName();
    }

    @Override
    public Admin getAdminByName(String name){
        return adminDao.getAdminByName(name);
    }
}
