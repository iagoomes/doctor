package br.com.fiap.postech.doctor.app.service;

import br.com.fiap.postech.doctor.app.mapper.DoctorMapper;
import br.com.fiap.postech.doctor.domain.usecase.DoctorUseCase;
import br.com.fiap.postech.doctor.model.DoctorDetailDTO;
import br.com.fiap.postech.doctor.model.DoctorRequestDTO;
import br.com.fiap.postech.doctor.model.DoctorResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorUseCase doctorUseCase;
    private final DoctorMapper doctorMapper;

    @Override
    public DoctorDetailDTO createDoctor(DoctorRequestDTO doctorRequestDTO) {
        return doctorMapper.toDTO(doctorUseCase.createDoctor(doctorMapper.toEntity(doctorRequestDTO)));
    }

    @Override
    public void deleteDoctor(String id) {

    }

    @Override
    public DoctorDetailDTO getDoctorById(String id) {
        return null;
    }

    @Override
    public List<DoctorResponseDTO> listDoctors() {
        return List.of();
    }

    @Override
    public DoctorDetailDTO updateDoctor(String id, DoctorRequestDTO doctorRequestDTO) {
        return null;
    }
}
