package org.example.soa_lab3_LabService.ws.lab.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.soa_lab3_LabService.ws.lab.validation.constraint.LabDtoConstraint;

@Getter
@Setter
@LabDtoConstraint
public class LabDto {
    private Long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    private String name; //Поле не может быть null, Строка не может быть пустой

    private String creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    private String minimalPoint; //Поле может быть null, Значение поля должно быть больше 0

    private String difficulty; //Поле не может быть null

    private CoordinatesDto coordinates; //Поле не может быть null

    private PersonDto author; //Поле может быть null
}
