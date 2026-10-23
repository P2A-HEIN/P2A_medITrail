package jp.co.medITrail.employeeManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.medITrail.entity.Employee;
import jp.co.medITrail.form.EmployeeInformationRegistrationForm;
import jp.co.medITrail.repository.EmployeeRepository;

@Controller
public class EmployeeInformationRegistrationController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(path="/employeeInformationRegistration", method=RequestMethod.GET)
    public String employeeInformationRegistration() {

        return "admin/empRegist";
    }

    @RequestMapping(path="/employeeInformationRegistrationCheck", method=RequestMethod.POST)
    public String employeeInformationRegistrationCheck(
            EmployeeInformationRegistrationForm form) {

        return "admin/empRegistCheck";
    }

    @RequestMapping(path="/employeeInformationRegistration", method=RequestMethod.POST)
    public String employeeInformationRegistration(
            EmployeeInformationRegistrationForm form) {

        Integer empId = employeeRepository.getNextEmployee();

        Employee employee = new Employee();

        employee.setEmpId(empId);
        employee.setEmpName(form.getEmpName());
        employee.setJobType(form.getJobType());
        employee.setPassword(form.getPassword());
        employee.setDeleteFlag(0);

        employeeRepository.save(employee);

        return "admin/empRegistCompletion";
    }

}