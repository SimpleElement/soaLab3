package org.example.soa_lab3_LabService.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.soa_lab3_LabService.model.emb.CoordinatesEmb;
import org.example.soa_lab3_LabService.model.emb.PersonEmb;
import org.example.soa_lab3_LabService.model.enm.DifficultyEnum;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "lab_ref")
public class LabEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lab_seq")
    private Long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    @Column(name = "name")
    private String name; //Поле не может быть null, Строка не может быть пустой

    @Column(name = "creation_date")
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    @Column(name = "minimal_point")
    private Integer minimalPoint; //Поле может быть null, Значение поля должно быть больше 0

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty")
    private DifficultyEnum difficulty; //Поле не может быть null

    @Embedded
    private CoordinatesEmb coordinates; //Поле не может быть null

    @Embedded
    private PersonEmb author; //Поле может быть null

    @ManyToMany(mappedBy = "labs")
    private List<DisciplineEntity> discipline;
}
