package org.example.ejb.service;

import javax.ejb.*;
import javax.servlet.ServletContext;

import org.example.ejb.rest.DisciplineRest;
import org.example.remote.dto.DisciplineDto;
import org.example.remote.DisciplineService;

@Stateless
@Remote(DisciplineService.class)
public class DisciplineServiceImpl implements DisciplineService {

    @EJB
    private DisciplineRest disciplineRest;

    @Override
    public Object createDiscipline(DisciplineDto discipline) {
        return disciplineRest.createDiscipline(discipline);
    }

    @Override
    public Object getAllDiscipline(String name, Integer pageNumber, Integer pageSize) {
        return disciplineRest.getAllDiscipline(name, pageNumber, pageSize);
    }

    @Override
    public Object getAllLab(Long id, Integer pageNumber, Integer pageSize) {
        return disciplineRest.getAllLab(id, pageNumber, pageSize);
    }

    @Override
    public Object deleteDisciplineById(Long id) {
        return disciplineRest.deleteDisciplineById(id);
    }

    @Override
    public Object addLabToDiscipline(Long disciplineId, Long labId) {
        return disciplineRest.addLabToDiscipline(disciplineId, labId);
    }

    @Override
    public Object removeLabToDiscipline(Long disciplineId, Long labId) {
        return disciplineRest.removeLabToDiscipline(disciplineId, labId);
    }
}
