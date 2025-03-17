package br.com.fiap.postech.doctor.domain;

import br.com.fiap.postech.doctor.domain.entity.Doctor;

public interface DoctorProvider {
    Doctor createDoctor(Doctor doctor);
}
