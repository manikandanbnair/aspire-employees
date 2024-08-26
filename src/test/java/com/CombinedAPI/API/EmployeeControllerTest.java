package com.CombinedAPI.API;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import java.time.Instant;

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
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.CombinedAPI.API.handlers.GlobalExceptionHandler;
import com.CombinedAPI.API.helpers.ManagerChangeRequest;
import com.CombinedAPI.API.model.EmployeeManagerModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ObjectMapper objectMapper; // Auto-configured by Spring Boot

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new GlobalExceptionHandler()).build();
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
        Instant dateOfJoining = Instant.parse("2010-08-14T11:00:00+00:00");
       
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
        Instant dateOfJoining2 = Instant.parse("2010-06-20T09:00:00+00:00");
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
        Instant dateOfJoining3 = Instant.parse("2010-01-15T10:30:00+00:00");
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
        Instant dateOfJoining4 = Instant.parse("2020-03-01T08:45:00+00:00");
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
        Instant dateOfJoining5 = Instant.parse("2010-11-10T07:30:00+00:00");
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
        Instant dateOfJoining6 = Instant.parse("2012-01-01T00:00:00+00:00");
        emp5.setDateOfJoining(dateOfJoining6);

        try {
            mockMvc.perform(post("/api/newEmployee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(emp6)))
                    //.andExpect(status().isCreated())
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
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00+00:00");
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
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00+00:00");
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
        Instant dateOfJoining = Instant.parse("2019-08-14T11:00:00+00:00");
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
                    //.andExpect(status().isOk())
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
                    //.andExpect(status().isOk())
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
                    //.andExpect(status().isOk())
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
                    //.andExpect(status().isOk())
                   // .andExpect(jsonPath("$.message").value("Successfully fetched"))
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

    @Order(32)
    @Test
    void deleteEmployeeWithInvalidEmployee()
    {
        try {
            mockMvc.perform(delete("/api/oldEmployee")
            .param("employeeId", "1"))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message")
                .value("Cannot find employee with ID 1 in the organization."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    @Order(33)
    @Test
    void deleteEmployeeWithValidEmployeeWithEmployeesToManage()
    {
        try {
            mockMvc.perform(delete("/api/oldEmployee")
            .param("employeeId", "1002"))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message")
                .value("Cannot delete employee as they have employees to manage."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }


    @Order(34)
    @Test
    void deleteEmployeeSucess()
    {
        try {
            mockMvc.perform(delete("/api/oldEmployee")
            .param("employeeId", "1007"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message")
                .value("Successfully deleted Billy from the organization."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    
    @Order(35)
    @Test
    void deleteEmployeeAsManagerSucess()
    {
        try {
            mockMvc.perform(delete("/api/oldEmployee")
            .param("employeeId", "1003"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message")
                .value("Successfully deleted Ken G from the organization."));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    // @Order(36)
    // @Test
    // void getException()  throws Exception {
    //     MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null, null);
    
        
    //     mockMvc.perform(post("/api/invalidEndpoint")
    //             .contentType("application/json"))
    //             .andExpect(status().isBadRequest())
    //             .andExpect(jsonPath("$.message").value("Validation failed: " + ex.getMessage()));
    
    // }

    @AfterAll
    void tearDown() {
        mongoTemplate.dropCollection("empmanager");
    }
}
