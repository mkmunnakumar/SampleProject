package com.sample.Sample_Project.service;

import com.sample.Sample_Project.SampleProjectApplication;
import com.sample.Sample_Project.entity.Employee;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;


@SpringBootTest(classes = SampleProjectApplication.class)
class EmpServiceTest {
    @Autowired
    @MockBean
    private EmpService empService;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void addEmpTest(){
        Employee employee = getEmployee();
        empService.createEmployee(employee);
        assertThat(employee.getEid()).isGreaterThan(0);
    }
    @Test
    @Order(2)
    public void getEmployeeByIdTest() throws Exception{
        Employee employee = getEmployee();
        given(empService.getEmployeeById(1)).willReturn(employee);
        Employee result = empService.getEmployeeById(1);
        assertEquals(result.getEid(),1);
    }

    @Test
    @Order(3)
    public void getAllEmpTest() throws Exception{
        Employee employee = getEmployee();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        given(empService.retriveAllEmp()).willReturn(employees);
        List<Employee> result = empService.retriveAllEmp();
        assertEquals(result.size(), 1);
    }

    private Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEid(1);
        employee.setEname("Prakash");
        employee.setPosition("Doctor");
        return employee;
    }
}