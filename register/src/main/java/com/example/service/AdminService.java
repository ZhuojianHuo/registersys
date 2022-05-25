package com.example.service;

import com.example.domain.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminService {
    Admin getAdminByName(String name);

    List<Admin> getAdmin();

    List<String> getAdminName();
}
