package com.example.Manufac.repo;

import com.example.Manufac.models.Sealingchamber;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface SealingchamberRepository extends CrudRepository<Sealingchamber, BigInteger> {
    @Query("SELECT seal.id, seal.power_kwt, seal.compress_psi, seal.air_supply_mpa, seal.hot_time_s, seal.noise_level_db, seal.seal_temp, seal.statusSC, m.model " +
            "FROM Sealingchamber seal " +
            "JOIN Machines m ON seal.model = m.id " +
            "WHERE seal.statusSC = 'USED'")
    List<Object[]> findUsedMachinesSC();

    @Query("SELECT seal.id, seal.power_kwt, seal.compress_psi, seal.air_supply_mpa, seal.hot_time_s, seal.noise_level_db, seal.seal_temp, seal.statusSC, m.model " +
            "FROM Sealingchamber seal " +
            "JOIN Machines m ON seal.model = m.id")
    List<Object[]> findMachinesSC();
}
