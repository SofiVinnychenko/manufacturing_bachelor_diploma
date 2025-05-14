package com.example.Manufac.repo;

import com.example.Manufac.models.Dryoven;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface DryovenRepository extends CrudRepository<Dryoven, BigInteger> {
    @Query("SELECT dry.id, dry.power_kwt, dry.temp_range_min, dry.temp_range_max, dry.noise_level_db, dry.statusD, m.model " +
            "FROM Dryoven dry " +
            "JOIN Machines m ON dry.model = m.id " +
            "WHERE dry.statusD = 'USED'")
    List<Object[]> findUsedMachinesD();

    @Query("SELECT dry.id, dry.power_kwt, dry.temp_range_min, dry.temp_range_max, dry.noise_level_db, dry.statusD, m.model " +
            "FROM Dryoven dry " +
            "JOIN Machines m ON dry.model = m.id ")
    List<Object[]> findMachinesD();
}
