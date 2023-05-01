package com.apple.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(generator = "emp_seq")
	@Column(name="SrNo")
	private int id;
	@Column(name="employee_id")
	private int employeeId;
	@Column(name="name")
	private String employeeName;
	@Column(name="department_id")
	private int departmentId;
	@Column(name="created_date_time")
	@JsonIgnore
    private String createdDateTime;
	@Column(name="updated_date_time")
	@JsonIgnore
    private String updatedDateTime;
	
	
}


