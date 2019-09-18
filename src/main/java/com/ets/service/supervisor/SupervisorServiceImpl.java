package com.ets.service.supervisor;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SupervisorServiceImpl Class
 *Description: Supervisor Entity Service class
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

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.supervisor.SupervisorDAO;
import com.ets.model.Supervisor;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SupervisorServiceImpl Class
 *Description: Supervisor Entity Service class
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
@Service
@Transactional
public class SupervisorServiceImpl implements SupervisorService {
	
	private SupervisorDAO supervisorDAO;

	
	public void setSupervisorDAO(SupervisorDAO supervisorDAO) {
		this.supervisorDAO = supervisorDAO;
	}


	/** This method save the Supervisor objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param supervisor
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addSupervisor(Supervisor supervisor) {
		
		supervisorDAO.addSupervisor(supervisor);
				
	}


	/** This method gets all the Supervisor objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Supervisor objects
	 */
	@Override
	public List<Supervisor> supervisorList() {
		
		return supervisorDAO.supervisorList();
	}


	/** This method update the Supervisor objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param supervisor
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateSupervisor(Supervisor supervisor) {
		
		supervisorDAO.updateSupervisor(supervisor);
		
	}


	/** This method gets all the Supervisor objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public Supervisor getBySupervisorID(Integer id) {
		
		return supervisorDAO.getBySupervisorID(id);
	}


	/** This method delete the Supervisor objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param supervisorName
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteSupervisor(Integer id) {
		
		supervisorDAO.deleteSupervisor(id);
		
	}

	/** This method gets all the Supervisor objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param supervisorName
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Supervisor objects
	 */
	@Override
	public List<Supervisor> searchSupervisor(String supervisorName) {
		// TODO Auto-generated method stub
		return supervisorDAO.searchSupervisor(supervisorName);
	}
	
	

}
