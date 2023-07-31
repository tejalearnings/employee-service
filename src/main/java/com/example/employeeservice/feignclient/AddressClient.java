package com.example.employeeservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employeeservice.response.AddressResponse;

 
@FeignClient(name = "address-service", url="http://localhost:8081",path="/address-app/api/")
public interface AddressClient {
	
	@GetMapping("address/{id}")
	AddressResponse getAddressByEmpId(@PathVariable("id") int id);
		
		
	

}
