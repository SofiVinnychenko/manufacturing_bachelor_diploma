package com.example.Manufac.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
public class WorkProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title, process, capacity;
    private int number, batch, morenumber;
    private BigInteger machines;
    private float onebatt_hour;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp datetime;

    public WorkProgram() {
    }

    public WorkProgram(int number, int morenumber, String title, int batch, String process, BigInteger machines, String capacity, float onebatt_hour, Timestamp datetime) {
        this.number = number;
        this.morenumber = morenumber;
        this.title = title;
        this.batch = batch;
        this.process = process;
        this.machines = machines;
        this.capacity = capacity;
        this.onebatt_hour = onebatt_hour;
        this.datetime = datetime;
    }

    public WorkProgram(int number, int morenumber, String title, int batch, String process, BigInteger machines, String capacity, float onebatt_hour, Timestamp datetime, Long id) {
        this(number, morenumber, title, batch, process, machines, capacity, onebatt_hour, datetime);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public BigInteger getMachines() { return machines; }

    public void setMachines(BigInteger machines) {
        this.machines = machines;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMorenumber() {
        return morenumber;
    }

    public void setMorenumber(int morenumber) {
        this.morenumber = morenumber;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public float getOnebatt_hour() {
        return onebatt_hour;
    }

    public void setOnebatt_hour(float onebatt_hour) {
        this.onebatt_hour = onebatt_hour;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
}
