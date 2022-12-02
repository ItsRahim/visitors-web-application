package com.rahim.visitorswebapplication.employeeTest;

import com.rahim.visitorswebapplication.configurators.EmployeeConfigurations;
import com.rahim.visitorswebapplication.enumeration.EmployeeRole;
import com.rahim.visitorswebapplication.model.Employee;
import com.rahim.visitorswebapplication.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private final String baseUrl = "/api/v2/employee";

    @BeforeAll
    static void createEmployeeData(EmployeeRepository employeeRepo) {
        Employee rahim = new Employee(
                UUID.randomUUID().toString(),
                "Rahim",
                "Ahmed",
                LocalDate.of(2001, Month.AUGUST, 17),
                EmployeeConfigurations.emailFormatter("rahim", "ahmed"),
                LocalDate.of(2019, Month.DECEMBER, 21),
                EmployeeRole.HOME_MANAGER
        );
        Employee naima = new Employee(
                UUID.randomUUID().toString(),
                "Naima",
                "Akther",
                LocalDate.of(1999, Month.JULY, 08),
                EmployeeConfigurations.emailFormatter("naima", "akther"),
                LocalDate.of(2019, Month.SEPTEMBER, 15),
                EmployeeRole.RECEPTIONIST
        );
        employeeRepo.saveAll(List.of(rahim, naima));
    }
    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    void shouldCreateEmployee() throws Exception {
        mockMvc.perform(post(baseUrl + "/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": \"UUID.randomUUID().toString()\"," +
                        "\"firstname\": \"Jasmin\", " +
                        "\"lastname\": \"Khanam\"," +
                        "\"dob\": \"1980-05-31\"," +
                        "\"email\": \"jasmin.khanam@yahoo.co.uk\"," +
                        "\"startDate\": \"2012-07-15\"," +
                        "\"role\": \"ACTIVITIES_COORDINATOR\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void shouldGetAllUsers() {

    }
}