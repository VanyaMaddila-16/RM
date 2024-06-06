package com.imaginnovate.Controller;

import java.util.List;

import com.imaginnovate.Dto.TaskDto;
import com.imaginnovate.Entities.Tasks;
import com.imaginnovate.Repository.TasksRepo;

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

@Path("/tasks")
public class TaskController {
    @Inject
    TasksRepo tasksRepo;

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tasks> all() {
        List<Tasks> tasks = Tasks.listAll();
        return tasks; 
     }
        
     @POST
     @Path("/add")
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     @Transactional
     public Response createTask(TaskDto taskDto) {
         Tasks tasks = new Tasks();
         tasks.setId(taskDto.getId());
         tasks.name=(taskDto.getName());
         tasks.description=(taskDto.getDescription());
 
         tasksRepo.persist(tasks);
 
         return Response.status(Response.Status.CREATED).entity(taskDto).build();
     }


    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tasks getById(@PathParam("id") int id) {
        Tasks tasks = tasksRepo.findById(id);
        return tasks;
    }
    }
    

