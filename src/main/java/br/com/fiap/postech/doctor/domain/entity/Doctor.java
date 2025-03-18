package br.com.fiap.postech.doctor.domain.entity;

public class Doctor {

    private final Long id;
    private String name;
    private final String email;
    private String phone;
    private final String crm;
    private Boolean active;
    private Specialty specialty;
    private final Address address;

    private Doctor(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.crm = builder.crm;
        this.active = builder.active;
        this.specialty = builder.specialty;
        this.address = builder.address;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCrm() {
        return crm;
    }

    public Boolean getActive() {
        return active;
    }

    public Address getAddress() {
        return address;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public void updateInformation(Doctor doctor) {
        if (doctor.getName() != null && !doctor.getName().isEmpty()) {
            this.name = doctor.getName();
        }
        if (doctor.getPhone() != null) {
            this.phone = doctor.getPhone();
        }
        if (doctor.getAddress() != null) {
            this.address.updateInformation(doctor.getAddress());
        }
        if (doctor.getSpecialty() != null) {
            this.specialty = doctor.getSpecialty();
        }
    }

    public static class Builder {
        private Long id;
        private String name;
        private String email;
        private String phone;
        private String crm;
        private Boolean active; // Default value
        private Specialty specialty;
        private Address address;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder crm(String crm) {
            this.crm = crm;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Builder specialty(Specialty specialty) {
            this.specialty = specialty;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Doctor build() {
            return new Doctor(this);
        }
    }

}
