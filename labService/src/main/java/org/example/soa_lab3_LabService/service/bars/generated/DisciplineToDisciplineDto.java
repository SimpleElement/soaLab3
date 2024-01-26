package org.example.soa_lab3_LabService.service.bars.generated;



import org.example.soa_lab3_LabService.model.entity.DisciplineEntity;
import org.example.soa_lab3_LabService.ws.bars.dto.DisciplineDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DisciplineToDisciplineDto implements Converter<DisciplineEntity, DisciplineDto> {

    @Override
    public DisciplineDto convert(DisciplineEntity source) {
        DisciplineDto res = new DisciplineDto();

        res.setId(source.getId());
        res.setName(source.getName());
        res.setDescription(source.getDescription());
        return res;
    }
}
