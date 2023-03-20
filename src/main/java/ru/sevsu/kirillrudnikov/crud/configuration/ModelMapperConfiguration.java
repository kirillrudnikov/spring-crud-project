package ru.sevsu.kirillrudnikov.crud.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.config.Configuration.AccessLevel;

@Configuration
public class ModelMapperConfiguration {

    private final ModelMapper modelMapper;

    public ModelMapperConfiguration() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
                .setSkipNullEnabled(true)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return this.modelMapper;
    }

}