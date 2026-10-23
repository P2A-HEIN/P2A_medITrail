package jp.co.medITrail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.medITrail.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	Employee findByHosIdAndEmpIdAndPassword(Integer hosId,Integer empId,String password);

}