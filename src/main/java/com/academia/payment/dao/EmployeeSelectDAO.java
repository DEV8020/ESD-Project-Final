package com.academia.payment.dao;

import com.academia.payment.bean.Employee;

import java.util.List;

public interface EmployeeSelectDAO {
    List<Employee> getEmployee(Integer empId);
    void createEmployee(Employee employee);
}
