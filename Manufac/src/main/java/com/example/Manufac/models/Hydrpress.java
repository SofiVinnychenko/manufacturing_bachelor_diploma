package com.example.Manufac.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Hydrpress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger model;
    private float pressure_kn;
    private int electrode_thickness, calendering_speed, noise_level_db;

    @Enumerated(EnumType.STRING)
    private Hydrpress.StatusH statusH;

    public enum StatusH {
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

    public Hydrpress.StatusH getStatusH() {
        return statusH;
    }

    public void setStatusH(Hydrpress.StatusH statusH) {
        this.statusH = statusH;
    }

    public float getPressure_kn() {
        return pressure_kn;
    }

    public void setPressure_kn(float pressure_kn) {
        this.pressure_kn = pressure_kn;
    }

    public int getElectrode_thickness() {
        return electrode_thickness;
    }

    public void setElectrode_thickness(int electrode_thickness) {
        this.electrode_thickness = electrode_thickness;
    }

    public int getCalendering_speed() {
        return calendering_speed;
    }

    public void setCalendering_speed(int calendering_speed) {
        this.calendering_speed = calendering_speed;
    }

    public int getNoise_level_db() {
        return noise_level_db;
    }

    public void setNoise_level_db(int noise_level_db) {
        this.noise_level_db = noise_level_db;
    }
}
