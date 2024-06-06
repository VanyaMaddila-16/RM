package com.imaginnovate.Repository;

import com.imaginnovate.Entities.Projects;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ProjectsRepo implements PanacheRepositoryBase<Projects,Integer> {

}