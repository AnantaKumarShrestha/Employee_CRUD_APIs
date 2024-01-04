package com.intern.employeesCrudAPI.mapper;

import com.intern.employeesCrudAPI.dto.EmployeeDto;
import com.intern.employeesCrudAPI.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE= Mappers.getMapper(EmployeeMapper.class);

    Employee employeeDtoIntoEmployee(EmployeeDto employeeDto);

    EmployeeDto employeeIntoEmployeeDto(Employee employee);

    List<Employee> employeeDtoListIntoEmployeeList(List<EmployeeDto> employeeDtos);

    List<EmployeeDto> employeeListIntoEmployeeDtoList(List<Employee> employees);

}
