package com.example.controller;

import com.example.domain.User;
import com.example.service.AdminService;
import com.example.service.UserService;
import com.example.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @GetMapping
    public R getAll(){
        return new R(true,userService.getAll());
    }

    @GetMapping("/name")
    public R getAllName(){
        return new R(true,userService.getAllName());
    }

    @GetMapping("/admins")
    public R getAdminName(){
        return new R(true,adminService.getAdminName());
    }

    @GetMapping("/{name}")
    public R getByName(@PathVariable String name){
        boolean res = true;
        if(userService.getByName(name) == null){
            res = false;
        }
        return new R(res,userService.getByName(name));
    }

    @GetMapping("/admins/{name}")
    public R getAdminByName(@PathVariable String name){
        boolean res = true;
        System.out.println(adminService.getAdminByName(name));
        if(adminService.getAdminByName(name) == null){
            System.out.println(adminService.getAdminByName(name));
            res = false;
        }
        return new R(res,adminService.getAdminByName(name));
    }
}
