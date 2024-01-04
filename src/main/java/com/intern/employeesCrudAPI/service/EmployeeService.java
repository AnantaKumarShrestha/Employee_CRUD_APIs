package com.intern.employeesCrudAPI.service;

import com.intern.employeesCrudAPI.dto.EmployeeDto;
import com.intern.employeesCrudAPI.model.Employee;
import com.intern.employeesCrudAPI.payload.ApiResponse;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    EmployeeDto addEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(UUID id);

    List<EmployeeDto> getEmployees();

    ApiResponse deleteEmployeeById(UUID id);

    EmployeeDto updateEmployee(UUID id,EmployeeDto employeeDto);

}
