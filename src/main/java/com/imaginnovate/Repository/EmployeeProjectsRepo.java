package com.imaginnovate.Repository;

import com.imaginnovate.Entities.EmployeeProjects;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeProjectsRepo implements PanacheRepositoryBase<EmployeeProjects,Integer> {

    
}
