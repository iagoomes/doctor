package br.com.fiap.postech.doctor.domain.entity;

public class Doctor {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String crm;
    private Boolean active;
    private Specialty specialty;
    private Address address;

    public Doctor(Long id, String name, String email, String phone, String crm, Boolean active, Specialty specialty, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.crm = crm;
        this.active = active;
        this.specialty = specialty;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public void desactive() {
        this.active = false;
    }
}
