package com.apple.employee.response;

import javax.persistence.Column;

import lombok.Data;

@Data
public class EmployeeDetailResponse {
	private int id;
	private int departmentId;
	private String departmentName;
	private int employeeId;
	private String employeeName;
	
}
