package ru.sevsu.kirillrudnikov.crud.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

import ru.sevsu.kirillrudnikov.crud.dto.serializer.CarSerializer;
import ru.sevsu.kirillrudnikov.crud.entity.CarBrand;

@Data //TODO: Make CarDto immutable (record or final)
@JsonSerialize(using = CarSerializer.class)
public class CarDto {

    private Long id;
    private UserDto user;
    private CarBrand brand;
    private String licensePlate;

}