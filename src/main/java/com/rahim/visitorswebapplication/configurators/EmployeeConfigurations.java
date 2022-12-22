package com.rahim.visitorswebapplication.configurators;

import java.text.MessageFormat;

public class EmployeeConfigurations {
    public static String emailFormatter(String firstName, String lastName) {
        return MessageFormat.format("{0}.{1}@bupa.com", firstName, lastName).toLowerCase();
    }
}
