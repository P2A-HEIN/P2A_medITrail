package jp.co.medITrail.form;

import java.util.Date;

public class PatientInformationRegistrationForm {

    private String patName;

    private Date birth;

    private Integer gender;

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

}