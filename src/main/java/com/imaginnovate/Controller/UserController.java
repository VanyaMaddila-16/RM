package com.imaginnovate.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.imaginnovate.Dto.UsersDto;
import com.imaginnovate.Entities.Employees;
import com.imaginnovate.Entities.Users;
import com.imaginnovate.Repository.UsersRepo;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserController {

    @Inject 
    UsersRepo usersRepo;
    
    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UsersDto> all() {
        List<Users> users = Users.listAll();
        List<UsersDto> usersDtos = new ArrayList<>();
        for (Users u : users) {
            UsersDto dto = new UsersDto();
            dto.setId(u.getId());
            dto.setUsername(u.username);
            dto.setPassword(u.password);
            dto.setEmployeeId(u.employeeId.getId());
            dto.setResetToken(u.resetToken);
            dto.setResetTokenExpiresAt(u.resetTokenExpiresAt);
           
            usersDtos.add(dto);
        }
        return usersDtos;
    }

    @POST
     @Path("/add")
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     @Transactional
     public Response createUser(UsersDto usersDto) {
         Users users=new Users();
         users.setId(usersDto.getId());
         users.username=(usersDto.getUsername());
         users.password=(usersDto.getPassword());
         users.resetToken=(usersDto.getResetToken());
         users.resetTokenExpiresAt=(usersDto.getResetTokenExpiresAt());

         if (usersDto.getEmployeeId() != 0) {
            Optional<Employees> employeeOptional = Employees.findByIdOptional(usersDto.getEmployeeId());
            if (employeeOptional.isPresent()) {
                users.employeeId=(employeeOptional.get()); 
            } 

 
         usersRepo.persist(users);
 
       
     }
        return Response.status(Response.Status.CREATED).entity(usersDto).build();
    }
    
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsersDto getById(@PathParam("id") int id) {
        Users users=usersRepo.findById(id);
        if (users == null) {
            return null;
        }
        UsersDto dto = new UsersDto();
        dto.setId(users.getId());
        dto.setUsername(users.username);
        dto.setPassword(users.password);
        dto.setEmployeeId(users.employeeId.getId());
        dto.setResetToken(users.resetToken);
        dto.setResetTokenExpiresAt(users.resetTokenExpiresAt);
       
        return dto;
    }
    }

