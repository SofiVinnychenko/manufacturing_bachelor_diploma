package com.example.Manufac.repo;

import com.example.Manufac.models.Lasercutter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface LasercutterRepository extends CrudRepository<Lasercutter, BigInteger> {
    @Query("SELECT las.id, las.power_kwt, las.speed_of_mov_min, las.width_electrodes, las.length_electrodes, las.noise_level_db, las.statusL, m.model " +
            "FROM Lasercutter las " +
            "JOIN Machines m ON las.model = m.id " +
            "WHERE las.statusL = 'USED'")
    List<Object[]> findUsedMachinesL();

    @Query("SELECT las.id, las.power_kwt, las.speed_of_mov_min, las.width_electrodes, las.length_electrodes, las.noise_level_db, las.statusL, m.model " +
            "FROM Lasercutter las " +
            "JOIN Machines m ON las.model = m.id ")
    List<Object[]> findMachinesL();
}
