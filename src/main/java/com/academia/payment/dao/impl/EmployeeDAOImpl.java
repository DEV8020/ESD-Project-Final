package com.academia.payment.dao.impl;

import com.academia.payment.bean.Employee;
import com.academia.payment.dao.EmployeeDAO;
import com.academia.payment.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    /*
        This method performs login of the Employee object specified
        So it basically checks whether the credentials provided in the Employee object match with
        a Employee object in the database
    */

    @Override
    public Employee login(Employee employee) {
        try (Session session = HibernateSessionUtil.getSession();){
            String employeeEmail = employee.getEmail();
            String employeePassword = employee.getPassword();
            String employeeDname = employee.getDname();

            List<Object> result = new ArrayList<Object>(
                    session.createQuery("FROM Employee WHERE email = :employeeEmail and password = :employeePassword and dname = :employeeDname")
                            .setParameter("employeeEmail", employeeEmail)
                            .setParameter("employeePassword", employeePassword)
                            .setParameter("account",employeeDname)
                            .list()
            );

            // If no valid employee found, return null so that login failure is understood
            if (result.size() == 0)
                return null;
            else
                return (Employee) result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }

    /*
        This method inserts the provided Student object into the database
        Used by the InitializeDB script to initialize the database with dummy data
    */
    @Override
    public void createEmployee(Employee employee) {
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

