package br.com.fiap.postech.doctor.domain;

import br.com.fiap.postech.doctor.domain.entity.Doctor;

import java.util.List;

public interface DoctorProvider {
    Doctor createDoctor(Doctor doctor);
    void deleteDoctor(Long id);
    Doctor getDoctorById(Long id);
    List<Doctor> listDoctors();
    Doctor updateDoctor(Long id, Doctor doctor);
}
