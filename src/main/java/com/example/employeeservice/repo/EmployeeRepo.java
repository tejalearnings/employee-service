package com.example.employeeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeeservice.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
