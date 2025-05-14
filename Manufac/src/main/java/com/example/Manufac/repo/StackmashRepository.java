package com.example.Manufac.repo;

import com.example.Manufac.models.Stackmash;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface StackmashRepository extends CrudRepository<Stackmash, BigInteger> {
    @Query("SELECT st.id, st.compress_air_mpa, st.stack_speed_s_pcs, st.power_kwt, st.vacuum_supply, st.noise_level_db, st.statusST, m.model " +
            "FROM Stackmash st " +
            "JOIN Machines m ON st.model = m.id " +
            "WHERE st.statusST = 'USED'")
    List<Object[]> findUsedMachinesST();

    @Query("SELECT st.id, st.compress_air_mpa, st.stack_speed_s_pcs, st.power_kwt, st.vacuum_supply, st.noise_level_db, st.statusST, m.model " +
            "FROM Stackmash st " +
            "JOIN Machines m ON st.model = m.id ")
    List<Object[]> findMachinesST();
}
