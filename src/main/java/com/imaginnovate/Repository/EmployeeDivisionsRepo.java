package com.imaginnovate.Repository;

import com.imaginnovate.Entities.EmployeeDivisions;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeDivisionsRepo implements PanacheRepositoryBase<EmployeeDivisions,Integer>{
    
}
