package com.apple.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apple.employee.common.Common;
import com.apple.employee.entity.Department;
import com.apple.employee.entity.Employee;
import com.apple.employee.exception.AppleEmployeeException;
import com.apple.employee.repository.DepartmentRepository;
import com.apple.employee.repository.EmployeeRepository;
import com.apple.employee.response.EmployeeDetailResponse;

import lombok.Builder;

@Service
@Builder
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private DepartmentRepository depRepo;

	public Employee saveEmployee(Employee employee) {

		Optional<Employee> empObj = empRepo.findByEmployeeId(employee.getEmployeeId());

		if (empObj.isPresent()) {
			throw new AppleEmployeeException("Employee :" + employee.getEmployeeId() + "already present.");
		} else {
			employee.setCreatedDateTime(Common.getCurrentDateTimeUsingDate());

			return empRepo.save(employee);
		}
	}

	public List<Employee> saveEmployees(List<Employee> employee) {
		return empRepo.saveAll(employee);
	}



	public List<EmployeeDetailResponse> getEmployee() {
		List<Employee> empList = new ArrayList<>();
		empList = empRepo.findAll();
		List<EmployeeDetailResponse> empDetailRespList = new ArrayList<>();
		empList.forEach(empListvar -> {
			EmployeeDetailResponse empDetailRespObject = new EmployeeDetailResponse();

			if (empListvar.getDepartmentId() != 0) {
				Optional<Department> deptObj = depRepo.findByDepartmentId(empListvar.getDepartmentId());
				if (deptObj.isPresent()) {
					empDetailRespObject.setDepartmentId(deptObj.get().getDepartmentId());
					empDetailRespObject.setDepartmentName(deptObj.get().getDepartmentName());
				}
			}

			empDetailRespObject.setId(empListvar.getId());
			empDetailRespObject.setEmployeeId(empListvar.getEmployeeId());
			empDetailRespObject.setEmployeeName(empListvar.getEmployeeName());
			empDetailRespList.add(empDetailRespObject);

		});
		return empDetailRespList;
	}

	public Employee getEmployeeById(int id) {
		return empRepo.findById(id).orElse(null);

	}

	public Employee getEmployeeByEmpId(int employee_id) {
		return empRepo.findByEmployeeId(employee_id).orElse(null);
	}

	public String deleteEmployee(int id) {
		empRepo.deleteById(id);
		return "Employee has been removed !!" + id;
	}

	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee = empRepo.findById(employee.getId()).orElse(null);
		existingEmployee.setEmployeeName(employee.getEmployeeName());
		existingEmployee.setEmployeeId(employee.getEmployeeId());
		existingEmployee.setDepartmentId(employee.getDepartmentId());
		existingEmployee.setUpdatedDateTime(Common.getCurrentDateTimeUsingDate());

		return empRepo.save(existingEmployee);
	}

}
