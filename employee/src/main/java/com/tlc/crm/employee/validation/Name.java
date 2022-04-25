package com.tlc.crm.employee.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * <p>
 *     Provides the name validation message and groups for
 *     validation class
 * </p>
 *
 * @author Devidurga Arunachalam
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValidator.class)
@Documented
public @interface Name {
    String message() default "please enter valid name!!!...";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
