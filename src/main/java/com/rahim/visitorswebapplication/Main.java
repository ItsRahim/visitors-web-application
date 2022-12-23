package com.rahim.visitorswebapplication;

import com.rahim.visitorswebapplication.config.EmployeeConfigurations;
import com.rahim.visitorswebapplication.model.Employee;
import com.rahim.visitorswebapplication.enumeration.EmployeeRole;
import com.rahim.visitorswebapplication.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class Main {
    @Bean
    CommandLineRunner addEmployee(EmployeeRepository employeeRepo) {
        return args -> {
            Employee rahim = new Employee(
                    UUID.randomUUID().toString(),
                    "Rahim",
                    "Ahmed",
                    LocalDate.of(2001, Month.AUGUST, 17),
                    EmployeeConfigurations.emailFormatter("rahim", "ahmed"),
                    LocalDate.of(2019, Month.DECEMBER, 21),
                    EmployeeRole.HOME_MANAGER
            );
            Employee reehan = new Employee(
                    "11",
                    "Reehan",
                    "Saif",
                    LocalDate.of(2013, Month.JANUARY, 13),
                    EmployeeConfigurations.emailFormatter("reehan", "saif"),
                    LocalDate.of(2022, Month.JULY, 13),
                    EmployeeRole.RECEPTIONIST
            );
            employeeRepo.saveAll(List.of(rahim, reehan));
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}