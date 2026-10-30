package jp.co.medITrail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.medITrail.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value = "SELECT PATIENT_SEQ.NEXTVAL FROM DUAL",nativeQuery = true)Integer getNextPatient();

    Patient findByPatIdAndHosIdAndDeleteFlag(Integer patId, Integer hosId, Integer deleteFlag);
}