package integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rahim.visitorswebapplication.Main;
import com.rahim.visitorswebapplication.controller.EmployeeController;
import com.rahim.visitorswebapplication.model.Employee;
import com.rahim.visitorswebapplication.repository.EmployeeRepository;
import com.rahim.visitorswebapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
@ContextConfiguration(classes = Main.class)
class EmployeeControllerTest {

    /*
    Creating mock instances of service and controller so results do not affect db
     */
    EmployeeService employeeService = mock(EmployeeService.class);
    EmployeeController employeeController = new EmployeeController(employeeService);

    @Autowired
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();

    @Test
    void shouldCreateEmployee() throws Exception {
        MvcResult result = mockMvc.perform(post("/api/v2/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"UUID.randomUUID().toString()\"," +
                                "\"firstName\": \"Jasmin\", " +
                                "\"lastName\": \"Khanam\"," +
                                "\"dob\": \"1980-05-31\"," +
                                "\"email\": \"jasmin.khanam@bupa.com\"," +
                                "\"startDate\": \"2012-07-15\"," +
                                "\"role\": \"ACTIVITIES_COORDINATOR\"}"))
                .andExpect(status().isCreated())
                //contains the response from the server
                .andReturn();

        /*
        Extract the response body from the MvcResult object above and verify that it contains the expected data
         */
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String responseBody = result.getResponse().getContentAsString();

        Employee createdEmployee = objectMapper.readValue(responseBody, Employee.class);

        assertEquals(createdEmployee.getFirstName(), "Jasmin");
        assertEquals(createdEmployee.getEmail(), "jasmin.khanam@bupa.com");
    }

    @Test
    void shouldGetAllEmployees() throws Exception {
        mockMvc.perform(get("/api/v2/employee/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.is(2)));
    }

    @DirtiesContext
    @Test
    void shouldDeleteEmployee() throws Exception {
        mockMvc.perform(delete("/api/v2/employee/delete/{id}", "11"))
                .andExpect(status().isOk());
        //verify(employeeService).deleteEmployee("11");
        verifyNoMoreInteractions(employeeService);

        Employee employee = employeeService.getEmployee("11");
        assertNull(employee);
    }

    @Test
    void shouldGetEmployeeById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v2/employee/get/{id}", "11")
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String responseBody = response.getContentAsString();

        Employee createdEmployee = objectMapper.readValue(responseBody, Employee.class);

        assertEquals(createdEmployee.getFirstName(), "Reehan");
        assertEquals(createdEmployee.getId(), "11");
    }

    @DirtiesContext
    @Test
    void shouldUpdateEmployee() throws Exception {
        MvcResult result = mockMvc.perform(put("/api/v2/employee/update/{id}", "11")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"UUID.randomUUID().toString()\"," +
                                "\"firstName\": \"Reehan2\", " +
                                "\"lastName\": \"Saif2\"," +
                                "\"dob\": \"2013-01-13\"," +
                                "\"email\": \"reehan.saif2@bupa.com\"," +
                                "\"startDate\": \"2022-12-25\"," +
                                "\"role\": \"ACTIVITIES_COORDINATOR\"}"))
                .andExpect(status().isNoContent())
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String responseBody = result.getResponse().getContentAsString();

        Employee createdEmployee = objectMapper.readValue(responseBody, Employee.class);

        assertEquals(createdEmployee.getFirstName(), "Reehan2");
        assertEquals(createdEmployee.getEmail(), "reehan.saif2@bupa.com");
    }
}