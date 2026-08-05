package com.techie.microservices.doctor.service;

import com.techie.microservices.doctor.model.Doctor;
import com.techie.microservices.doctor.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public boolean isAvailable(Long doctorId) {
        log.info("Start -- Checking availability for doctorId {}", doctorId);
        boolean isAvailable = doctorRepository.existsByIdAndAvailableTrue(doctorId);
        log.info("End -- Doctor {} availability: {}", doctorId, isAvailable);
        return isAvailable;
    }

    public List<Doctor> getBySpeciality(String speciality) {
        return doctorRepository.findBySpecialityIgnoreCase(speciality);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
