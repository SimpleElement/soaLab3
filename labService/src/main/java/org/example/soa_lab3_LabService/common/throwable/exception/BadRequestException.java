package org.example.soa_lab3_LabService.common.throwable.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
