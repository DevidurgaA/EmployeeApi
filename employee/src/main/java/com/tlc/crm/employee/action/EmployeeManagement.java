package com.tlc.crm.employee.action;

import com.tlc.commons.code.ErrorCode;
import com.tlc.commons.json.Json;
import com.tlc.commons.json.JsonArray;
import com.tlc.commons.json.JsonObject;
import com.tlc.crm.employee.api.EmployeeManager;
import com.tlc.crm.employee.common.action.secure.CrmConfigAction;
import com.tlc.crm.employee.common.config.ConfigManager;
import com.tlc.crm.employee.validation.Validator;
import com.tlc.crm.employee.model.Employee;
import com.tlc.validator.type.Group;
import com.tlc.web.WebAction;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 *    Performs CURD operations to employee details
 *    using API
 * </p>
 *
 * @author Devidurga Arunachalam
 */
@WebAction(path = "/employee/mgmt")
public class EmployeeManagement extends CrmConfigAction<Employee> {

    /**
     * <P>
     *     Gets the input from the user and returns
     *     as the jsonObject
     * </P>
     *
     * @param model
     * @return jsonObject
     */
    @Override
    public JsonObject construct(final Employee model) {
        final JsonObject jsonObject = Json.object();

        jsonObject.put("id", model.id());
        jsonObject.put("name", model.getName());
        jsonObject.put("salary", model.getSalary());
        jsonObject.put("contactNumber", model.getContactNumber());

        return jsonObject;
    }

    /**
     * <p>
     *     Gets the instance for the ConfigManager and returns
     *     the instance
     * </p>
     *
     * @return instance
     */
    @Override
    public ConfigManager<Employee> getConfigManager() {
        return EmployeeManager.getInstance();
    }

    /**
     * <p>
     *     Returns the jsonObject  for the given request
     *     from the user
     * </p>
     *
     * @param jsonObject
     */
    @Override
    public Employee construct(final JsonObject jsonObject) {
       final Long id = jsonObject.optLong("id", 0);
       final String name = jsonObject.optString("name", null);
       final String salary = jsonObject.optString("salary", null);
       final String contactNumber = jsonObject.optString("contactNumber", null);
       final Employee employee = new Employee(id, name, contactNumber, salary);
       final String type = jsonObject.getString("type");

       if (type.equals("create") || type.equals("update")) {
           Validator.validate(employee, getGroups(type));
       }
       return employee;
    }

    /**
     * <P>
     *     Gets the input from the user and returns
     *     as the jsonObject
     * </P>
     *
     * @param data
     * @return jsonObject
     */
    public Collection<Employee> constructArray(final JsonObject data) {
        final Collection<Employee> employeeList = new ArrayList<>();
        final JsonArray dataArray = data.getJsonArray("data");

        for (int index = 0; index < dataArray.size(); index++) {
            final JsonObject input = dataArray.getJsonObject(index);
            final Long id = input.optLong("id", 0);
            final String name = input.optString("name", null);
            final String salary = input.optString("salary", null);
            final String contactNumber = input.optString("contactNumber", null);
            final Employee employee = new Employee(id, name, contactNumber, salary);
            final String type = data.getString("type");

            if (type.equals("create") || type.equals("update")) {

                try {
                    Validator.validate(employee, getGroups(type));
                    employeeList.add(employee);
                } catch (ErrorCode exception) {
                    exception.printStackTrace();
                }
            }
          }
        return employeeList;
    }

    /**
     * <p>
     *     Provides groups for the validator class
     * </p>
     *
     * @param type
     */
    private Class getGroups(final String type) {

        if (type.equals("create")) {
            return Group.Create.class;
        } else {
            return Group.Update.class;
        }
    }
}
