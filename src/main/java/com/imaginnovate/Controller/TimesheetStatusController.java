package com.imaginnovate.Controller;

import java.util.List;

import com.imaginnovate.Entities.TimesheetStatus;
import com.imaginnovate.Repository.TimesheetStatusRepo;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/timesheetstatus")
public class TimesheetStatusController {
    @Inject
    TimesheetStatusRepo timesheetStatusRepo;
     @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TimesheetStatus> all() {
        List<TimesheetStatus> timesheetStatus = TimesheetStatus.listAll();
        return timesheetStatus; 
     }
    
     
   

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TimesheetStatus getById(@PathParam("id") int id) {
       TimesheetStatus timesheetStatus = timesheetStatusRepo.findById(id);
        return timesheetStatus;
    }
}
