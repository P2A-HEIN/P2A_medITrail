
package jp.co.medITrail.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @Column(name = "med_id")
    private Integer medId;

    @Column(name = "pat_id")
    private Integer patId;

    @Column(name = "questionnaire_id")
    private Integer questionnaireId;

    @Column(name = "created_emp_id")
    private Integer createdEmpId;

    @Column(name = "updated_emp_id")
    private Integer updatedEmpId;

    @Column(name = "diagnosis_details")
    private String diagnosisDetails;

    @Column(name = "treatment_details")
    private String treatmentDetails;

    @Column(name = "prescription_details")
    private String prescriptionDetails;

    @Column(name = "remarks")
    private String remarks;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

    public Integer getMedId() {
        return medId;
    }

    public void setMedId(Integer medId) {
        this.medId = medId;
    }

    public Integer getPatId() {
        return patId;
    }

    public void setPatId(Integer patId) {
        this.patId = patId;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Integer getCreatedEmpId() {
        return createdEmpId;
    }

    public void setCreatedEmpId(Integer createdEmpId) {
        this.createdEmpId = createdEmpId;
    }

    public Integer getUpdatedEmpId() {
        return updatedEmpId;
    }

    public void setUpdatedEmpId(Integer updatedEmpId) {
        this.updatedEmpId = updatedEmpId;
    }

    public String getDiagnosisDetails() {
        return diagnosisDetails;
    }

    public void setDiagnosisDetails(String diagnosisDetails) {
        this.diagnosisDetails = diagnosisDetails;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = treatmentDetails;
    }

    public String getPrescriptionDetails() {
        return prescriptionDetails;
    }

    public void setPrescriptionDetails(String prescriptionDetails) {
        this.prescriptionDetails = prescriptionDetails;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
