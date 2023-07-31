package com.example.employeeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repo.EmployeeRepo;
import com.example.employeeservice.response.EmployeeResponse;
import com.example.employeeservice.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable int id) {
		EmployeeResponse employeeByid = empService.getEmployeeByid(id);
		return ResponseEntity.status(HttpStatus.OK).body(employeeByid);
	}

}
