package uz.kpi.motors.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import uz.kpi.motors.enums.CalcType;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class CalcTypeConverter implements AttributeConverter<CalcType, String> {

    @Override
    public String convertToDatabaseColumn(CalcType calcType) {
        if (calcType == null) {
            return null;
        }
        return calcType.toString();
    }



    @Override
    public CalcType convertToEntityAttribute(String name) {
        if (name == null) {
            return null;
        }

        return Stream.of(CalcType.values())
                .filter(c -> c.name().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}