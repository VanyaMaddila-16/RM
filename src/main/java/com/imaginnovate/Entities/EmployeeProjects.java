package com.imaginnovate.Entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "employee_projects", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"employee_id", "project_id"})
})
public class EmployeeProjects extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    public Employees employee;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    public Projects project;

    @Column(name = "can_approve_timesheets", nullable = false)
    public Boolean canApproveTimesheets;

    

    public EmployeeProjects() {
    }

    

    public EmployeeProjects(int id, Employees employee, Projects project, Boolean canApproveTimesheets) {
        this.id = id;
        this.employee = employee;
        this.project = project;
        this.canApproveTimesheets = canApproveTimesheets;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        return "EmployeeProjects [id=" + id + ", employee=" + employee + ", project=" + project
                + ", canApproveTimesheets=" + canApproveTimesheets + "]";
    }

    
}

