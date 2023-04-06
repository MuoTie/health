package com.health.service;

import com.health.constant.PageResult;
import com.health.constant.QueryPageBean;
import com.health.pojo.Setmeal;

public interface SetmealService {


    public void add(Setmeal setmeal, Integer[] checkgroupIds);

    public PageResult pageQuery(QueryPageBean queryPageBean);
}
