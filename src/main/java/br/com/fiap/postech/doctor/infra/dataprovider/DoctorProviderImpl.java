package br.com.fiap.postech.doctor.infra.dataprovider;

import br.com.fiap.postech.doctor.domain.DoctorProvider;
import br.com.fiap.postech.doctor.domain.entity.Doctor;
import br.com.fiap.postech.doctor.infra.dataprovider.mapper.DoctorMapperRepository;
import br.com.fiap.postech.doctor.infra.exception.DoctorAllreadyExistsException;
import br.com.fiap.postech.doctor.infra.exception.DoctorNotFoundException;
import br.com.fiap.postech.doctor.infra.repository.DoctorData;
import br.com.fiap.postech.doctor.infra.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DoctorProviderImpl implements DoctorProvider {
    private final DoctorRepository doctorRepository;
    private final DoctorMapperRepository doctorMapperRepository;

    @Override
    public Doctor createDoctor(Doctor doctor) {
        valid(doctor);
        doctor.activate();
        return doctorMapperRepository.toEntity(doctorRepository.save(doctorMapperRepository.toDataRepository(doctor)));
    }

    @Override
    public void deleteDoctor(Long id) {
        Doctor doctor = getDoctorById(id);
        doctor.deactivate();
        DoctorData doctorData = doctorMapperRepository.toDataRepository(doctor);
        doctorRepository.save(doctorData);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorMapperRepository.toEntity(doctorRepository.findById(id).orElseThrow(() -> new DoctorNotFoundException("Doctor not found")));
    }

    @Override
    public List<Doctor> listDoctors() {
        List<DoctorData> doctorsData = doctorRepository.findAllByActive(true);
        return doctorsData.stream().map(doctorMapperRepository::toEntity).toList();
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {
        Doctor doctorAsIs = getDoctorById(id);
        doctorAsIs.updateInformation(doctor);
        DoctorData doctorData = doctorMapperRepository.toDataRepository(doctorAsIs);
        return doctorMapperRepository.toEntity(doctorRepository.save(doctorData));
    }

    private void valid(Doctor doctor) {
        if (doctorRepository.existsByCrm(doctor.getCrm()) || doctorRepository.existsByEmail(doctor.getEmail())) {
            throw new DoctorAllreadyExistsException("Doctor already exists");
        }
    }
}
