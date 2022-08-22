package com.sample.Sample_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.Sample_Project.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
