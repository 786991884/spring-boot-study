package com.xubh.springboot;

import com.xubh.springboot.bean.Employee;
import com.xubh.springboot.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate; //字符串的类型的tenplate模板

    @Autowired
    private RedisTemplate redisTemplate; //操作对象的template模板

    @Autowired
    private RedisTemplate<Object, Employee> empredisTemplate;  //注入自定义的redis对象类型的模板


    @Test
    public void contextLoads() {
        Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee);
    }

    /**
     * 测试StringRedisTemplate模板
     *   redis的五大基本数据类型
     *      String（字符串)    模板使用 ： stringRedisTemplate.opsForValue()
     *      List(列表)         模板使用 ： stringRedisTemplate.opsForList()
     *      Set(集合)          模板使用 ： stringRedisTemplate.opsForSet()
     *      ZSet(有序集合)     模板使用 ： stringRedisTemplate.opsForZSet()
     *      Hash(列表)         模板使用 ： stringRedisTemplate.opsForLHash()
     */
    /**
     * 测试保存对象
     */
    @Test
    public void test01() {
        //操作String
        //stringRedisTemplate.opsForValue().append("msg","zsl");
        //String msg = stringRedisTemplate.opsForValue().get("msg");
        //System.out.println(msg);

        //操作list
        //stringRedisTemplate.opsForList().leftPush("mylist","1");  //从左边插入一个数据
        //stringRedisTemplate.opsForList().leftPush("mylist","2");
        //stringRedisTemplate.opsForList().leftPush("mylist","3");

        //测试保存对象
        //Employee employee = employeeMapper.getEmpById(1);
        //redisTemplate.opsForValue().set("employee",employee);

        //使用自定义redistemplate模板
        Employee employee = employeeMapper.getEmpById(1);
        empredisTemplate.opsForValue().set("emp-011", employee);

    }

}
