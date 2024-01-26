package org.example.soa_lab3_LabService.service.bars;

import lombok.RequiredArgsConstructor;

import org.example.soa_lab3_LabService.common.throwable.exception.BadRequestException;
import org.example.soa_lab3_LabService.model.entity.DisciplineEntity;
import org.example.soa_lab3_LabService.model.entity.LabEntity;
import org.example.soa_lab3_LabService.service.bars.repository.DisciplineRepository;
import org.example.soa_lab3_LabService.service.lab.repository.LabRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DisciplineService {

    private final LabRepository labRepository;
    private final DisciplineRepository disciplineRepository;

    public DisciplineEntity createDiscipline(DisciplineEntity discipline) {
        discipline.setId(null);
        return disciplineRepository.save(discipline);
    }

    public Page<DisciplineEntity> getAllDiscipline(String name, Integer pageNumber, Integer pageSize) {
        if (Objects.isNull(name) || name.trim().equals(""))
            return disciplineRepository.findAll(PageRequest.of(pageNumber, pageSize));
        else
            return disciplineRepository.findAllByNameStartingWithIgnoreCase(name, PageRequest.of(pageNumber, pageSize));
    }

    public Page<LabEntity> getAllLabByDisciplineId(Long disciplineId, Integer pageNumber, Integer pageSize) {
        return labRepository.findAllByDisciplineId(disciplineId, PageRequest.of(pageNumber, pageSize));
    }

    public void addLabToDiscipline(Long disciplineId, Long labId) {
        LabEntity lab = labRepository.findById(labId)
                .orElseThrow(() -> new BadRequestException("Lab с id " + labId + " не существует"));

        DisciplineEntity discipline = disciplineRepository.findById(disciplineId)
                .orElseThrow(() -> new BadRequestException("Discipline с id " + disciplineId + " не существует"));

        if (discipline.getLabs().contains(lab))
            throw new BadRequestException("Lab с id " + labId + " уже есть в данной дисциплине");

        discipline.getLabs().add(lab);
        disciplineRepository.save(discipline);
    }

    public void removeLabToDiscipline(Long disciplineId, Long labId) {
        LabEntity lab = labRepository.findById(labId)
                .orElseThrow(() -> new BadRequestException("Lab с id " + labId + " не существует"));

        DisciplineEntity discipline = disciplineRepository.findById(disciplineId)
                .orElseThrow(() -> new BadRequestException("Discipline с id " + disciplineId + " не существует"));

        if (!discipline.getLabs().contains(lab))
            throw new BadRequestException("Lab с id " + labId + " нет в данной дисциплине");

        discipline.getLabs().remove(lab);
        disciplineRepository.save(discipline);
    }

    public void deleteDisciplineById(Long id) {
        disciplineRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Discipline с id " + id + " не существует"));

        disciplineRepository.deleteById(id);
    }
}
