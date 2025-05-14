package com.example.Manufac.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Sealingchamber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger model;
    private float power_kwt, compress_psi, air_supply_mpa;
    private int hot_time_s, noise_level_db, seal_temp;

    @Enumerated(EnumType.STRING)
    private Sealingchamber.StatusSC statusSC;

    public enum StatusSC {
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

    public int getSeal_temp() {
        return seal_temp;
    }

    public void setSeal_temp(int seal_temp) {
        this.seal_temp = seal_temp;
    }

    public Sealingchamber.StatusSC getStatusSC() {
        return statusSC;
    }
    public void setStatusSC(Sealingchamber.StatusSC statusSC) {
        this.statusSC = statusSC;
    }

    public float getPower_kwt() {
        return power_kwt;
    }

    public void setPower_kwt(float power_kwt) {
        this.power_kwt = power_kwt;
    }

    public float getCompress_psi() {
        return compress_psi;
    }

    public void setCompress_psi(float compress_psi) {
        this.compress_psi = compress_psi;
    }

    public float getAir_supply_mpa() {
        return air_supply_mpa;
    }

    public void setAir_supply_mpa(float air_supply_mpa) {
        this.air_supply_mpa = air_supply_mpa;
    }

    public int getHot_time_s() {
        return hot_time_s;
    }

    public void setHot_time_s(int hot_time_s) {
        this.hot_time_s = hot_time_s;
    }

    public int getNoise_level_db() {
        return noise_level_db;
    }

    public void setNoise_level_db(int noise_level_db) {
        this.noise_level_db = noise_level_db;
    }
}
