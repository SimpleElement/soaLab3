package org.example.soa_lab3_LabService.model.emb;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class CoordinatesEmb {
    @Column(name = "coordinates_x")
    private Long x;

    @Column(name = "coordinates_y")
    private Double y; //Максимальное значение поля: 395, Поле не может быть null
}
