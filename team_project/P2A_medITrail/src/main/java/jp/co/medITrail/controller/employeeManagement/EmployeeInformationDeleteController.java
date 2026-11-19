package jp.co.medITrail.controller.employeeManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import jp.co.medITrail.entity.Employee;
import jp.co.medITrail.repository.EmployeeRepository;

@Controller
public class EmployeeInformationDeleteController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(path = "/admin/empDeleteCheck", method = RequestMethod.GET)
	public String employeeInformationDeleteCheck(Integer empId, HttpSession session, Model model) {

		Integer hosId = (Integer) session.getAttribute("hosId");

		Employee employee = employeeRepository.findByEmpIdAndHosIdAndDeleteFlag(empId, hosId, 0);

		if (employee == null) {
			return "redirect:/admin/empList";
		}

		model.addAttribute("employee", employee);

		return "admin/empDeleteCheck";
	}

	@RequestMapping(path = "/admin/empDeleteCompletion", method = RequestMethod.POST)
	public String employeeInformationDeleteCompletion(Integer empId, HttpSession session, Model model) {

		Integer hosId = (Integer) session.getAttribute("hosId");

		Employee employee = employeeRepository.findByEmpIdAndHosIdAndDeleteFlag(empId, hosId, 0);

		if (employee == null) {
			return "redirect:/admin/empList";
		}

		employee.setDeleteFlag(1);

		employeeRepository.save(employee);

		model.addAttribute("empName", employee.getEmpName());

		return "admin/empDeleteCompletion";
	}

}