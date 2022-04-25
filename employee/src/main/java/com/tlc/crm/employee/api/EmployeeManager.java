package com.tlc.crm.employee.api;

import com.tlc.commons.code.ErrorCode;
import com.tlc.crm.employee.common.config.AuditEntry;
import com.tlc.crm.employee.common.config.ConfigManager;
import com.tlc.crm.employee.model.Employee;
import com.tlc.crm.employee.status.EmployeeErrorCodes;
import com.tlc.sql.SQLAccess;
import com.tlc.sql.api.DataContainer;
import com.tlc.sql.api.Row;
import com.tlc.sql.api.dml.Table;
import com.tlc.sql.api.ds.OrgDataStore;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * <p>
 *     Provides the CRUD operations by implementing
 *     ConfigManager and uses database to store the values
 *     using EmployeeData table
 * </p>
 *
 * @author Devidurga Arunachalam
 */
public class EmployeeManager implements ConfigManager<Employee> {

    private static final Table TABLE = Table.get("EmployeeData");
    private static final OrgDataStore ORG_DATA_STORE = getOrgDataStore();

    /**
     * <p>
     *     Provides datastore by returning the sql access
     *     and gets the OrgDataStore
     * </p>
     */
    private static OrgDataStore getOrgDataStore() {
        return SQLAccess.get().getOrgDataStore(1L);
    }

    /**
     * <p>
     *     Inner class which gets activated when getAdminDataSore()
     *     method is called
     * </p>
     */
    private static class Instance {
        private static final EmployeeManager INSTANCE = new EmployeeManager();
    }

    private EmployeeManager() {}

    /**
     * <p>
     *     Returns the instance for EmployeeManager
     * </p>
     *
     * @return INSTANCE
     */
    public static EmployeeManager getInstance() {
        return Instance.INSTANCE;
    }

    /**
     * <p>
     *     Creates the employee data by obtaining the
     *     inputs from the user and sets them into the
     *     rows of EmployeeData table
     * </p>
     *
     * @param employee
     */
    @Override
    public void create(final Employee employee) {
        final Row row = new Row(TABLE);
        final DataContainer dataContainer = DataContainer.create();

        row.set("NAME", employee.getName());
        row.set("SALARY", employee.getSalary());
        row.set("CONTACT_NUMBER", employee.getContactNumber());

        dataContainer.addNewRow(row);
        ORG_DATA_STORE.commitChanges(dataContainer);
    }

    /**
     * <p>
     *    Updates the employee data which is given as
     *    the input from the user by using
     *    dataContainer
     *</p>
     *
     * @param employee
     */
    @Override
    public void update(final Employee employee) {
        final Row row = new Row(TABLE, employee.id());
        final DataContainer dataContainer = DataContainer.create();

        if (exists(employee)) {
            setColumns(row, employee);
            dataContainer.updateRow(row);
            ORG_DATA_STORE.commitChanges(dataContainer);
        } else {
            throw ErrorCode.get(EmployeeErrorCodes.DATA_UNAVAILABLE);
        }
    }

    /**
     * <p>
     *     Sets the inputs into the columns of
     *     the Employee Data table
     * </p>
     *
     * @param row
     * @param employee
     */
    private void setColumns(final Row row, final Employee employee) {
        row.set("NAME", employee.getName());
        row.set("SALARY", employee.getSalary());
        row.set("CONTACT_NUMBER", employee.getContactNumber());
    }

    /**
     * <p>
     *     Gets the data of the employee
     * </p>
     *
     * @param id
     * @return employeeModel
     */
    @Override
    public Employee get(final Long id) {
        final Row row = ORG_DATA_STORE.get(TABLE, id);
        final Employee employee = new Employee();

        employee.setId(row.get("ID"));
        employee.setName(row.get("NAME").toString());
        employee.setSalary(row.get("SALARY").toString());
        employee.setContactNumber(row.get("CONTACT_NUMBER").toString());

        return employee;
    }

    /**
     * <p>
     *     Creates the employee data by obtaining the
     *     inputs from the user and sets them into the
     *     rows of EmployeeData table
     * </p>
     *
     * @param model
     */
    public void create(final Collection<Employee> model) {
        final DataContainer dataContainer = DataContainer.create();

        for (final Employee employee : model) {
            final Row row = new Row(TABLE);

            row.set("NAME", employee.getName());
            row.set("SALARY", employee.getSalary());
            row.set("CONTACT_NUMBER", employee.getContactNumber());

            dataContainer.addNewRow(row);
            ORG_DATA_STORE.commitChanges(dataContainer);
        }
    }

    /**
     * <p>
     *     Deletes the employee data by obtaining the
     *     input from the user
     * </p>
     *
     * @param employee
     */
    @Override
    public void delete(final Employee employee) {

        if (exists(employee)) {
            delete(List.of(employee));
        } else {
            throw ErrorCode.get(EmployeeErrorCodes.DATA_UNAVAILABLE);
        }
    }

    /**
     * <p>
     *     Checks the employee details which are available
     *     in the collection and then deletes the data
     *     from the EmployeeData table
     * </p>
     *
     * @param employee
     */
    @Override
    public void delete(final Collection<Employee> employee) {
        final Collection<Long> id = new HashSet<>();

        employee.forEach(model -> id.add(model.id()));
        ORG_DATA_STORE.delete(TABLE, id);
    }

    /**
     * <p>
     *     Gets the collection of the employee data
     * </p>
     *
     * @param id
     */
    @Override
    public Collection<Employee> get(final Collection<Long> id) {
      return null;
    }

    /**
     * <p>
     *     Gets the audit entry
     * </p>
     *
     * @param employee
     */
    @Override
    public AuditEntry auditEntry(final Employee employee)  {
        return null;
    }

    /**
     * <p>
     *     Checks the existence of the data
     * </p>
     *
     * @param employee
     */
    @Override
    public boolean exists(final Employee employee) {
        return ORG_DATA_STORE.get(TABLE, employee.id()) != null ? true : false;
    }

    /**
     * <p>
     *     Gets particular employee details as getting
     *     id as the inputs from the user
     * </p>
     *
     * @param id
     * @return id
     */
    @Override
    public Employee partialGet(final Long id) {
        final Employee employee = new Employee();

        employee.setId(id);
        return employee;
    }
}