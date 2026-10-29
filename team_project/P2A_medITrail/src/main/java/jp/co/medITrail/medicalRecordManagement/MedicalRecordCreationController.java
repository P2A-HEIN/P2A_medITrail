
package jp.co.medITrail.medicalRecordManagement;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import jp.co.medITrail.entity.FixedText;
import jp.co.medITrail.entity.MedicalRecord;
import jp.co.medITrail.form.MedicalRecordCreationForm;
import jp.co.medITrail.repository.EmployeeRepository;
import jp.co.medITrail.repository.FixedTextRepository;
import jp.co.medITrail.repository.MedicalRecordRepository;
import jp.co.medITrail.repository.PatientRepository;
import jp.co.medITrail.repository.QuestionnaireRepository;

@Controller
public class MedicalRecordCreationController {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;
    
    @Autowired
    private QuestionnaireRepository questionnaireRepository;
    
    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private FixedTextRepository fixedTextRepository;


@RequestMapping(path="/employee/medicalRecordRegist", method=RequestMethod.GET)
public String medicalRecordCreation(Integer patId,Integer questionnaireId,MedicalRecordCreationForm form,Model model) {

    form.setPatId(patId);
    form.setQuestionnaireId(questionnaireId);

    List<FixedText> fixedTextList =fixedTextRepository.findByDeleteFlagOrderByCategoryAscTitleAsc(0);

    model.addAttribute("fixedTextList", fixedTextList);

    return "employee/medicalRecordRegist";
}


    @RequestMapping(path="/employee/medicalRecordRegistCheck", method=RequestMethod.POST)
    public String medicalRecordCreationCheck(MedicalRecordCreationForm form,Model model) {

        model.addAttribute("medicalRecordCreationForm", form);

        return "employee/medicalRecordRegistCheck";
    }

    @RequestMapping(path = "/employee/medicalRecordRegistCompletion",method = RequestMethod.POST)
    	public String medicalRecordCreationComplete(MedicalRecordCreationForm form,HttpSession session,Model model) {

    	    Integer empId = (Integer) session.getAttribute("empId");
    	    Integer hosId = (Integer) session.getAttribute("hosId");

    	    if (empId == null || hosId == null|| form.getPatId() == null|| form.getQuestionnaireId() == null) {

    	        model.addAttribute("errorMessage","ログイン情報、患者情報、または問診票情報を取得できませんでした。");

    	        return "employee/medicalRecordRegist";
    	    }
    	    
    	    var employee = employeeRepository.findByEmpIdAndHosIdAndDeleteFlag(empId, hosId, 0);

    	    if (employee == null) {
    	        model.addAttribute("errorMessage","ログイン中の職員情報が見つからないか、利用できない状態です。");

    	        return "employee/medicalRecordRegist";
    	    }
    	    
    	    var patient = patientRepository.findByPatIdAndHosIdAndDeleteFlag(form.getPatId(), hosId, 0);

    	    if (patient == null) {
    	        model.addAttribute("errorMessage","指定された患者が見つからないか、登録された病院が異なります。");
    	        return "employee/medicalRecordRegist";
    	    }

    	    var questionnaire =questionnaireRepository.findByQuestionnaireIdAndPatId(form.getQuestionnaireId(),form.getPatId());

    	    if (questionnaire == null) {
    	        model.addAttribute("errorMessage","指定された患者の問診票が見つかりませんでした。");

    	        return "employee/medicalRecordRegist";
    	    }

    	    Integer medId = medicalRecordRepository.getNextMedicalRecord();

    	    MedicalRecord medicalRecord = new MedicalRecord();

    	    medicalRecord.setMedId(medId);
    	    medicalRecord.setPatId(form.getPatId());
    	    medicalRecord.setQuestionnaireId(form.getQuestionnaireId());
    	    medicalRecord.setCreatedEmpId(empId);
    	    medicalRecord.setUpdatedEmpId(empId);

    	    medicalRecord.setDiagnosisDetails(form.getDiagnosisDetails());
    	    medicalRecord.setTreatmentDetails(form.getTreatmentDetails());
    	    medicalRecord.setPrescriptionDetails(form.getPrescriptionDetails());
    	    medicalRecord.setRemarks(form.getRemarks());

    	    Date now = new Date();
    	    medicalRecord.setCreatedDate(now);
    	    medicalRecord.setUpdatedDate(now);

    	    medicalRecordRepository.save(medicalRecord);

    	    return "employee/medicalRecordRegistCompletion";
    	}

}
