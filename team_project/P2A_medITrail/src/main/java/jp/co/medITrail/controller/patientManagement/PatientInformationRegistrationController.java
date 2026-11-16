package jp.co.medITrail.controller.patientManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import jp.co.medITrail.entity.MedicalRecord;
import jp.co.medITrail.entity.Patient;
import jp.co.medITrail.entity.Questionnaire;
import jp.co.medITrail.form.PatientInformationRegistrationForm;
import jp.co.medITrail.repository.MedicalRecordRepository;
import jp.co.medITrail.repository.PatientRepository;
import jp.co.medITrail.repository.QuestionnaireRepository;

@Controller
public class PatientInformationRegistrationController {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private QuestionnaireRepository questionnaireRepository;

	@Autowired
	private MedicalRecordRepository medicalRecordRepository;

	@RequestMapping(path = "/employee/patientList", method = RequestMethod.GET)
	public String patientList(HttpSession session, Model model) {

		Integer hosId = (Integer) session.getAttribute("hosId");

		List<Patient> patientList = patientRepository.findByHosIdAndDeleteFlagOrderByPatIdAsc(hosId, 0);

		model.addAttribute("patientList", patientList);

		return "employee/patientList";
	}

	@RequestMapping(path = "/patient/patientSelection", method = RequestMethod.GET)
	public String patientSelection(HttpSession session, Model model) {

		Integer hosId = (Integer) session.getAttribute("hosId");

		List<Patient> patientList = patientRepository.findByHosIdAndDeleteFlagOrderByPatIdAsc(hosId, 0);

		model.addAttribute("patientList", patientList);

		return "patient/patientSelection";
	}

	@RequestMapping(path = "/employee/patientRegist", method = RequestMethod.GET)
	public String patientInformationRegistration() {

		return "employee/patientRegist";
	}

	@RequestMapping(path = "/employee/patientRegistCheck", method = RequestMethod.POST)
	public String patientInformationRegistrationCheck(
			PatientInformationRegistrationForm form, Model model) {

		model.addAttribute("patientForm", form);

		return "employee/patientRegistCheck";
	}

	@RequestMapping(path = "/employee/patientRegistCompletion", method = RequestMethod.POST)
	public String patientInformationRegistrationComplete(
			PatientInformationRegistrationForm form, HttpSession session) {

		Integer hosId = (Integer) session.getAttribute("hosId");
		Integer patId = patientRepository.getNextPatient();

		Patient patient = new Patient();

		patient.setPatId(patId);
		patient.setHosId(hosId);
		patient.setPatName(form.getPatName());
		patient.setBirth(form.getBirth());
		patient.setGender(form.getGender());
		patient.setDeleteFlag(0);

		patientRepository.save(patient);

		return "redirect:/employee/patientRegistCompletion";
	}

	@RequestMapping(path = "/employee/patientRegistCompletion", method = RequestMethod.GET)
	public String patientInformationRegistrationCompletion() {
		return "employee/patientRegistCompletion";
	}

	@RequestMapping(path = "/employee/patientDetail", method = RequestMethod.GET)
	public String patientDetail(Integer patId, HttpSession session, Model model) {

		Integer hosId = (Integer) session.getAttribute("hosId");

		if (hosId == null) {
			return "redirect:/login";
		}

		Patient patient = patientRepository.findByPatIdAndHosIdAndDeleteFlag(
				patId, hosId, 0);

		if (patient == null) {
			return "redirect:/employee/patientList";
		}

		model.addAttribute("patient", patient);

		// 選択した患者の問診票を新しい順に取得
		List<Questionnaire> questionnaireList = questionnaireRepository.findByPatIdOrderByInputDateDesc(patId);

		// 問診票の情報をHTMLに渡す
		model.addAttribute("questionnaireList", questionnaireList);

		// 選択した患者のカルテを新しい順に取得
		List<MedicalRecord> medicalRecordList = medicalRecordRepository.findByPatIdOrderByCreatedDateDesc(patId);

		// カルテ一覧をHTMLに渡す
		model.addAttribute("medicalRecordList", medicalRecordList);

		return "employee/patientDetail";

	}

}