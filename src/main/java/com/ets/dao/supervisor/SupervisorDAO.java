package com.ets.dao.supervisor;

import java.util.List;

import com.ets.model.Supervisor;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SupervisorDAO Interface
 *Description: Supervisor Entity DAO Interface
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

public interface SupervisorDAO {
	
	public void addSupervisor(Supervisor supervisor);
	
	public List<Supervisor> supervisorList();
	
	public void updateSupervisor(Supervisor supervisor);
	
	public Supervisor getBySupervisorID(Integer id);
	
	public void deleteSupervisor(Integer id);
	
	public List<Supervisor> searchSupervisor(String supervisorName);
	
	

}
