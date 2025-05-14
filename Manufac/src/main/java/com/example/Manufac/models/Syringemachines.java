package com.example.Manufac.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Syringemachines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger model;
    private float power_kwt;
    private int pressure_bar, equipment_speed, noise_level_db;

    @Enumerated(EnumType.STRING)
    private Syringemachines.StatusS statusS;

    public enum StatusS {
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

    public Syringemachines.StatusS getStatusS() {
        return statusS;
    }
    public void setStatusS(Syringemachines.StatusS statusS) {
        this.statusS = statusS;
    }

    public float getPower_kwt() {
        return power_kwt;
    }

    public void setPower_kwt(float power_kwt) {
        this.power_kwt = power_kwt;
    }

    public int getPressure_bar() {
        return pressure_bar;
    }

    public void setPressure_bar(int pressure_bar) {
        this.pressure_bar = pressure_bar;
    }

    public int getEquipment_speed() {
        return equipment_speed;
    }

    public void setEquipment_speed(int equipment_speed) {
        this.equipment_speed = equipment_speed;
    }

    public int getNoise_level_db() {
        return noise_level_db;
    }

    public void setNoise_level_db(int noise_level_db) {
        this.noise_level_db = noise_level_db;
    }
}
