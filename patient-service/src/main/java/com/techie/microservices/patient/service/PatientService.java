package com.techie.microservices.patient.service;

import com.techie.microservices.patient.dto.PatientRequest;
import com.techie.microservices.patient.dto.PatientResponse;
import com.techie.microservices.patient.model.Patient;
import com.techie.microservices.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientResponse createPatient(PatientRequest patientRequest) {
        Patient patient = Patient.builder()
                .firstName(patientRequest.firstName())
                .lastName(patientRequest.lastName())
                .dateOfBirth(patientRequest.dateOfBirth())
                .medicalRecordNumber(patientRequest.medicalRecordNumber())
                .phoneNumber(patientRequest.phoneNumber())
                .address(patientRequest.address())
                .build();

        patientRepository.save(patient);
        log.info("Patient created successfully");

        return toResponse(patient);
    }

    public List<PatientResponse> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private PatientResponse toResponse(Patient patient) {
        return new PatientResponse(patient.getId(), patient.getFirstName(), patient.getLastName(),
                patient.getDateOfBirth(), patient.getMedicalRecordNumber(),
                patient.getPhoneNumber(), patient.getAddress());
    }
}
