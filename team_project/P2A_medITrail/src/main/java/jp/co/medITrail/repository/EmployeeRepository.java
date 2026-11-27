package jp.co.medITrail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.medITrail.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByHosIdAndEmpIdAndPasswordAndDeleteFlag(
			Integer hosId, Integer empId, String password, Integer deleteFlag);

	@Query(value = "SELECT EMPLOYEE_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Integer getNextEmployee();

	Employee findByEmpIdAndHosIdAndDeleteFlag(Integer empId, Integer hosId, Integer deleteFlag);

	List<Employee> findByHosIdAndDeleteFlag(Integer hosId, Integer deleteFlag);

	List<Employee> findByHosId(Integer hosId);

}