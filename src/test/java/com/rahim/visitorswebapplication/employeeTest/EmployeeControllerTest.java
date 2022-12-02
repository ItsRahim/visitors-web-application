package com.rahim.visitorswebapplication.employeeTest;

import com.rahim.visitorswebapplication.configurators.EmployeeConfigurations;
import com.rahim.visitorswebapplication.enumeration.EmployeeRole;
import com.rahim.visitorswebapplication.model.Employee;
import com.rahim.visitorswebapplication.repository.EmployeeRepository;
import com.rahim.visitorswebapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private final String baseUrl = "/api/v2/employee";

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
    void shouldGetAllUsers() throws Exception{
        mockMvc.perform(get(baseUrl + "/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)));
    }
}