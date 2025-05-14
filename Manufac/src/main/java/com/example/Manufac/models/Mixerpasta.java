package com.example.Manufac.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Mixerpasta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private BigInteger model;
    private int speed_of_rot_min, power_kwt, noise_level_db;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
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

    public int getSpeed_of_rot_min() {
        return speed_of_rot_min;
    }

    public void setSpeed_of_rot_min(int speed_of_rot_min) {
        this.speed_of_rot_min = speed_of_rot_min;
    }

    public int getPower_kwt() {
        return power_kwt;
    }

    public void setPower_kwt(int power_kwt) {
        this.power_kwt = power_kwt;
    }

    public int getNoise_level_db() {
        return noise_level_db;
    }

    public void setNoise_level_db(int noise_level_db) {
        this.noise_level_db = noise_level_db;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
