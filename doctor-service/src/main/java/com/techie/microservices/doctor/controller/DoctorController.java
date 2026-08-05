package com.techie.microservices.doctor.controller;

import com.techie.microservices.doctor.model.Doctor;
import com.techie.microservices.doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/available/{doctorId}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isAvailable(@PathVariable Long doctorId) {
        return doctorService.isAvailable(doctorId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/speciality/{speciality}")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getBySpeciality(@PathVariable String speciality) {
        return doctorService.getBySpeciality(speciality);
    }
}
