package org.example.soa_lab3_LabService.ws.lab.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.soa_lab3_LabService.ws.lab.validation.validator.LabDtoValidator;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { LabDtoValidator.class })
public @interface LabDtoConstraint {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
