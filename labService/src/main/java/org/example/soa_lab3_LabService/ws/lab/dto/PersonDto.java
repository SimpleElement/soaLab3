package org.example.soa_lab3_LabService.ws.lab.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class PersonDto {
    private String name; //Поле не может быть null, Строка не может быть пустой

    private String birthday; //Поле не может быть null

    private String eyeColor; //Поле может быть null

    private String hairColor; //Поле может быть null

    private String nationality; //Поле может быть null

    private LocationDto location; //Поле может быть null
}
