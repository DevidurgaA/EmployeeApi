package com.tlc.crm.employee.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * <p>
 *     Implements the ConstraintValidator to provide the
 *     regex to check the ContactNumber validation
 * </p>
 *
 * @author Devidurga Arunachalam
 */
public class ContactNumberValidator implements ConstraintValidator<ContactNumber, String> {

    /**
     * <p>
     *     Provides regex patten to validate the contactNumber
     *     given as the input from the user
     * </p>
     *
     * @param input
     * @param constraintValidatorContext
     */
    @Override
    public boolean isValid(final String input, final ConstraintValidatorContext constraintValidatorContext) {
        return input.matches("[6-9]{1}[0-9]{9}");
    }
}
