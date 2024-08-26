package com.sql.MySql.response;


import java.time.Instant;

public class EmployeeResponseDTO {
    private String id; 
    private String name;
    private String designation;
    private String email;
    private String department;
    private String mobile;
    private String location;
    
    private Instant dateOfJoining;
    
    private Instant createdTime;
    
    private Instant updatedTime;

    // Getters and setters
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

    public Instant getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Instant instant) {
        this.dateOfJoining = instant;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Instant instant) {
        this.createdTime = instant;
    }

    public Instant getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Instant instant) {
        this.updatedTime = instant;
    }
}
