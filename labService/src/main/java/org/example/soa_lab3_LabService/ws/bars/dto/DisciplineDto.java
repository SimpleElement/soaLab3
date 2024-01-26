package org.example.soa_lab3_LabService.ws.bars.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplineDto {
    private Long id;

    @NotBlank(message = "Поле Name не может быть пустым")
    @Size(max = 254, message = "Поле Name не может быть больше 254 символа")
    private String name;

    @NotBlank(message = "Поле Description не может быть пустым")
    @Size(max = 254, message = "Поле Description не может быть больше 254 символа")
    private String description;
}
