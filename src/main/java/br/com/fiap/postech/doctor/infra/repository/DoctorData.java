package br.com.fiap.postech.doctor.infra.repository;

import br.com.fiap.postech.doctor.domain.entity.Address;
import br.com.fiap.postech.doctor.domain.entity.Specialty;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Doctor")
@Table(name = "Doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String crm;
    private Boolean active;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private Address address;


}
