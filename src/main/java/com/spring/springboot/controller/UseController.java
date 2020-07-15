package com.spring.springboot.controller;

import com.spring.springboot.dao.UseMapper;
import com.spring.springboot.entity.Use;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UseController {

    @Autowired
    private UseMapper useMapper;

    //http://localhost:8080/getUser?username=xiaoli2
    @GetMapping("/getUser")
    public String getUser(String username){
        Use use =useMapper.findUseByUseName(username);
        return use!=null ? username+"的密码是："+use.getMi_password():"不存在用户名为"+username+"的用户";
    }

    //http://localhost:8080/updateUser?username=xiaoli2&password=123
    @GetMapping("/updateUser")
    public String updateUser(String password,String username){
        Use use = new Use(username,password);
        useMapper.updateUseByUseName(use);
        return "success!";
    }


    //http://localhost:8080/addUser?username=xiaoli2&password=123
    @GetMapping("/addUser")
    public String addUser(String username,String password){
        Use use = new Use(username,password);
        useMapper.saveUse(use);
        return "success!";
    }

    //http://localhost:8080/deleteUser?username=xiaoli2
    @GetMapping("/deleteUser")
    public String deleteUser(String username){
        useMapper.deleteUseByUseName(username);
        return "success!";
    }

    //http://localhost:8080/getUserList
    @GetMapping("/getUserList")
    public List getUserList(){
        return useMapper.getUseList();
    }


//    //http://localhost:8080/findUserById?id=1
//    @GetMapping("/findUserById")
//    public List findUserById(int id){
//        return useMapper.findUseByUseName(id);
//    }
}
