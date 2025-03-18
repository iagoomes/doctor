package br.com.fiap.postech.doctor.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorData, Long> {
    boolean existsByCrm(String crm);
    boolean existsByEmail(String email);
    List<DoctorData> findAllByActive(Boolean active);
}
