package com.example.employeeservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.feignclient.AddressClient;
import com.example.employeeservice.repo.EmployeeRepo;
import com.example.employeeservice.response.AddressResponse;
import com.example.employeeservice.response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AddressClient addressClient;

	
	public EmployeeResponse getEmployeeByid(int idd) {
		
		Employee employee = empRepo.findById(idd).get();
		EmployeeResponse er = modelMapper.map(employee, EmployeeResponse.class);
			
		AddressResponse addressResponse = addressClient.getAddressByEmpId(idd);
		er.setAddressResponse(addressResponse);
 
		
		return er;

	}

}
