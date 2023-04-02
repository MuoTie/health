package com.health.service;

import com.health.constant.PageResult;
import com.health.constant.QueryPageBean;
import com.health.pojo.CheckItem;

public interface CheckItemService  {

    public void add(CheckItem  checkItem);

    public PageResult pageQuery(QueryPageBean queryPageBean);
}
