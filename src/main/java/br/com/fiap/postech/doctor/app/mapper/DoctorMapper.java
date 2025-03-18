package br.com.fiap.postech.doctor.app.mapper;

import br.com.fiap.postech.doctor.domain.entity.Address;
import br.com.fiap.postech.doctor.domain.entity.Doctor;
import br.com.fiap.postech.doctor.domain.entity.Specialty;
import br.com.fiap.postech.doctor.model.AddressDTO;
import br.com.fiap.postech.doctor.model.AddressRequestDTO;
import br.com.fiap.postech.doctor.model.DoctorDetailDTO;
import br.com.fiap.postech.doctor.model.DoctorRequestDTO;
import br.com.fiap.postech.doctor.model.DoctorResponseDTO;
import br.com.fiap.postech.doctor.model.DoctorUpdateDTO;
import br.com.fiap.postech.doctor.model.SpecialtyDTO;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public Doctor toEntity(DoctorRequestDTO doctorRequestDTO) {
        return new Doctor.Builder()
                .name(doctorRequestDTO.getName())
                .email(doctorRequestDTO.getEmail())
                .phone(doctorRequestDTO.getPhone())
                .crm(doctorRequestDTO.getCrm())
                .specialty(Specialty.valueOf(doctorRequestDTO.getSpecialty().getValue()))
                .address(toAddressEntity(doctorRequestDTO.getAddress()))
                .build();
    }

    public Doctor toEntity(DoctorUpdateDTO doctorUpdateDTO) {
        return new Doctor.Builder()
                .name(doctorUpdateDTO.getName())
                .phone(doctorUpdateDTO.getPhone())
                .specialty(Specialty.valueOf(doctorUpdateDTO.getSpecialty().getValue()))
                .address(toAddressEntity(doctorUpdateDTO.getAddress()))
                .build();
    }

    public DoctorDetailDTO toDetailDTO(Doctor doctor) {
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

    public DoctorResponseDTO toDTO(Doctor doctor) {
        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();
        doctorResponseDTO.setId(doctor.getId());
        doctorResponseDTO.setName(doctor.getName());
        doctorResponseDTO.setEmail(doctor.getEmail());
        doctorResponseDTO.setCrm(doctor.getCrm());
        doctorResponseDTO.setSpecialty(SpecialtyDTO.valueOf(doctor.getSpecialty().name()));
        return doctorResponseDTO;
    }

    public Address toAddressEntity(AddressRequestDTO addressRequestDTO) {
        return new Address(addressRequestDTO.getStreet(),
                addressRequestDTO.getCity(),
                addressRequestDTO.getState(),
                addressRequestDTO.getZipCode());
    }

    public AddressDTO toAddressDTO(Address address) {
        return new AddressDTO(address.getStreet(), address.getCity(), address.getState(), address.getZipCode());
    }

}
