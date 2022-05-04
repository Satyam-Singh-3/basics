package com.example.tectoro.pgmt.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tectoro.pgmt.dao.SalaryDao;
import com.example.tectoro.pgmt.domain.JobDepartmentDomain;
import com.example.tectoro.pgmt.domain.SalaryDomain;
import com.example.tectoro.pgmt.model.JobDepartmentModel;
import com.example.tectoro.pgmt.model.SalaryModel;
import com.example.tectoro.pgmt.service.JobDepartmentService;
import com.example.tectoro.pgmt.service.SalaryService;

@Service
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private SalaryDao salaryDao;
	@Autowired
	private JobDepartmentService jobservice;

	@Override
	public SalaryModel createSalary(SalaryModel salaryModel) throws Exception {

		try {
			if (salaryModel != null) {
				SalaryDomain salaryDomain = new SalaryDomain();
				populateDomainFromBean(salaryDomain, salaryModel);
				
				salaryDomain = salaryDao.createSalary(salaryDomain);
				if (salaryDomain != null) {
					populateBeanFromDomain(salaryDomain, salaryModel);
					return salaryModel;
				} else {
					return null;
				}
			} else {
				throw new Exception("Salary object is empty");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public SalaryModel updateSalary(SalaryModel salaryModel) throws Exception {
	
		try {
			if (salaryModel != null) {
				SalaryDomain salaryDomain = new SalaryDomain();
				salaryDomain.setSalaryId(Integer.parseInt(salaryModel.getSalaryId()));
				if (salaryModel.getJobdept().getJobId() != null) {
					JobDepartmentDomain jpob = new JobDepartmentDomain();
					jpob.setJobId(Integer.parseInt(salaryModel.getJobdept().getJobId()));
					salaryDomain.setJobdept(jpob);
				}
				if (salaryModel.getAmount() != null) {
					salaryDomain.setAmount(Integer.parseInt(salaryModel.getAmount()));

				}
				if (salaryModel.getAnnual() != null) {
					Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(salaryModel.getAnnual());
					salaryDomain.setAnnual(date1);
				}
				if (salaryModel.getBonous() != null) {
					Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(salaryModel.getBonous());
					salaryDomain.setBonous(date2);
				}

				salaryDomain = salaryDao.updateSalary(salaryDomain);
				if (salaryDomain != null) {
					populateBeanFromDomain(salaryDomain, salaryModel);
					return salaryModel;
				}
			} else {
				throw new Exception("Salary object is empty");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SalaryModel getSalary(Integer salaryId) throws Exception{

		SalaryDomain saldomain = null;
		try {
			if (salaryId != null) {
				SalaryDomain salaryDomain = new SalaryDomain();
				salaryDomain.setSalaryId(salaryId);

				saldomain = salaryDao.getSalary(salaryId);
				if (saldomain != null) {
					SalaryModel salaryModel = new SalaryModel();
					populateBeanFromDomain(salaryDomain, salaryModel);

					JobDepartmentModel job1 = new JobDepartmentModel();
					job1 = jobservice.getJobDepartment(saldomain.getJobdept().getJobId());
					salaryModel.setJobdept(job1);
					return salaryModel;
				} else {
					return null;
				}
			} else {
				throw new Exception("Salary object is empty");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteSalary(Integer salaryId) throws Exception {

		int flag = 0;
		try {
			if (salaryId != 0) {
				flag = salaryDao.deleteSalary(salaryId);
				if (flag == 1) {
					return flag;
				}

			} else {
				throw new Exception("salary id is empty");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	private void populateDomainFromBean(SalaryDomain salaryDomain, SalaryModel salaryModel) throws ParseException {
		JobDepartmentDomain jpob = new JobDepartmentDomain();
		jpob.setJobId(Integer.parseInt(salaryModel.getJobdept().getJobId()));
		salaryDomain.setJobdept(jpob);
		salaryDomain.setAmount(Integer.parseInt(salaryModel.getAmount()));
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(salaryModel.getAnnual());
		salaryDomain.setAnnual(date1);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(salaryModel.getBonous());
		salaryDomain.setBonous(date2);
	}
	private void populateBeanFromDomain(SalaryDomain salaryDomain, SalaryModel salaryModel) {
		salaryModel.setSalaryId(String.valueOf(salaryDomain.getSalaryId()));
		JobDepartmentModel model1 = new JobDepartmentModel();
		model1.setJobId(String.valueOf(salaryDomain.getJobdept().getJobId()));
		salaryModel.setJobdept(model1);
		salaryModel.setAmount(String.valueOf(salaryDomain.getAmount()));
		DateFormat dateFormat = new SimpleDateFormat();
		String strDate = dateFormat.format(salaryDomain.getAnnual());
		salaryModel.setAnnual(strDate);
		DateFormat dateFormat1 = new SimpleDateFormat();
		String strDate1 = dateFormat1.format(salaryDomain.getBonous());
		salaryModel.setBonous(strDate1);
	}

}
