package com.xubh.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 操作数据库来进行操作缓存
 * <p>
 * 缓存操作：
 * 开启spring的注解缓存： @EnableCaching
 * 注解： @Cacheable
 *
 * @CacheEvict
 * @CachePut 整合redis
 * 一、引入redis的starter
 * 二、redis的配置
 */

@EnableCaching  //开启spring的缓存功能
@MapperScan("com.xubh.springboot.mapper")
@SpringBootApplication
public class Springboot01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01CacheApplication.class, args);
    }
}
