package com.academia.payment.dao.impl;

import com.academia.payment.bean.EmployeeSalary;
import com.academia.payment.dao.EmployeeSalaryDAO;
import com.academia.payment.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeSalaryDAOImpl implements EmployeeSalaryDAO {
    /*
        This method fetches all the Bills of the Students with ID = s_id
    */
    @Override
    public List<EmployeeSalary> getSalary(Integer empId) {
        List<EmployeeSalary> salaryList = new ArrayList<>();

        try (Session session = HibernateSessionUtil.getSession()){
            for (
                    final Object salary : session
                    .createQuery("FROM EmployeeSalary WHERE employee.empId=:empId")
                    .setParameter("empId", empId).list()
            )
                salaryList.add((EmployeeSalary) salary);
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return salaryList;
    }

    /*
        This method "pays" the salary with ID = billId
        So it basically deletes the Bill with the given ID
    */
    @Override
    public Boolean paySalary(Integer sId) {
        try (Session session = HibernateSessionUtil.getSession()) {
            LocalDate date = LocalDate.now();
            Transaction transaction = session.beginTransaction();

            String query_string="FROM EmployeeSalary WHERE sId=:sId";
            Query query=session.createQuery(query_string);
            query.setParameter("sId", sId);
            EmployeeSalary es = (EmployeeSalary) query.list().get(0);
            String dateS = date.toString();
            es.setPayment_date(dateS);
            transaction.commit();
            return true;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return false;
    }
//    public Boolean payBill(Integer billId) {
//        try (Session session = HibernateSessionUtil.getSession()) {
//            Transaction transaction = session.beginTransaction();
//            String query_string="DELETE FROM Bill WHERE billId=:billId";
//            Query query=session.createQuery(query_string);
//            query.setParameter("billId", billId);
//            query.executeUpdate();
//            transaction.commit();
//            return true;
//
//        } catch (HibernateException exception) {
//            System.out.print(exception.getLocalizedMessage());
//        }
//        return false;
//    }
    /*
        This method inserts the given salary object into the Database
        Not used by any Controller but it is used by the InitializeDB script to initialize the
        database with dummy data
    */
    @Override
    public void createSalary(EmployeeSalary employeeSalary ) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employeeSalary);
            transaction.commit();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    }
}
