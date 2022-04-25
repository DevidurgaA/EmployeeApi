package com.tlc.crm.employee.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * <p>
 *     Implements the ConstraintValidator to provide the
 *     regex to check the Salary validation
 * </p>
 *
 * @author Devidurga Arunachalam
 */
public class SalaryValidator implements ConstraintValidator<Salary, String> {

    /**
     * <p>
     *     Provides regex patten to validate the salary
     *     given as the input from the user
     * </p>
     *
     * @param input
     * @param constraintValidatorContext
     */
    @Override
    public boolean isValid(final String input, final ConstraintValidatorContext constraintValidatorContext) {
        return input.matches("[0-9]+([,.][0-9]{2,})?");
    }
}
