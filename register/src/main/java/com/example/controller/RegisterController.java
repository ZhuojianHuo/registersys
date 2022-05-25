package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import com.example.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping
    public R save(@RequestBody User user){
        return new R(userService.save(user));
    }
}
