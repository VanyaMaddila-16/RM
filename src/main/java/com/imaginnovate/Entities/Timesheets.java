package com.imaginnovate.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "timesheets")
public class Timesheets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_project_id", nullable = false)
    private EmployeeProjects employeeProject;

    @ManyToOne
    @JoinColumn(name = "project_task_id", nullable = false)
    private ProjectTasks projectTask;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "hours_worked", nullable = false)
    private Short hoursWorked;

    @ManyToOne
    @JoinColumn(name = "submitted_by", nullable = false)
    private Employees submittedBy;

    @Column(name = "submitted_on", nullable = false)
    private LocalDateTime submittedOn;

    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    private TimesheetStatus status;

    @ManyToOne
    @JoinColumn(name = "approved_by")
    private Employees approvedBy;

    

    public Timesheets() {
    }

    

    public Timesheets(EmployeeProjects employeeProject, ProjectTasks projectTask, String description, Short hoursWorked,
            Employees submittedBy, LocalDateTime submittedOn, TimesheetStatus status, Employees approvedBy) {
        this.employeeProject = employeeProject;
        this.projectTask = projectTask;
        this.description = description;
        this.hoursWorked = hoursWorked;
        this.submittedBy = submittedBy;
        this.submittedOn = submittedOn;
        this.status = status;
        this.approvedBy = approvedBy;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeProjects getEmployeeProject() {
        return employeeProject;
    }

    public void setEmployeeProject(EmployeeProjects employeeProject) {
        this.employeeProject = employeeProject;
    }

    public ProjectTasks getProjectTask() {
        return projectTask;
    }

    public void setProjectTask(ProjectTasks projectTask) {
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

    public Employees getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(Employees submittedBy) {
        this.submittedBy = submittedBy;
    }

    public LocalDateTime getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(LocalDateTime submittedOn) {
        this.submittedOn = submittedOn;
    }

    public TimesheetStatus getStatus() {
        return status;
    }

    public void setStatus(TimesheetStatus status) {
        this.status = status;
    }

    public Employees getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Employees approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Override
    public String toString() {
        return "Timesheets [id=" + id + ", employeeProject=" + employeeProject + ", projectTask=" + projectTask
                + ", description=" + description + ", hoursWorked=" + hoursWorked + ", submittedBy=" + submittedBy
                + ", submittedOn=" + submittedOn + ", status=" + status + ", approvedBy=" + approvedBy + "]";
    }

    
}
