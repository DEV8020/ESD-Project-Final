package com.academia.payment.dao.impl;

import com.academia.payment.bean.Employee;
import com.academia.payment.bean.EmployeeSalary;
import com.academia.payment.dao.EmployeeSelectDAO;
import com.academia.payment.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSelectDAOImpl implements EmployeeSelectDAO {
    @Override
    public List<Employee> getEmployee() {
        List<Employee> employeeSelectList = new ArrayList<>();

        try (Session session = HibernateSessionUtil.getSession()){
            String deptName= "faculty";
            for (

                    final Object employee : session
                    .createQuery("FROM Employee WHERE  dname =:dname")
                    .setParameter("dname",deptName).list()
            )
                employeeSelectList.add((Employee) employee);
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return employeeSelectList;
    }
    @Override
    public void createEmployee(Employee employee ) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    }
}
