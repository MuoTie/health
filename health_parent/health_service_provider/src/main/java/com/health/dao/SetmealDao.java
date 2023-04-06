package com.health.dao;

import com.github.pagehelper.Page;
import com.health.pojo.Setmeal;

import java.util.Map;

public interface SetmealDao {
    public void add(Setmeal setmeal);
    public void setSetmealAndcheckGroup(Map map);


    public Page<Setmeal> findByCondition(String queryString);
}
