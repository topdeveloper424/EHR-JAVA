package com.ets.service.stateWorkArea;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.stateWorkArea.StateWorkAreaDAO;
import com.ets.model.StateWorkArea;
/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StateWorkAreaServiceImpl Class
 *Description: StateWorkArea Entity Service class
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
public class StateWorkAreaServiceImpl implements StateWorkAreaService {
	
	private StateWorkAreaDAO stateWorkAreaDAO;

	
	public void setStateWorkAreaDAO(StateWorkAreaDAO stateWorkAreaDAO) {
		this.stateWorkAreaDAO = stateWorkAreaDAO;
	}

	/** This method save the StateWorkArea objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param stateWorkArea
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addStateWorkArea(StateWorkArea stateWorkArea) {
		stateWorkAreaDAO.addStateWorkArea(stateWorkArea);
		
	}

	/** This method gets all the StateWorkArea objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of StateWorkArea objects
	 */
	@Override
	public List<StateWorkArea> stateWorkAreaList() {
		
		return stateWorkAreaDAO.stateWorkAreaList();
	}

	/** This method update the StateWorkArea objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param stateWorkArea
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateStateWorkArea(StateWorkArea stateWorkArea) {
		
		stateWorkAreaDAO.updateStateWorkArea(stateWorkArea);
	}

	/** This method gets all the StateWorkArea objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of StateWorkArea objects
	 */
	@Override
	public StateWorkArea getByStateWorkArea(Integer id) {
		
		return stateWorkAreaDAO.getByStateWorkArea(id);
	}

	/** This method delete the StateWorkArea objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteStateWorkArea(Integer id) {
		
		stateWorkAreaDAO.deleteStateWorkArea(id);
		
	}
	
	

}
