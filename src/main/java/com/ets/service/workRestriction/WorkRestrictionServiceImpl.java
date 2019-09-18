package com.ets.service.workRestriction;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.workRestriction.WorkRestrictionDAO;
import com.ets.model.WorkRestriction;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkRestrictionServiceImpl Class
 *Description: WorkRestriction Entity Service class
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
public class WorkRestrictionServiceImpl implements WorkRestrictionService{
	
	private WorkRestrictionDAO  workRestrictionDAO;

	public void setWorkRestrictionDAO(WorkRestrictionDAO workRestrictionDAO) {
		this.workRestrictionDAO = workRestrictionDAO;
	}
	/** This method save the WorkRestriction objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param workRestriction
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void add(WorkRestriction workRestriction) {
		
		workRestrictionDAO.add(workRestriction);
		
	}
	/** This method gets all the WorkRestriction objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of WorkRestriction objects
	 */
	@Override
	public List<WorkRestriction> list() {
		
		return workRestrictionDAO.list();
	}
	/** This method update the WorkRestriction objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param workRestriction
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void update(WorkRestriction workRestriction) {
		
		workRestrictionDAO.update(workRestriction);
		
	}
	/** This method gets all the WorkRestriction objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of WorkRestriction objects
	 */
	@Override
	public WorkRestriction getByID(Integer id) {
		
		return workRestrictionDAO.getByID(id);
	}
	/** This method delete the WorkRestriction objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void delete(Integer id) {
		
		workRestrictionDAO.delete(id);
		
	}

	
	

}
