package com.example.Manufac.repo;

import com.example.Manufac.models.Syringemachines;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface SyringemachinesRepository extends CrudRepository<Syringemachines, BigInteger> {

    @Query("SELECT syr.id, syr.power_kwt, syr.pressure_bar, syr.equipment_speed, syr.noise_level_db, syr.statusS, m.model " +
            "FROM Syringemachines syr " +
            "JOIN Machines m ON syr.model = m.id " +
            "WHERE syr.statusS = 'USED'")
    List<Object[]> findUsedMachinesS();

    @Query("SELECT syr.id, syr.power_kwt, syr.pressure_bar, syr.equipment_speed, syr.noise_level_db, syr.statusS, m.model " +
            "FROM Syringemachines syr " +
            "JOIN Machines m ON syr.model = m.id ")
    List<Object[]> findMachinesS();
}
