package com.sample.Sample_Project.controller;

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

@SpringBootTest(classes = SampleProjectApplication.class)
class EmpControllerTest {

    @Autowired
    @MockBean
    private EmpController empController;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void addEmpTest(){
        Employee employee = getEmployee();
        empController.addEmp(employee);
        assertThat(employee.getEid()).isGreaterThan(0);
    }

    @Test
    void getEmpByIdTest() {
        Employee employees = getEmployee();
        given(empController.getEmployeeById(1)).willReturn(employees);
        Employee result = empController.getEmployeeById(1);
        assertEquals(result.getEid(),1);
    }

    @Test
    void getAllEmpTest() {
        Employee employee = getEmployee();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        given(empController.getEmployees()).willReturn(employees);
        List<Employee> result = empController.getEmployees();
        assertEquals(result.size(), 1);
    }

    private Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEid(1);
        employee.setEname("Ruchi Singh");
        employee.setPosition("Doctor");
        return employee;
    }
}