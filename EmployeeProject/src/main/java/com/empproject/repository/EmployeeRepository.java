package com.empproject.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empproject.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Transactional
	@Modifying
	@Query(value = "delete from employee_table  where first_name=?", nativeQuery = true)
	public void deleteEmpName(String name);
	
	
}
