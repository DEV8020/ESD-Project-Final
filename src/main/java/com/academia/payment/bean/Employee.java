package com.academia.payment.bean;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.academia.payment.bean.EmployeeSalary;

import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @Column(nullable = false)
    private String first_name;

    @Column
    private String last_name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column
    private String title;

    @Column
    private String Photograph_path;

    @Column(nullable = false)
    private String password;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    //    @ManyToOne
//    @JoinColumn(name = "deptId")
  private String dname;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    @JsonIgnore // Doesn't seem to work in this case
    private List<EmployeeSalary> salaryList;


    private List<Employee> employeeList;


    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotograph_path() {
        return Photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        Photograph_path = photograph_path;
    }

//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalaryList(List<EmployeeSalary> salaryList) {
        this.salaryList = salaryList;
    }

    public List<EmployeeSalary> getSalaryList() {
        return salaryList;
    }

    public Employee(String first_name, String last_name, String email, String title, String photograph_path, String password,String dname) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.title = title;
        Photograph_path = photograph_path;
        this.password = password;
        this.dname = dname;
  //     this.salaryList = salaryList;
    }
    public Employee(){}
}



