package com.imaginnovate.Entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "project_tasks",uniqueConstraints = {
    @UniqueConstraint(columnNames = {"project_id", "task_id"})
})
public class ProjectTasks extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
   public Projects project;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    public Tasks task;


    public ProjectTasks() {
    }

    

    public ProjectTasks(int id, Projects project, Tasks task) {
        this.id = id;
        this.project = project;
        this.task = task;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    @Override
    public String toString() {
        return "ProjectTasks [id=" + id + ", project=" + project + ", task=" + task + "]";
    }
    
}
