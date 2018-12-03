package com.xubh.springboot.mapper;


import com.xubh.springboot.bean.Users;

import java.util.List;

public interface UsersMapper {

    void insertUser(Users users);
    List<Users> selectUsersAll();
    Users selectUsersById(Integer id);
    void updateUser(Users users);
    void deleteUserById(Integer id);
}
