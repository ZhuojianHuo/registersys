package com.example.service;

import com.example.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Boolean save(User user);
    User getByName(String name);

    List<User> getAll();

    List<String> getAllName();
}
