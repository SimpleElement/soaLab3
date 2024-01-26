package org.example.soa_lab3_LabService.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "discipline_ref")
public class DisciplineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discipline_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "discipline_labs",
            joinColumns = { @JoinColumn(name = "discipline_id") },
            inverseJoinColumns = { @JoinColumn(name = "lab_id") })
    private List<LabEntity> labs;
}
