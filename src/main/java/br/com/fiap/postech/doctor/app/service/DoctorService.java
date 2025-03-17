package br.com.fiap.postech.doctor.app.service;

import br.com.fiap.postech.doctor.model.DoctorDetailDTO;
import br.com.fiap.postech.doctor.model.DoctorRequestDTO;
import br.com.fiap.postech.doctor.model.DoctorResponseDTO;

import java.util.List;

public interface DoctorService {
    DoctorDetailDTO createDoctor(DoctorRequestDTO doctorRequestDTO);
    void deleteDoctor(String id);
    DoctorDetailDTO getDoctorById(String id);
    List<DoctorResponseDTO> listDoctors();
    DoctorDetailDTO updateDoctor(String id, DoctorRequestDTO doctorRequestDTO);
}
