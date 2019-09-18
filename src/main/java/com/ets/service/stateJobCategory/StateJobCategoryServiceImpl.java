package com.ets.service.stateJobCategory;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.stateJobCategory.StateJobCategoryDAO;
import com.ets.model.StateJobCategory;
/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StateJobCategoryServiceImpl Class
 *Description: StateJobCategory Entity Service class
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
@Transactional
@Service
public class StateJobCategoryServiceImpl implements StateJobCategoryService {
	
	private StateJobCategoryDAO stateJobCategoryDAO;

	public void setStateJobCategoryDAO(StateJobCategoryDAO stateJobCategoryDAO) {
		this.stateJobCategoryDAO = stateJobCategoryDAO;
	}

	/** This method save the StateJobCategory objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param stateJobCategory
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addStateJobCategory(StateJobCategory stateJobCategory) {
		stateJobCategoryDAO.addStateJobCategory(stateJobCategory);
		
	}


	/** This method gets all the StateJobCategory objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of StateJobCategory objects
	 */
	@Override
	public List<StateJobCategory> stateJobCategoryList() {
		
		return stateJobCategoryDAO.stateJobCategoryList();
	}

	/** This method update the StateJobCategory objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param stateJobCategory
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateStateJobCategory(StateJobCategory stateJobCategory) {
		
		stateJobCategoryDAO.updateStateJobCategory(stateJobCategory);
		
	}

	/** This method gets all the StateJobCategory objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of StateJobCategory objects
	 */
	@Override
	public StateJobCategory getByStateJobCategoryID(Integer id) {
		
		return stateJobCategoryDAO.getByStateJobCategoryID(id);
	}

	/** This method delete the StateJobCategory objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteStateJobCategory(Integer id) {
		
		stateJobCategoryDAO.deleteStateJobCategory(id);
		
	}
	
	

}
