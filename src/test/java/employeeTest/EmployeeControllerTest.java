package employeeTest;

import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private final String baseUrl = "/api/v2/employee";

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
    void shouldGetAllUsers() throws Exception {
        mockMvc.perform(get(baseUrl + "/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)));
    }

    @Test
    void shouldDeleteUser() throws Exception {
        mockMvc.perform(delete(baseUrl + "delete/{id}", "11"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
