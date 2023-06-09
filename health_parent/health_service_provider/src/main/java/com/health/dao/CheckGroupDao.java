package com.health.dao;


import com.github.pagehelper.Page;
import com.health.pojo.CheckGroup;

import java.util.List;
import java.util.Map;

public interface CheckGroupDao {


    public void add(CheckGroup checkGroup);

    public void setCheckGroupAndCheckItem(Map map);


    public Page<CheckGroup> findByCondition(String queryString);

    public CheckGroup findById(Integer id);

    public List<Integer> findCheckItemIdByCheckGroupId(Integer id);



    public void edit(CheckGroup checkGroup);

    public void deleteAssoication(Integer id);

    public List<CheckGroup> findAll();
}
