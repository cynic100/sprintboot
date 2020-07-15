package com.spring.springboot.entity;

import org.apache.ibatis.type.Alias;

/**
 * @program: springboot
 * @description: 用户实体类
 * @author: xyx
 * @create: 2020-07-14 01:41
 */
@Alias("use")
public class Use {
    private int id;
    private String mi_name;
    private String mi_password;

    public Use() {
    }

    public Use(String mi_name, String mi_password) {
        this.mi_name = mi_name;
        this.mi_password = mi_password;
    }

    public Use(int id, String mi_name, String mi_password) {
        this.id = id;
        this.mi_name = mi_name;
        this.mi_password = mi_password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMi_name() {
        return mi_name;
    }

    public void setMi_name(String mi_name) {
        this.mi_name = mi_name;
    }

    public String getMi_password() {
        return mi_password;
    }

    public void setMi_password(String mi_password) {
        this.mi_password = mi_password;
    }

    @Override
    public String toString() {
        return "Use{" +
                "id=" + id +
                ", mi_name='" + mi_name + '\'' +
                ", mi_password='" + mi_password + '\'' +
                '}';
    }
}
