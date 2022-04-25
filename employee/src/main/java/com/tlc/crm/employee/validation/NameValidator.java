package com.tlc.crm.employee.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * <p>
 *     Implements the ConstraintValidator to provide the
 *     regex to check the name validation
 * </p>
 *
 * @author Devidurga Arunachalam
 */
public class NameValidator implements ConstraintValidator<Name, String> {

    /**
     * <p>
     *     Provides regex patten to validate the name
     *     given as the input from the user
     * </p>
     *
     * @param input
     * @param constraintValidatorContext
     */
    @Override
    public boolean isValid(final String input, final ConstraintValidatorContext constraintValidatorContext) {
        return input.matches("[a-zA-z]{1,}");
    }
}
