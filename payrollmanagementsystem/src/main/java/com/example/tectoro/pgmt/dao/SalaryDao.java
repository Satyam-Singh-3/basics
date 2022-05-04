package com.example.tectoro.pgmt.dao;

import com.example.tectoro.pgmt.domain.SalaryDomain;

public interface SalaryDao {

	SalaryDomain createSalary(SalaryDomain salaryDomain);

	SalaryDomain updateSalary(SalaryDomain salaryDomain);

	SalaryDomain getSalary(Integer salaryId) throws Exception;

	int deleteSalary(Integer salaryId);

	public int deleteRelationshipWithJob(Integer id);

	

}
