package jp.co.medITrail.controller.interviewManagement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.medITrail.entity.Questionnaire;
import jp.co.medITrail.form.EnteringMedicalQuestionnaireForm;
import jp.co.medITrail.repository.QuestionnaireRepository;
import jp.co.medITrail.service.GeminiService;

@Controller
public class EnteringMedicalQuestionnaireController {

	@Autowired
	private QuestionnaireRepository questionnaireRepository;

	@Autowired
	private GeminiService geminiService;
	
	
	@RequestMapping(path="/patient/questionnaireInput", method=RequestMethod.GET)
	public String enteringMedicalQuestionnaire(
	        Integer patId,
	        EnteringMedicalQuestionnaireForm form,
	        Model model) {

	    form.setPatId(patId);

	    model.addAttribute("patId", patId);

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
        
        String questionnaireText = "症状：" + form.getSymptoms()
        + "\n症状の詳細：" + form.getSymptomsDetail()
        + "\n発症日：" + form.getOnsetDate()
        + "\nアレルギー：" + form.getAllergy()
        + "\n服用中の薬：" + form.getTakingMedications()
        + "\n既往歴：" + form.getMedicalHistory()
        + "\n家族歴：" + form.getFamilyHistory()
        + "\nその他：" + form.getOthers();
        
        
        String summary = geminiService.summarize(questionnaireText);

        questionnaire.setAiSummary(summary);

        questionnaireRepository.save(questionnaire);

        return "patient/questionnaireInputCompletion";
    }

}