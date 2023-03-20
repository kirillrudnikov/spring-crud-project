package ru.sevsu.kirillrudnikov.crud.dto;

import lombok.Data;

@Data
public class CreateUserDto {
    private final String fullName;
    private final String email;
    private final String phoneNumber;
    //private String password; TODO: Integrate Spring Security
}
