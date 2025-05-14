package com.example.Manufac.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Stackmash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger model;
    private float compress_air_mpa, stack_speed_s_pcs;
    private int power_kwt, vacuum_supply, noise_level_db;

    @Enumerated(EnumType.STRING)
    private Stackmash.StatusST statusST;

    public enum StatusST {
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

    public Stackmash.StatusST getStatusST() {
        return statusST;
    }
    public void setStatusST(Stackmash.StatusST statusST) {
        this.statusST = statusST;
    }

    public float getCompress_air_mpa() {
        return compress_air_mpa;
    }

    public void setCompress_air_mpa(float compress_air_mpa) {
        this.compress_air_mpa = compress_air_mpa;
    }

    public float getStack_speed_s_pcs() {
        return stack_speed_s_pcs;
    }

    public void setStack_speed_s_pcs(float stack_speed_s_pcs) {
        this.stack_speed_s_pcs = stack_speed_s_pcs;
    }

    public int getPower_kwt() {
        return power_kwt;
    }

    public void setPower_kwt(int power_kwt) {
        this.power_kwt = power_kwt;
    }

    public int getVacuum_supply() {
        return vacuum_supply;
    }

    public void setVacuum_supply(int vacuum_supply) {
        this.vacuum_supply = vacuum_supply;
    }

    public int getNoise_level_db() {
        return noise_level_db;
    }

    public void setNoise_level_db(int noise_level_db) {
        this.noise_level_db = noise_level_db;
    }
}
