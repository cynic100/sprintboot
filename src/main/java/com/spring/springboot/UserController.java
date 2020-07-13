package com.spring.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //http://localhost:8080/createTable
    @GetMapping("createTable")
    public String createTable(){
        String sql =
                "CREATE TABLE mi\n" +
                        "(\n" +
                        "id INT IDENTITY PRIMARY KEY(id),\n" +
                        "mi_name VARCHAR(200) ,\n" +
                        "mi_password  VARCHAR(20)\n" +
                        ")";
        jdbcTemplate.execute(sql);
        return "创建User表成功";
    }

    //http://localhost:8080/saveUserSql
    @GetMapping("saveUserSql")
    public String saveUserSql(){
        String sql = "INSERT INTO mi (mi_name,mi_password) VALUES ('dalaoyang','123')";
        int rows= jdbcTemplate.update(sql);
        return "执行成功，影响"+rows+"行";
    }

    //http://localhost:8080/saveUser?userName=lisi&passWord=111
    @GetMapping("saveUser")
    public String saveMi(String userName,String passWord){
        int rows= jdbcTemplate.update("INSERT INTO mi (mi_name,mi_password) VALUES (?,?)",userName,passWord);
        return "执行成功，影响"+rows+"行";
    }

    //http://localhost:8080/updateUserPassword?id=1&passWord=111
    @GetMapping("updateUserPassword")
    public String updateUserPassword(int id,String passWord){
        int rows= jdbcTemplate.update("UPDATE mi SET mi_password = ? WHERE id = ?",passWord,id);
        return "执行成功，影响"+rows+"行";
    }

    //http://localhost:8080/deleteUserById?id=1
    @GetMapping("deleteUserById")
    public String deleteUserById(int id){
        int rows= jdbcTemplate.update("DELETE FROM  mi  WHERE id = ?",id);
        return "执行成功，影响"+rows+"行";
    }


    //http://localhost:8080/batchSaveUserSql
    @GetMapping("batchSaveUserSql")
    public String batchSaveUserSql(){
        String sql =
                "INSERT INTO mi (mi_name,mi_password) VALUES (?,?)" ;
        List<Object[]> paramList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String[] arr = new String[2];
            arr[0] = "zhangsan"+i;
            arr[1] = "password"+i;
            paramList.add(arr);
        }
        jdbcTemplate.batchUpdate(sql,paramList);
        return "执行成功";
    }

    //http://localhost:8080/getUserByUserName?userName=zhangsan0
    @GetMapping("getUserByUserName")
    public List getUserByUserName(String userName){
        String sql = "SELECT * FROM mi WHERE mi_name = ?";
        List<Mi> list= jdbcTemplate.query(sql,new Object[]{userName},new BeanPropertyRowMapper<>(Mi.class));
        return list;
    }

    //http://localhost:8080/getMapById?id=1
    @GetMapping("getMapById")
    public Map getMapById(Integer id){
        String sql = "SELECT * FROM mi WHERE id = ?";
        Map map = null;
        try{
            map= jdbcTemplate.queryForMap(sql,id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return map;
    }

    //http://localhost:8080/getUserById?id=1
    @GetMapping("getUserById")
    public Mi getUserById(Integer id){
        String sql = "SELECT * FROM mi WHERE id = ?";
        Mi mi= null;
        try{
            mi = jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(Mi.class));
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return mi;
    }
}
