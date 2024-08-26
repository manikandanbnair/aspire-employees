package com.sql.MySql.repositories;

import com.sql.MySql.models.EmployeeManagerModel;

import java.time.Instant;
import java.util.List;

public interface EmployeeManagerCustomRepository {

    List<EmployeeManagerModel> getAllEmployees();
    
    EmployeeManagerModel findByIdCustom(String id);

    EmployeeManagerModel findByExistingManagerId(String managerId);
    
    EmployeeManagerModel findManagerByDepartment(String department);
    
    List<EmployeeManagerModel> getEmployeesByManagerIdAndJoiningDate(String managerId, Instant dateOfJoining);
    
    List<EmployeeManagerModel> findByManagerId(String managerId);
    
   

}
