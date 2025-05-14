package com.example.Manufac.repo;

import com.example.Manufac.models.Machines;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface MachinesRepository extends CrudRepository<Machines, BigInteger> {

    @Query("SELECT m FROM Machines m WHERE m.is_active = true")
    List<Machines> findActiveModels();
}
