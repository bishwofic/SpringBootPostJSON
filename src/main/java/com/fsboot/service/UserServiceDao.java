package com.fsboot.service;

import com.fsboot.dao.UserDao;
import com.fsboot.dao.UserSqlQueries;
import com.fsboot.dto.UserDto;
import com.fsboot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceDao implements UserServiceDaoImpl, UserSqlQueries {
    @Autowired
    private UserDao userDao;

    @Override
    public User insertUser(User user) {
        return userDao.insData(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return (List<UserDto>) userDao.AllUsers();
    }

    @Override
    public User getSingleUserById(Integer id) {


        return userDao.getSingleUser(id);
    }

    @Override
    public Optional<User> updateUserById(User user) {
        return userDao.updUsers(user);

    }

    @Override
    public Optional<User> deleteUserById(Integer id) {
        return userDao.delData(id);
    }
}

