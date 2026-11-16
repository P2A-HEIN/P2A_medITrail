
package jp.co.medITrail.controller.employeeManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import jp.co.medITrail.entity.Employee;
import jp.co.medITrail.repository.EmployeeRepository;

@Controller
public class EmployeeInformationListController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(path = "/admin/empList", method = RequestMethod.GET)
	public String employeeInformationList(
			HttpSession session, Model model) {

		Integer hosId = (Integer) session.getAttribute("hosId");

		List<Employee> employeeList = employeeRepository.findByHosIdAndDeleteFlag(hosId, 0);

		model.addAttribute("employeeList", employeeList);

		return "admin/empList";
	}
}
