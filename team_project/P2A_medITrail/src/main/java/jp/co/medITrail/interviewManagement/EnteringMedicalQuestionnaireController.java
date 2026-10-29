package jp.co.medITrail.interviewManagement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.medITrail.entity.Questionnaire;
import jp.co.medITrail.form.EnteringMedicalQuestionnaireForm;
import jp.co.medITrail.repository.QuestionnaireRepository;

@Controller
public class EnteringMedicalQuestionnaireController {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @RequestMapping(path="/patient/questionnaireInput", method=RequestMethod.GET)
    public String enteringMedicalQuestionnaire(Integer patId,EnteringMedicalQuestionnaireForm form) {
    	
    	form.setPatId(patId);

        return "patient/questionnaireInput";
    }

    @RequestMapping(path="/patient/questionnaireInputCompletion", method=RequestMethod.POST)
    public String enteringMedicalQuestionnaireComplete(
            EnteringMedicalQuestionnaireForm form) {

        Integer questionnaireId = questionnaireRepository.getNextQuestionnaire();

        Questionnaire questionnaire = new Questionnaire();

        questionnaire.setQuestionnaireId(questionnaireId);
        questionnaire.setPatId(form.getPatId());
        questionnaire.setSymptoms(form.getSymptoms());
        questionnaire.setSymptomsDetail(form.getSymptomsDetail());
        questionnaire.setOnsetDate(form.getOnsetDate());
        questionnaire.setAllergy(form.getAllergy());
        questionnaire.setTakingMedications(form.getTakingMedications());
        questionnaire.setMedicalHistory(form.getMedicalHistory());
        questionnaire.setFamilyHistory(form.getFamilyHistory());
        questionnaire.setOthers(form.getOthers());

        questionnaire.setInputDate(new Date());

        questionnaireRepository.save(questionnaire);

        return "patient/questionnaireInputCompletion";
    }

}