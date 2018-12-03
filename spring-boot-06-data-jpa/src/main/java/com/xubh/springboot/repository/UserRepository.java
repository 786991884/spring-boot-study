package com.xubh.springboot.repository;

import com.xubh.springboot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<Users,Integer> {
}
