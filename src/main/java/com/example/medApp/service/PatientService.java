package com.example.medApp.service;

import com.example.medApp.exception.ResourceNotFoundException;
import com.example.medApp.models.Patient;
import com.example.medApp.models.User;
import com.example.medApp.repository.PatientRepository;
import com.example.medApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatient(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
    }
}
