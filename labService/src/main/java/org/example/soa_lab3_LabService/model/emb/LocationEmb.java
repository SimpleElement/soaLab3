package org.example.soa_lab3_LabService.model.emb;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class LocationEmb {
    @Column(name = "person_location_name")
    private String name; //Поле не может быть null

    @Column(name = "person_location_x")
    private Float x; //Поле не может быть null

    @Column(name = "person_location_y")
    private Double y; //Поле не может быть null
}
