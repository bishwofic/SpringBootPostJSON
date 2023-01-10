package com.fsboot.service;

import com.fsboot.dto.UserDto;
import com.fsboot.entities.User;

import java.util.List;

public interface UserServiceDaoImpl {
    public User insertUser(User user);

    public List<UserDto> getAllUsers();

    public User getSingleUserById(Integer id);

    public User updateUserById(User user);

    public User deleteUserById(Integer id);
}
