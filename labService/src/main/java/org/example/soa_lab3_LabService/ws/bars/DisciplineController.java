package org.example.soa_lab3_LabService.ws.bars;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.soa_lab3_LabService.common.object.page.PageResponse;
import org.example.soa_lab3_LabService.model.entity.DisciplineEntity;
import org.example.soa_lab3_LabService.model.entity.LabEntity;
import org.example.soa_lab3_LabService.service.bars.DisciplineService;
import org.example.soa_lab3_LabService.ws.bars.dto.DisciplineDto;
import org.example.soa_lab3_LabService.ws.bars.dto.DisciplineFilter;
import org.example.soa_lab3_LabService.ws.bars.dto.LabDisciplineDto;
import org.example.soa_lab3_LabService.ws.bars.dto.LabFilter;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/bars/discipline")
@RequiredArgsConstructor
public class DisciplineController {

    private final DisciplineService disciplineService;
    private final ConversionService conversionService;

    @PostMapping
    public DisciplineDto createDiscipline(@Valid @RequestBody DisciplineDto discipline) {
        return conversionService.convert(
                disciplineService.createDiscipline(conversionService.convert(discipline, DisciplineEntity.class)),
                DisciplineDto.class
        );
    }

    @GetMapping
    public PageResponse<DisciplineDto> getAllDiscipline(DisciplineFilter disciplineFilter) {
        Page<DisciplineEntity> page = disciplineService.getAllDiscipline(disciplineFilter.getName(), disciplineFilter.getPageNumber(), disciplineFilter.getPageSize());
        PageResponse<DisciplineDto> response = conversionService.convert(page, PageResponse.class);
        response.setContent(
                page.getContent().stream()
                        .map(disciplineEntity -> conversionService.convert(disciplineEntity, DisciplineDto.class))
                        .collect(Collectors.toList())
        );
        return response;
    }

    @GetMapping("{id}/lab")
    public PageResponse<LabDisciplineDto> getAllLab(@PathVariable Long id, LabFilter labFilter) {
        Page<LabEntity> page = disciplineService.getAllLabByDisciplineId(id, labFilter.getPageNumber(), labFilter.getPageSize());

        PageResponse<LabDisciplineDto> response = conversionService.convert(page, PageResponse.class);
        response.setContent(
                page.getContent().stream()
                        .map(labEntity -> conversionService.convert(labEntity, LabDisciplineDto.class))
                        .collect(Collectors.toList())
        );
        return response;
    }

    @DeleteMapping("/{id}")
    public void deleteDisciplineById(@PathVariable Long id) {
        this.disciplineService.deleteDisciplineById(id);
    }

    @PostMapping("/{disciplineId}/labwork/{labId}/add")
    public void addLabToDiscipline(@PathVariable("disciplineId") Long disciplineId, @PathVariable("labId") Long labId) {
        this.disciplineService.addLabToDiscipline(disciplineId, labId);
    }

    @DeleteMapping("/{disciplineId}/labwork/{labId}/remove")
    public void removeLabToDiscipline(@PathVariable("disciplineId") Long disciplineId, @PathVariable("labId") Long labId) {
        this.disciplineService.removeLabToDiscipline(disciplineId, labId);
    }
}