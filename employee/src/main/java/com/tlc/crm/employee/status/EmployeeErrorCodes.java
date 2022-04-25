package com.tlc.crm.employee.status;

import com.tlc.commons.code.ErrorCodeGroup;
import com.tlc.commons.code.ErrorCodeProvider;

/**
 * <p>
 *     Enum which implements the ErrorCodeProvider to provide
 *     custom ErrorCodes
 * </p>
 *
 * @author Devidurga Arunachalam
 */
public enum EmployeeErrorCodes implements ErrorCodeProvider {

    INVALID_INPUTS_FOUND(0x20),
    DATA_UNAVAILABLE(0x21);

    private final int CODE;

    EmployeeErrorCodes(final int localCode) {
        this.CODE = EmployeeErrorCodeGroup.GROUP.getConvertedCode(localCode);
    }

    /**
     * <p>
     *     EmployeeErrorCodeGroup class which implements the ErrorCodeGroups
     *     to provide the custom ErrorCodeGroups
     * </p>
     */
    private static class EmployeeErrorCodeGroup implements ErrorCodeGroup {

        private static final ErrorCodeGroup GROUP = new EmployeeErrorCodeGroup();

        /**
         * <p>
         *     Gets the errorCode
         * </p>
         *
         * @return 0x10
         */
        @Override
        public int getPrefix() {
            return 0x10;
        }
    }

    /**
     * <p>
     *     Returns the custom errorCodes
     * </p>
     *
     * @return CODE
     */
    @Override
    public int getCode() {
        return CODE;
    }
}
