package com.CombinedAPI.API.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.CombinedAPI.API.model.EmployeeManagerModel;



@Repository
public interface EmployeeManagerRepository extends MongoRepository<EmployeeManagerModel, String> {

    boolean existsByEmail(String email);
    // Custom query methods, if any

    



}
