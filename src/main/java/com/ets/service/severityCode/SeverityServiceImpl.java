package com.ets.service.severityCode;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.severityCode.SeverityDAO;
import com.ets.model.SeverityCode;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SeverityServiceImpl Class
 *Description: SeverityCode Entity Service class
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
public class SeverityServiceImpl implements SeverityService {
	
	private SeverityDAO severityDAO;

	
	public void setSeverityDAO(SeverityDAO severityDAO) {
		this.severityDAO = severityDAO;
	}


	/** This methodsave the SeverityCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param severityCode
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addSeverity(SeverityCode severityCode) {
		
		severityDAO.addSeverity(severityCode);
		
	}


	/** This method gets all the SeverityCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of SeverityCode objects
	 */
	@Override
	public List<SeverityCode> severityCodeLists() {
		
		return severityDAO.severityCodeLists();
	}


	/** This method update the SeverityCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param severityCode
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateSeverityCode(SeverityCode severityCode) {
		
		severityDAO.updateSeverityCode(severityCode);
		
	}


	/** This method gets all the SeverityCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of SeverityCode objects
	 */
	@Override
	public SeverityCode getBySeverityCodeID(Integer id) {
		
		return severityDAO.getBySeverityCodeID(id);
	}


	/** This method delete the SeverityCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteSeverityCode(Integer id) {
		
		severityDAO.deleteSeverityCode(id);
		
	}
	
}
