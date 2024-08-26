package com.sql.MySql.models;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeeManagerModel")
public class EmployeeManagerModel {

    @Id
    private String id;

    private String name;
    private String designation;
    private String email;
    private String department;
    private String mobile;
    private String location;
    private String managerId;
    private Instant dateOfJoining;
    private Instant createdTime;
    private Instant updatedTime;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getManagerId() {
        return managerId;
    }
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
    public Instant getDateOfJoining() {
        return dateOfJoining;
    }
    public void setDateOfJoining(Instant dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    public Instant getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Instant createdTime) {
        this.createdTime = createdTime;
    }
    public Instant getUpdatedTime() {
        return updatedTime;
    }
    public void setUpdatedTime(Instant updatedTime) {
        this.updatedTime = updatedTime;
    }

   
}
