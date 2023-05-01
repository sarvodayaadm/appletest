package com.apple.employee.service;

import java.util.List;
import java.util.Optional;

import com.apple.employee.entity.Employee;
import com.apple.employee.exception.UserNotFoundException;
import com.apple.employee.repository.EmployeeRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apple.employee.common.Common;
import com.apple.employee.entity.Department;
import com.apple.employee.exception.AppleEmployeeException;
import com.apple.employee.repository.DepartmentRepository;

@Service
public class DepartmentService {


	private final DepartmentRepository deptRepo;
	private final EmployeeRepository empRepo;

	@Autowired
	public DepartmentService(DepartmentRepository deptRepo, EmployeeRepository empRepo) throws UserNotFoundException {
		this.deptRepo = deptRepo;
		this.empRepo=empRepo;
	}

	public Department saveDepartment(Department department) {

		Optional<Department> deptObj = deptRepo.findByDepartmentId(department.getDepartmentId());

		if (deptObj.isPresent()) {
			throw new AppleEmployeeException("Department :" + department.getDepartmentId() + " already present.");
		} else {
			department.setCreatedDateTime(Common.getCurrentDateTimeUsingDate());
			return deptRepo.save(department);
		}
	}

	public List<Department> saveDepartments(List<Department> departments) {
		return deptRepo.saveAll(departments);

	}

	public List<Department> getDepartment() {
		return deptRepo.findAll();
	}

	public Department getDepartmentById(int id) {
		return deptRepo.findById(id).orElse(null);
	}

	public Department getDepartmentByDeptId(int department_id) {
		return deptRepo.findByDepartmentId(department_id).orElse(null);
	}

	public Department deleteDepartment(int id) throws UserNotFoundException {

		Optional<Department> deptobj=deptRepo.findById(id);

		List<Employee> employeeList=empRepo.findByDepartmentId(deptobj.get().getDepartmentId());
		if(employeeList.isEmpty()){
			deptRepo.deleteById(id);
			return deptobj.get();
		}else {
			throw new UserNotFoundException("Employee has been associated with department. Please delete associated employee");
		}



	}

	public Department updateDepartment(Department department) {
		Optional<Department> existingDepartment = deptRepo.findById(department.getId());
		Department deptObj = existingDepartment.get();
		// Department deptObjRes = new Department();

		deptObj.setDepartmentName(department.getDepartmentName());
		deptObj.setDepartmentId(department.getDepartmentId());
		deptObj.setUpdatedDateTime(Common.getCurrentDateTimeUsingDate());

		try {
			return deptRepo.save(deptObj);
		} catch (Exception e) {
			throw new AppleEmployeeException("Department :" + department.getDepartmentId() + " already present.");
		}

	}
}
