package com.imaginnovate.Dto;

import java.time.LocalDate;

public class EmployeeDto {
    private int id;
    private String firstName;
    private String lastName;
    private char gender;
    private String email;
    private String designation;
    private LocalDate startDate;
    private LocalDate endDate;
    private int divisionId;
    private int reportsToId;
    
    public EmployeeDto() {
    }

    public EmployeeDto(int id, String firstName, String lastName, char gender, String email, String designation,
            LocalDate startDate, LocalDate endDate, int divisionId, int reportsToId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.designation = designation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.divisionId = divisionId;
        this.reportsToId = reportsToId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public int getReportsToId() {
        return reportsToId;
    }

    public void setReportsToId(int reportsToId) {
        this.reportsToId = reportsToId;
    }

    
}