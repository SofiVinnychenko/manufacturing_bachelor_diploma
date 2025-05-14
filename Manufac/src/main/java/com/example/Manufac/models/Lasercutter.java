package com.example.Manufac.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Lasercutter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger model;
    private float power_kwt;
    private int speed_of_mov_min, width_electrodes, length_electrodes, noise_level_db;

    @Enumerated(EnumType.STRING)
    private Lasercutter.StatusL statusL;

    public enum StatusL {
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

    public Lasercutter.StatusL getStatusL() {
        return statusL;
    }
    public void setStatusL(Lasercutter.StatusL statusL) {
        this.statusL = statusL;
    }

    public float getPower_kwt() {
        return power_kwt;
    }

    public void setPower_kwt(float power_kwt) {
        this.power_kwt = power_kwt;
    }

    public int getSpeed_of_mov_min() {
        return speed_of_mov_min;
    }

    public void setSpeed_of_mov_min(int speed_of_mov_min) {
        this.speed_of_mov_min = speed_of_mov_min;
    }

    public int getWidth_electrodes() {
        return width_electrodes;
    }

    public void setWidth_electrodes(int width_electrodes) {
        this.width_electrodes = width_electrodes;
    }

    public int getLength_electrodes() {
        return length_electrodes;
    }

    public void setLength_electrodes(int length_electrodes) {
        this.length_electrodes = length_electrodes;
    }

    public int getNoise_level_db() {
        return noise_level_db;
    }

    public void setNoise_level_db(int noise_level_db) {
        this.noise_level_db = noise_level_db;
    }
}
