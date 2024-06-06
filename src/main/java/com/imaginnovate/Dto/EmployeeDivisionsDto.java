package com.imaginnovate.Dto;


public class EmployeeDivisionsDto {
    private int id;
    private int employeeId;
    private int divisionId;
    private boolean canApproveTimesheets;
    

    public EmployeeDivisionsDto() {
    }

    
    public EmployeeDivisionsDto(int id, int employeeId, int divisionId, boolean canApproveTimesheets) {
        this.id = id;
        this.employeeId = employeeId;
        this.divisionId = divisionId;
        this.canApproveTimesheets = canApproveTimesheets;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public int getDivisionId() {
        return divisionId;
    }
    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }
    public boolean isCanApproveTimesheets() {
        return canApproveTimesheets;
    }
    public void setCanApproveTimesheets(boolean canApproveTimesheets) {
        this.canApproveTimesheets = canApproveTimesheets;
    }
    
    
}
