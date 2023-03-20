package ru.sevsu.kirillrudnikov.crud.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.sevsu.kirillrudnikov.crud.dto.CarDto;
import ru.sevsu.kirillrudnikov.crud.entity.Car;
import ru.sevsu.kirillrudnikov.crud.exception.ResourceAlreadyExistsException;
import ru.sevsu.kirillrudnikov.crud.exception.ResourceNotFoundException;
import ru.sevsu.kirillrudnikov.crud.repository.CarRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final ModelMapper modelMapper;
    private final CarRepository carRepository;

    private CarDto toDto(Car entity) {
        return modelMapper.map(entity, CarDto.class);
    }

    private Car toEntity(CarDto dto) {
        return modelMapper.map(dto, Car.class);
    }

    @Override
    public Long createCar(CarDto dto) {

        Car car = toEntity(dto);

        if (carRepository.findCarByLicensePlate(car.getLicensePlate()).isPresent()) {
            throw new ResourceAlreadyExistsException("Car with that license code already exists");
        }

        return carRepository.save(car).getId();
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = true
    )
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = true
    )
    public List<CarDto> getAllByUserId(Long id) {
        return carRepository.findAllByUserId(id).stream().map(this::toDto).toList();
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = true
    )
    public CarDto getCarById(Long id) {
        return toDto(carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car Not Found")));
    }

    @Override
    public Boolean deleteCarById(Long id) {
        Car car = carRepository.getReferenceById(id);
        carRepository.delete(car);
        return true;
    }

}