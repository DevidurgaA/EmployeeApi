package com.tlc.crm.employee.validation;

import com.tlc.commons.code.ErrorCode;
import com.tlc.crm.employee.model.Employee;
import com.tlc.crm.employee.status.EmployeeErrorCodes;
import com.tlc.validator.ModelValidator;
import com.tlc.validator.ValidatorAccess;

/**
 * <p>
 *     Provides the validation by using the validator access
 *     and gets the required method which is used to
 *     get validation
 * </p>
 *
 * @author Devidurga Arunachalam
 */
public class Validator {

    private static final ModelValidator MODEL_VALIDATOR = ValidatorAccess.get();

    /**
     * <p>
     *     Uses the isValid method from the ValidatorAccess to validate by
     *     getting the employee object as the input and validateClass to get
     *     groups to validate
     * </p>
     *
     * @param employee
     * @param validateClass
     */
    public static void validate(final Employee employee, final Class... validateClass) {

        if (!MODEL_VALIDATOR.isValid(employee, validateClass)) {
            throw ErrorCode.get(EmployeeErrorCodes.INVALID_INPUTS_FOUND);
        }
    }
}
