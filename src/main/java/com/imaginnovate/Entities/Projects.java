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

@Entity
@Table(name = "projects")
public class Projects extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, unique = true, length = 50)
     public String name;

    @Column(name = "description", length = 200)
    public String description;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    public Divisions division;

    

    public Projects() {
    }

    

    public Projects(int id, String name, String description, Divisions division) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.division = division;
    }



    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        return "Projects [id=" + id + ", name=" + name + ", description=" + description + ", division=" + division
                + "]";
    }

    
}
