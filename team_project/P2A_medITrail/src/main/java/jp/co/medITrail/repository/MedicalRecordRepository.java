
package jp.co.medITrail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.medITrail.entity.MedicalRecord;

public interface MedicalRecordRepository
        extends JpaRepository<MedicalRecord, Integer> {

    @Query(value = "SELECT MEDICAL_RECORD_SEQ.NEXTVAL FROM DUAL",
           nativeQuery = true)
    Integer getNextMedicalRecord();

}
