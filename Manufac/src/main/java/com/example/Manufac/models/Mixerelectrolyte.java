package com.example.Manufac.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Mixerelectrolyte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger modelE;
    private int power_kwt, speed_of_rot_min, noise_level_db;

    @Enumerated(EnumType.STRING)
    private Mixerelectrolyte.StatusE statusE;

    public enum StatusE {
        USED,
        STORAGE
    }


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getModelE() {
        return modelE;
    }

    public void setModelE(BigInteger modelE) {
        this.modelE = modelE;
    }

    public Mixerelectrolyte.StatusE getStatusE() {
        return statusE;
    }

    public void setStatus(Mixerelectrolyte.StatusE statusE) {
        this.statusE = statusE;
    }

    public int getPower_kwt() {
        return power_kwt;
    }

    public void setPower_kwt(int power_kwt) {
        this.power_kwt = power_kwt;
    }

    public int getSpeed_of_rot_min() {
        return speed_of_rot_min;
    }

    public void setSpeed_of_rot_min(int speed_of_rot_min) {
        this.speed_of_rot_min = speed_of_rot_min;
    }

    public int getNoise_level_db() {
        return noise_level_db;
    }

    public void setNoise_level_db(int noise_level_db) {
        this.noise_level_db = noise_level_db;
    }

}
