package com.intern.employeesCrudAPI.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@NamedQuery(name = "Employee.findAll",query = "select e from Employee e")
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID employeeId;
    private String fullName;
    private String department;
    private String position;
    private double salary;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


}
