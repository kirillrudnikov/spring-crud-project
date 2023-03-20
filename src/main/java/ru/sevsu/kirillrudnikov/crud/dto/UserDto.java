package ru.sevsu.kirillrudnikov.crud.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

import ru.sevsu.kirillrudnikov.crud.dto.serializer.UserSerializer;
import ru.sevsu.kirillrudnikov.crud.entity.UserRole;

import java.util.List;

@Data //TODO: Make UserDto immutable (record or final)
@JsonSerialize(using = UserSerializer.class)
public class UserDto {

    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private UserRole role;
    private List<CarDto> cars;

}