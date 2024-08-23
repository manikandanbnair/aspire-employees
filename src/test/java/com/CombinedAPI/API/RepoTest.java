// package com.CombinedAPI.API;

// import com.CombinedAPI.API.model.EmployeeManagerModel;
// import com.CombinedAPI.API.repositories.EmpImpl;
// import com.CombinedAPI.API.repositories.EmployeeManagerRepository;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.data.mongodb.core.MongoTemplate;
// import org.springframework.data.mongodb.core.query.Criteria;
// import org.springframework.data.mongodb.core.query.Query;

// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.util.Arrays;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.*;

// public class RepoTest {

//     @Mock
//     private MongoTemplate mongoTemplate;

//     @Mock
//     private EmployeeManagerRepository employeeManagerRepository;

//     @InjectMocks
//     private EmpImpl empImpl;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     void testGetEmployeesByManagerIdAndJoiningDate() {
//         // Arrange
//         String managerId = "1";
//         LocalDateTime dateOfJoining = LocalDateTime.now().minusYears(5);

//         EmployeeManagerModel employee = new EmployeeManagerModel();
//         employee.setId("10");
//         employee.setDateOfJoining(LocalDateTime.now().minusYears(6));

//         List<EmployeeManagerModel> employees = Arrays.asList(employee);

//         Query query = new Query();
//         query.addCriteria(Criteria.where("managerId").is(managerId));
//         query.addCriteria(Criteria.where("dateOfJoining").lte(dateOfJoining));

//         when(mongoTemplate.find(query, EmployeeManagerModel.class)).thenReturn(employees);

//         // Act
//         List<EmployeeManagerModel> result = empImpl.getEmployeesByManagerIdAndJoiningDate(managerId, dateOfJoining);

//         // Assert
//         assertNotNull(result);
//         assertEquals(1, result.size());
//         assertEquals("10", result.get(0).getId());
//     }

//     @Test
//     void testGetAllEmployees() {
//         // Arrange
//         EmployeeManagerModel employee = new EmployeeManagerModel();
//         employee.setId("10");

//         List<EmployeeManagerModel> employees = Arrays.asList(employee);

//         when(employeeManagerRepository.findAll()).thenReturn(employees);

//         // Act
//         List<EmployeeManagerModel> result = empImpl.getAllEmployees();

//         // Assert
//         assertNotNull(result);
//         assertEquals(1, result.size());
//         assertEquals("10", result.get(0).getId());
//     }

//     @Test
//     void testFindManagerByDepartment() {
//         // Arrange
//         String department = "Engineering";
//         EmployeeManagerModel manager = new EmployeeManagerModel();
//         manager.setId("0");
//         manager.setDepartment(department);

//         Query query = new Query();
//         query.addCriteria(Criteria.where("managerId").is("0"));
//         query.addCriteria(Criteria.where("department").is(department));

//         when(mongoTemplate.findOne(query, EmployeeManagerModel.class)).thenReturn(manager);

//         // Act
//         EmployeeManagerModel result = empImpl.findManagerByDepartment(department);

//         // Assert
//         assertNotNull(result);
//         assertEquals("0", result.getId());
//         assertEquals(department, result.getDepartment());
//     }

//     @Test
//     void testFindByManagerId() {
//         // Arrange
//         String managerId = "1";
//         EmployeeManagerModel employee = new EmployeeManagerModel();
//         employee.setId("10");

//         List<EmployeeManagerModel> employees = Arrays.asList(employee);

//         Query query = new Query();
//         query.addCriteria(Criteria.where("managerId").is(managerId));

//         when(mongoTemplate.find(query, EmployeeManagerModel.class)).thenReturn(employees);

//         // Act
//         List<EmployeeManagerModel> result = empImpl.findByManagerId(managerId);

//         // Assert
//         assertNotNull(result);
//         assertEquals(1, result.size());
//         assertEquals("10", result.get(0).getId());
//     }

//     @Test
//     void testFindByExistingManagerId() {
//         // Arrange
//         String managerId = "1";
//         EmployeeManagerModel manager = new EmployeeManagerModel();
//         manager.setId(managerId);

//         Query query = new Query();
//         query.addCriteria(Criteria.where("id").is(managerId));

//         when(mongoTemplate.findOne(query, EmployeeManagerModel.class)).thenReturn(manager);

//         // Act
//         EmployeeManagerModel result = empImpl.findByExistingManagerId(managerId);

//         // Assert
//         assertNotNull(result);
//         assertEquals(managerId, result.getId());
//     }

//     @Test
//     void testFindByIdCustom() {
//         // Arrange
//         String id = "10";
//         EmployeeManagerModel employee = new EmployeeManagerModel();
//         employee.setId(id);

//         Query query = new Query();
//         query.addCriteria(Criteria.where("id").is(id));

//         when(mongoTemplate.findOne(query, EmployeeManagerModel.class)).thenReturn(employee);

//         // Act
//         EmployeeManagerModel result = empImpl.findByIdCustom(id);

//         // Assert
//         assertNotNull(result);
//         assertEquals(id, result.getId());
//     }

//     @Test
//     void testFindByDepartment() {
//         // Arrange
//         String department = "Sales";
//         EmployeeManagerModel employee = new EmployeeManagerModel();
//         employee.setDepartment(department);

//         List<EmployeeManagerModel> employees = Arrays.asList(employee);

//         Query query = new Query();
//         query.addCriteria(Criteria.where("department").is(department));

//         when(mongoTemplate.find(query, EmployeeManagerModel.class)).thenReturn(employees);

//         // Act
//         List<EmployeeManagerModel> result = empImpl.findByDepartment(department);

//         // Assert
//         assertNotNull(result);
//         assertEquals(1, result.size());
//         assertEquals(department, result.get(0).getDepartment());
//     }

//     @Test
//     void testFindByDateOfJoiningBefore() {
//         // Arrange
//         LocalDate minJoiningDate = LocalDate.now().minusYears(5);
//         EmployeeManagerModel employee = new EmployeeManagerModel();
//         employee.setDateOfJoining(LocalDateTime.now().minusYears(6));

//         List<EmployeeManagerModel> employees = Arrays.asList(employee);

//         Query query = new Query();
//         query.addCriteria(Criteria.where("dateOfJoining").lt(minJoiningDate));

//         when(mongoTemplate.find(query, EmployeeManagerModel.class)).thenReturn(employees);

//         // Act
//         List<EmployeeManagerModel> result = empImpl.findByDateOfJoiningBefore(minJoiningDate);

//         // Assert
//         assertNotNull(result);
//         assertEquals(1, result.size());
//         assertEquals(2018, result.get(0).getDateOfJoining().getYear());
//     }
// }
