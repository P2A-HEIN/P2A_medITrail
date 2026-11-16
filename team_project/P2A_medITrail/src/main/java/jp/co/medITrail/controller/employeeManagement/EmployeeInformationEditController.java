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
public class EmployeeInformationEditController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(path = "/admin/empEdit", method = RequestMethod.GET)
	public String employeeInformationEdit(Integer empId, HttpSession session, Model model) {

		Integer hosId = (Integer) session.getAttribute("hosId");

		Employee employee = employeeRepository.findByEmpIdAndHosIdAndDeleteFlag(empId, hosId, 0);

		if (employee == null) {
			return "redirect:/admin/empList";
		}

		model.addAttribute("employee", employee);

		return "admin/empEdit";
	}

	@RequestMapping(path = "/admin/empEditCheck", method = RequestMethod.POST)
	public String employeeInformationEditCheck(Integer empId, String empName, String jobType, Model model,
			HttpSession session) {

		Integer hosId = (Integer) session.getAttribute("hosId");

		Employee employee = employeeRepository.findByEmpIdAndHosIdAndDeleteFlag(empId, hosId, 0);

		if (employee == null) {
			return "redirect:/admin/empList";
		}

		if (empName == null || empName.isBlank()) {
			return "redirect:/admin/empEdit?empId=" + empId;
		}

		if (empName.getBytes(java.nio.charset.StandardCharsets.UTF_8).length > 100) {
			return "redirect:/admin/empEdit?empId=" + empId;
		}

		if (jobType == null || jobType.isBlank()) {
			return "redirect:/admin/empEdit?empId=" + empId;
		}

		if (!jobType.equals("医師")
				&& !jobType.equals("看護師")
				&& !jobType.equals("受付・医療事務")) {
			return "redirect:/admin/empEdit?empId=" + empId;
		}

		model.addAttribute("empId", empId);
		model.addAttribute("empName", empName);
		model.addAttribute("jobType", jobType);

		return "admin/empEditCheck";
	}

	@RequestMapping(path = "/admin/empEditCompletion", method = RequestMethod.POST)
	public String employeeInformationEditCompletion(
			Integer empId, String empName, String jobType, HttpSession session, Model model) {

		// ログイン中の病院IDを取得
		Integer hosId = (Integer) session.getAttribute("hosId");

		// 編集対象の勤務者を取得
		Employee employee = employeeRepository.findByEmpIdAndHosIdAndDeleteFlag(empId, hosId, 0);

		// 勤務者が存在しない場合
		if (employee == null) {
			return "redirect:/admin/empList";
		}

		// 勤務者名の未入力チェック
		if (empName == null || empName.isBlank()) {
			return "redirect:/admin/empEdit?empId=" + empId;
		}

		// 勤務者名のバイト数チェック
		if (empName.getBytes(java.nio.charset.StandardCharsets.UTF_8).length > 100) {
			return "redirect:/admin/empEdit?empId=" + empId;
		}

		// 職種の未入力チェック
		if (jobType == null || jobType.isBlank()) {
			return "redirect:/admin/empEdit?empId=" + empId;
		}

		// 職種の選択肢チェック
		if (!jobType.equals("医師")
				&& !jobType.equals("看護師")
				&& !jobType.equals("受付・医療事務")) {
			return "redirect:/admin/empEdit?empId=" + empId;
		}

		// 勤務者情報を変更
		employee.setEmpName(empName);
		employee.setJobType(jobType);

		// データベースに保存
		employeeRepository.save(employee);
		
		// 編集した勤務者名を画面に渡す
		model.addAttribute("empName", empName);
		
		// 編集完了画面へ
		return "admin/empEditCompletion";
	}

}