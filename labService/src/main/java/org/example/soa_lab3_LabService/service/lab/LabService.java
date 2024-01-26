package org.example.soa_lab3_LabService.service.lab;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.example.soa_lab3_LabService.common.throwable.exception.BadRequestException;
import org.example.soa_lab3_LabService.common.throwable.exception.NotFoundException;
import org.example.soa_lab3_LabService.model.entity.LabEntity;
import org.example.soa_lab3_LabService.service.lab.jooq.JooqService;
import org.example.soa_lab3_LabService.service.lab.repository.LabRepository;
import org.jooq.Condition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class LabService {

    private final JooqService jooqService;

    private final LabRepository labRepository;

    public LabEntity createLab(LabEntity lab) {
        lab.setId(null);
        lab.setCreationDate(LocalDateTime.now());
        return labRepository.save(lab);
    }

    public Page<LabEntity> getAllLab(Condition condition, Sort sort, Integer pageNumber, Integer pageSize) {
        return jooqService.findAllLabByPredicate(condition, sort, pageNumber, pageSize);
    }

    public LabEntity getLabById(String id) {
        if (!NumberUtils.isCreatable(id)) {
            throw new BadRequestException("Identifier should be number");
        }

        Long longId = NumberUtils.toLong(id);
        return labRepository.findById(longId).orElseThrow(() -> new NotFoundException("Lab with id = " + id + " not found"));
    }

    public LabEntity updateLabById(String id, LabEntity lab) {
        if (!NumberUtils.isCreatable(id)) {
            throw new BadRequestException("Identifier should be number");
        }

        Long longId = NumberUtils.toLong(id);
        if (!labRepository.existsById(longId)) {
            throw new NotFoundException("Lab with id = " + id + " not found");
        }

        lab.setId(longId);
        lab.setCreationDate(labRepository.findById(longId).get().getCreationDate());
        return labRepository.save(lab);
    }

    public LabEntity deleteLabById(String id) {
        if (!NumberUtils.isCreatable(id)) {
            throw new BadRequestException("Identifier should be number");
        }

        Long longId = NumberUtils.toLong(id);
        LabEntity removedEntity = labRepository.findById(longId).orElseThrow(() -> new NotFoundException("Lab with id = " + id + " not found"));

        labRepository.deleteById(longId);
        return removedEntity;
    }

    public Long getMinimalPointSum() {
        return labRepository.getMinimalPointSum();
    }

    public LabEntity getMinimalPointMax() {
        return labRepository.findByMinimalPointIsMax();
    }
}
