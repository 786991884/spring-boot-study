package com.xubh.springboot.config;

import com.xubh.springboot.bean.Department;
import com.xubh.springboot.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Employee> empredisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    @Bean
    public RedisTemplate<Object, Department> deptredisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Department> template = new RedisTemplate<Object, Department>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Department> serializer = new Jackson2JsonRedisSerializer<Department>(Department.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    //定制redis的缓存管理器
    @Primary  //多喝缓存管理器的情况下，必须使用注解指定哪个为默认的缓存管理器
    @Bean
    public RedisCacheManager employeeCacheManager(RedisTemplate<Object, Employee> empredisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(empredisTemplate);
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }

    @Bean
    public RedisCacheManager deptCacheManager(RedisTemplate<Object, Department> deptredisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(deptredisTemplate);
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }

}
