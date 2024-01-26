package org.example.soa_lab3_LabService.ws.lab.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoordinatesDto {
    private String x;

    private String y; //Максимальное значение поля: 395, Поле не может быть null
}
