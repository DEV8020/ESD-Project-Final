package com.academia.payment.service;

import com.academia.payment.bean.Employee;
import com.academia.payment.dao.impl.EmployeeSelectDAOImpl;

import java.util.List;

public class EmployeeSelectService {
    EmployeeSelectDAOImpl employeeSelectDAO = new EmployeeSelectDAOImpl();

//    public List<Bill> getBills(Integer s_id){
//        List<Bill> billList = billDAO.getBills(s_id);
//
//        // Removing student attribute from returned list to kill cyclic references
//        for (Bill bill: billList)
//            bill.setStudent(null);

    public List<Employee> getEmployee(Integer empId){
        List<Employee> employeeSelectList = employeeSelectDAO.getEmployee(empId);

        // Removing student attribute from returned list to kill cyclic references
        for (Employee employeeSelect: employeeSelectList)
            employeeSelect.setEmployee(null);

        return employeeSelectList;}
}
