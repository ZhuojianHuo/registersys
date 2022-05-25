package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Works;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorksService{
    Boolean save(Works work);
    Boolean update(Works work);
    Boolean delete(String name);
    Boolean deleteById(Integer id);

    List<Works> getByCondition(Works works);

    Works getById(Integer id);

    List<Works> getAll();

    IPage<Works> getPage(int currentPage, int pageSize);

    IPage<Works> getPageByName(int currentPage, int pageSize,String name);

}
