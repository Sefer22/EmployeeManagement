package com.safar.jafarli.employeemanagement.controller;

import com.safar.jafarli.employeemanagement.entity.Employee;
import com.safar.jafarli.employeemanagement.service.impl.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
}
