package com.imaginnovate.Controller;

import java.util.ArrayList;
import java.util.List;

import com.imaginnovate.Dto.EmployeeDivisionsDto;
import com.imaginnovate.Entities.EmployeeDivisions;
import com.imaginnovate.Repository.DivisionsRepo;
import com.imaginnovate.Repository.EmployeeDivisionsRepo;
import com.imaginnovate.Repository.EmployeesRepo;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/employeeDivisions")
public class EmployeeDivisionController {

    @Inject
    EmployeeDivisionsRepo employeeDivisionsRepo;

    @Inject
    EmployeesRepo employeeRepo;
    
    @Inject
    DivisionsRepo divisionRepo;

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<EmployeeDivisions> employeeDivisions = EmployeeDivisions.listAll();
        List<EmployeeDivisionsDto> employeeDivisionsDtos = new ArrayList<>();
        for (EmployeeDivisions ed : employeeDivisions) {
            EmployeeDivisionsDto dto = new EmployeeDivisionsDto();
            dto.setId(ed.getId());
            dto.setEmployeeId(ed.employee.getId());
            dto.setDivisionId(ed.division.getId());
            dto.setCanApproveTimesheets(ed.canApproveTimesheets);

            employeeDivisionsDtos.add(dto);
        }
        return Response.ok(employeeDivisionsDtos).build();
    }


    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        EmployeeDivisions ed = employeeDivisionsRepo.findById(id);
        if (ed == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("EmployeeDivision not found for ID: " + id)
                           .build();
        }
        EmployeeDivisionsDto dto = new EmployeeDivisionsDto();
        dto.setId(ed.getId());
        dto.setEmployeeId(ed.employee.getId());
        dto.setDivisionId(ed.division.getId());
        dto.setCanApproveTimesheets(ed.canApproveTimesheets);

        return Response.ok(dto).build();
    }



    
}
