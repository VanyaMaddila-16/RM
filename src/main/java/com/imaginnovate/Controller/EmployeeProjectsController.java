package com.imaginnovate.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.imaginnovate.Dto.EmployeeProjectsDto;
import com.imaginnovate.Entities.EmployeeProjects;
import com.imaginnovate.Entities.Employees;
import com.imaginnovate.Entities.Projects;
import com.imaginnovate.Repository.EmployeeProjectsRepo;

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

@Path("/employee-projects")
public class EmployeeProjectsController {
    @Inject
    EmployeeProjectsRepo employeeProjectsRepo;

     @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeProjectsDto> all() {
        List<EmployeeProjects> employeeProjects = EmployeeProjects.listAll();
        List<EmployeeProjectsDto> employeeProjectsDtos = new ArrayList<>();
        for (EmployeeProjects ep : employeeProjects) {
            EmployeeProjectsDto dto = new EmployeeProjectsDto();
            dto.setId(ep.getId());
            dto.setEmployee(ep.employee.getId());
            dto.setProject(ep.project.getId());
            dto.setCanApproveTimesheets(ep.canApproveTimesheets);
           
            employeeProjectsDtos.add(dto);
        }
        return employeeProjectsDtos;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createEmployeeProjects(EmployeeProjectsDto employeeProjectsDto) {
        EmployeeProjects employeeProjects = new EmployeeProjects();

        employeeProjects.setId(employeeProjectsDto.getId()); 
        if (employeeProjectsDto.getEmployee() != 0) {
            Optional<Employees> projectOptional = Employees.findByIdOptional(employeeProjectsDto.getEmployee());
            if (projectOptional.isPresent()) {
                employeeProjects.employee = projectOptional.get();
            }
        }

        if (employeeProjectsDto.getProject() != 0) {
            Optional<Projects> projectOptional = Projects.findByIdOptional(employeeProjectsDto.getProject());
            if (projectOptional.isPresent()) {
                employeeProjects.project = projectOptional.get();
            }
        }
        employeeProjects.canApproveTimesheets=employeeProjectsDto.getCanApproveTimesheets();
        
        

        employeeProjectsRepo.persist(employeeProjects); 
        return Response.status(Response.Status.CREATED).entity(employeeProjectsDto).build();
    }

     @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        EmployeeProjects ep = employeeProjectsRepo.findById(id);
        if (ep == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Employee project not found for ID: " + id)
                           .build();
        }
        EmployeeProjectsDto dto = new EmployeeProjectsDto();
        dto.setId(ep.getId());
        dto.setEmployee(ep.employee.getId());
        dto.setProject(ep.project.getId());
        dto.setCanApproveTimesheets(ep.canApproveTimesheets);

        return Response.ok(dto).build();
    }
    
}
