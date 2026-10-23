package jp.co.medITrail.employeeManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeInformationRegistrationController {

    @RequestMapping(path="/employeeInformationRegistration", method=RequestMethod.GET)
    public String employeeInformationRegistration() {

        return "admin/empRegist";
    }

}