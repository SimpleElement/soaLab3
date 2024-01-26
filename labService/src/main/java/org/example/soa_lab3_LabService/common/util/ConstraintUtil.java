package org.example.soa_lab3_LabService.common.util;

import jakarta.validation.ConstraintValidatorContext;

public final class ConstraintUtil {

    public static boolean addConstraintViolation(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        return false;
    }
}
