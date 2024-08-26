package com.ElasticSearch.EsAPI.repositories;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ElasticSearch.EsAPI.model.EmployeeManagerModel;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class EmpImpl implements EmployeeManagerCustomRepository {

    @Autowired
    private EmployeeManagerRepository employeeManagerRepository;

    @Override
    public List<EmployeeManagerModel> getAllEmployees() {
        List<EmployeeManagerModel> employees = (List<EmployeeManagerModel>) employeeManagerRepository.findAll();
        return employees.stream()
            .sorted((e1, e2) -> e1.getId().compareTo(e2.getId())) 
            .collect(Collectors.toList());
    }

    @Override
    public EmployeeManagerModel findByIdCustom(String id) {
        return employeeManagerRepository.findById(id).orElse(null);
    }

    @Override
    public EmployeeManagerModel findByExistingManagerId(String managerId) {
        return employeeManagerRepository.findById(managerId).stream().findFirst().orElse(null);
    }

    @Override
    public EmployeeManagerModel findManagerByDepartment(String department) {
        return employeeManagerRepository.findByDepartment(department).stream().findFirst().orElse(null);
    }

    @Override
    public List<EmployeeManagerModel> getEmployeesByManagerIdAndJoiningDate(String managerId, Instant dateOfJoining) {
        return employeeManagerRepository.findByManagerIdAndDateOfJoiningBefore(managerId, dateOfJoining);
    }

    @Override
    public List<EmployeeManagerModel> findByManagerId(String managerId) {
        return employeeManagerRepository.findByManagerId(managerId);
    }


}
