package com.imaginnovate.Dto;

import java.time.LocalDateTime;

public class TimesheetDto {

    private int id;

    private int employeeProject;

     private int projectTask;

     private String description;

     private Short hoursWorked;

     private int submittedBy;

     private LocalDateTime submittedOn;

      private int status;

      private int approvedBy;

    public TimesheetDto() {
    }

    public TimesheetDto(int id, int employeeProject, int projectTask, String description, Short hoursWorked,
            int submittedBy, LocalDateTime submittedOn, int status, int approvedBy) {
        this.id = id;
        this.employeeProject = employeeProject;
        this.projectTask = projectTask;
        this.description = description;
        this.hoursWorked = hoursWorked;
        this.submittedBy = submittedBy;
        this.submittedOn = submittedOn;
        this.status = status;
        this.approvedBy = approvedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeProject() {
        return employeeProject;
    }

    public void setEmployeeProject(int employeeProject) {
        this.employeeProject = employeeProject;
    }

    public int getProjectTask() {
        return projectTask;
    }

    public void setProjectTask(int projectTask) {
        this.projectTask = projectTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Short hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(int submittedBy) {
        this.submittedBy = submittedBy;
    }

    public LocalDateTime getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(LocalDateTime submittedOn) {
        this.submittedOn = submittedOn;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(int approvedBy) {
        this.approvedBy = approvedBy;
    }

      
    
}
