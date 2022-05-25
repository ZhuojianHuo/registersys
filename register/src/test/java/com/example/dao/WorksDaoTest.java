package com.example.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.domain.Works;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WorksDaoTest {

    @Autowired
    private WorksDao worksDao;

    @Test
    void testGetById(){
        System.out.println(worksDao.selectById(1));
    }

    @Test
    void testSave(){
        Works work = new Works();
        work.setAuthor("李斯");
        work.setPress("人民出版社");
        work.setTitle("树先生");
        work.setPressDate(java.sql.Date.valueOf("2012-08-20"));
        worksDao.insert(work);
    }

    @Test
    void testUpdate(){
        Works work = new Works();
        work.setId(3);
        work.setAuthor("李斯");
        work.setPress("人民出版社");
        work.setTitle("树先生");
        work.setPressDate(java.sql.Date.valueOf("2012-08-20"));
        work.setStatus("审核通过");
        worksDao.updateById(work);
    }

    @Test
    void testDelete(){
        String index = "李斯";
        LambdaQueryWrapper<Works> qw = new LambdaQueryWrapper<>();
        qw.like(index != null, Works::getAuthor,index);
        worksDao.delete(qw);
    }

    @Test
    void testGetAll(){
        System.out.println(worksDao.selectList(null));
    }

    @Test
    void testGetBy(){
        QueryWrapper<Works> qw = new QueryWrapper<>();
        qw.like("press","人民");
        System.out.println(worksDao.selectList(qw));
    }

    @Test
    void testGetBy2(){
        String index = "人民";
        LambdaQueryWrapper<Works> qw = new LambdaQueryWrapper<>();
        qw.like(index != null, Works::getPress,index);
        System.out.println(worksDao.selectList(qw));
    }
}
