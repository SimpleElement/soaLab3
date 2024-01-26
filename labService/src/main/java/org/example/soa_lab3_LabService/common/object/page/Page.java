package org.example.soa_lab3_LabService.common.object.page;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page {
    @Min(value = 0, message = "Количество страниц должно быть больше или равно 0")
    protected Integer pageNumber = 0;

    @Min(value = 1, message = "Размер страницы должен быть больше или равен 1")
    @Max(value = 1000, message = "Максимальный размер страницы должен быть меньше или равен 1000")
    protected Integer pageSize = 100;
}
