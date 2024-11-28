package com.example.medApp.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HeartRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private Integer heartrate;
    private LocalDateTime timestamp = LocalDateTime.now();

    public void setPatient(Patient patient) {

    }
}