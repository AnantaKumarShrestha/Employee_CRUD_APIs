package com.intern.employeesCrudAPI.restcontroller;

import com.intern.employeesCrudAPI.dto.EmployeeDto;
import com.intern.employeesCrudAPI.model.Employee;
import com.intern.employeesCrudAPI.payload.ApiResponse;
import com.intern.employeesCrudAPI.repo.EmployeeRepo;
import com.intern.employeesCrudAPI.service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@Path("/employees")
public class EmployeeRestController {


    @Inject
    private EmployeeService employeeService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeDto addEmployee(EmployeeDto employeeDto){
        return employeeService.addEmployee(employeeDto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeDto> getEmployees(){
      return   employeeService.getEmployees();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeDto getEmployeeById(@PathParam("id")UUID id){
        return employeeService.getEmployeeById(id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse delete(@PathParam("id") UUID id){
       return employeeService.deleteEmployeeById(id);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeDto updateEmployee(@PathParam("id") UUID id,EmployeeDto employeeDto){
       return employeeService.updateEmployee(id,employeeDto);
    }


}
