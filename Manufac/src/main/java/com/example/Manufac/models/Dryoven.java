package com.example.Manufac.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Dryoven {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger model;
    private float power_kwt;
    private int temp_range_min, temp_range_max, noise_level_db;

    @Enumerated(EnumType.STRING)
    private Dryoven.StatusD statusD;

    public enum StatusD {
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

    public Dryoven.StatusD getStatusD() {
        return statusD;
    }

    public void setStatusD(Dryoven.StatusD statusD) {
        this.statusD = statusD;
    }

    public float getPower_kwt() {
        return power_kwt;
    }

    public void setPower_kwt(float power_kwt) {
        this.power_kwt = power_kwt;
    }

    public int getTemp_range_min() {
        return temp_range_min;
    }

    public void setTemp_range_min(int temp_range_min) {
        this.temp_range_min = temp_range_min;
    }

    public int getTemp_range_max() {
        return temp_range_max;
    }

    public void setTemp_range_max(int temp_range_max) {
        this.temp_range_max = temp_range_max;
    }

    public int getNoise_level_db() {
        return noise_level_db;
    }

    public void setNoise_level_db(int noise_level_db) {
        this.noise_level_db = noise_level_db;
    }
}
