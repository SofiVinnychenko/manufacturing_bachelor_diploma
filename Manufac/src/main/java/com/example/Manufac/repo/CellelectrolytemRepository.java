package com.example.Manufac.repo;

import com.example.Manufac.models.Cellelectrolytem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface CellelectrolytemRepository extends CrudRepository<Cellelectrolytem, BigInteger> {
    @Query("SELECT cel.id, cel.vacuum_degree_mpa, cel.power_kwt, cel.noise_level_db, cel.statusC, m.model " +
            "FROM Cellelectrolytem cel " +
            "JOIN Machines m ON cel.model = m.id " +
            "WHERE cel.statusC = 'USED'")
    List<Object[]> findUsedMachinesC();

    @Query("SELECT cel.id, cel.vacuum_degree_mpa, cel.power_kwt, cel.noise_level_db, cel.statusC, m.model " +
            "FROM Cellelectrolytem cel " +
            "JOIN Machines m ON cel.model = m.id ")
    List<Object[]> findMachinesC();
}
