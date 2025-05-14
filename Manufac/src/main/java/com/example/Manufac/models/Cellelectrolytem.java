package com.example.Manufac.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Cellelectrolytem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger model;
    private float vacuum_degree_mpa, power_kwt;
    private int noise_level_db;

    @Enumerated(EnumType.STRING)
    private Cellelectrolytem.StatusC statusC;

    public enum StatusC {
        USED,
        STORAGE
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getModel() {
        return model;
    }

    public void setModel(BigInteger model) {
        this.model = model;
    }

    public Cellelectrolytem.StatusC getStatusC() {
        return statusC;
    }

    public void setStatusC(Cellelectrolytem.StatusC statusC) {
        this.statusC = statusC;
    }

    public float getVacuum_degree_mpa() {
        return vacuum_degree_mpa;
    }

    public void setVacuum_degree_mpa(float vacuum_degree_mpa) {
        this.vacuum_degree_mpa = vacuum_degree_mpa;
    }

    public float getPower_kwt() {
        return power_kwt;
    }

    public void setPower_kwt(float power_kwt) {
        this.power_kwt = power_kwt;
    }

    public int getNoise_level_db() {
        return noise_level_db;
    }

    public void setNoise_level_db(int noise_level_db) {
        this.noise_level_db = noise_level_db;
    }
}
