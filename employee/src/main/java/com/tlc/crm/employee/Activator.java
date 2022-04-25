package com.tlc.crm.employee;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * <p>
 *     Activator that gets started when the bundle
 *     gets activated
 * </p>
 */
public class Activator implements BundleActivator {

    /**
     * <p>
     *     Gets started when the activator gets activated
     * </p>
     *
     * @param context
     */
    public void start(BundleContext context) {
        System.out.println("Starting the employee bundle");
    }

    /**
     * <p>
     *     Gets halted when the activator gets stopped
     * </p>
     *
     * @param context
     */
    public void stop(BundleContext context) {
        System.out.println("Stopping the employee bundle");
    }
}