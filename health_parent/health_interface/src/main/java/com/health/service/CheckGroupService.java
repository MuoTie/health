package com.health.service;

import com.health.constant.PageResult;
import com.health.constant.QueryPageBean;
import com.health.pojo.CheckGroup;

public interface CheckGroupService {
    public void add(CheckGroup checkGroup, Integer[] checkitemIds);

    public PageResult pageQuery(QueryPageBean queryPageBean);

    public CheckGroup findById(Integer id);
}
