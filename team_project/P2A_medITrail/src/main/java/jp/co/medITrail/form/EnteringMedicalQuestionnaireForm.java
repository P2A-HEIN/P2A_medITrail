package jp.co.medITrail.form;

import java.util.Date;

public class EnteringMedicalQuestionnaireForm {

    private String symptoms;

    private String symptomsDetail;
    
    private Integer patId;

    private Date onsetDate;

    private String allergy;

    private String takingMedications;

    private String medicalHistory;

    private String familyHistory;

    private String others;

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getSymptomsDetail() {
        return symptomsDetail;
    }

    public void setSymptomsDetail(String symptomsDetail) {
        this.symptomsDetail = symptomsDetail;
    }
    
    public Integer getPatId() {
        return patId;
    }

    public void setPatId(Integer patId) {
        this.patId = patId;
    }

    public Date getOnsetDate() {
        return onsetDate;
    }

    public void setOnsetDate(Date onsetDate) {
        this.onsetDate = onsetDate;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getTakingMedications() {
        return takingMedications;
    }

    public void setTakingMedications(String takingMedications) {
        this.takingMedications = takingMedications;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

}