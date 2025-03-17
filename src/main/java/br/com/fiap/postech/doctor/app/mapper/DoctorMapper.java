package br.com.fiap.postech.doctor.app.mapper;

import br.com.fiap.postech.doctor.domain.entity.Address;
import br.com.fiap.postech.doctor.domain.entity.Doctor;
import br.com.fiap.postech.doctor.domain.entity.Specialty;
import br.com.fiap.postech.doctor.model.AddressDTO;
import br.com.fiap.postech.doctor.model.DoctorDetailDTO;
import br.com.fiap.postech.doctor.model.DoctorRequestDTO;
import br.com.fiap.postech.doctor.model.SpecialtyDTO;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
    public Doctor toEntity(DoctorRequestDTO doctorRequestDTO) {
        return new Doctor(null,
                doctorRequestDTO.getName(),
                doctorRequestDTO.getEmail(),
                doctorRequestDTO.getPhone(),
                doctorRequestDTO.getCrm(),
                true,
                Specialty.valueOf(doctorRequestDTO.getSpecialty().getValue()),
                toAddressEntity(doctorRequestDTO));
    }

    public DoctorDetailDTO toDTO(Doctor doctor) {
        DoctorDetailDTO doctorDetailDTO = new DoctorDetailDTO();
        doctorDetailDTO.setId(doctor.getId());
        doctorDetailDTO.setName(doctor.getName());
        doctorDetailDTO.setEmail(doctor.getEmail());
        doctorDetailDTO.setPhone(doctor.getPhone());
        doctorDetailDTO.setCrm(doctor.getCrm());
        doctorDetailDTO.setActive(doctor.getActive());
        doctorDetailDTO.setSpecialty(SpecialtyDTO.valueOf(doctor.getSpecialty().name()));
        doctorDetailDTO.setAddress(toAddressDTO(doctor.getAddress()));
        return doctorDetailDTO;
    }

    public Address toAddressEntity(DoctorRequestDTO doctorRequestDTO) {
        return new Address(doctorRequestDTO.getAddress().getStreet(),
                doctorRequestDTO.getAddress().getCity(),
                doctorRequestDTO.getAddress().getState(),
                doctorRequestDTO.getAddress().getZipCode());
    }

    public AddressDTO toAddressDTO(Address address) {
        return new AddressDTO(address.getStreet(), address.getCity(), address.getState(), address.getZipCode());
    }

}
