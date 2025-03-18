package br.com.fiap.postech.doctor.domain.usecase;

import br.com.fiap.postech.doctor.domain.DoctorProvider;
import br.com.fiap.postech.doctor.domain.entity.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DoctorUseCase {

    private final DoctorProvider doctorProvider;

    public Doctor createDoctor(Doctor doctor) {
        return doctorProvider.createDoctor(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorProvider.deleteDoctor(id);
    }

    public Doctor getDoctorById(Long id) {
        return doctorProvider.getDoctorById(id);
    }

    public List<Doctor> listDoctors() {
        return doctorProvider.listDoctors();
    }

    public Doctor updateDoctor(Long id, Doctor doctor) {
        return doctorProvider.updateDoctor(id, doctor);
    }
}
