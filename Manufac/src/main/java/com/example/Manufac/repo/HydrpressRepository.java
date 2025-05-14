package com.example.Manufac.repo;

import com.example.Manufac.models.Hydrpress;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface HydrpressRepository extends CrudRepository<Hydrpress, BigInteger> {
    @Query("SELECT hyd.id, hyd.pressure_kn, hyd.electrode_thickness, hyd.calendering_speed, hyd.noise_level_db, hyd.statusH, m.model " +
            "FROM Hydrpress hyd " +
            "JOIN Machines m ON hyd.model = m.id " +
            "WHERE hyd.statusH = 'USED'")
    List<Object[]> findUsedMachinesH();

    @Query("SELECT hyd.id, hyd.pressure_kn, hyd.electrode_thickness, hyd.calendering_speed, hyd.noise_level_db, hyd.statusH, m.model " +
            "FROM Hydrpress hyd " +
            "JOIN Machines m ON hyd.model = m.id ")
    List<Object[]> findMachinesH();
}
