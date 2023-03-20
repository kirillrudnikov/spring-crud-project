package ru.sevsu.kirillrudnikov.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.sevsu.kirillrudnikov.crud.entity.Car;
import ru.sevsu.kirillrudnikov.crud.entity.CarBrand;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findCarByLicensePlate(String licencePlate);
    List<Car> findAllByBrand(CarBrand brand);
    List<Car> findAllByUserId(Long id);

}