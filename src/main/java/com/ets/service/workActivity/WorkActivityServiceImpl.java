package com.ets.service.workActivity;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.workActivity.WorkActivityDAO;
import com.ets.model.WorkActivity;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkActivityServiceImpl Class
 *Description: WorkActivity Entity Service class
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
public class WorkActivityServiceImpl implements WorkActivityService {
	
	private WorkActivityDAO workActivityDAO;

	public void setWorkActivityDAO(WorkActivityDAO workActivityDAO) {
		this.workActivityDAO = workActivityDAO;
	}


	/** This method save the WorkActivity objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param workActivity
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addWorkActivity(WorkActivity workActivity) {
		workActivityDAO.addWorkActivity(workActivity);
		
	}

	/** This method gets all the WorkActivity objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of WorkActivity objects
	 */
	@Override
	public List<WorkActivity> workActivityList() {
		
		return workActivityDAO.workActivityList();
	}

	/** This method update the WorkActivity objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param workActivity
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateWorkActivity(WorkActivity workActivity) {
		
		workActivityDAO.updateWorkActivity(workActivity);
		
	}

	/** This method gets all the WorkActivity objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of WorkActivity objects
	 */
	@Override
	public WorkActivity getByWorkActivityID(Integer id) {
		
		return workActivityDAO.getByWorkActivityID(id);
	}

	/** This method delete the WorkActivity objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteWorkActivity(Integer id) {
		
		workActivityDAO.deleteWorkActivity(id);
		
	}
	
	

}
