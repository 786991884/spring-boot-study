package com.xubh.springboot.repository;

import com.xubh.springboot.entity.Users;
import org.springframework.data.repository.Repository;

import java.util.List;


/**
 * Repository接口的方法名称命名查询
 */
public interface UsersRepositoryByName extends Repository<Users, Integer> {

    //方法的名称必须要遵循驼峰式命名规则。findBy(关键字)+属性名称(首字母要大写)+查询条件(首字母大写)
    List<Users> findByLastName(String name);

    List<Users> findByLastNameAndEmail(String name, String email);

    List<Users> findByLastNameLike(String name);
}
