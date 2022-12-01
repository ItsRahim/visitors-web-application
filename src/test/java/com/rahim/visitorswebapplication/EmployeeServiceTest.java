package com.rahim.visitorswebapplication;

import com.rahim.visitorswebapplication.configurators.EmployeeConfigurations;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class EmployeeServiceTest {

    @Autowired
    private MockMvc mockMvc;
    private final String baseUrl = "/api/v2/employee";

    @Test
    public void shouldCreateEmployee() throws Exception {
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
    public void shouldFormatEmailCorrectly() {
        assertEquals(EmployeeConfigurations.emailFormatter("jasmin", "khanam"), "jasmin.khanam@bupa.com");
    }
}