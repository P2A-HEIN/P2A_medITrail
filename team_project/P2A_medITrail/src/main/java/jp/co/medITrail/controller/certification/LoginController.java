package jp.co.medITrail.controller.certification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jp.co.medITrail.entity.Admin;
import jp.co.medITrail.entity.Employee;
import jp.co.medITrail.repository.AdminRepository;
import jp.co.medITrail.repository.EmployeeRepository;

@Controller
public class LoginController {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(Integer hosId, Integer userId, String password, HttpSession session,
			HttpServletRequest request) {

		Admin admin = adminRepository.findByHosIdAndAdminIdAndPassword(hosId, userId, password);

		if (admin != null) {
			request.changeSessionId();
			session.removeAttribute("empId");
			session.setAttribute("hosId", hosId);
			session.setAttribute("role", "admin");
			return "redirect:/admin/empList";
		}

		Employee employee = employeeRepository.findByHosIdAndEmpIdAndPasswordAndDeleteFlag(hosId, userId, password, 0);

		if (employee != null) {
			request.changeSessionId();
			session.setAttribute("hosId", hosId);
			session.setAttribute("empId", employee.getEmpId());
			session.setAttribute("role", "employee");
			return "employee/empTop";
		}

		return "login";
	}

}
