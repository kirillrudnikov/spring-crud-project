package ru.sevsu.kirillrudnikov.crud.service;

import ru.sevsu.kirillrudnikov.crud.dto.CarDto;

import java.util.List;

public interface CarService {

    Long createCar(CarDto car);
    List<CarDto> getAllCars();
    List<CarDto> getAllByUserId(Long id);
    CarDto getCarById(Long id);
    Boolean deleteCarById(Long id);

}