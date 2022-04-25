package com.tlc.crm.employee.model;

import com.tlc.crm.employee.validation.ContactNumber;
import com.tlc.crm.employee.validation.Name;
import com.tlc.crm.employee.validation.Salary;
import com.tlc.validator.TlcModel;
import com.tlc.validator.type.Group;

/**
 * <p>
 *     Provides getter and setter methods
 *     for Employee class
 * </p>
 *
 * @author Devidurga Arunachalam
 */
public class Employee implements TlcModel {

    private Long id;

    @Name(groups = {Group.Create.class, Group.Update.class})
    private  String name;

    @ContactNumber(groups = {Group.Create.class, Group.Update.class})
    private String contactNumber;

    @Salary(groups = {Group.Create.class, Group.Update.class})
    private  String salary;

    public Employee(Long id, String name, String contactNumber, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.contactNumber = contactNumber;
    }

    public Employee() {

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long id() {
        return id;
    }

    @Override
    public Long orgId() {
        return null;
    }

    @Override
    public Object identity() {
        return null;
    }

    public String toString() {
        return new StringBuffer().append("\n").append("EmployeeId:").append(id).append("\n").append("Name:").append(name).append("\n").append("Salary:").append(salary).
                append("\n").append("Contact Number:").append(contactNumber).append("\n").toString();
    }
}
