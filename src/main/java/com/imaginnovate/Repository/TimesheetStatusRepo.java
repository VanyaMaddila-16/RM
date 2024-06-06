package com.imaginnovate.Repository;

import com.imaginnovate.Entities.TimesheetStatus;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TimesheetStatusRepo implements PanacheRepositoryBase<TimesheetStatus,Integer>{
    
}
