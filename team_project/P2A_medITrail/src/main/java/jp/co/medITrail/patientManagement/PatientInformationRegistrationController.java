package jp.co.medITrail.patientManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import jp.co.medITrail.entity.Patient;
import jp.co.medITrail.form.PatientInformationRegistrationForm;
import jp.co.medITrail.repository.PatientRepository;

@Controller
public class PatientInformationRegistrationController {

    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping(path="/employee/patientRegist", method=RequestMethod.GET)
    public String patientInformationRegistration() {

        return "employee/patientRegist";
    }

    @RequestMapping(path="/employee/patientRegistCheck", method=RequestMethod.POST)
    public String patientInformationRegistrationCheck(
            PatientInformationRegistrationForm form) {

        return "employee/patientRegistCheck";
    }

    @RequestMapping(path="/employee/patientRegistCompletion", method=RequestMethod.POST)
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

        return "employee/patientRegistCompletion";
    }

}