package br.com.fiap.postech.doctor.domain.entity;

public enum Specialty {
    ORTHOPEDICS("ORTHOPEDICS"),

    CARDIOLOGY("CARDIOLOGY"),

    GYNECOLOGY("GYNECOLOGY"),

    DERMATOLOGY("DERMATOLOGY");

    private final String value;

    Specialty(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
