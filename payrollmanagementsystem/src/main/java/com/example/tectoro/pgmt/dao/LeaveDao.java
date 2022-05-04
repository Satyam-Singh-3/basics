package com.example.tectoro.pgmt.dao;

import com.example.tectoro.pgmt.domain.LeaveDomain;

public interface LeaveDao {

	LeaveDomain createLeave(LeaveDomain domain) throws Exception;

	LeaveDomain updateLeave(LeaveDomain domain);


	int deleteLeave(Integer leaveId);

	LeaveDomain getLeave(Integer leaveId);


}
