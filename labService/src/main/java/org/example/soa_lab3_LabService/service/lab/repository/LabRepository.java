package org.example.soa_lab3_LabService.service.lab.repository;

import org.example.soa_lab3_LabService.model.entity.LabEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LabRepository extends CrudRepository<LabEntity, Long> {

    Page<LabEntity> findAllByIdIn(List<Long> ids, Pageable pageable);

    Page<LabEntity> findAllByDisciplineId(Long id, Pageable pageable);

    @Query("SELECT SUM(lr.minimalPoint) FROM lab_ref lr")
    Long getMinimalPointSum();

    @Query("SELECT lr FROM lab_ref lr WHERE lr.minimalPoint = (SELECT MAX(lrPod.minimalPoint) FROM lab_ref lrPod)")
    LabEntity findByMinimalPointIsMax();
}
