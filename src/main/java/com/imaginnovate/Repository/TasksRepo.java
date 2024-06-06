package com.imaginnovate.Repository;

import com.imaginnovate.Entities.Tasks;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class TasksRepo implements PanacheRepositoryBase<Tasks,Integer> {

}