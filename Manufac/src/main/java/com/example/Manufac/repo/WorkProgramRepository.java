package com.example.Manufac.repo;

import com.example.Manufac.models.WorkProgram;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;


public interface WorkProgramRepository extends CrudRepository<WorkProgram, Long> {
    List<WorkProgram> findByDatetimeBetween(Timestamp start, Timestamp end);
}
