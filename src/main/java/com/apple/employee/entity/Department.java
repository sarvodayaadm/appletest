package com.apple.employee.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(generator = "dept_seq")
	private int id;
	@Column(unique = true,name="department_id")
	private int departmentId;
	@Column(name="department_name")
	private String departmentName;
	@Column(name="created_date_time")
	@JsonIgnore
    private String createdDateTime;
	@Column(name="updated_date_time")
	@JsonIgnore
    private String updatedDateTime;
}
