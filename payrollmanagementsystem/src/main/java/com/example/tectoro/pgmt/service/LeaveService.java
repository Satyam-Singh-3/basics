package com.example.tectoro.pgmt.service;

import com.example.tectoro.pgmt.model.LeaveModel;

public interface LeaveService {

	LeaveModel createLeave(LeaveModel leaveModel) throws Exception;

	LeaveModel updateLeave(LeaveModel leaveModel) throws Exception;

	LeaveModel getLeave(Integer leaveId) throws Exception;

	int deleteLeave(Integer leaveId);

}
