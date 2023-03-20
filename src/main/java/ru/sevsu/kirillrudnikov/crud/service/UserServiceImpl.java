package ru.sevsu.kirillrudnikov.crud.service;

import java.util.List;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.sevsu.kirillrudnikov.crud.dto.UserDto;
import ru.sevsu.kirillrudnikov.crud.entity.User;
import ru.sevsu.kirillrudnikov.crud.exception.ResourceAlreadyExistsException;
import ru.sevsu.kirillrudnikov.crud.exception.ResourceNotFoundException;
import ru.sevsu.kirillrudnikov.crud.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    private UserDto toDto(User entity) {
        return modelMapper.map(entity, UserDto.class);
//        List<CarDto> carDtoList = new ArrayList<>();
//
//        entity.getCars().forEach(car -> {
//            carDtoList.add(new CarDto(
//                    car.getId(),
//                    car.getUser().getId(),
//                    car.getBrand(),
//                    car.getLicensePlate())
//            );
//        });
//
//        return new UserDto(
//                entity.getId(),
//                entity.getFullname(),
//                entity.getEmail(),
//                entity.getPhoneNumber(),
//                entity.getRole(),
//                carDtoList
//        );
    }

    private User toEntity(UserDto dto) {
        return modelMapper.map(dto, User.class);
    }

    @Override
    public Long createUser(UserDto dto) {
        User user = toEntity(dto);

        if (userRepository.findByEmailAndPhoneNumber(user.getEmail(), user.getPhoneNumber()).isPresent()) {
            throw new ResourceAlreadyExistsException("User already exists");
        }

        return userRepository.save(user).getId();
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = true
    )
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = true
    )
    public UserDto getUserById(Long id) {
        return toDto(userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException())
        );
    }

    @Override
    public Boolean deleteUserById(Long id) {
        User user = userRepository.getReferenceById(id);
        userRepository.delete(user);
        return true;
    }

}