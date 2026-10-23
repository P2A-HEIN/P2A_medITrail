package jp.co.medITrail.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "hos_id")
    private Integer hosId;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_kana")
    private String empKana;

    @Column(name = "emp_type")
    private Integer empType;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "password")
    private String password;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getHosId() {
        return hosId;
    }

    public void setHosId(Integer hosId) {
        this.hosId = hosId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpKana() {
        return empKana;
    }

    public void setEmpKana(String empKana) {
        this.empKana = empKana;
    }

    public Integer getEmpType() {
        return empType;
    }

    public void setEmpType(Integer empType) {
        this.empType = empType;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}