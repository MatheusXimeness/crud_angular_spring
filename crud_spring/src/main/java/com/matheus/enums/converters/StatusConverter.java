package com.matheus.enums.converters;

import com.matheus.enums.Status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true) //JPA vai aplicar essa interface sempre que for necessario
public class StatusConverter implements AttributeConverter<Status, String> {
    @Override
    public String convertToDatabaseColumn(Status status) {
        if( status == null) {
            return null;
        }
        return status.getValue();
    }

    @Override
    public Status convertToEntityAttribute(String value) {
        if( value == null) {
            return null;
        }
        return Stream.of(Status.values())// of -> transforma qualquer array de informações em um streaming
                .filter(c -> c.getValue().equals(value)) //compara strings
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
