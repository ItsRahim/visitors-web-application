package unit_test.employee;

import com.rahim.visitorswebapplication.helper.EmployeeHelper;
import com.rahim.visitorswebapplication.enumeration.EmployeeRole;
import com.rahim.visitorswebapplication.model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private static Employee employee1;

    @BeforeAll
    public static void setUp() {
        employee1 = new Employee(
                "100",
                "Rahim",
                "Ahmed",
                LocalDate.of(2001, Month.AUGUST, 17),
                EmployeeHelper.emailFormatter("rahim", "ahmed"),
                LocalDate.of(2019, Month.DECEMBER, 21),
                EmployeeRole.HOME_MANAGER
        );
    }

    @Test
    void getId() {
        assertEquals("100", employee1.getId());
    }

    @Test
    void getFirstName() {
        assertEquals("Rahim", employee1.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Ahmed", employee1.getLastName());
    }

    @Test
    void getDob() {
        assertEquals(LocalDate.of(2001, Month.AUGUST, 17), employee1.getDob());
    }

    @Test
    void getEmail() {
        assertEquals("rahim.ahmed@bupa.com", employee1.getEmail());
    }

    @Test
    void getStartDate() {
        assertEquals(LocalDate.of(2019, Month.DECEMBER, 21), employee1.getStartDate());
    }

    @Test
    void getRole() {
        assertEquals(EmployeeRole.HOME_MANAGER, employee1.getRole());
    }

//    @Test
//    void setId() {
//        employee1.setId("123");
//        assertEquals("123", employee1.getId());
//    }
//
//    @Test
//    void setFirstName() {
//        employee1.setFirstName("Saif");
//        assertEquals("Saif", employee1.getFirstName());
//    }
//
//    @Test
//    void setLastName() {
//        employee1.setLastName("Uddin");
//        assertEquals("Uddin", employee1.getLastName());
//    }
//
//    @Test
//    void setDob() {
//        employee1.setDob(LocalDate.of(2005, Month.NOVEMBER, 21));
//        assertEquals(LocalDate.of(2005, Month.NOVEMBER, 21), employee1.getDob());
//    }
//
//    @Test
//    void setEmail() {
//        String newEmail = EmployeeConfigurations.emailFormatter(employee1.getFirstName(), employee1.getLastName());
//        employee1.setEmail(newEmail);
//        assertEquals("saif.uddin@bupa.com", employee1.getEmail());
//    }
//
//    @Test
//    void setStartDate() {
//        employee1.setStartDate(LocalDate.of(2023, Month.JANUARY, 1));
//        assertEquals(LocalDate.of(2023, Month.JANUARY, 1), employee1.getStartDate());
//    }
//
//    @Test
//    void setRole() {
//        employee1.setRole(EmployeeRole.RECEPTIONIST);
//        assertEquals(EmployeeRole.RECEPTIONIST, employee1.getRole());
//    }
}