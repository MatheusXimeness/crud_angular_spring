package com.matheus.enums.converters;

import com.matheus.enums.Category;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true) //JPA vai aplicar essa interface sempre que for necessario
public class CategoryConverter implements AttributeConverter<Category, String> {
    @Override
    public String convertToDatabaseColumn(Category category) {
        if( category == null) {
            return null;
        }
        return category.getValue();
    }

    @Override
    public Category convertToEntityAttribute(String value) {
        if( value == null) {
            return null;
        }
        return Stream.of(Category.values())// of -> transforma qualquer array de informações em um streaming
                .filter(c -> c.getValue().equals(value)) //compara strings
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
