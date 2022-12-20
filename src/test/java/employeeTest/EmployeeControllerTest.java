package employeeTest;

import com.rahim.visitorswebapplication.Main;
import com.rahim.visitorswebapplication.controller.EmployeeController;
import com.rahim.visitorswebapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
@ContextConfiguration(classes = Main.class)
class EmployeeControllerTest {

    EmployeeService employeeService = mock(EmployeeService.class);
    EmployeeController employeeController = new EmployeeController(employeeService);

    @Autowired
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();

    @Test
    void shouldCreateEmployee() throws Exception {
        mockMvc.perform(post("/api/v2/employee/create")
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
    void shouldGetAllUsers() throws Exception {
        mockMvc.perform(get("/api/v2/employee/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)));
    }

    @Test
    void shouldDeleteUser() throws Exception {
        mockMvc.perform(delete("/api/v2/employee/delete/{id}", "11"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
