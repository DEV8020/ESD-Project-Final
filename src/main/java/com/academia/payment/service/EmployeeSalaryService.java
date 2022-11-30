package com.academia.payment.service;

import com.academia.payment.bean.EmployeeSalary;
import com.academia.payment.dao.impl.EmployeeSalaryDAOImpl;

import java.util.List;

public class EmployeeSalaryService {

    EmployeeSalaryDAOImpl salaryDAO = new EmployeeSalaryDAOImpl();

//    public List<Bill> getBills(Integer s_id){
//        List<Bill> billList = billDAO.getBills(s_id);
//
//        // Removing student attribute from returned list to kill cyclic references
//        for (Bill bill: billList)
//            bill.setStudent(null);

        public List<EmployeeSalary> getSalary(Integer empId){
        List<EmployeeSalary> salaryList = salaryDAO.getSalary(empId);

        // Removing student attribute from returned list to kill cyclic references
        for (EmployeeSalary employeeSalary: salaryList)
            employeeSalary.setEmployee(null);

        return salaryList;}
        public Boolean paySalary(Integer sId) {
            return salaryDAO.paySalary(sId);
        }
//    public Boolean payBill(Integer billId) {
//        return billDAO.payBill(billId);
//    }
}
