package com.spring.springboot.dao;

import com.spring.springboot.entity.Use;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: springboot
 * @description: Use接口类
 * @author: xyx
 * @create: 2020-07-14 01:46
 */
@Mapper
@Repository
public interface UseMapper {
    Use findUseByUseName(String usename);
    void updateUseByUseName(Use use);
    void deleteUseByUseName(String usename);
    void saveUse(Use use);
    List<Use> getUseList();

}
