package br.com.fiap.postech.doctor.app.resource;

import br.com.fiap.postech.doctor.api.DoctorApiDelegate;
import br.com.fiap.postech.doctor.app.service.DoctorService;
import br.com.fiap.postech.doctor.model.DoctorDetailDTO;
import br.com.fiap.postech.doctor.model.DoctorRequestDTO;
import br.com.fiap.postech.doctor.model.DoctorResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class DoctorResource implements DoctorApiDelegate {

    private final DoctorService doctorService;

    @Override
    public CompletableFuture<ResponseEntity<DoctorDetailDTO>> createDoctor(@Valid DoctorRequestDTO doctorRequestDTO) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(doctorService.createDoctor(doctorRequestDTO)));
    }

    @Override
    public CompletableFuture<ResponseEntity<Void>> deleteDoctor(String id) {
        return DoctorApiDelegate.super.deleteDoctor(id);
    }

    @Override
    public CompletableFuture<ResponseEntity<DoctorDetailDTO>> getDoctorById(String id) {
        return DoctorApiDelegate.super.getDoctorById(id);
    }

    @Override
    public CompletableFuture<ResponseEntity<List<DoctorResponseDTO>>> listDoctors() {
        return DoctorApiDelegate.super.listDoctors();
    }

    @Override
    public CompletableFuture<ResponseEntity<DoctorDetailDTO>> updateDoctor(String id, DoctorRequestDTO doctorRequestDTO) {
        return DoctorApiDelegate.super.updateDoctor(id, doctorRequestDTO);
    }
}
