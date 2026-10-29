package jp.co.medITrail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.medITrail.entity.Questionnaire;

public interface QuestionnaireRepository
        extends JpaRepository<Questionnaire, Integer> {

    @Query(value = "SELECT QUESTIONNAIRE_SEQ.NEXTVAL FROM DUAL",
           nativeQuery = true)
    Integer getNextQuestionnaire();

    Questionnaire findByQuestionnaireIdAndPatId(
            Integer questionnaireId, Integer patId);
}