package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Works;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WorksServiceTest {

    @Autowired
    private WorksService worksService;

//    @Test
//    void testGetByName(){
//        System.out.println(worksService.getByName("wan"));
//    }
    @Test
    void testSave(){
        Works work = new Works();
        work.setAuthor("李斯");
        work.setPress("人民出版社");
        work.setTitle("树先生");
        work.setPressDate(java.sql.Date.valueOf("2012-08-20"));
        worksService.save(work);
    }

    @Test
    void testUpdate(){
        Works work = new Works();
        work.setId(3);
        work.setAuthor("李斯");
        work.setPress("商务印书馆");
        work.setTitle("树先生");
        work.setPressDate(java.sql.Date.valueOf("2012-08-20"));
        work.setStatus("审核通过");
        worksService.update(work);
    }

    @Test
    void testDelete(){
        worksService.delete("李斯");
    }

    @Test
    void testGetAll(){
        System.out.println(worksService.getAll());
    }

//    @Test
//    void testGetPage(){
//        IPage<Works> page = worksService.getPage(0,1);
//        System.out.println(page.getCurrent());
//        System.out.println(page.getSize());
//        System.out.println(page.getTotal());
//        System.out.println(page.getPages());
//        System.out.println(page.getRecords());
//    }

}
