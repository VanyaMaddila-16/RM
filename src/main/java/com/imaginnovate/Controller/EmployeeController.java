package com.imaginnovate.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.imaginnovate.Dto.EmployeeDto;
import com.imaginnovate.Entities.Divisions;
import com.imaginnovate.Entities.Employees;
import com.imaginnovate.Repository.DivisionsRepo;
import com.imaginnovate.Repository.EmployeesRepo;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeController {

    @Inject
    EmployeesRepo employeesRepository;

    @Inject
    DivisionsRepo divisionsRepo;

   @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeDto> all() {
        List<Employees> employees = Employees.listAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employees e : employees) {
            EmployeeDto dto = new EmployeeDto();
            dto.setId(e.getId()); 
            dto.setFirstName(e.firstName);
            dto.setLastName(e.lastName);
            dto.setGender(e.gender);
            dto.setEmail(e.email);
            dto.setDesignation(e.designation);
            dto.setStartDate(e.startDate);
            dto.setEndDate(e.endDate);
            dto.setDivisionId(e.division.getId());
            if (e.reports_to != null) {
            dto.setReportsToId(e.reports_to.getId());
            }
           
            employeeDtos.add(dto);
        }
        return employeeDtos;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Employees addEmployee(EmployeeDto employeeDto) {
        Employees employees = new Employees();
        employees.setId(employeeDto.getId());
        employees.firstName=(employeeDto.getFirstName());
        employees.lastName=(employeeDto.getLastName());
        employees.email=(employeeDto.getEmail());
        employees.gender=(employeeDto.getGender());
        employees.designation=(employeeDto.getDesignation());
        employees.startDate=(employeeDto.getStartDate());
        employees.endDate=(employeeDto.getEndDate());
    
        if (employeeDto.getDivisionId() != 0) {
            Divisions division = Divisions.findById(employeeDto.getDivisionId());
            if (division != null) {
                employees.division=(division);
            } else {
                throw new IllegalArgumentException("Division with ID " + employeeDto.getDivisionId() + " not found");
            }
        }
    
        if (employeeDto.getReportsToId() != 0) {
            Optional<Employees> reportsToOptional = Employees.findByIdOptional(employeeDto.getReportsToId());
            if (reportsToOptional.isPresent()) {
                employees.reports_to=(reportsToOptional.get());
            } else {
                throw new IllegalArgumentException("Employee with ID " + employeeDto.getReportsToId() + " not found");
            }
        }
    
        employees.persist();
        return employees;
    }
    
  
        
     @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeDto getById(@PathParam("id") int id) {
        Employees employees = employeesRepository.findById(id);
        if (employees == null) {
            return null;
        }
        EmployeeDto dto = new EmployeeDto();
       dto.setId(employees.getId()); 
        dto.setFirstName(employees.firstName);
        dto.setLastName(employees.lastName);
        dto.setGender(employees.gender);
        dto.setEmail(employees.email);
        dto.setDesignation(employees.designation);
        dto.setStartDate(employees.startDate);
        dto.setEndDate(employees.endDate);
        dto.setDivisionId(employees.division.getId());
        if (employees.reports_to != null) {
        dto.setReportsToId(employees.reports_to.getId());
        }
        return dto;
    }
    }

