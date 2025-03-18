package br.com.fiap.postech.doctor.infra.exception;

public class DoctorAllreadyExistsException extends RuntimeException {
    public DoctorAllreadyExistsException(String message) {
        super(message);
    }
}
