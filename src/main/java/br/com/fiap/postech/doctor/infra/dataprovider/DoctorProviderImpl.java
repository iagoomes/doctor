package br.com.fiap.postech.doctor.infra.dataprovider;

import br.com.fiap.postech.doctor.domain.DoctorProvider;
import br.com.fiap.postech.doctor.domain.entity.Doctor;
import br.com.fiap.postech.doctor.infra.dataprovider.mapper.DoctorMapperRepository;
import br.com.fiap.postech.doctor.infra.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DoctorProviderImpl implements DoctorProvider {
    private final DoctorRepository doctorRepository;
    private final DoctorMapperRepository doctorMapperRepository;

    public Doctor createDoctor(Doctor doctor) {
        return doctorMapperRepository.toEntity(doctorRepository.save(doctorMapperRepository.toDataRepository(doctor)));
    }
}
