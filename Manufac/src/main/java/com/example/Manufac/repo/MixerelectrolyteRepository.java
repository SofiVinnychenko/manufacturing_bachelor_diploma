package com.example.Manufac.repo;

import com.example.Manufac.models.Mixerelectrolyte;
import com.example.Manufac.models.Mixerpasta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface MixerelectrolyteRepository extends CrudRepository<Mixerelectrolyte, BigInteger> {
    @Query("SELECT mie.id, mie.power_kwt, mie.speed_of_rot_min, mie.noise_level_db, mie.statusE, m.model " +
            "FROM Mixerelectrolyte mie " +
            "JOIN Machines m ON mie.modelE = m.id " +
            "WHERE mie.statusE = 'USED'")
    List<Object[]> findUsedMachinesE();

    @Query("SELECT mie.id, mie.power_kwt, mie.speed_of_rot_min, mie.noise_level_db, mie.statusE, m.model " +
            "FROM Mixerelectrolyte mie " +
            "JOIN Machines m ON mie.modelE = m.id ")
    List<Object[]> findMachinesE();
}
