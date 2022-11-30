package com.academia.payment.dao.impl;

import com.academia.payment.bean.Accounts;
import com.academia.payment.bean.Employee;
import com.academia.payment.dao.AccountsDAO;
import com.academia.payment.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AccountsDAOImpl implements AccountsDAO {

    @Override
    public Accounts login(Accounts accounts) {
        try (Session session = HibernateSessionUtil.getSession();){
            String accountsEmail = accounts.getEmail();
            String accountsPassword = accounts.getPassword();

            List<Object> result = new ArrayList<Object>(
                    session.createQuery("FROM Accounts WHERE email = :accountsEmail and password = :accountsPassword")
                            .setParameter("accountsEmail", accountsEmail)
                            .setParameter("accountsPassword", accountsPassword)
                            .list()
            );
            if (result.size() == 0)
                return null;
            else
                return (Accounts) result.get(0);
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
    public void createAccounts(Accounts accounts) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(accounts);
            transaction.commit();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    }
}
