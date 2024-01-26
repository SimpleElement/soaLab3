package org.example.soa_lab3_LabService.ws.lab;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.soa_lab3_LabService.common.object.page.PageResponse;
import org.example.soa_lab3_LabService.model.entity.LabEntity;
import org.example.soa_lab3_LabService.service.lab.LabService;
import org.example.soa_lab3_LabService.ws.lab.dto.LabDto;
import org.example.soa_lab3_LabService.ws.lab.dto.LabFilter;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/lab")
@RequiredArgsConstructor
public class LabController {

    private final LabService labService;

    private final ConversionService conversionService;

    @PostMapping
    public LabDto creatLab(@Valid @RequestBody LabDto lab) {
        return conversionService.convert(
                labService.createLab(
                     conversionService.convert(lab, LabEntity.class)
                ),
                LabDto.class
        );
    }

    @GetMapping
    public PageResponse<LabDto> getAllLab(@Valid LabFilter labFilter) {
        Page<LabEntity> page = labService.getAllLab(labFilter.toPredicate(), labFilter.getSort(), labFilter.getPageNumber(), labFilter.getPageSize());

        PageResponse<LabDto> response = conversionService.convert(page, PageResponse.class);
        response.setContent(
                page.getContent().stream()
                        .map(labEntity -> conversionService.convert(labEntity, LabDto.class))
                        .collect(Collectors.toList())
        );
        return response;
    }

    @GetMapping("/{id}")
    public LabDto getLabById(@PathVariable String id) {
        return conversionService.convert(labService.getLabById(id), LabDto.class);
    }

    @PutMapping("/{id}")
    public LabDto updateLabById(@PathVariable String id, @Valid @RequestBody LabDto lab) {
        return conversionService.convert(
                labService.updateLabById(
                        id,
                        conversionService.convert(lab, LabEntity.class)
                ),
                LabDto.class
        );
    }

    @DeleteMapping("/{id}")
    public LabDto deleteLabById(@PathVariable String id) {
        return conversionService.convert(labService.deleteLabById(id), LabDto.class);
    }

    @GetMapping("/minimalPoint/sum")
    public Long getMinimalPointSum() {
        return labService.getMinimalPointSum();
    }

    @GetMapping("/minimalPoint/max")
    public LabDto getMinimalPointMax() {
        return conversionService.convert(labService.getMinimalPointMax(), LabDto.class);
    }
}
