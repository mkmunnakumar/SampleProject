package com.sample.Sample_Project;

import com.sample.Sample_Project.entity.Employee;
import com.sample.Sample_Project.repository.EmpRepo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepoTests {

    @Autowired
    private EmpRepo empRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void addEmpTest(){
        Employee employee = new Employee(1,"Munna Kumar","Doctor");

        empRepo.save(employee);
        assertThat(employee.getEid()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getEmpTest(){
        Employee employee = empRepo.findById(1).get();
        assertThat(employee.getEid()).isEqualTo(1);
    }
    @Test
    @Order(3)
    public void getAllEmpTest(){
        List<Employee> employee = empRepo.findAll();
        assertThat(employee.size()).isGreaterThan(0);
}
}
