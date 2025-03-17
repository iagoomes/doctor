package br.com.fiap.postech.doctor.domain.usecase;

import br.com.fiap.postech.doctor.domain.DoctorProvider;
import br.com.fiap.postech.doctor.domain.entity.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DoctorUseCase {

    private final DoctorProvider doctorProvider;

    public Doctor createDoctor(Doctor doctor) {
        return doctorProvider.createDoctor(doctor);
    }


}
