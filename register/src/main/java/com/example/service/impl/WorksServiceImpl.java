package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.WorksDao;
import com.example.domain.Works;
import com.example.service.WorksService;
import com.example.utils.Encryption;
import org.apache.ibatis.annotations.Select;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WorksServiceImpl implements WorksService {

    @Autowired
    private WorksDao worksDao;



    @Override
    public Boolean save(Works work) {
        return worksDao.insert(work) > 0;
    }

    @Override
    public Boolean update(Works work) {
        return worksDao.updateById(work) > 0;
    }

    @Override
    public Boolean delete(String name) {
        String index = name;
        LambdaQueryWrapper<Works> qw = new LambdaQueryWrapper<>();
        qw.like(index != null, Works::getAuthor,index);
        return  worksDao.delete(qw) > 0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return  worksDao.deleteById(id) > 0;
    }

    @Override
    public List<Works> getByCondition(Works works) {
        LambdaQueryWrapper<Works> qw = new LambdaQueryWrapper<>();
        qw.like(works.getAuthor() != null, Works::getAuthor,works.getAuthor());
        qw.like(works.getTitle() != null, Works::getTitle,works.getTitle());
        qw.like(works.getPress() != null, Works::getPress,works.getPress());
        qw.like(works.getStatus() != null, Works::getStatus,works.getStatus());
        return worksDao.selectList(qw);
    }

    @Override
    public Works getById(Integer id){
        return worksDao.selectById(id);
    }

    @Override
    public List<Works> getAll(){
        return worksDao.selectList(null);
    }

    @Override
    public IPage<Works> getPage(int currentPage, int pageSize){
        IPage page = new Page(currentPage,pageSize);
        worksDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Works> getPageByName(int currentPage, int pageSize,String name){
        if(name == null){
            name = "test001";
        }
        LambdaQueryWrapper<Works> qw = new LambdaQueryWrapper<>();
        qw.eq(name != null, Works::getAuthor,name);
        IPage page = new Page(currentPage,pageSize);
        worksDao.selectPage(page,qw);
        return page;
    }
}
