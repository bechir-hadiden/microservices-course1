package com.techie.microservices.patient.controller;

import com.techie.microservices.patient.dto.PatientRequest;
import com.techie.microservices.patient.dto.PatientResponse;
import com.techie.microservices.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PatientResponse createPatient(@RequestBody PatientRequest patientRequest) {
        return patientService.createPatient(patientRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PatientResponse> getAllPatients() {
        return patientService.getAllPatients();
    }
}
