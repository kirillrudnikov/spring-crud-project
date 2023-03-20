package ru.sevsu.kirillrudnikov.crud.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;;

import ru.sevsu.kirillrudnikov.crud.dto.CarDto;
import ru.sevsu.kirillrudnikov.crud.service.CarService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/api/v1/cars"
)
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @RequestMapping(
            value = "",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Long> createCar(CarDto dto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(carService.createCar(dto));
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(carService.getAllCars());
    }

    @RequestMapping(
            value = "/user/{id}",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<CarDto>> getAllByUserId(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(carService.getAllByUserId(id));
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CarDto> getCarById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(carService.getCarById(id));
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Boolean> deleteCarById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(carService.deleteCarById(id));
    }

}