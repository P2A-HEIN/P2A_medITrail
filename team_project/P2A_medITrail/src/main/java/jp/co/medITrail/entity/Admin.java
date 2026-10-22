package jp.co.medITrail.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @Column(name = "admin_id")
    private Integer adminId;

    @Column(name = "hos_id")
    private Integer hosId;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "password")
    private String password;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getHosId() {
        return hosId;
    }

    public void setHosId(Integer hosId) {
        this.hosId = hosId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}