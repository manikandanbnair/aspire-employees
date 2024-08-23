package com.CombinedAPI.API.repositories;

import com.CombinedAPI.API.model.EmployeeManagerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;


@Repository
public class EmpImpl implements EmployeeManagerCustomRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private EmployeeManagerRepository employeeManagerRepository;

    @Override
    public List<EmployeeManagerModel> getEmployeesByManagerIdAndJoiningDate(String managerId, Instant dateOfJoining) {
        Query query = new Query();
        query.addCriteria(Criteria.where("managerId").is(managerId));
        query.addCriteria(Criteria.where("dateOfJoining").lte(dateOfJoining));
        return mongoTemplate.find(query, EmployeeManagerModel.class);
    }

    


    @Override
    public List<EmployeeManagerModel> getAllEmployees() {
        return employeeManagerRepository.findAll();
    }

    @Override
    public EmployeeManagerModel findManagerByDepartment(String department) {
        Query query = new Query();
        query.addCriteria(Criteria.where("managerId").is("0"));
        query.addCriteria(Criteria.where("department").is(department));
        return mongoTemplate.findOne(query, EmployeeManagerModel.class);
    }

    @Override
    public List<EmployeeManagerModel> findByManagerId(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("managerId").is(id));
        return mongoTemplate.find(query, EmployeeManagerModel.class);
    }

    @Override
    public EmployeeManagerModel findByExistingManagerId(String managerId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(managerId));
        return mongoTemplate.findOne(query, EmployeeManagerModel.class);
    }

    @Override
    public EmployeeManagerModel findByIdCustom(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, EmployeeManagerModel.class);
    }

    @Override
    public List<EmployeeManagerModel> findByDepartment(String department) {
        Query query = new Query();
        query.addCriteria(Criteria.where("department").is(department));
        return mongoTemplate.find(query, EmployeeManagerModel.class);
    }

    @Override
    public List<EmployeeManagerModel> findByDateOfJoiningBefore(LocalDate minJoiningDate) {
        Query query = new Query();
        query.addCriteria(Criteria.where("dateOfJoining").lt(minJoiningDate));
        return mongoTemplate.find(query, EmployeeManagerModel.class);
    }
}
