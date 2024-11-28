package com.example.medApp.service;

import com.example.medApp.models.HeartRate;
import com.example.medApp.models.Patient;
import com.example.medApp.repository.HeartRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeartRateService {
    @Autowired private HeartRateRepository heartRateRepository;
    @Autowired private PatientService patientService;

    public HeartRate recordHeartRate(Long patientId, HeartRate heartRate) {
        Patient patient = patientService.getPatient(patientId);
        heartRate.setPatient(patient);
        return heartRateRepository.save(heartRate);
    }

    public List<HeartRate> getHeartRates(Long patientId) {
        return heartRateRepository.findByPatientId(patientId);
    }
}
