package com.academia.payment.dao;

import com.academia.payment.bean.Employee;

public interface EmployeeDAO {
    Employee login(Employee employee);
    void createEmployee(Employee employee);
}
