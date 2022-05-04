package com.example.tectoro.pgmt.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tectoro.pgmt.dao.EmployeeDao;
import com.example.tectoro.pgmt.dao.JobDepartmentDao;
import com.example.tectoro.pgmt.dao.LeaveDao;
import com.example.tectoro.pgmt.dao.PayRollDao;
import com.example.tectoro.pgmt.dao.SalaryDao;
import com.example.tectoro.pgmt.domain.EmployeeDomain;
import com.example.tectoro.pgmt.domain.JobDepartmentDomain;
import com.example.tectoro.pgmt.domain.LeaveDomain;
import com.example.tectoro.pgmt.domain.PayRollDomain;
import com.example.tectoro.pgmt.domain.SalaryDomain;
import com.example.tectoro.pgmt.model.Employee;
import com.example.tectoro.pgmt.model.JobDepartmentModel;
import com.example.tectoro.pgmt.model.LeaveModel;
import com.example.tectoro.pgmt.model.PayRollModel;
import com.example.tectoro.pgmt.model.SalaryModel;
import com.example.tectoro.pgmt.service.EmployeeService;
import com.example.tectoro.pgmt.service.JobDepartmentService;
import com.example.tectoro.pgmt.service.LeaveService;
import com.example.tectoro.pgmt.service.PayRollService;
import com.example.tectoro.pgmt.service.SalaryService;

@Service
public class PayRollServiceImpl implements PayRollService {

	@Autowired
	private PayRollDao payDao;
	@Autowired
	private EmployeeService empservice;
	@Autowired
	private JobDepartmentService jobservice;
	@Autowired
	private SalaryService salservice;
	@Autowired
	private LeaveService leaveservice;
	@Autowired
	private EmployeeDao empDao;
	@Autowired
	private JobDepartmentDao jobdao;
	@Autowired
	private SalaryDao saldao;
	@Autowired
	private LeaveDao leaveDao;

	@Override

