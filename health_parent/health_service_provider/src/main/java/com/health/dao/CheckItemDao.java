package com.health.dao;

import com.github.pagehelper.Page;
import com.health.constant.PageResult;
import com.health.constant.QueryPageBean;
import com.health.pojo.CheckItem;

public interface CheckItemDao {
    public void add(CheckItem checkItem);

    public Page<CheckItem> selectByCondition(String queryString);

    public Long findCountByCheckItemId(Integer id);

    public void deleteById(Integer id);

    public void edit(CheckItem checkItem);

    CheckItem findById(Integer id);
}
