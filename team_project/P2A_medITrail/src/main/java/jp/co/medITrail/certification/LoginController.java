package jp.co.medITrail.certification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(path="/login",method=RequestMethod.POST)
	public String login(Integer hosId,Integer userId,String password) {
		
		Admin admin=adminRepository.findByHosIdAndAdminIdAndPassword(hosId,userId,password);
		
		
		if(admin!=null) {
			return"admin/empList";
		}
		
		Employee employee=employeeRepository.findByHosIdAndEmpIdAndPassword(hosId, userId, password);
		
		if(employee!=null) {
			return"employee/empTop";
		}
		
		return"login";
	}

}
