package com.imaginnovate.Controller;

import java.util.ArrayList;
import java.util.List;

import com.imaginnovate.Dto.TimesheetDto;
import com.imaginnovate.Entities.Timesheets;
import com.imaginnovate.Repository.TimesheetRepo;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Timesheet")
public class TimesheetController {

    @Inject
    TimesheetRepo timesheetRepo;

    
   @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TimesheetDto> all(){

    List<Timesheets> timesheets =timesheetRepo.listAll();
       
    List<TimesheetDto> timesheetDtos=new ArrayList<>();
    for(Timesheets d:timesheets){
     TimesheetDto fhd= new TimesheetDto();
     fhd.setId(d.getId());
     fhd.setEmployeeProject(d.getEmployeeProject().getId());
     fhd.setProjectTask(d.getProjectTask().getId());
     fhd.setDescription(d.getDescription());
     fhd.setHoursWorked(d.getHoursWorked());
     fhd.setSubmittedBy(d.getSubmittedBy().getId());
     fhd.setSubmittedOn(d.getSubmittedOn());
     fhd.setStatus(d.getStatus().getId());
     if (d.getApprovedBy() != null){
     fhd.setApprovedBy(d.getApprovedBy().getId());
     }
     
     timesheetDtos.add(fhd);

    }
    return timesheetDtos;

}


    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        Timesheets d = timesheetRepo.findById(id);
        if (d == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        TimesheetDto fhd = new TimesheetDto();
        fhd.setId(d.getId());
        fhd.setEmployeeProject(d.getEmployeeProject().getId());
        fhd.setProjectTask(d.getProjectTask().getId());
        fhd.setDescription(d.getDescription());
        fhd.setHoursWorked(d.getHoursWorked());
        fhd.setSubmittedBy(d.getSubmittedBy().getId());
        fhd.setSubmittedOn(d.getSubmittedOn());
        fhd.setStatus(d.getStatus().getId());
        if (d.getApprovedBy() != null) {
            fhd.setApprovedBy(d.getApprovedBy().getId());
        }
        return Response.ok(fhd).build();
    }
}