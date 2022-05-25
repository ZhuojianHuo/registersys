package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminDao extends BaseMapper<Admin> {
    @Select("select username from admin")
    List<String> getAdminName();

    @Select("select * from admin where username=#{name}")
    Admin getAdminByName(String name);
}
