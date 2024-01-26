package org.example.soa_lab3_LabService.service.bars.generated;

import org.example.soa_lab3_LabService.model.entity.LabEntity;
import org.example.soa_lab3_LabService.ws.bars.dto.LabDisciplineDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LabDisciplineToLabDisciplineDto implements Converter<LabEntity, LabDisciplineDto> {

    @Override
    public LabDisciplineDto convert(LabEntity source) {
        LabDisciplineDto res = new LabDisciplineDto();

        res.setId(source.getId());
        res.setName(source.getName());
        res.setAuthorName(source.getAuthor().getName());
        return res;
    }
}
