package com.example.Manufac.repo;

import com.example.Manufac.models.Mixerpasta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface MixerpastaRepository extends CrudRepository<Mixerpasta, BigInteger> {

    @Query("SELECT mi.id, mi.speed_of_rot_min, mi.power_kwt, mi.noise_level_db, mi.status, m.model " +
            "FROM Mixerpasta mi " +
            "JOIN Machines m ON mi.model = m.id " +
            "WHERE mi.status = 'USED'")
    List<Object[]> findUsedMachines();

    @Query("SELECT mi.id, mi.speed_of_rot_min, mi.power_kwt, mi.noise_level_db, mi.status, m.model " +
            "FROM Mixerpasta mi " +
            "JOIN Machines m ON mi.model = m.id ")
    List<Object[]> findMachines();
}