	public PayRollModel createPayroll(PayRollModel payrollModel) throws Exception {

		try {

			EmployeeDomain emp = new EmployeeDomain();
			emp = empDao.getEmployee(Integer.parseInt(payrollModel.getEmp().getEmpId()));
			if (emp.getEmpId() != 0) {
				JobDepartmentDomain jobdomain = new JobDepartmentDomain();
				jobdomain = jobdao.getJobDepartment(Integer.parseInt(payrollModel.getJobdept().getJobId()));
				if (jobdomain.getJobId() != 0) {
					SalaryDomain saldomain = new SalaryDomain();
					saldomain = saldao.getSalary(Integer.parseInt(payrollModel.getSalray().getSalaryId()));
					if (saldomain.getSalaryId() != 0) {
						LeaveDomain leavedomain = new LeaveDomain();
						leavedomain = leaveDao.getLeave(Integer.parseInt(payrollModel.getLeave().getLeaveId()));
						if (leavedomain.getLeaveId() != 0) {
							if (payrollModel != null) {
								PayRollDomain domain = new PayRollDomain();
								populateDomainFromBean(payrollModel, domain);
								domain = payDao.createPayroll(domain);
								if (domain != null) {
									populateBeanFromDomain(payrollModel, domain);
									return payrollModel;
								} else {
									return null;
								}
							} else {
								throw new Exception("Payroll model object is empty");
							}
						} else {
							throw new Exception("Leave Id is not exist");
						}
					} else {
						throw new Exception("salary Id is not exist");
					}
				} else {
					throw new Exception("Jobdepartment Id is not exist");
				}
			} else {
				throw new Exception("Employee Id is not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public PayRollModel updatePayroll(PayRollModel payrollModel) throws Exception {

		try {
			PayRollDomain domain = new PayRollDomain();
			if (payrollModel != null) {
				domain.setPayrollId(Integer.parseInt(payrollModel.getPayrollId()));
				if (payrollModel.getEmp().getEmpId() != null) {
					EmployeeDomain emp = new EmployeeDomain();
					emp.setEmpId(Integer.parseInt(payrollModel.getEmp().getEmpId()));
					domain.setEmp(emp);
				}
				if (payrollModel.getJobdept().getJobId() != null) {
					JobDepartmentDomain job = new JobDepartmentDomain();
					job.setJobId(Integer.parseInt(payrollModel.getJobdept().getJobId()));
					domain.setJobdept(job);
				}
				if (payrollModel.getSalray().getSalaryId() != null) {
					SalaryDomain sal = new SalaryDomain();
					sal.setSalaryId(Integer.parseInt(payrollModel.getSalray().getSalaryId()));
					domain.setSalray(sal);
				}
				if (payrollModel.getLeave().getLeaveId() != null) {
					LeaveDomain leave = new LeaveDomain();
					leave.setLeaveId(Integer.parseInt(payrollModel.getLeave().getLeaveId()));
					domain.setLeave(leave);
				}
				if (payrollModel.getDate() != null) {
					Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(payrollModel.getDate());
					domain.setDate(date1);
				}
				if (payrollModel.getReport() != null) {
					domain.setReport(payrollModel.getReport());
				}
				if (payrollModel.getTotalAmount() != null) {
					domain.setTotalAmount(Integer.parseInt(payrollModel.getTotalAmount()));
				}
				domain = payDao.updatePayroll(domain);
				if (domain != null) {
					populateBeanFromDomain(payrollModel, domain);
					return payrollModel;
				} else {
					
					return null;
				}
			} else {
				throw new Exception("PayRoll object is empty");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		//return null;
	}

	@Override
	public PayRollModel getPayroll(Integer payrollId) throws Exception {

		try {
			if (payrollId != null) {
				PayRollDomain domain = new PayRollDomain();
				domain.setPayrollId(payrollId);

				domain = payDao.getPayroll(domain);
				if (domain
						!= null) {
					PayRollModel payrollModel = new PayRollModel();
					populateBeanFromDomain(payrollModel, domain);

					Employee emp2 = new Employee();
					emp2 = empservice.getEmployee(domain.getEmp().getEmpId());
					payrollModel.setEmp(emp2);
					JobDepartmentModel job2 = new JobDepartmentModel();
					job2 =
							jobservice.getJobDepartment(domain.getJobdept().getJobId());
					payrollModel.setJobdept(job2);
					SalaryModel sal2 = new SalaryModel();
					sal2 = salservice.getSalary(domain.getSalray().getSalaryId());
					payrollModel.setSalray(sal2);
					LeaveModel lea = new LeaveModel();
					lea = leaveservice.getLeave(domain.getLeave().getLeaveId());
					payrollModel.setLeave(lea);
					return payrollModel;
				} else {
					return null;
				}
			} else {
				throw new Exception("PayRoll object is empty");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		//return null;
	}

	
	@Override
	public int deletePayroll(Integer payrollId) throws Exception{
		int flag = 0;
		try {
			if (payrollId != 0) {
				flag = payDao.deletePayroll(payrollId);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	private void populateDomainFromBean(PayRollModel payrollModel, PayRollDomain domain) throws ParseException {
		EmployeeDomain emp = new EmployeeDomain();
		emp.setEmpId(Integer.parseInt(payrollModel.getEmp().getEmpId()));
		domain.setEmp(emp);
		JobDepartmentDomain job = new JobDepartmentDomain();
		job.setJobId(Integer.parseInt(payrollModel.getJobdept().getJobId()));
		domain.setJobdept(job);
		SalaryDomain sal = new SalaryDomain();
		sal.setSalaryId(Integer.parseInt(payrollModel.getSalray().getSalaryId()));
		domain.setSalray(sal);
		LeaveDomain leave = new LeaveDomain();
		leave.setLeaveId(Integer.parseInt(payrollModel.getLeave().getLeaveId()));
		domain.setLeave(leave);
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(payrollModel.getDate());
		domain.setDate(date1);
		domain.setReport(payrollModel.getReport());
		domain.setTotalAmount(Integer.parseInt(payrollModel.getTotalAmount()));
	}
	

	private void populateBeanFromDomain(PayRollModel payrollModel, PayRollDomain domain) {
		payrollModel.setPayrollId(String.valueOf(domain.getPayrollId()));
		Employee emp1 = new Employee();
		emp1.setEmpId(String.valueOf(domain.getEmp().getEmpId()));
		payrollModel.setEmp(emp1);
		JobDepartmentModel job1 = new JobDepartmentModel();
		job1.setJobId(String.valueOf(domain.getJobdept().getJobId()));
		payrollModel.setJobdept(job1);
		SalaryModel sal1 = new SalaryModel();
		sal1.setSalaryId(String.valueOf(domain.getSalray().getSalaryId()));
		payrollModel.setSalray(sal1);
		LeaveModel leave1 = new LeaveModel();
		leave1.setLeaveId(String.valueOf(domain.getLeave().getLeaveId()));
		payrollModel.setLeave(leave1);
		DateFormat dateFormat = new SimpleDateFormat();
		String strDate = dateFormat.format(domain.getDate());
		payrollModel.setDate(strDate);
		payrollModel.setReport(domain.getReport());
		payrollModel.setTotalAmount(String.valueOf(domain.getTotalAmount()));
	}

}
