package com.ElasticSearch.EsAPI.repositories;


import java.time.Instant;
import java.util.List;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


import org.springframework.stereotype.Repository;

import com.ElasticSearch.EsAPI.model.EmployeeManagerModel;





@Repository
public interface EmployeeManagerRepository extends ElasticsearchRepository<EmployeeManagerModel, String> {

    boolean existsByEmail(String email);
   
    List<EmployeeManagerModel> findAll();
    List<EmployeeManagerModel> findByManagerId(String managerId);
    List<EmployeeManagerModel> findByDepartment(String department);
    List<EmployeeManagerModel> findByManagerIdAndDateOfJoiningBefore(String managerId, Instant dateOfJoining);
    



}
