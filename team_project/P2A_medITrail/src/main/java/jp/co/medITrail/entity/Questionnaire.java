package jp.co.medITrail.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "questionnaires")
public class Questionnaire {

    @Id
    @Column(name = "questionnaire_id")
    private Integer questionnaireId;

    @Column(name = "pat_id")
    private Integer patId;

    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "symptoms_detail")
    private String symptomsDetail;

    @Column(name = "onset_date")
    private Date onsetDate;

    @Column(name = "allergy")
    private String allergy;

    @Column(name = "taking_medications")
    private String takingMedications;

    @Column(name = "medical_history")
    private String medicalHistory;

    @Column(name = "family_history")
    private String familyHistory;

    @Column(name = "others")
    private String others;

    @Column(name = "ai_summary")
    private String aiSummary;

    @Column(name = "input_date")
    private Date inputDate;

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Integer getPatId() {
        return patId;
    }

    public void setPatId(Integer patId) {
        this.patId = patId;
    }

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

    public String getAiSummary() {
        return aiSummary;
    }

    public void setAiSummary(String aiSummary) {
        this.aiSummary = aiSummary;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

}