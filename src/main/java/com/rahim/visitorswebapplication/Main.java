package com.rahim.visitorswebapplication;

import com.rahim.visitorswebapplication.enumeration.ResidentUnit;
import com.rahim.visitorswebapplication.model.Booking;
import com.rahim.visitorswebapplication.model.Employee;
import com.rahim.visitorswebapplication.enumeration.EmployeeRole;
import com.rahim.visitorswebapplication.model.Resident;
import com.rahim.visitorswebapplication.model.Visitor;
import com.rahim.visitorswebapplication.repository.BookingRepository;
import com.rahim.visitorswebapplication.repository.EmployeeRepository;
import com.rahim.visitorswebapplication.repository.ResidentRepository;
import com.rahim.visitorswebapplication.repository.VisitorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class Main {
    @Bean
    CommandLineRunner addEmployee(EmployeeRepository employeeRepo,
                                  VisitorRepository visitorRepo,
                                  ResidentRepository residentRepo,
                                  BookingRepository bookingRepository) {
        return args -> {
            Employee rahim = new Employee(
                    "Rahim",
                    "Ahmed",
                    LocalDate.of(2001, Month.AUGUST, 17),
                    LocalDate.of(2019, Month.DECEMBER, 21),
                    EmployeeRole.HOME_MANAGER
            );
            Employee reehan = new Employee(
                    "Reehan",
                    "Saif",
                    LocalDate.of(2013, Month.JANUARY, 13),
                    LocalDate.of(2022, Month.JULY, 13),
                    EmployeeRole.RECEPTIONIST
            );
            Visitor visitor = new Visitor(
                    "Jasmin",
                    "Khanam",
                    "jasminkhanam@yahoo.co.uk",
                    "07770594166"
            );
            Resident resident = new Resident(
                    "Leo",
                    "Bigglesworth",
                    LocalDate.of(2021, Month.JUNE, 26),
                    ResidentUnit.WILLOW,
                    "Self-Funded",
                    1,
                    LocalDate.of(2023, Month.JANUARY, 10)
            );
            Booking booking = new Booking(
                    visitor,
                    resident,
                    LocalDate.of(2023, Month.JANUARY, 28).atTime(13, 15)
            );
            Booking booking1 = new Booking(
                    visitor,
                    resident,
                    LocalDate.of(2024, Month.JANUARY, 28).atTime(13, 15)
            );
            employeeRepo.saveAll(List.of(rahim, reehan));
            visitorRepo.saveAll(List.of(visitor));
            residentRepo.saveAll(List.of(resident));
            bookingRepository.saveAll(List.of(booking, booking1));
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}