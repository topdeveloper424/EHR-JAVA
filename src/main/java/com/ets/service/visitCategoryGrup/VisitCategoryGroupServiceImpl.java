package com.ets.service.visitCategoryGrup;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.visitCategoryGroup.VisitCategoryGroupDAO;
import com.ets.model.VisitCategoryGroup;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of VisitCategoryGroupServiceImpl Class
 *Description: VisitCategoryGroup Entity Service class
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
public class VisitCategoryGroupServiceImpl implements VisitCategoryGroupService {
	
	private VisitCategoryGroupDAO visitCategoryGroupDAO;

	public void setVisitCategoryGroupDAO(VisitCategoryGroupDAO visitCategoryGroupDAO) {
		this.visitCategoryGroupDAO = visitCategoryGroupDAO;
	}
	/** This method gets all the VisitCategoryGroup objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param visitCategoryGroup
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addVisitCategoryGroup(VisitCategoryGroup visitCategoryGroup) {
		
		visitCategoryGroupDAO.addVisitCategoryGroup(visitCategoryGroup);
		
	}
	/** This method gets all the VisitCategoryGroup objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of VisitCategoryGroup objects
	 */
	@Override
	public List<VisitCategoryGroup> viewVisitCategoryGroup() {
		
		return visitCategoryGroupDAO.viewVisitCategoryGroup();
	}
	

}
