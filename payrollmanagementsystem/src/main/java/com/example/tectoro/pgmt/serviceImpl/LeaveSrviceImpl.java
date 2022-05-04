package com.example.tectoro.pgmt.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tectoro.pgmt.dao.EmployeeDao;
import com.example.tectoro.pgmt.dao.LeaveDao;
import com.example.tectoro.pgmt.domain.EmployeeDomain;
import com.example.tectoro.pgmt.domain.LeaveDomain;
import com.example.tectoro.pgmt.model.Employee;
import com.example.tectoro.pgmt.model.LeaveModel;
import com.example.tectoro.pgmt.service.EmployeeService;
import com.example.tectoro.pgmt.service.LeaveService;

@Service
public class LeaveSrviceImpl implements LeaveService {

	@Autowired
	private LeaveDao leaveDao;
	@Autowired
	private EmployeeDao empDao;
	@Autowired
	private EmployeeService empservice;

	@Override
	public LeaveModel createLeave(LeaveModel leaveModel) throws Exception {

		try {
			if (leaveModel.getEmployee().getEmpId() != null) {
				EmployeeDomain emp = new EmployeeDomain();
				emp = empDao.getEmployee(Integer.parseInt(leaveModel.getEmployee().getEmpId()));
				if (emp.getEmpId() != 0) {
					LeaveDomain domain = new LeaveDomain();
					populateDomainFromBean(leaveModel, domain);
					domain = leaveDao.createLeave(domain);
					if (domain != null) {
						populateBeanFromDomain(leaveModel, domain);
						return leaveModel;
					} else {
						return null;
					}
				} else {
					throw new Exception("Leave object is empty");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}

	@Override
	public LeaveModel updateLeave(LeaveModel leaveModel) throws Exception {

		try {
			LeaveDomain domain = new LeaveDomain();
			if (leaveModel.getEmployee().getEmpId() != null) {
				EmployeeDomain emp1 = new EmployeeDomain();
				emp1 = empDao.getEmployee(Integer.parseInt(leaveModel.getEmployee().getEmpId()));
				if (emp1.getEmpId() != 0) {
				domain.setLeaveId(Integer.parseInt(leaveModel.getLeaveId()));
				EmployeeDomain emp = new EmployeeDomain();
				emp.setEmpId(Integer.parseInt(leaveModel.getEmployee().getEmpId()));
				domain.setEmp(emp);

				if (leaveModel.getDate() != null) {
					Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(leaveModel.getDate());
					domain.setDate(date1);
				}
				if (leaveModel.getStatus() != null) {
					domain.setStatus(leaveModel.getStatus());
				}
				if (leaveModel.getReason() != null) {
					domain.setReason(leaveModel.getReason());
				}

				domain = leaveDao.updateLeave(domain);
				if (domain != null) {
					populateBeanFromDomain(leaveModel, domain);
					return leaveModel;
				} else {
					return null;
				}
			}
			} else {
				throw new Exception("Leave object is empty");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}

	@Override
	public LeaveModel getLeave(Integer leaveId) throws Exception {

		try {
			LeaveDomain domain = new LeaveDomain();
			if (leaveId != null) {
				domain.setLeaveId(leaveId);
				domain = leaveDao.getLeave(leaveId);

				LeaveModel leaveModel = new LeaveModel();
				populateBeanFromDomain(leaveModel, domain);

				Employee emp = new Employee();
				emp = empservice.getEmployee(domain.getEmp().getEmpId());
				leaveModel.setEmployee(emp);
				return leaveModel;
			} else {
				throw new Exception("object is empty");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteLeave(Integer leaveId) {

		int flag = 0;
		try {
			if (leaveId!= 0) {
				flag = leaveDao.deleteLeave(leaveId);
				return flag;
			} else {
				throw new Exception("leaveid is not there");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	private void populateDomainFromBean(LeaveModel leaveModel, LeaveDomain domain) throws ParseException {
		EmployeeDomain emp = new EmployeeDomain();
		emp.setEmpId(Integer.parseInt(leaveModel.getEmployee().getEmpId()));
		domain.setEmp(emp);
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(leaveModel.getDate());
		domain.setDate(date1);
		domain.setStatus(leaveModel.getStatus());
		domain.setReason(leaveModel.getReason());
	}

	private void populateBeanFromDomain(LeaveModel leaveModel, LeaveDomain domain) {
		leaveModel.setLeaveId(String.valueOf(domain.getLeaveId()));
		Employee emp1 = new Employee();
		emp1.setEmpId(String.valueOf(domain.getEmp().getEmpId()));
		leaveModel.setEmployee(emp1);
		DateFormat dateFormat = new SimpleDateFormat();
		String strDate = dateFormat.format(domain.getDate());
		leaveModel.setDate(strDate);
		leaveModel.setStatus(domain.getStatus());
		leaveModel.setReason(domain.getReason());
	}

}
