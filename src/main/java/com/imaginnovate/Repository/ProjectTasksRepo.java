package com.imaginnovate.Repository;

import com.imaginnovate.Entities.ProjectTasks;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProjectTasksRepo implements PanacheRepositoryBase<ProjectTasks,Integer> {
    
}
