package com.tectoro.ems.dao;

import java.util.List;

import com.tectoro.ems.domain.Depend;

public interface DependDao {

	List<Depend> getDepend(int empId);

	List<Depend> getDependById(int empId);

	Depend addDepend(Depend depend);

	Depend updateDepend(Depend depend);

	String delteDepend(int dependId);

}
