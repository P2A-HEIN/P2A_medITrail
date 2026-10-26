package jp.co.medITrail.medicalRecordManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MedicalRecordCreationController {

    @RequestMapping(path="/employee/medicalRecordRegist", method=RequestMethod.GET)
    public String medicalRecordCreation() {

        return "employee/medicalRecordRegist";
    }

    @RequestMapping(path="/employee/medicalRecordRegistCheck", method=RequestMethod.POST)
    public String medicalRecordCreationCheck() {

        return "employee/medicalRecordRegistCheck";
    }

    @RequestMapping(path="/employee/medicalRecordRegistCompletion", method=RequestMethod.POST)
    public String medicalRecordCreationComplete() {

        return "employee/medicalRecordRegistCompletion";
    }

}