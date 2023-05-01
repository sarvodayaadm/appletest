package com.apple.employee.controller;

import java.util.List;

import com.apple.employee.exception.UserNotFoundException;
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

import com.apple.employee.entity.Department;
import com.apple.employee.service.DepartmentService;

@RestController
@RequestMapping("api/appledept")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE,
		RequestMethod.PUT }, allowedHeaders = "*")
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;

	@PostMapping("/department")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		Department deptAdd=deptService.saveDepartment(department);
		return new ResponseEntity<Department>(deptAdd,HttpStatus.CREATED);


	}

	@GetMapping("/department")
	public ResponseEntity<List<Department>> findAllDepartments() {
		List<Department> listOfDepartment=deptService.getDepartment();
		return new ResponseEntity<List<Department>>(listOfDepartment,HttpStatus.OK);

	}

	@GetMapping("/department/{id}")
	public ResponseEntity<Department> findDepartmentById(@PathVariable int id) {
		   Department getDepById = deptService.getDepartmentById(id);
		   return new ResponseEntity<Department>(getDepById,HttpStatus.OK);

	}

	@GetMapping("/department/{deptId}")
	public Department findDepartmentByDeptId(@PathVariable int deptId) {
		return deptService.getDepartmentByDeptId(deptId);
	}

	@PutMapping("/department")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		Department departmentSaved=deptService.updateDepartment(department);
		return new ResponseEntity<Department>(departmentSaved,HttpStatus.CREATED);

	}

	@DeleteMapping("/department/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable int id) throws UserNotFoundException {
		Department deptobj=deptService.deleteDepartment(id);
		return new ResponseEntity<Department>(deptobj,HttpStatus.OK);
	}
}
