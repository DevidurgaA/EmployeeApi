package com.tlc.crm.employee.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * <p>
 *     Provides the contactNumber validation message and groups for
 *     validation class
 * </p>
 *
 * @author Devidurga Arunachalam
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ContactNumberValidator.class)
@Documented
public @interface ContactNumber {
    String message() default "please enter valid contactNumber!!!...";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
