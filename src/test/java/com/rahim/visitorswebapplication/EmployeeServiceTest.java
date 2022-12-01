package com.rahim.visitorswebapplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahim.visitorswebapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class EmployeeServiceTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private EmployeeService employeeService;
    private final String baseUrl = "/api/v2/employee";

    @Test
    public void shouldCreateEmployee() throws Exception {
        mockMvc.perform(post(baseUrl+"/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": \"UUID.randomUUID().toString()\",\"firstname\": \"Jasmin\", " +
                        "\"lastname\": \"Khanam\"," +
                        "\"dob\": \"1980-05-31\"," +
                        "\"email\": \"jasmin.khanam@yahoo.co.uk\"," +
                        "\"startDate\": \"2012-07-15\"," +
                        "\"role\": \"ACTIVITIES_COORDINATOR\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}