package com.CombinedAPI.API.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CombinedAPI.API.helpers.ManagerChangeRequest;
import com.CombinedAPI.API.model.EmployeeManagerModel;
import com.CombinedAPI.API.response.ManagerChangeResponseDTO;
import com.CombinedAPI.API.response.ResponseDTO;
import com.CombinedAPI.API.response.ResponseMessage;
import com.CombinedAPI.API.services.EmployeeManagerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeManagerController {

    @Autowired
    private EmployeeManagerService employeeService;

    // Get all employees
    @GetMapping("/employees")
    public List<EmployeeManagerModel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get manager with experience
    @GetMapping("/managerWithYear")
    public ResponseEntity<ResponseDTO> getManagerWithExperience(
            @RequestParam(value = "managerId", required = false) String managerId,
            @RequestParam(value = "year", required = false) Integer minYearsOfExperience) {

        ResponseDTO responseDTO = employeeService.managerWithExperience(managerId, minYearsOfExperience);

        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add new employee
    @PostMapping("/newEmployee")
    public ResponseEntity<ResponseMessage> addEmployee(@RequestBody EmployeeManagerModel employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(new ResponseMessage("Successfully created."), HttpStatus.CREATED);
    }

    // Change manager
    @PutMapping("/newManager")
    public ResponseEntity<ManagerChangeResponseDTO> changeManager(@RequestBody ManagerChangeRequest request) {
        String employeeId = request.getEmployeeId();
        String newManagerId = request.getManagerId();

        ManagerChangeResponseDTO responseDTO = employeeService.changeManager(employeeId, newManagerId);
        return ResponseEntity.ok(responseDTO);
    }

    // Delete employee
    @DeleteMapping("/oldEmployee")
    public ResponseEntity<ResponseMessage> deleteEmployee(@RequestParam String employeeId) {
        ResponseMessage response = employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok(response);
    }
}
