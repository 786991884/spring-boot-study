package com.xubh.springboot.service.impl;

import com.xubh.springboot.bean.Users;
import com.xubh.springboot.mapper.UsersMapper;
import com.xubh.springboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void addUser(Users users) {
        this.usersMapper.insertUser(users);
    }

    @Override
    public List<Users> findUserAll() {
        return this.usersMapper.selectUsersAll();
    }

    @Override
    public Users findUserById(Integer id) {
        return this.usersMapper.selectUsersById(id);
    }

    @Override
    public void updateUser(Users users) {
        this.usersMapper.updateUser(users);
    }

    @Override
    public void deleteUserById(Integer id) {
        this.usersMapper.deleteUserById(id);
    }
}
