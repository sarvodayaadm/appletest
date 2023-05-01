package com.apple.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apple.employee.entity.Department;
import com.apple.employee.entity.AppleUser;

public interface EmployeeRegistrationRepository extends JpaRepository<AppleUser, Integer> {


	AppleUser findUserByEmailId(String emailId);

	AppleUser findUserByEmailIdAndPassword(String emailId, String password);


	AppleUser findByUserName(String username);
}