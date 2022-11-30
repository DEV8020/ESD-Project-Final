package com.academia.payment.service;

import com.academia.payment.bean.Accounts;
import com.academia.payment.dao.impl.AccountsDAOImpl;

public class AccountsService {
    AccountsDAOImpl accountsDAO = new AccountsDAOImpl();

    public Accounts login(Accounts accounts){
        Accounts loggedInAccounts = accountsDAO.login(accounts);

        // If no login happens, then return null
        if (loggedInAccounts == null)
            return null;

        return loggedInAccounts;
    }
}
