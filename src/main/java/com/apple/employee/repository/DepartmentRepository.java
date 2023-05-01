package com.apple.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apple.employee.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	Optional<Department> findByDepartmentId(int departmentId);

}
