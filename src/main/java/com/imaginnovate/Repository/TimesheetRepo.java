package com.imaginnovate.Repository;

import com.imaginnovate.Entities.Timesheets;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TimesheetRepo implements PanacheRepositoryBase<Timesheets,Integer> {
    
}
