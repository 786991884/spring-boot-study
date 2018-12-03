package com.xubh.springboot.repository;

import com.xubh.springboot.entity.Users;
import org.springframework.data.repository.CrudRepository;


/**
 * CrudRepository接口
 */
public interface UsersRepositoryCrudRepository extends CrudRepository<Users, Integer> {

}
