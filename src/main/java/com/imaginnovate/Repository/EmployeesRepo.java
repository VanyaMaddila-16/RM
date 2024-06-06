package com.imaginnovate.Repository;

import com.imaginnovate.Entities.Employees;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeesRepo implements PanacheRepositoryBase<Employees,Integer> {
    
}
