package com.sample.Sample_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.Sample_Project.entity.Employee;
import com.sample.Sample_Project.repository.EmpRepo;


@Service
public class EmpService {
	@Autowired
	private EmpRepo empRepo;
	public List<Employee> retriveAllEmp(){

		return empRepo.findAll();
	}
	
	public Employee createEmployee(Employee employee) {
		return empRepo.save(employee);
	}

}
