package br.com.fiap.postech.doctor.app.service;

import br.com.fiap.postech.doctor.model.DoctorDetailDTO;
import br.com.fiap.postech.doctor.model.DoctorRequestDTO;
import br.com.fiap.postech.doctor.model.DoctorResponseDTO;
import br.com.fiap.postech.doctor.model.DoctorUpdateDTO;

import java.util.List;

public interface DoctorService {
    DoctorDetailDTO createDoctor(DoctorRequestDTO doctorRequestDTO);
    void deleteDoctor(Long id);
    DoctorDetailDTO getDoctorById(Long id);
    List<DoctorResponseDTO> listDoctors();
    DoctorDetailDTO updateDoctor(Long id, DoctorUpdateDTO doctorUpdateDTO);
}
