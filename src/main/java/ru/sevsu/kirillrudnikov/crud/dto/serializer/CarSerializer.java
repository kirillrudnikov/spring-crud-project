package ru.sevsu.kirillrudnikov.crud.dto.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import ru.sevsu.kirillrudnikov.crud.dto.CarDto;

import java.io.IOException;

public class CarSerializer extends StdSerializer<CarDto> {

    public CarSerializer() {
        this(null);
    }

    public CarSerializer(Class<CarDto> t) {
        super(t);
    }

    @Override
    public void serialize(CarDto value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        {
            gen.writeNumberField("id", value.getId());
            gen.writeNumberField("linkedUserId", value.getUser().getId());
            gen.writeStringField("brand", value.getBrand().name());
            gen.writeStringField("licensePlate", value.getLicensePlate());
        }
        gen.writeEndObject();
    }

}