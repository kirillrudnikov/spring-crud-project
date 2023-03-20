package ru.sevsu.kirillrudnikov.crud.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sevsu.kirillrudnikov.crud.entity.*;
import ru.sevsu.kirillrudnikov.crud.repository.CarRepository;
import ru.sevsu.kirillrudnikov.crud.repository.UserRepository;

@Configuration
@AllArgsConstructor
public class AppInitConfiguration {

    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
            // Some Users
            User firstUser = User.builder()
                    .fullName("Рудников Кирилл Глебович")
                    .email("kirill.rudnikov@gmail.com")
                    .phoneNumber("+76731651539")
                    .role(UserRole.USER)
                    .build();

            User secondUser = User.builder()
                    .fullName("Боканов Александр Дмитриевич")
                    .email("alex.bokanov@gmail.com")
                    .phoneNumber("+71882195713")
                    .role(UserRole.ADMINISTRATOR)
                    .build();

            userRepository.save(firstUser);
            userRepository.save(secondUser);

            // Some Cars
            Car firstCar = Car.builder()
                        .licensePlate("1273GFH")
                        .brand(CarBrand.SUBARU)
                    .build();

            Car secondCar = Car.builder()
                    .licensePlate("0001JDS")
                    .brand(CarBrand.TOYOTA)
                    .build();

            Car thirdCar = Car.builder()
                    .licensePlate("5905FDJ")
                    .brand(CarBrand.ZAZ)
                    .build();

            firstCar.setUser(firstUser);
            secondCar.setUser(firstUser);
            thirdCar.setUser(secondUser);

            carRepository.save(firstCar);
            carRepository.save(secondCar);
            carRepository.save(thirdCar);

        };
    }

}