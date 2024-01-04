package com.intern.employeesCrudAPI.service.serviceImpl;

import com.intern.employeesCrudAPI.dto.EmployeeDto;
import com.intern.employeesCrudAPI.enums.Status;
import com.intern.employeesCrudAPI.mapper.EmployeeMapper;
import com.intern.employeesCrudAPI.model.Employee;
import com.intern.employeesCrudAPI.payload.ApiResponse;
import com.intern.employeesCrudAPI.repo.EmployeeRepo;
import com.intern.employeesCrudAPI.service.EmployeeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    private EmployeeRepo employeeRepo;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee=EmployeeMapper.INSTANCE.employeeDtoIntoEmployee(employeeDto);
        logger.info("Employee Dto converted into employee");
        Employee savedEmployee=employeeRepo.addEmployee(employee);
        logger.info("Employee is saved into database employee : {}",savedEmployee);
        return EmployeeMapper.INSTANCE.employeeIntoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(UUID id) {
        logger.info("Employee searching by id :{}",id);
        Employee employee=employeeRepo.getEmployeeId(id);
        logger.info("Employee found by id :{}",id);
        return EmployeeMapper.INSTANCE.employeeIntoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        logger.info("Getting all employee data");
        List<Employee> employees=employeeRepo.getEmployees();
        logger.info("All employees data are get");
        return EmployeeMapper.INSTANCE.employeeListIntoEmployeeDtoList(employees);
    }

    @Override
    public ApiResponse deleteEmployeeById(UUID id) {
        logger.info("Employee deleting");
        employeeRepo.deleteEmployee(id);
        logger.info("Employee deleted id :{}",id);
        return new ApiResponse("Employee Deleted Successfully", Status.SUCCESS);
    }

    @Override
    public EmployeeDto updateEmployee(UUID id,EmployeeDto employeeDto) {
        logger.info("Employee updating id : {},employee : {}",id,employeeDto);
        Employee employee=EmployeeMapper.INSTANCE.employeeDtoIntoEmployee(employeeDto);
        employee.setEmployeeId(id);
        Employee updatedEmployee=employeeRepo.updateEmployee(employee);
        logger.info("Employee updated id : {},employee : {}",id,employeeDto);
        return EmployeeMapper.INSTANCE.employeeIntoEmployeeDto(updatedEmployee);
    }
}
