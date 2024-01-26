package org.example.soa_lab3_LabService.model.emb;

import jakarta.persistence.*;
import lombok.Data;
import org.example.soa_lab3_LabService.model.enm.ColorEnum;
import org.example.soa_lab3_LabService.model.enm.CountryEnum;

import java.time.LocalDateTime;

@Data
@Embeddable
public class PersonEmb {
    @Column(name = "person_name")
    private String name; //Поле не может быть null, Строка не может быть пустой

    @Column(name = "person_birthday")
    private LocalDateTime birthday; //Поле не может быть null

    @Enumerated(EnumType.STRING)
    @Column(name = "person_eye_color")
    private ColorEnum eyeColor; //Поле может быть null

    @Enumerated(EnumType.STRING)
    @Column(name = "person_hair_color")
    private ColorEnum hairColor; //Поле может быть null

    @Enumerated(EnumType.STRING)
    @Column(name = "person_nationality")
    private CountryEnum nationality; //Поле может быть null

    @Embedded
    private LocationEmb location; //Поле может быть null
}
