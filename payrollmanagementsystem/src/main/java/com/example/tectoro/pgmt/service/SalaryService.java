package com.example.tectoro.pgmt.service;

import com.example.tectoro.pgmt.model.SalaryModel;

public interface SalaryService {

	SalaryModel createSalary(SalaryModel salaryModel) throws Exception;

	SalaryModel updateSalary(SalaryModel salaryModel) throws Exception;

	SalaryModel getSalary(Integer salaryId) throws Exception;

	int deleteSalary(Integer salaryId) throws Exception;

}
