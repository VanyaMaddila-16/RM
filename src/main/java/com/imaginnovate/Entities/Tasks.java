package com.imaginnovate.Entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Tasks extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, unique = true, length = 30)
    public String name;

    @Column(name = "description", nullable = false, length = 200)
    public String description;

    

    public Tasks() {
    }

    

    public Tasks(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

       @Override
    public String toString() {
        return "Tasks [id=" + id + ", name=" + name + ", description=" + description + "]";
    }

}
