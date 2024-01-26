package org.example.remote;

import org.example.remote.dto.DisciplineDto;

public interface DisciplineService {
    Object createDiscipline(DisciplineDto discipline);
    Object getAllDiscipline(String name, Integer pageNumber, Integer pageSize);
    Object getAllLab(Long id, Integer pageNumber, Integer pageSize);
    Object deleteDisciplineById(Long id);
    Object addLabToDiscipline(Long disciplineId, Long labId);
    Object removeLabToDiscipline(Long disciplineId, Long labId);
}
