package com.imaginnovate.Repository;

import com.imaginnovate.Entities.Users;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsersRepo implements PanacheRepositoryBase<Users,Integer>{
    
}
