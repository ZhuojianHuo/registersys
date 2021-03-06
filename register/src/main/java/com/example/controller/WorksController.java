package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Works;
import com.example.service.WorksService;
import com.example.utils.Encryption;
import com.example.utils.R;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Network;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/works")
@AllArgsConstructor
public class WorksController {
    @Autowired
    private WorksService worksService;

    @Autowired
    private Encryption encryption;

    final Gateway gateway;

    @GetMapping("/name")
    public R getByCondition(Works works) throws ContractException {
        Contract contract = getContract();
        byte[] bytes = contract.evaluateTransaction("queryWorks", works.getCode());


        List<Works> res = worksService.getByCondition(works);
        if(res.isEmpty()){
            return new R(false,worksService.getByCondition(works));
        }else {
            return new R(true,worksService.getByCondition(works));
        }
    }

    @GetMapping("/id/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,worksService.getById(id));
    }

//    @GetMapping
//    public R getAll(){
//        return new R(true,worksService.getAll());
//    }

    @PostMapping
    public R save(@RequestBody Works works) throws ContractException {
        String key = encryption.enTimeCode(works.getPressDate());
        works.setCode(key);
        Contract contract = getContract();
        byte[] bytes = contract.evaluateTransaction("createWorks",
                works.getCode(), String.valueOf(works.getId()), works.getTitle(), works.getAuthor(), works.getPress(), works.getStatus(), new SimpleDateFormat("yyyy-MM-dd").format(works.getPressDate()));
        return new R(worksService.save(works));
    }

    @PutMapping
    public R update(@RequestBody Works works) throws ContractException {
        Contract contract = getContract();
        byte[] bytes = contract.evaluateTransaction("updateWorks",
                works.getCode(), String.valueOf(works.getId()), works.getTitle(), works.getAuthor(), works.getPress(), works.getStatus(), new SimpleDateFormat("yyyy-MM-dd").format(works.getPressDate()));

        return new R(worksService.update(works));
    }

//    @DeleteMapping("/{name}")
//    public R delete(@PathVariable String name){
//        return new R(worksService.delete(name));
//    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id) throws ContractException {
        Works works = worksService.getById(id);
        Contract contract = getContract();
        byte[] cat = contract.evaluateTransaction("deleteCat", works.getCode());
        return new R(worksService.deleteById(id));
    }


    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
//        System.out.println("??????==>"+works.getPress());

        IPage<Works> page = worksService.getPage(currentPage, pageSize);
        //????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        if( currentPage > page.getPages()){
            page = worksService.getPage((int)page.getPages(), pageSize);
        }
        return new R(true, page);
    }

//    @GetMapping("/{currentPage}/{pageSize}/{name}")
//    public R getPageByName(@PathVariable int currentPage,@PathVariable int pageSize,@PathVariable String name){
//
//        IPage<Works> page = worksService.getPageByName(currentPage, pageSize,name);
//        //????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
//        if( currentPage > page.getPages()){
//            page = worksService.getPageByName((int)page.getPages(), pageSize,name);
//        }
//        return new R(true, page);
//    }

    private Contract getContract() {

        // ????????????
        Network network = gateway.getNetwork("mychannel");

        // ????????????
        return network.getContract("register-contract");
    }

}
