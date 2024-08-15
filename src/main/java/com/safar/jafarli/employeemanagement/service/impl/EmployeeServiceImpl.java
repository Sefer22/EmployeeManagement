package com.safar.jafarli.employeemanagement.service.impl;

import com.safar.jafarli.employeemanagement.entity.Employee;
import com.safar.jafarli.employeemanagement.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    public Employee updateEmployee(Long employeeId, Employee newEmployee) {
        Optional<Employee> foundedEmployee = employeeRepository.findById(employeeId);
        if(foundedEmployee.isPresent()) {
            Employee updateEmployee = foundedEmployee.get();
            updateEmployee.setId(newEmployee.getId());
            updateEmployee.setFirstName(newEmployee.getFirstName());
            updateEmployee.setLastName(newEmployee.getLastName());
            updateEmployee.setEmail(newEmployee.getEmail());

            return employeeRepository.save(updateEmployee);
        }
        return null;
    }

    public void removeEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
