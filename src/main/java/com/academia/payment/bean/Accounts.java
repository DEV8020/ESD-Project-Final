package com.academia.payment.bean;


import jakarta.persistence.*;
@Entity
@Table(name="Accounts")
public class Accounts {

    @Id
    @Column(nullable = false,unique = true)
    private String email;


    @Column(nullable = false)
    private String password;

    public Accounts(){}

    public Accounts(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
