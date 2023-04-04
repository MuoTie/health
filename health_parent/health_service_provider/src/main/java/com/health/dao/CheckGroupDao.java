package com.health.dao;


import com.github.pagehelper.Page;
import com.health.pojo.CheckGroup;

import java.util.Map;

public interface CheckGroupDao {


    public void add(CheckGroup checkGroup);

    public void setCheckGroupAndCheckItem(Map map);


    public Page<CheckGroup> findByCondition(String queryString);

    public CheckGroup findById(Integer id);
}
