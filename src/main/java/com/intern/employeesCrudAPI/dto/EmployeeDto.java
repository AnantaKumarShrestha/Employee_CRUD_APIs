package com.intern.employeesCrudAPI.dto;

import com.intern.employeesCrudAPI.model.Address;
import lombok.Data;

import java.util.UUID;

@Data
public class EmployeeDto {
    private UUID employeeId;
    private String fullName;
    private String department;
    private String position;
    private double salary;
    private Address address;
}
