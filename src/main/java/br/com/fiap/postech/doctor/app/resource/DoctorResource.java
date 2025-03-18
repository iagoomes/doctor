package br.com.fiap.postech.doctor.app.resource;

import br.com.fiap.postech.doctor.api.DoctorApiDelegate;
import br.com.fiap.postech.doctor.app.service.DoctorService;
import br.com.fiap.postech.doctor.model.DoctorDetailDTO;
import br.com.fiap.postech.doctor.model.DoctorRequestDTO;
import br.com.fiap.postech.doctor.model.DoctorResponseDTO;
import br.com.fiap.postech.doctor.model.DoctorUpdateDTO;
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
    public CompletableFuture<ResponseEntity<Void>> deleteDoctor(Long id) {
        doctorService.deleteDoctor(id);
        return CompletableFuture.supplyAsync(() -> ResponseEntity.noContent().build());
    }

    @Override
    public CompletableFuture<ResponseEntity<DoctorDetailDTO>> getDoctorById(Long id) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(doctorService.getDoctorById(id)));
    }

    @Override
    public CompletableFuture<ResponseEntity<List<DoctorResponseDTO>>> listDoctors() {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(doctorService.listDoctors()));
    }

    @Override
    public CompletableFuture<ResponseEntity<DoctorDetailDTO>> updateDoctor(Long id, @Valid DoctorUpdateDTO doctorUpdateDTO) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(doctorService.updateDoctor(id, doctorUpdateDTO)));
    }
}
