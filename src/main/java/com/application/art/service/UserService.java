package com.application.art.service;

import com.application.art.dto.UserDto;
import com.application.art.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}