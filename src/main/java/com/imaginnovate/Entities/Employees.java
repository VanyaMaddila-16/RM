package com.imaginnovate.Entities;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employees extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    @Column(name = "first_name", nullable = false, length = 40)
    public String firstName;

    @Column(name = "last_name", nullable = false, length = 40)
    public String lastName;

    @Column(name = "gender", nullable = false, length = 1)
    public char gender;

    @Column(name = "email", nullable = false, length = 60)
    public String email;

    @Column(name = "designation", nullable = false, length = 30)
    public String designation;

    @Column(name = "start_date", nullable = false)
    public LocalDate startDate;

    @Column(name = "end_date")
    public LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    public Divisions division;

    @ManyToOne
    @JoinColumn(name = "reports_to")
    public Employees reports_to;

    

    public Employees() {
    }

    public Employees(int id, String firstName, String lastName, char gender, String email, String designation,
            LocalDate startDate, LocalDate endDate, Divisions division, Employees reports_to) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.designation = designation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.division = division;
        this.reports_to = reports_to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        return "Employees [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
                + ", email=" + email + ", designation=" + designation 
                + ", startDate=" + startDate + ", endDate=" + endDate + ", division=" + division + ", reports_to="
                + reports_to + "]";
    }
  
}


