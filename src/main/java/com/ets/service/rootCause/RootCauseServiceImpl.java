package com.ets.service.rootCause;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.rootCause.RootCauseDAO;
import com.ets.model.RootCause;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RootCauseServiceImpl Class
 *Description: RootCause Entity Service class
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
public class RootCauseServiceImpl implements RootCauseService {
	
private RootCauseDAO rootCauseDAO;
	
	
	public void setRootCauseDAO(RootCauseDAO rootCauseDAO) {
		this.rootCauseDAO = rootCauseDAO;
	}
	
	/** This method save the RootCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param rootCause
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addRootCause(RootCause rootCause) {
		
		rootCauseDAO.addRootCause(rootCause);
		
	}

	/** This method gets all the RootCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of RootCause objects
	 */
	@Override
	public List<RootCause> rootCauseLists() {
		
		return rootCauseDAO.rootCauseLists();
	}
	
	/** This method update the RootCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param rootCause
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateRootCause(RootCause rootCause) {
		
		rootCauseDAO.updateRootCause(rootCause);
		
	}
	
	/** This method gets all the RootCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of RootCause objects
	 */
	@Override
	public RootCause getByRootCauseID(Integer id) {
		
		return rootCauseDAO.getByRootCauseID(id);
	}
	
	/** This method delete the RootCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteRootCause(Integer id) {
		
		rootCauseDAO.deleteRootCause(id);
		
	}

}
