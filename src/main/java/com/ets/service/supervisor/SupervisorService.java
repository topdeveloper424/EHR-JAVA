package com.ets.service.supervisor;

import java.util.List;

import com.ets.model.Supervisor;

public interface SupervisorService {

	public void addSupervisor(Supervisor supervisor);

	public List<Supervisor> supervisorList();

	public void updateSupervisor(Supervisor supervisor);

	public Supervisor getBySupervisorID(Integer id);

	public void deleteSupervisor(Integer id);
	
	public List<Supervisor> searchSupervisor(String supervisorName);

}
