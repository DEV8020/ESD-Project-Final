package com.academia.payment.service;

import com.academia.payment.bean.Employee;
import com.academia.payment.dao.impl.EmployeeDAOImpl;

public class EmployeeService {

    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

    public Employee login(Employee employee){
        Employee loggedInEmployee = employeeDAO.login(employee);

        // If no login happens, then return null
        if (loggedInEmployee == null)
            return null;

        // Setting billList to null to avoid cyclic dependency issues
        loggedInEmployee.setSalaryList(null);

        return loggedInEmployee;
    }

}
