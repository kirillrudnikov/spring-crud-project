package ru.sevsu.kirillrudnikov.crud.dto.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.google.common.primitives.Longs;

import ru.sevsu.kirillrudnikov.crud.dto.CarDto;
import ru.sevsu.kirillrudnikov.crud.dto.UserDto;

import java.io.IOException;

public class UserSerializer extends StdSerializer<UserDto> {

    public UserSerializer() {
        this(null);
    }

    public UserSerializer(Class<UserDto> t) {
        super(t);
    }

    @Override
    public void serialize(UserDto value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        long[] carIdsArray = Longs.toArray(value.getCars().stream().map(CarDto::getId).limit(5).toList());

        gen.writeStartObject();
        {
            gen.writeNumberField("id", value.getId());
            gen.writeStringField("fullName", value.getFullName());
            gen.writeStringField("email", value.getEmail());
            gen.writeStringField("phoneNumber", value.getPhoneNumber());
            gen.writeStringField("role", value.getRole().getName());
            gen.writeArrayFieldStart("linkedCarsId");
            {
                gen.writeArray(carIdsArray, 0, carIdsArray.length);
            }
            gen.writeEndArray();
        }
        gen.writeEndObject();
    }

}