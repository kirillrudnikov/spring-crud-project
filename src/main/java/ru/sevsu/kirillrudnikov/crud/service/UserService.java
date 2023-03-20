package ru.sevsu.kirillrudnikov.crud.service;

import ru.sevsu.kirillrudnikov.crud.dto.UserDto;

import java.util.List;

public interface UserService {

    Long createUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    Boolean deleteUserById(Long id);

}
