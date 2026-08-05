package com.techie.microservices.doctor.repository;

import com.techie.microservices.doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    boolean existsByIdAndAvailableTrue(Long id);
    List<Doctor> findBySpecialityIgnoreCase(String speciality);
}
