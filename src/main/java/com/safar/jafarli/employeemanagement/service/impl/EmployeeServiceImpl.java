package com.safar.jafarli.employeemanagement.service.impl;

import com.safar.jafarli.employeemanagement.entity.Employee;
import com.safar.jafarli.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
