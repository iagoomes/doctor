package br.com.fiap.postech.doctor.app.service;

import br.com.fiap.postech.doctor.app.mapper.DoctorMapper;
import br.com.fiap.postech.doctor.domain.entity.Doctor;
import br.com.fiap.postech.doctor.domain.usecase.DoctorUseCase;
import br.com.fiap.postech.doctor.model.DoctorDetailDTO;
import br.com.fiap.postech.doctor.model.DoctorRequestDTO;
import br.com.fiap.postech.doctor.model.DoctorResponseDTO;
import br.com.fiap.postech.doctor.model.DoctorUpdateDTO;
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
        Doctor doctor = doctorMapper.toEntity(doctorRequestDTO);
        return doctorMapper.toDetailDTO(doctorUseCase.createDoctor(doctor));
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorUseCase.deleteDoctor(id);
    }

    @Override
    public DoctorDetailDTO getDoctorById(Long id) {
        return doctorMapper.toDetailDTO(doctorUseCase.getDoctorById(id));
    }

    @Override
    public List<DoctorResponseDTO> listDoctors() {
        return doctorUseCase.listDoctors().stream().map(doctorMapper::toDTO).toList();
    }

    @Override
    public DoctorDetailDTO updateDoctor(Long id, DoctorUpdateDTO doctorUpdateDTO) {
        return doctorMapper.toDetailDTO(doctorUseCase.updateDoctor(id, doctorMapper.toEntity(doctorUpdateDTO)));
    }
}
