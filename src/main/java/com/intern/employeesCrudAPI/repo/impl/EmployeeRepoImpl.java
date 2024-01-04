package com.intern.employeesCrudAPI.repo.impl;

import com.intern.employeesCrudAPI.exception.ResourceNotFoundException;
import com.intern.employeesCrudAPI.model.Employee;
import com.intern.employeesCrudAPI.repo.EmployeeRepo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Stateless
public class EmployeeRepoImpl implements EmployeeRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee addEmployee(Employee employee) {
       entityManager.persist(employee);
       return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        return entityManager.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }

    @Override
    public Employee getEmployeeId(UUID id) {
        return Optional.ofNullable(entityManager.find(Employee.class, id)).orElseThrow(()->new ResourceNotFoundException("Employee NOt Found ID : "+ id));
    }

    @Override
    public void deleteEmployee(UUID id) {
        Employee employee = Optional.ofNullable(entityManager.find(Employee.class, id)).orElseThrow(()->new ResourceNotFoundException("Employee NOt Found ID : "+ id));
            entityManager.remove(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
      Optional.ofNullable(entityManager.find(Employee.class, employee.getEmployeeId())).orElseThrow(()->new ResourceNotFoundException("Employee Not Found "+employee.getEmployeeId()));
        return entityManager.merge(employee);
    }
}
