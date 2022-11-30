package com.academia.payment.util;

import com.academia.payment.bean.Accounts;
import com.academia.payment.dao.AccountsDAO;
import com.academia.payment.bean.Employee;
import com.academia.payment.bean.EmployeeSalary;
import com.academia.payment.dao.EmployeeSalaryDAO;
import com.academia.payment.dao.EmployeeDAO;
import com.academia.payment.dao.impl.AccountsDAOImpl;
import com.academia.payment.dao.impl.EmployeeSalaryDAOImpl;
import com.academia.payment.dao.impl.EmployeeDAOImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Script that initializes the database with dummy entries for all tables
*/
public class InitDB {
    public static void main(String[] args) {

        List<List<String>> accountsdata = Arrays.asList(
                Arrays.asList("jasvin.james@iiitb.ac.in","1234"),
                Arrays.asList("monit.thakkar@iiitb.ac.in", "1234")

        );
        List<List<String>> employees = Arrays.asList(
                Arrays.asList("Jasvin", "James", "jasvin.james@iiitb.ac.in","title","photo", "1234","account"),
                Arrays.asList("Monit", "Thakkar", "monit.thakkar@iiitb.ac.in","title","photo", "1234","faculty"),
                Arrays.asList("Ashutosh", "Soni", "ashutosh.soni@iiitb.ac.in","title","photo", "1234","faculty"),
                Arrays.asList("Sarika", "Vadodariya", "sarika.Vadodariya@iiitb.ac.in", "title","photo","1234","admin"),
                Arrays.asList("Niraj", "Gujarathi", "niraj.gujarathi@iiitb.ac.in","title","photo", "1234","account")
        );

        List<List<Object>> employeeSalaries = Arrays.asList(
                Arrays.asList("Yearly Fees", 69000, "2021-12-23",1),
                Arrays.asList("Caution Deposit", 69000, "2021-12-23",2),
                Arrays.asList("Miscellaneous Fees", 69000, "2021-12-23",3),

                Arrays.asList("Yearly Fees", 420000, "2021-12-23",4),
                Arrays.asList("Caution Deposit", 69000, "2021-12-23",5),
                Arrays.asList("Miscellaneous Fees", 69000, "2021-12-23",6),

                Arrays.asList("Yearly Fees", 420000, "2021-12-23",7),
                Arrays.asList("Caution Deposit", 69000, "2021-12-23",8),
                Arrays.asList("Miscellaneous Fees", 69000, "2021-12-23",9),

                Arrays.asList("Yearly Fees", 420000, "2021-12-23",10),
                Arrays.asList("Caution Deposit", 69000, "2021-12-23",11),
                Arrays.asList("Miscellaneous Fees", 69000, "2021-12-23",12),

                Arrays.asList("Yearly Fees", 420000, "2021-12-23",13),
                Arrays.asList("Caution Deposit", 69000, "2021-12-23",14),
                Arrays.asList("Miscellaneous Fees", 69000, "2021-12-23",15)
        );

        AccountsDAO accountsDAO =new AccountsDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        EmployeeSalaryDAO employeeSalaryDAO = new EmployeeSalaryDAOImpl();


        List<EmployeeSalary> salaryList = new ArrayList<>();
        for (int i=0; i<accountsdata.size(); i++) {
            List<String> accounts = accountsdata.get(i);
            Accounts accountsObj = new Accounts(accounts.get(0), accounts.get(1));
            accountsDAO.createAccounts(accountsObj);
        }

        for (List<Object> employeeSalary: employeeSalaries) {
            EmployeeSalary salaryObj = new EmployeeSalary((String) employeeSalary.get(0),(Integer) employeeSalary.get(1), (String) employeeSalary.get(2),(Integer) employeeSalary.get(3));
            //Integer sId, Employee employee, Integer ammount,String payment_date,  String description
            salaryList.add(salaryObj);
        }

        for (int i=0; i<employees.size(); i++) {
            List<String> employee = employees.get(i);
            Employee employeeObj = new Employee(employee.get(0),employee.get(1),employee.get(2),employee.get(3),employee.get(4),employee.get(5),employee.get(6));
            //0 Integer empId, 1 String first_name,2 String last_name,3 String email,4 String title,5 String photograph_path,6 String password,7 Department department,8 List<EmployeeSalary> salaryList

            // Set employees of employeeSalaries
            salaryList.get(i).setEmployee(employeeObj);
            salaryList.get(i+1).setEmployee(employeeObj);
            salaryList.get(i+2).setEmployee(employeeObj);

            // Set salaryList of employee
            employeeObj.setSalaryList(Arrays.asList(salaryList.get(i), salaryList.get(i+1), salaryList.get(i+2)));

            employeeDAO.createEmployee(employeeObj);

            employeeSalaryDAO.createSalary(salaryList.get(i));
            employeeSalaryDAO.createSalary(salaryList.get(i+1));
            employeeSalaryDAO.createSalary(salaryList.get(i+2));
        }
    }
}

