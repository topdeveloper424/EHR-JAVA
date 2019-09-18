package com.ets.controller.entity.supervisor;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Supervisor;
import com.ets.service.supervisor.SupervisorServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SupervisorEntityController Class
 *Description: Supervisor Entity Non-GUI Controller class
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

public class SupervisorEntityController {

	//private static ClassPathXmlApplicationContext context;

	private SupervisorServiceImpl supervisorServiceImpl;

	private ObservableList<Supervisor> observableList;

	public SupervisorEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		supervisorServiceImpl = (SupervisorServiceImpl) Global.context.getBean("supervisorService");
		observableList = FXCollections.observableArrayList();

	}

	

	/**
	 * This method save the Supervisor objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param supervisor
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void saveSupervisor(Supervisor supervisor) {

		supervisorServiceImpl.addSupervisor(supervisor);
		//this.closeApplicationConrext();
	}

	/**
	 * This method gets all the Supervisor objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Supervisor objects
	 */

	public ObservableList<Supervisor> viewSupervisor() {

		observableList = FXCollections.observableArrayList(supervisorServiceImpl.supervisorList());
		//this.closeApplicationConrext();
		return observableList;

	}

	/**
	 * This method update the Supervisor objects currently present in the system
	 * .
	 * 
	 * @author Sumanta Deyashi
	 * @param supervisor
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void updateSupervisor(Supervisor supervisor) {

		supervisorServiceImpl.updateSupervisor(supervisor);
		//this.closeApplicationConrext();

	}

	/**
	 * This method delete the Supervisor objects currently present in the system
	 * .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void removeSupervisor(Integer id) {

		supervisorServiceImpl.deleteSupervisor(id);
		//this.closeApplicationConrext();

	}

	/**
	 * This method gets all the Supervisor objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param supervisorName
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Supervisor objects
	 */
	public ObservableList<Supervisor> searchSupervisor(String supervisorName) {

		observableList = FXCollections.observableArrayList(supervisorServiceImpl.searchSupervisor(supervisorName));
		//this.closeApplicationConrext();
		return observableList;

	}

}
