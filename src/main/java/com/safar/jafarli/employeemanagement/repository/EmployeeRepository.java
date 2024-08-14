package com.safar.jafarli.employeemanagement.repository;

import com.safar.jafarli.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
