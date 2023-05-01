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
@Table(name="appleuser")
public class AppleUser {
	
	@Id
	@GeneratedValue(generator = "user_seq")
	private int id;
	@Column(name="email_id")
	private String emailId;	
	@Column(name="user_name")
	private String userName;
	@Column(name="Password")
	private String password;
	@Column(name="created_date_time")
    private String createdDateTime;
	@Column(name="updated_date_time")
    private String updatedDateTime;
	
}
