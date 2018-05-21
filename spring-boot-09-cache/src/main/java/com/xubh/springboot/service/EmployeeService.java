package com.xubh.springboot.service;

import com.xubh.springboot.bean.Employee;
import com.xubh.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

//cacheNames = "emp", 表示制定存入到那个cahce中
@CacheConfig(/*cacheNames = "emp",*/cacheManager = "employeeCacheManager")
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存，如果以后在需要相同的数据，自动去缓存中取得数据，而不会再去数据库查询
     * 加上这个注解以后，在规定的时间内，再次取得数据就会直接去缓存中拿，不会再去执行这个方法
     * 几个属性:
     * cacheNames/value : 将方法的返回值放到哪个缓存中，是数组的方式，可以指定多个缓存
     * keyGenerator ： key的生成器（自动），与 key 只能二选一
     * condition : 指定实现条件才能够进行缓存
     * unless : 当unless指定的条件为true，不会进行缓存
     * sync ： 缓存是否异步处理
     * key ： 缓存数据所用的key，默认是方法参数（形参）的值    key = "#root.methodName+'['+#id+']'"
     * cacheNames = {"emp"}  指的是存入到emp这个缓存管理器中
     * key = "#id"   指的是方法形参id来作为缓存的key
     */
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmpById(Integer id) {
        System.out.println("查询" + id + "的员工");
        Employee empById = employeeMapper.getEmpById(id);
        return empById;
    }

    /**
     * @CachePut 既调用方法，有更新缓存
     * 主要使用的是更新数据以后，同步更新缓存的内容
     * 注解的执行步骤：
     * 1. 先执行更新
     * 2. 将目标方法的返回值存入到缓存中
     * 注意：
     * 必须要指定需要把哪个缓存，以及这个缓存中的哪条数据
     * 所以 value 指的是哪个缓存， key 指定的是缓存中的哪条数据
     */
    @CachePut(value = "emp", key = "#result.id")
    public Employee updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict :  清空缓存
     * value : 指定哪个缓存
     * key : 指定哪条缓存，key与allEntries只能二选一
     * allEntries = true  指定删除所有缓存
     * beforeInvocation = true  指定的是先清空缓存，再进行其他操作
     */
    @CacheEvict(value = "emp", key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("delete的id" + id);
        //employeeMapper.deleteEmpById(id);
    }

    /**
     * 组合注解
     *
     * @param lastName
     * @return
     */
    @Caching(
            cacheable = {@Cacheable(value = "emp", key = "#lastName")},
            put = {
                    @CachePut(value = "emp", key = "#result.id"),
                    @CachePut(value = "emp", key = "#result.email"),
            })
    public Employee getEmpBylastName(String lastName) {
        System.out.println(employeeMapper.getEmpBylastName(lastName));
        return employeeMapper.getEmpBylastName(lastName);
    }


}
