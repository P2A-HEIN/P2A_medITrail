package jp.co.medITrail.patientManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.medITrail.entity.Patient;
import jp.co.medITrail.form.PatientInformationRegistrationForm;
import jp.co.medITrail.repository.PatientRepository;

@Controller
public class PatientInformationRegistrationController {
	@Autowired
	private PatientRepository patientRepository;

    @RequestMapping(path="/patientInformationRegistration", method=RequestMethod.GET)
    public String patientInformationRegistration() {

        return "employee/patientRegist";
    }

    @RequestMapping(path="/patientInformationRegistrationCheck", method=RequestMethod.POST)
    public String patientInformationRegistrationCheck() {

        return "employee/patientRegistCheck";
    }

    @RequestMapping(path="/patientInformationRegistration", method=RequestMethod.POST)
    public String patientInformationRegistrationComplete(PatientInformationRegistrationForm form) {
    	
    	Integer patId=patientRepository.getNextPatient();
    	
    	Patient patient=new Patient();
    	
    	patient.setPatId(patId);
        patient.setPatName(form.getPatName());
        patient.setBirth(form.getBirth());
        patient.setGender(form.getGender());
        patient.setDeleteFlag(0);
        
        patientRepository.save(patient);
    	

        return "employee/patientRegistCompletion";
    }

}