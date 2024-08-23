package com.CombinedAPI.API;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.CombinedAPI.API.helpers.ManagerChangeRequest;
import com.CombinedAPI.API.model.EmployeeManagerModel;
import com.CombinedAPI.API.response.ManagerChangeResponseDTO;
import com.CombinedAPI.API.response.ResponseDTO;
import com.CombinedAPI.API.response.ResponseMessage;
import com.CombinedAPI.API.services.EmployeeManagerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeManagerService employeeService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ObjectMapper objectMapper; // Auto-configured by Spring Boot

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Order(1)
    @Test
    void addEmployee() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId("1001");
        emp1.setName("John Doe");
        emp1.setEmail("john.doe@example.com");
        emp1.setDesignation("Account Manager");
        emp1.setDepartment("BA");
        emp1.setMobile("1234567890");
        emp1.setLocation("New York");
        emp1.setManagerId("0");
        Instant dateOfJoining = Instant.parse("2010-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.message").value("Successfully created."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }

        // Manager 2
        EmployeeManagerModel emp2 = new EmployeeManagerModel();
        emp2.setId("1002");
        emp2.setName("Jane Smith");
        emp2.setEmail("jane.smith@example.com");
        emp2.setDesignation("Account Manager");
        emp2.setDepartment("Delivery");
        emp2.setMobile("0987654321");
        emp2.setLocation("Chicago");
        emp2.setManagerId("0");
        Instant dateOfJoining2 = Instant.parse("2010-06-20T09:00:00.000Z");
        emp2.setDateOfJoining(dateOfJoining2);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp2)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.message").value("Successfully created."));
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }

        // Manager 3
        EmployeeManagerModel emp3 = new EmployeeManagerModel();
        emp3.setId("1003");
        emp3.setName("Ken G");
        emp3.setEmail("keng@example.com");
        emp3.setDesignation("Account Manager");
        emp3.setDepartment("Sales");
        emp3.setMobile("1122334455");
        emp3.setLocation("San Francisco");
        emp3.setManagerId("0");
        Instant dateOfJoining3 = Instant.parse("2010-01-15T10:30:00.000Z");
        emp3.setDateOfJoining(dateOfJoining3);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp3)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.message").value("Successfully created."));
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }

        // Manager 4
        EmployeeManagerModel emp4 = new EmployeeManagerModel();
        emp4.setId("1004");
        emp4.setName("Alice Johnson");
        emp4.setEmail("alice.johnson@example.com");
        emp4.setDesignation("Account Manager");
        emp4.setDepartment("QA");
        emp4.setMobile("5566778899");
        emp4.setLocation("Boston");
        emp4.setManagerId("0");
        Instant dateOfJoining4 = Instant.parse("2020-03-01T08:45:00.000Z");
        emp4.setDateOfJoining(dateOfJoining4);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp4)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.message").value("Successfully created."));
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }

        // Manager 5
        EmployeeManagerModel emp5 = new EmployeeManagerModel();
        emp5.setId("1005");
        emp5.setName("Michael Brown");
        emp5.setEmail("michael.brown@example.com");
        emp5.setDesignation("Account manager");
        emp5.setDepartment("Engineering");
        emp5.setMobile("2233445566");
        emp5.setLocation("Los Angeles");
        emp5.setManagerId("0");
        Instant dateOfJoining5 = Instant.parse("2010-11-10T07:30:00.000Z");
        emp5.setDateOfJoining(dateOfJoining5);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp5)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.message").value("Successfully created."));
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }


        EmployeeManagerModel emp6 = new EmployeeManagerModel();
        emp6.setId("1007");
        emp6.setName("Billy");
        emp6.setEmail("butcher@example.com");
        emp6.setDesignation("Associate");
        emp6.setDepartment("Engineering");
        emp6.setMobile("2233445566");
        emp6.setLocation("Los Angeles");
        emp6.setManagerId("1005");
        Instant dateOfJoining6 = Instant.parse("2015-11-10T07:30:00.000Z");
        emp5.setDateOfJoining(dateOfJoining6);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp6)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.message").value("Successfully created."));
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }

    }

    @Order(2)
    @Test
    void addEmployeeWithExceptionExistingId() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId("1001");
        emp1.setName("Sam Doe");
        emp1.setEmail("Sam.doe@example.com");
        emp1.setDesignation("Account Manager");
        emp1.setDepartment("BA");
        emp1.setMobile("1234567890");
        emp1.setLocation("New York");
        emp1.setManagerId("0");
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("Employee with id 1001 exists."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }

    }

    @Order(3)
    @Test
    void addEmployeeWithExceptionInvalidEmail() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId("1006");
        emp1.setName("Sam Doe");
        emp1.setEmail("invalid-email");
        emp1.setDesignation("Account Manager");
        emp1.setDepartment("BA");
        emp1.setMobile("1234567890");
        emp1.setLocation("New York");
        emp1.setManagerId("0");
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("Invalid Email format."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(4)
    @Test
    void addEmployeeWithExceptionExistingManager() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId("1006");
        emp1.setName("Sam Doe");
        emp1.setEmail("Sam.doe@example.com");
        emp1.setDesignation("Account Manager");
        emp1.setDepartment("BA");
        emp1.setMobile("1234567890");
        emp1.setLocation("New York");
        emp1.setManagerId("0");
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("Department BA already has a manager."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(5)
    @Test
    void addEmployeeWithExceptionExistingEmail() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId("1006");
        emp1.setName("Sam Doe");
        emp1.setEmail("john.doe@example.com");
        emp1.setDesignation("Account Manager");
        emp1.setDepartment("Sales");
        emp1.setMobile("1234567890");
        emp1.setLocation("New York");
        emp1.setManagerId("0");
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("Employee with email john.doe@example.com already exists."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(6)
    @Test
    void addEmployeeWithExceptionInvalidMobileNumberNot10Digit() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId("1006");
        emp1.setName("Sam Doe");
        emp1.setEmail("sam.doe@example.com");
        emp1.setDesignation("Account Manager");
        emp1.setDepartment("Sales");
        emp1.setMobile("123456789");
        emp1.setLocation("New York");
        emp1.setManagerId("0");
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("Invalid mobile number. It must be a 10-digit number."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(7)
    @Test
    void addEmployeeWithExceptionInvalidMobileNumberNotNumer() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId("1006");
        emp1.setName("Sam Doe");
        emp1.setEmail("sam.doe@example.com");
        emp1.setDesignation("Account Manager");
        emp1.setDepartment("Sales");
        emp1.setMobile("invalid-mobile");
        emp1.setLocation("New York");
        emp1.setManagerId("0");
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("Invalid mobile number. It must be a 10-digit number."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(8)
    @Test
    void addEmployeeWithExceptionInvalidDepartment() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId("1006");
        emp1.setName("Sam Doe");
        emp1.setEmail("sam.doe@example.com");
        emp1.setDesignation("Account Manager");
        emp1.setDepartment("HR");
        emp1.setMobile("invalid-mobile");
        emp1.setLocation("New York");
        emp1.setManagerId("0");
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message")
                            .value("Invalid department. Must be one of: sales, delivery, QA, engineering, BA."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(9)
    @Test
    void addEmployeeWithExceptionInvalidDesignation() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId("1006");
        emp1.setName("Sam Doe");
        emp1.setEmail("sam.doe@example.com");
        emp1.setDesignation("Sales Manager");
        emp1.setDepartment("Sales");
        emp1.setMobile("invalid-mobile");
        emp1.setLocation("New York");
        emp1.setManagerId("0");
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("Designation can only be Account Manager or associate."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(10)
    @Test
    void addEmployeeWithInvalidDesignationOfManager() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId("1006");
        emp1.setName("Sam Doe");
        emp1.setEmail("sam.doe@example.com");
        emp1.setDesignation("Account Manager");
        emp1.setDepartment("Sales");
        emp1.setMobile("1234567890");
        emp1.setLocation("New York");
        emp1.setManagerId("1001");
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message")
                            .value("Designation cannot be Account Manager for an employee with a valid manager ID."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(11)
    @Test
    void addEmployeeWithInvalidManagerId() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId("1006");
        emp1.setName("Sam Doe");
        emp1.setEmail("sam.doe@example.com");
        emp1.setDesignation("Associate");
        emp1.setDepartment("Sales");
        emp1.setMobile("1234567890");
        emp1.setLocation("New York");
        emp1.setManagerId("1000");
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("Manager with ID 1000 does not exist."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(12)
    @Test
    void addEmployeeWithValidManagerIdButWithDifferentDepartment() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId("1006");
        emp1.setName("Sam Doe");
        emp1.setEmail("sam.doe@example.com");
        emp1.setDesignation("Associate");
        emp1.setDepartment("Sales");
        emp1.setMobile("1234567890");
        emp1.setLocation("New York");
        emp1.setManagerId("1001");
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message")
                            .value("Employee's department does not match the manager's department."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(13)
    @Test
    void addEmployeeAsManagerWithInvalidDesignation() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId("1008    ");
        emp1.setName("Manu");
        emp1.setEmail("Manu@example.com");
        emp1.setDesignation("Associate");
        emp1.setDepartment("BA");
        emp1.setMobile("1234567890");
        emp1.setLocation("New York");
        emp1.setManagerId("0");
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("Designation must be Account Manager for a new manager."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(14)
    @Test
    void addEmployeeAsManagerWithNullID() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId(null);
        emp1.setName("Manu");
        emp1.setEmail("Manu@example.com");
        emp1.setDesignation("Associate");
        emp1.setDepartment("BA");
        emp1.setMobile("1234567890");
        emp1.setLocation("New York");
        emp1.setManagerId("1001");
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("Employee ID cannot be null."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(15)
    @Test
    void addEmployeeWithValidManagerId() {
        EmployeeManagerModel emp1 = new EmployeeManagerModel();
        emp1.setId("1006");
        emp1.setName("Sam Doe");
        emp1.setEmail("sam.doe@example.com");
        emp1.setDesignation("Associate");
        emp1.setDepartment("BA");
        emp1.setMobile("1234567890");
        emp1.setLocation("New York");
        emp1.setManagerId("1001");
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00.000Z");
        emp1.setDateOfJoining(dateOfJoining);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp1)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.message").value("Successfully created."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(16)
    @Test
    void getAllEmployees() {
        try {
            mockMvc.perform(get("/api/employees")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].name").value("John Doe"));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(17)
    @Test
    void getAllEmployeesWithManagerAndExperience() {
        try {
            mockMvc.perform(get("/api/managerWithYear")
                    .param("managerId", "1001")
                    .param("year", "1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message").value("Successfully fetched"))
                    .andExpect(jsonPath("$.details[0].accountManager").value("John Doe"))
                    .andExpect(jsonPath("$details[0].department").value("BA"))
                    .andExpect(jsonPath("$details[0].employeeList[0].name").value("Sam Doe"));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(18)
    @Test
    void getAllEmployeesWithInvalidManagerAndExperience() {
        try {
            mockMvc.perform(get("/api/managerWithYear")
                    .param("managerId", "10010000")
                    .param("year", "1"))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("Invalid Manager ID"));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(19)
    @Test
    void getAllEmployeesWithManager() {
        try {
            mockMvc.perform(get("/api/managerWithYear")
                    .param("managerId", "1001"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message").value("Successfully fetched"))
                    .andExpect(jsonPath("$.details[0].accountManager").value("John Doe"))
                    .andExpect(jsonPath("$details[0].department").value("BA"))
                    .andExpect(jsonPath("$details[0].employeeList[0].name").value("Sam Doe"));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(20)
    @Test
    void getAllEmployeesWithYears() {
        try {
            mockMvc.perform(get("/api/managerWithYear")
                    .param("year", "1"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message").value("Successfully fetched"))
                    .andExpect(jsonPath("$.details[0].accountManager").value("John Doe"))
                    .andExpect(jsonPath("$.details[1].accountManager").value("Jane Smith"))
                    .andExpect(jsonPath("$details[0].department").value("BA"))
                    .andExpect(jsonPath("$details[0].department").value("Delivery"))
                    .andExpect(jsonPath("$details[0].employeeList[0].name").value("Sam Doe"))
                    .andExpect(jsonPath("$.details[1].employeeList").isEmpty());
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(20)
    @Test
    void getAllEmployeesWithManagerAndYearAsNull() {
        try {
            mockMvc.perform(get("/api/managerWithYear"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message").value("Successfully fetched"))
                    .andExpect(jsonPath("$.details[0].accountManager").value("John Doe"))
                    .andExpect(jsonPath("$.details[1].accountManager").value("Jane Smith"))
                    .andExpect(jsonPath("$details[0].department").value("BA"))
                    .andExpect(jsonPath("$details[0].department").value("Delivery"))
                    .andExpect(jsonPath("$details[0].employeeList[0].name").value("Sam Doe"))
                    .andExpect(jsonPath("$.details[1].employeeList").isEmpty());
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(21)
    @Test
    void getAllEmployeesWithNegativeManager() {
        try {
            mockMvc.perform(get("/api/managerWithYear")
                    .param("managerId", "-1")
                    .param("year", "1"))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message")
                            .value("Manager ID and Minimum Years of Experience must be non-negative."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(22)
    @Test
    void getAllEmployeesWithNegativeYear() {
        try {
            mockMvc.perform(get("/api/managerWithYear")
                    .param("managerId", "1001")
                    .param("year", "-1"))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message")
                            .value("Manager ID and Minimum Years of Experience must be non-negative."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(23)
    @Test
    void getAllEmployeesWithNegativeManagerOnly() {
        try {
            mockMvc.perform(get("/api/managerWithYear")
                    .param("managerId", "-1"))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("Manager ID cannot be negative"));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(24)
    @Test
    void getAllEmployeesWithNegativeYearOnly() {
        try {
            mockMvc.perform(get("/api/managerWithYear")
                    .param("year", "-1"))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("Minimum Years of Experience must be non-negative."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(25)
    @Test
    void getAllEmployeesWithInvalidManagerOnly() {
        try {
            mockMvc.perform(get("/api/managerWithYear")
                    .param("managerId", "10010000"))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("Invalid Manager ID"));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(26)
    @Test
    void putEmployeeManagerInvalidManagerId() {
        try {
            ManagerChangeRequest managerChangeRequest = new ManagerChangeRequest();
            managerChangeRequest.setEmployeeId("1006");
            managerChangeRequest.setManagerId("100");
            mockMvc.perform(put("/api/newManager")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(managerChangeRequest)))
                    .andExpect(status().isBadRequest())
                    .andExpect(
                            jsonPath("$.message").value("Cannot find new Manager with id 100 in the organisation"));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }




    @Order(27)
    @Test
    void putEmployeeManagerButUnderSameManager() {
        try {
            ManagerChangeRequest managerChangeRequest = new ManagerChangeRequest();
            managerChangeRequest.setEmployeeId("1006");
            managerChangeRequest.setManagerId("1001");
            mockMvc.perform(put("/api/newManager")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(managerChangeRequest)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message")
                            .value("Employee is currently working under the manager with id 1001"));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(26)
    @Test
    void putEmployeeManagerInvalidEmployeeId() {
        try {
            ManagerChangeRequest managerChangeRequest = new ManagerChangeRequest();
            managerChangeRequest.setEmployeeId("106");
            managerChangeRequest.setManagerId("100");
            mockMvc.perform(put("/api/newManager")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(managerChangeRequest)))
                    .andExpect(status().isBadRequest())
                    .andExpect(
                            jsonPath("$.message").value("Cannot find employee with id 106 in the organisation"));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    
    @Order(29)
    @Test
    void putEmployeeManagerAndEmployeeIdValid() {
        try {
            ManagerChangeRequest managerChangeRequest = new ManagerChangeRequest();
            managerChangeRequest.setEmployeeId("1006");
            managerChangeRequest.setManagerId("1002");
            mockMvc.perform(put("/api/newManager")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(managerChangeRequest)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.message")
                            .value("Sam Doe's manager has been succesfully changed from John Doe to Jane Smith"));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(30)
    @Test
    void putEmployeeManagerChangeMangerOfExisitingManager() {
        try {
            ManagerChangeRequest managerChangeRequest = new ManagerChangeRequest();
            managerChangeRequest.setEmployeeId("1001");
            managerChangeRequest.setManagerId("1002");
            mockMvc.perform(put("/api/newManager")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(managerChangeRequest)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message")
                            .value("Employee is already a manager. Cannot assign manager to another manager"));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(31)
    @Test
    void putEmployeeManagerChangeMangerWhoIsNotAManager() {
        try {
            ManagerChangeRequest managerChangeRequest = new ManagerChangeRequest();
            managerChangeRequest.setEmployeeId("1006");
            managerChangeRequest.setManagerId("1007");
            mockMvc.perform(put("/api/newManager")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(managerChangeRequest)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message")
                            .value("New manager must be a valid manager of the department."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @AfterAll
    void tearDown() {
        mongoTemplate.dropCollection("empmanager");
    }
}
/*
 * 
 * @Test
 * void testGetAllEmployeesFromController() throws Exception {
 * // Create a mock employee
 * EmployeeManagerModel employee = new EmployeeManagerModel();
 * employee.setId("1");
 * employee.setName("John Doe");
 * employee.setEmail("john.doe@example.com");
 * employee.setDesignation("Associate");
 * employee.setLocation("Delhi");
 * employee.setManagerId("1001");
 * employee.setMobile("1234567890");
 * employee.setDepartment("sales");
 * employee.setCreatedTime(LocalDateTime.of(2024, 1, 1, 10, 0));
 * employee.setUpdatedTime(LocalDateTime.of(2024, 1, 2, 10, 0));
 * 
 * List<EmployeeManagerModel> employees = Arrays.asList(employee);
 * 
 * // Mock the behavior of employeeService
 * when(employeeService.getAllEmployees()).thenReturn(employees);
 * 
 * // Perform the request and verify
 * mockMvc.perform(get("/api/employees")
 * .contentType(MediaType.APPLICATION_JSON))
 * .andExpect(status().isOk())
 * .andExpect(jsonPath("$[0].id").value("1"))
 * .andExpect(jsonPath("$[0].name").value("John Doe"))
 * .andExpect(jsonPath("$[0].designation").value("Associate"))
 * .andExpect(jsonPath("$[0].email").value("john.doe@example.com"))
 * .andExpect(jsonPath("$[0].department").value("sales"))
 * .andExpect(jsonPath("$[0].mobile").value("1234567890"))
 * .andExpect(jsonPath("$[0].location").value("Delhi"))
 * .andExpect(jsonPath("$[0].managerId").value("1001"));
 * }
 * 
 * @Test
 * void testAddEmployeeSuccess() throws Exception {
 * // Create a mock employee
 * EmployeeManagerModel employee = new EmployeeManagerModel();
 * employee.setId("1");
 * employee.setName("John Doe");
 * employee.setEmail("john.doe@example.com");
 * employee.setDesignation("Associate");
 * employee.setLocation("Delhi");
 * employee.setManagerId("1001");
 * employee.setMobile("1234567890");
 * employee.setDepartment("sales");
 * employee.setCreatedTime(LocalDateTime.of(2024, 1, 1, 10, 0));
 * employee.setUpdatedTime(LocalDateTime.of(2024, 1, 2, 10, 0));
 * 
 * // Mock the behavior of employeeService
 * when(employeeService.addEmployee(employee)).thenReturn(employee);
 * 
 * // Perform the request and verify
 * mockMvc.perform(post("/api/newEmployee")
 * .contentType(MediaType.APPLICATION_JSON)
 * .content(objectMapper.writeValueAsString(employee)))
 * .andExpect(status().isCreated())
 * .andExpect(jsonPath("$.message").value("Successfully created."));
 * }
 * 
 * @Test
 * public void testAddEmployee() throws Exception {
 * // Create a sample Employee object
 * EmployeeManagerModel employee1 = new EmployeeManagerModel();
 * employee1.setId("1001");
 * employee1.setName("Alice Johnson");
 * employee1.setDesignation("Account Manager");
 * employee1.setEmail("alice.johnson@example.com");
 * employee1.setDepartment("les");
 * employee1.setMobile("9876543210");
 * employee1.setLocation("Los Angeles");
 * employee1.setManagerId("0");
 * 
 * // Perform the request and verify
 * mockMvc.perform(MockMvcRequestBuilders.post("/api/newEmployee")
 * .contentType(MediaType.APPLICATION_JSON)
 * .content(objectMapper.writeValueAsString(employee1)))
 * .andExpect(MockMvcResultMatchers.status().isCreated());
 * }
 * 
 * @Test
 * void testDeleteEmployeeSuccess() throws Exception {
 * // Mock the behavior of employeeService
 * ResponseMessage response = new ResponseMessage("Successfully deleted.");
 * when(employeeService.deleteEmployee("1")).thenReturn(response);
 * 
 * // Perform the request and verify
 * mockMvc.perform(delete("/api/oldEmployee")
 * .param("employeeId", "1")
 * .contentType(MediaType.APPLICATION_JSON))
 * .andExpect(status().isOk())
 * .andExpect(content().json("{\"message\":\"Successfully deleted.\"}"));
 * }
 * 
 * @Test
 * void testDeleteEmployeeNotFound() throws Exception {
 * // Mock the behavior of employeeService to throw an exception
 * doThrow(new
 * IllegalArgumentException("Employee not found.")).when(employeeService).
 * deleteEmployee("1");
 * 
 * // Perform the request and verify
 * mockMvc.perform(delete("/api/oldEmployee")
 * .param("employeeId", "1")
 * .contentType(MediaType.APPLICATION_JSON))
 * .andExpect(status().isBadRequest())
 * .andExpect(content().json("{\"message\":\"Employee not found.\"}"));
 * }
 * 
 * @Test
 * void testChangeManagerSuccess() throws Exception {
 * // Create a request and response DTO
 * ManagerChangeRequest request = new ManagerChangeRequest();
 * request.setEmployeeId("123");
 * request.setManagerId("456");
 * 
 * ManagerChangeResponseDTO responseDTO = new
 * ManagerChangeResponseDTO("Manager changed successfully");
 * 
 * // Mock the behavior of employeeService
 * when(employeeService.changeManager("123", "456")).thenReturn(responseDTO);
 * 
 * // Perform the request and verify
 * mockMvc.perform(put("/api/newManager")
 * .contentType(MediaType.APPLICATION_JSON)
 * .content(objectMapper.writeValueAsString(request)))
 * .andExpect(status().isOk())
 * .andExpect(content().json("{\"message\":\"Manager changed successfully\"}"));
 * }
 * 
 * @Test
 * void testChangeManagerFailure() throws Exception {
 * // Create a request and response DTO
 * ManagerChangeRequest request = new ManagerChangeRequest();
 * request.setEmployeeId("123");
 * request.setManagerId("456");
 * 
 * // Mock the behavior of employeeService to throw an exception
 * doThrow(new
 * IllegalArgumentException("Invalid manager ID")).when(employeeService)
 * .changeManager("123", "456");
 * 
 * // Perform the request and verify
 * mockMvc.perform(put("/api/newManager")
 * .contentType(MediaType.APPLICATION_JSON)
 * .content(objectMapper.writeValueAsString(request)))
 * .andExpect(status().isBadRequest())
 * .andExpect(content().json("{\"message\":\"Invalid manager ID\"}"));
 * }
 * 
 * @Test
 * void testGetManagerWithExperience_Success() throws Exception {
 * // Create a mock Details object
 * ResponseDTO.Details mockDetails = new ResponseDTO.Details();
 * mockDetails.setAccountManager("John Doe");
 * mockDetails.setDepartment("HR");
 * mockDetails.setId("123");
 * 
 * // Create a mock ResponseDTO object
 * ResponseDTO mockResponse = new ResponseDTO(null);
 * mockResponse.setDetails(Arrays.asList(mockDetails)); // Add the Details
 * object to the list
 * 
 * // Mock the behavior of the employeeService
 * when(employeeService.managerWithExperience("123",
 * 5)).thenReturn(mockResponse);
 * 
 * // Perform the request and verify the response
 * mockMvc.perform(get("/api/managerWithYear")
 * .param("managerId", "123")
 * .param("year", "5"))
 * .andExpect(status().isOk())
 * .andExpect(jsonPath("$.details[0].id").value("123"))
 * .andExpect(jsonPath("$.details[0].accountManager").value("John Doe"))
 * .andExpect(jsonPath("$.details[0].department").value("HR"));
 * }
 * 
 * @Test
 * void testGetManagerWithExperience_NotFound() throws Exception {
 * when(employeeService.managerWithExperience("123", 10)).thenReturn(null);
 * 
 * mockMvc.perform(get("/api/managerWithYear")
 * .param("managerId", "123")
 * .param("year", "10"))
 * .andExpect(status().isNotFound());
 * }
 * }
 */