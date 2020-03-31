package com.cn.dao;

import com.cn.pojo.Person;

public interface PersonMapper {
    int insert(Person record);

    int insertSelective(Person record);
}