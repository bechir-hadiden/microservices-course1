package com.techie.microservices.patient.dto;

import java.time.LocalDate;

public record PatientResponse(String id, String firstName, String lastName,
                               LocalDate dateOfBirth, String medicalRecordNumber,
                               String phoneNumber, String address) { }
