package com.tectoro.ems.service.impl;

import java.util.List;

import com.tectoro.ems.dao.DependDao;
import com.tectoro.ems.dao.impl.DependDaoImpl;
import com.tectoro.ems.domain.Department;
import com.tectoro.ems.domain.Depend;
import com.tectoro.ems.service.DependService;

public class DependServiceImpl implements DependService {
	
	private static DependDao dependDao= new DependDaoImpl();

	@Override
	public List<Depend> getDependById(int empId) {
		
		return dependDao.getDependById(empId);
	}

	@Override
	public Depend addDepend(Depend depend) {
		
		Depend dependOutput = dependDao.addDepend(depend);
		
		if(dependOutput!= null) {
			return depend;
		}
		return null;
	}

	@Override
	public Depend updateDepend(Depend depend) {
		

		Depend dependOutput = dependDao.updateDepend(depend);
		
		if(dependOutput!= null) {
			return depend;
		}
		return null;
	}

	@Override
	public String delteDepend(int dependId) {
		String msg = dependDao.delteDepend(dependId);
		return msg;
	}

}
