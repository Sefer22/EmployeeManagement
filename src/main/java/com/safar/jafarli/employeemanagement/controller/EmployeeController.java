package com.safar.jafarli.employeemanagement.controller;

import com.safar.jafarli.employeemanagement.entity.Employee;
import com.safar.jafarli.employeemanagement.service.impl.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    @PostMapping("/new")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee),HttpStatus.CREATED);
    }
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long employeeId) {
        return new ResponseEntity<>(employeeService.findEmployeeById(employeeId),HttpStatus.OK);
    }
    @PutMapping("/edit/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId,@RequestBody Employee newEmployee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeId,newEmployee),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{employeeId}")
    public void removeEmployee(@PathVariable Long employeeId) {
        employeeService.removeEmployee(employeeId);
    }
}
