package com.example.Manufac.models;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalTime;

@Entity
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String process, problem, details, possible_reasons;
    private BigInteger machines_model;
    private float abnormal_value, normal_value_min, normal_value_max;
    private LocalTime spent_time;

    @Enumerated(EnumType.STRING)
    private Repair.Status status;

    public enum Status {
        SENT,
        COMPLETED
    }

    public Repair(){}

    public Repair(String process, BigInteger machines_model, String problem, String possible_reasons, float abnormal_value, float normal_value_max, float normal_value_min, Status status) {
        this.process = process;
        this.machines_model = machines_model;
        this.problem = problem;
        this.abnormal_value = abnormal_value;
        this.status = status;
        this.possible_reasons = possible_reasons;
        this.normal_value_min = normal_value_min;
        this.normal_value_max = normal_value_max;
    }

    public Repair(String details, LocalTime spent_time, Long id) {
        this.details = details;
        this.spent_time = spent_time;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public BigInteger getMachines_model() {
        return machines_model;
    }

    public void setMachines_model(BigInteger machines_model) {
        this.machines_model = machines_model;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Repair.Status getStatus() {
        return status;
    }

    public void setStatus(Repair.Status status) {
        this.status = status;
    }

    public float getAbnormal_value() {
        return abnormal_value;
    }

    public void setAbnormal_value(float abnormal_value) {
        this.abnormal_value = abnormal_value;
    }

    public String getPossible_reasons() {
        return possible_reasons;
    }

    public void setPossible_reasons(String possible_reasons) {
        this.possible_reasons = possible_reasons;
    }

    public float getNormal_value_min() {
        return normal_value_min;
    }

    public void setNormal_value_min(float normal_value_min) {
        this.normal_value_min = normal_value_min;
    }

    public LocalTime getSpent_time() {
        return spent_time;
    }

    public void setSpent_time(LocalTime spent_time) {
        this.spent_time = spent_time;
    }

    public float getNormal_value_max() {
        return normal_value_max;
    }

    public void setNormal_value_max(float normal_value_max) {
        this.normal_value_max = normal_value_max;
    }
}
