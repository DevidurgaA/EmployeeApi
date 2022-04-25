package com.tlc.crm.employee.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * <p>
 *     Provides the salary validation message and groups for
 *     validation class
 * </p>
 *
 * @author Devidurga Arunachalam
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SalaryValidator.class)
@Documented
public @interface Salary {
    String message() default "please enter valid salary!!!...";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
