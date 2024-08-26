package com.ElasticSearch.EsAPI.repositories;



import org.springframework.stereotype.Repository;

import com.ElasticSearch.EsAPI.model.EmployeeManagerModel;

import java.time.Instant;
import java.util.List;


@Repository
public interface EmployeeManagerCustomRepository {

    List<EmployeeManagerModel> getAllEmployees();
    
    EmployeeManagerModel findByIdCustom(String id);

    EmployeeManagerModel findByExistingManagerId(String managerId);
    
    EmployeeManagerModel findManagerByDepartment(String department);
    
    List<EmployeeManagerModel> getEmployeesByManagerIdAndJoiningDate(String managerId, Instant dateOfJoining);
    
    List<EmployeeManagerModel> findByManagerId(String managerId);
    

}
