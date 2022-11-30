package com.academia.payment.dao;

import com.academia.payment.bean.EmployeeSalary;

import java.util.List;


public interface EmployeeSalaryDAO {
    List<EmployeeSalary> getSalary(Integer empId);
    void createSalary(EmployeeSalary employeeSalary);
     Boolean paySalary(Integer sId);
     //    Boolean payBill(Integer billId);
}

