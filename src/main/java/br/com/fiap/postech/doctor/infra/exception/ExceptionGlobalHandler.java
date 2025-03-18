package br.com.fiap.postech.doctor.infra.exception;

import br.com.fiap.postech.doctor.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestControllerAdvice
@Slf4j
public class ExceptionGlobalHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
        return ErrorResponse.builder()
                .traceId(UUID.randomUUID().toString())
                .timestamp(LocalDateTime.now().toString())
                .message(errors)
                .build();
    }

    @ExceptionHandler(DoctorNotFoundException.class)
    public ErrorResponse handleDoctorNotFoundException(DoctorNotFoundException e) {
        log.error("DoctorNotFoundException: ", e);
        return ErrorResponse.builder()
                .traceId(UUID.randomUUID().toString())
                .timestamp(LocalDateTime.now().toString())
                .message(List.of(e.getMessage()))
                .build();
    }

    @ExceptionHandler(DoctorAllreadyExistsException.class)
    public ErrorResponse handleDoctorAllreadyExistsException(DoctorAllreadyExistsException e) {
        log.error("DoctorAllreadyExistsException: ", e);
        return ErrorResponse.builder()
                .traceId(UUID.randomUUID().toString())
                .timestamp(LocalDateTime.now().toString())
                .message(List.of(e.getMessage()))
                .build();
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception e) {
        log.error("Exception: ", e);
        return ErrorResponse.builder()
                .traceId(UUID.randomUUID().toString())
                .timestamp(LocalDateTime.now().toString())
                .message(List.of(e.getMessage()))
                .build();
    }
}
