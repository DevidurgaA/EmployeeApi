package com.tlc.crm.employee.contact;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Abishek
 * @version 1.0
 */
public class Activator implements BundleActivator
{
    //private static final EmployeeManager EMPLOYEE_MANAGER = new EmployeeManager();

    @Override
    public void start(BundleContext bundleContext)
    {
        System.out.println("test");
    }

    @Override
    public void stop(BundleContext bundleContext)
    {

    }
}
