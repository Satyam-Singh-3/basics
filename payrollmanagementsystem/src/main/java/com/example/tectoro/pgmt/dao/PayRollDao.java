package com.example.tectoro.pgmt.dao;

import com.example.tectoro.pgmt.domain.PayRollDomain;

public interface PayRollDao {

	PayRollDomain createPayroll(PayRollDomain domain) throws Exception;

	PayRollDomain updatePayroll(PayRollDomain domain) throws Exception;

	PayRollDomain getPayroll(PayRollDomain domain) throws Exception;

	int deletePayroll(Integer payrollId) throws Exception;

	public int deleteRelationShiptoSalary(Integer id) throws Exception;

	public int deleteRelationShiptoLeave(int id) throws Exception;

	public int deleteLeaveRelationShipwithPayroll(Integer id) throws Exception;



}
