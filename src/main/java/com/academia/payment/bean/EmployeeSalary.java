package com.academia.payment.bean;
import jakarta.persistence.*;
@Entity
@Table(name = "EmployeeSalary")
public class EmployeeSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sId;

    @ManyToOne
    @JoinColumn(name = "empId")
    private Employee employee;

    @Column(nullable = false)
    private String payment_date;


    @Column(nullable = false)
    private Integer ammount;

    @Column
    private String description;

    public EmployeeSalary(){

    }

    public EmployeeSalary(String description, Integer ammount, String payment_date, Integer sId) {
        this.sId = sId;
        this.employee = employee;
        this.payment_date = payment_date;
        this.ammount = ammount;
        this.description = description;
    }




    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}