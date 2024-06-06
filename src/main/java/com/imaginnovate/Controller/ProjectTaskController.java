package com.imaginnovate.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.imaginnovate.Dto.ProjectTasksDto;
import com.imaginnovate.Entities.ProjectTasks;
import com.imaginnovate.Entities.Projects;
import com.imaginnovate.Entities.Tasks;
import com.imaginnovate.Repository.ProjectTasksRepo;

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

@Path("/project-task")
public class ProjectTaskController {
    
    @Inject
    ProjectTasksRepo projectTasksRepo;

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectTasksDto> all() {
        List<ProjectTasks> projectsTasks = ProjectTasks.listAll();
        List<ProjectTasksDto> projecttask = new ArrayList<>();
        for (ProjectTasks p : projectsTasks) {
            ProjectTasksDto dto = new ProjectTasksDto();
            dto.setId(p.getId());
            dto.setProject(p.project.getId());
            dto.setTask(p.task.getId());
            
           
            projecttask.add(dto);
        }
        return projecttask;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createProjectTask(ProjectTasksDto projectTasksDto) {
        ProjectTasks projectTasks = new ProjectTasks();

        projectTasks.setId(projectTasksDto.getId()); 
        if (projectTasksDto.getProject() != 0) {
            Optional<Projects> projectOptional = Projects.findByIdOptional(projectTasksDto.getProject());
            if (projectOptional.isPresent()) {
                projectTasks.project = projectOptional.get();
            }
        }

        if (projectTasksDto.getTask() != 0) {
            Optional<Tasks> projectOptional = Tasks.findByIdOptional(projectTasksDto.getTask());
            if (projectOptional.isPresent()) {
                projectTasks.task = projectOptional.get();
            }
        }
        
        

        projectTasksRepo.persist(projectTasks); 
        return Response.status(Response.Status.CREATED).entity(projectTasksDto).build();
    }


    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProjectTasksDto getById(@PathParam("id") int id) {
        ProjectTasks projectTasks = projectTasksRepo.findById(id);
        if (projectTasks == null) {
            return null;
        }
        ProjectTasksDto dto = new ProjectTasksDto();
        dto.setId(projectTasks.getId()); 
        dto.setProject(projectTasks.project.getId());
        dto.setTask(projectTasks.task.getId());
        
        return dto;
    }
    }

