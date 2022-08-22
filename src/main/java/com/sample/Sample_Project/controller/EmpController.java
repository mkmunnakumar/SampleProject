package com.sample.Sample_Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.Sample_Project.entity.Employee;
import com.sample.Sample_Project.service.EmpService;

@RestController
public class EmpController {
	@Autowired
	private EmpService service;
	
	@GetMapping("/emp")
	public List<Employee> getEmployees(){

		return service.retriveAllEmp();
	}
	
	@PostMapping("/addEmp")
	public Employee addEmp(@RequestBody Employee employee) {
		return service.createEmployee(employee);
	}

}
