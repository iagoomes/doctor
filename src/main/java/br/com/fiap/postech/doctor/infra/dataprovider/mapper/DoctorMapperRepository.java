package br.com.fiap.postech.doctor.infra.dataprovider.mapper;

import br.com.fiap.postech.doctor.domain.entity.Doctor;
import br.com.fiap.postech.doctor.infra.repository.DoctorData;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapperRepository {

    public DoctorData toDataRepository(Doctor doctor) {
        return new DoctorData(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhone(), doctor.getCrm(), doctor.getActive(), doctor.getSpecialty(), doctor.getAddress());
    }

    public Doctor toEntity(DoctorData doctorData) {
        return new Doctor.Builder()
                .id(doctorData.getId())
                .name(doctorData.getName())
                .email(doctorData.getEmail())
                .phone(doctorData.getPhone())
                .crm(doctorData.getCrm())
                .active(doctorData.getActive())
                .specialty(doctorData.getSpecialty())
                .address(doctorData.getAddress())
                .build();
    }
}
