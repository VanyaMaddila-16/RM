package com.imaginnovate.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.imaginnovate.Dto.ProjectDto;
import com.imaginnovate.Entities.Divisions;
import com.imaginnovate.Entities.Projects;
import com.imaginnovate.Repository.DivisionsRepo;
import com.imaginnovate.Repository.ProjectsRepo;

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

@Path("/projects")
public class ProjectController {
    @Inject
    ProjectsRepo projectsRepo;

    @Inject
    private DivisionsRepo divisionRepo;

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectDto> all() {
        List<Projects> projects = Projects.listAll();
        List<ProjectDto> projectDtos = new ArrayList<>();
        for (Projects p : projects) {
            ProjectDto dto = new ProjectDto();
            dto.setId(p.getId());
            dto.setName(p.name);
            dto.setDescription(p.description);
            if(p.division !=null){
            dto.setDivision(p.division.getId());
            }
           
            projectDtos.add(dto);
        }
        return projectDtos;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createProject(ProjectDto projectDto) {
        Projects projects = new Projects();
        projects.setId(projectDto.getId()); 
        projects.name = projectDto.getName();
        projects.description=projectDto.getDescription();

        if (projectDto.getDivision() != 0) {
            Optional<Divisions> dOptional = divisionRepo.findByIdOptional(projectDto.getDivision());
            if (dOptional.isPresent()) {
                projects.division=(dOptional.get());
            }
        }

        
        projectsRepo.persist(projects); 
        return Response.status(Response.Status.CREATED).entity(projectDto).build();
    }


     @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProjectDto getById(@PathParam("id") int id) {
        Projects projects = projectsRepo.findById(id);
        if (projects == null) {
            return null;
        }
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(projects.getId()); 
        projectDto.setName(projects.name);
        projectDto.setDescription(projects.description);
        if(projects.division !=null){
            projectDto.setDivision(projects.division.getId());
            }
        return projectDto;
    }
    }

