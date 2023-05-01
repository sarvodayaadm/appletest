package com.apple.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apple.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Optional<Employee> findByEmployeeId(int employee_id);
	List<Employee> findByDepartmentId(int dept_id);
	
}
