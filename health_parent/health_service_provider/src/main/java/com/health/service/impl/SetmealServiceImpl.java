package com.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.health.constant.PageResult;
import com.health.constant.QueryPageBean;
import com.health.constant.RedisConstant;
import com.health.dao.SetmealDao;
import com.health.pojo.Setmeal;
import com.health.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

@Service(interfaceClass = SetmealService.class )
@Transactional
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    private SetmealDao setmealDao;
    @Autowired
    private JedisPool jedisPool;

    @Override
    public void add(Setmeal setmeal, Integer[] checkgroupIds) {
        setmealDao.add(setmeal);
        Integer setmealId = setmeal.getId();
        this.setSetmealAndcheckGroup(setmealId,checkgroupIds);
        String fileName = setmeal.getImg();
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES,fileName);
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();

        PageHelper.startPage(currentPage,pageSize);

        Page<Setmeal> page = setmealDao.findByCondition(queryString);

        return new PageResult(page.getTotal(),page.getResult());
    }


    public void setSetmealAndcheckGroup(Integer setmealId, Integer[] checkgroupIds){
        if(checkgroupIds != null && checkgroupIds.length > 0){
            for(Integer checkgroupId : checkgroupIds){
                Map<String, Integer> map = new HashMap<>();
                map.put("checkgroupId",checkgroupId);
                map.put("setmealId",setmealId);
                setmealDao.setSetmealAndcheckGroup(map);
            }
        }
    }
}
