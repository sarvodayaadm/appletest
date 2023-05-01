package com.apple.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apple.employee.entity.Employee;
import com.apple.employee.response.EmployeeDetailResponse;
import com.apple.employee.service.EmployeeService;

@RestController
@RequestMapping("api/appleemp")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE,
		RequestMethod.PUT }, allowedHeaders = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee employeeSaved=empService.saveEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved,HttpStatus.CREATED);
	}

	@GetMapping("/employee")
	public List<EmployeeDetailResponse> findAllEmployees() {
		return empService.getEmployee();
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable int id) {
		Employee empById = empService.getEmployeeById(id);
		return  new ResponseEntity<Employee>(empById,HttpStatus.OK);
	}

	@GetMapping("/employee/{empId}")
	public ResponseEntity<Employee> findEmployeeByEmpId(@PathVariable int empId) {
		Employee empByEmpId = empService.getEmployeeByEmpId(empId);
		return new ResponseEntity<Employee>(empByEmpId,HttpStatus.OK);

	}

	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		   Employee empUpdate = empService.updateEmployee(employee);
		   return new ResponseEntity<Employee>(empUpdate,HttpStatus.CREATED);

	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		empService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
