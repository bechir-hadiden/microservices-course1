package com.techie.microservices.patient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(value = "patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String medicalRecordNumber;
    private String phoneNumber;
    private String address;
}
