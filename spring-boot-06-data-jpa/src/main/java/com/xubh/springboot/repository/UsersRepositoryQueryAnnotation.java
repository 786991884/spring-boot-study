package com.xubh.springboot.repository;

import com.xubh.springboot.entity.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;


/**
 * Repository   @Query
 */
public interface UsersRepositoryQueryAnnotation extends Repository<Users, Integer> {

    @Query("from Users where name = ?")
    List<Users> queryByNameUseHQL(String name);

    @Query(value = "select * from t_users where name = ?", nativeQuery = true)
    List<Users> queryByNameUseSQL(String name);

    @Query("update Users set name  = ? where id  = ?")
    @Modifying
    /**
     *需要执行一个更新操作
     */
    void updateUsersNameById(String name, Integer id);
}
