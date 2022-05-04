package com.tectoro.ems.service;

import java.util.List;

import com.tectoro.ems.domain.Depend;

public interface DependService {
	public List<Depend> getDependById(int empId);
	public Depend addDepend(Depend depend);
	public Depend updateDepend(Depend depend);
	public String delteDepend(int dependId);

}
