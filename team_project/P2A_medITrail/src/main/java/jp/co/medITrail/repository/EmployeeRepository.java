package jp.co.medITrail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.medITrail.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	Employee findByHosIdAndEmpIdAndPassword(Integer hosId,Integer empId,String password);
	
	@Query(value="SELECT EMPLOYEE_SEQ.NEXTVAL FROM DUAL",nativeQuery=true)
	Integer getNextEmployee();
	
	Employee findByEmpIdAndHosIdAndDeleteFlag(Integer empId, Integer hosId, Integer deleteFlag);

}