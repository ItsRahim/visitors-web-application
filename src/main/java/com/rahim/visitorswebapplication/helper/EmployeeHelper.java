package com.rahim.visitorswebapplication.helper;

import java.text.MessageFormat;

public class EmployeeHelper {
    public static String emailFormatter(String firstName, String lastName) {
        return MessageFormat.format("{0}.{1}@bupa.com", firstName, lastName).toLowerCase();
    }
}
