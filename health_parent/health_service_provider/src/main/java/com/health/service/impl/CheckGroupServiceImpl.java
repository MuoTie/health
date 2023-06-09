package com.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.health.constant.PageResult;
import com.health.constant.QueryPageBean;
import com.health.dao.CheckGroupDao;
import com.health.pojo.CheckGroup;
import com.health.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {

    @Autowired
    private CheckGroupDao checkGroupDao;


    @Override
    public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
        checkGroupDao.add(checkGroup);

        Integer checkGroupId = checkGroup.getId();

        this.setCheckGroupAndCheckItem(checkGroupId, checkitemIds );
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage,pageSize);
        Page<CheckGroup> page = checkGroupDao.findByCondition(queryString);
        long total = page.getTotal();
        List<CheckGroup> rows = page.getResult();
        return new PageResult(total,rows);
    }

    @Override
    public CheckGroup findById(Integer id) {

        return checkGroupDao.findById(id);
    }

    @Override
    public List<Integer> findCheckItemIdByCheckGroupId(Integer id) {

        return checkGroupDao.findCheckItemIdByCheckGroupId(id);
    }

    @Override
    public void edit(CheckGroup checkGroup, Integer[] checkitemIds) {
         checkGroupDao.edit(checkGroup);
         checkGroupDao.deleteAssoication(checkGroup.getId());

        Integer checkGroupId = checkGroup.getId();
        this.setCheckGroupAndCheckItem(checkGroupId, checkitemIds );

    }

    @Override
    public List<CheckGroup> findAll() {
        return checkGroupDao.findAll();
    }

    public void setCheckGroupAndCheckItem(Integer checkGroupId, Integer[] checkitemIds){
        if(checkitemIds != null && checkitemIds.length > 0){
            for ( Integer checkitemId : checkitemIds ){
                Map<String , Integer> map = new HashMap<>();
                map.put("checkgroupId",checkGroupId);
                map.put("checkitemId",checkitemId);
                checkGroupDao.setCheckGroupAndCheckItem(map);
            }
        }
    }
}
