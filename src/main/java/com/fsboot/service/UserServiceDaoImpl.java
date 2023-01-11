package com.fsboot.service;

import com.fsboot.dto.UserDto;
import com.fsboot.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceDaoImpl {
    public User insertUser(User user);

    public List<UserDto> getAllUsers();

    public User getSingleUserById(Integer id);

    public Optional<User> updateUserById(User user);

    public Optional<User> deleteUserById(Integer id);
}
