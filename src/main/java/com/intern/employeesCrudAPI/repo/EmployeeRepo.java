package com.intern.employeesCrudAPI.repo;

import com.intern.employeesCrudAPI.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepo {

    Employee addEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee getEmployeeId(UUID id);

    void deleteEmployee(UUID id);

    Employee updateEmployee(Employee employee);

}
