package com.academia.payment.dao;

import com.academia.payment.bean.Accounts;

public interface AccountsDAO {
    Accounts login(Accounts accounts);
    void createAccounts(Accounts accounts);
}
