package com.xubh.springboot.service;

import com.xubh.springboot.bean.Department;
import com.xubh.springboot.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheManager = "deptCacheManager")
@Service
public class DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Cacheable(value = "dept")
    public Department getOneById(Integer id)
    {
        return deptMapper.selectOneById(id);
    }

}



