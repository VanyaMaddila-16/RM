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
@Table(name = "employee_divisions", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"employee_id", "project_id"})
})
public class EmployeeDivisions extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Employees employee;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Divisions division;

    @Column(name = "can_approve_timesheets", nullable = false)
    public boolean canApproveTimesheets;


    public EmployeeDivisions() {
    }

    

    public EmployeeDivisions(Integer id, Integer employeeId, Integer divisionId, boolean canApproveTimesheets,
            Employees employee, Divisions division) {
        this.id = id;
        this.employee = employee;
        this.division = division;
        this.canApproveTimesheets = canApproveTimesheets;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "EmployeeDivisions [id=" + id + ", employee=" + employee + ", division=" + division
                + ", canApproveTimesheets=" + canApproveTimesheets + "]";
    }

    }

