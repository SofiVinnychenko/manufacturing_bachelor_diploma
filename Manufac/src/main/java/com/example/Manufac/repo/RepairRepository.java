package com.example.Manufac.repo;

import com.example.Manufac.models.Repair;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepairRepository extends CrudRepository<Repair, Long> {

    @Query("SELECT r.id, r.process, r.problem, r.details, r.possible_reasons, r.abnormal_value, r.normal_value_min, r.normal_value_max, r.status, m.model " +
            "FROM Repair r " +
            "JOIN Machines m ON r.machines_model = m.id")
    List<Object[]> findAllWithMachineModels();

    @Query("SELECT r.id, r.process, r.problem, r.details, r.possible_reasons, r.abnormal_value, r.normal_value_min, r.normal_value_max, r.status, r.spent_time, m.model " +
            "FROM Repair r " +
            "JOIN Machines m ON r.machines_model = m.id " +
            "WHERE r.status = 'COMPLETED'")
    List<Object[]> findCompletedWithMachineModels();
}
