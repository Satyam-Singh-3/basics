package com.example.tectoro.pgmt.service;

import com.example.tectoro.pgmt.model.PayRollModel;

public interface PayRollService {

	PayRollModel createPayroll(PayRollModel payrollModel) throws Exception;

	PayRollModel updatePayroll(PayRollModel payrollModel) throws Exception;

	PayRollModel getPayroll(Integer payrollId) throws Exception;

	int deletePayroll(Integer payrollId) throws Exception;

}
