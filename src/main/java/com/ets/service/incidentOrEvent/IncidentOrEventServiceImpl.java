package com.ets.service.incidentOrEvent;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.incidentOrEvent.IncidentOrEventDAO;
import com.ets.model.IncidentOrEvent;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of IncidentOrEventServiceImpl Class
 *Description: IncidentOrEvent Entity Service class
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
public class IncidentOrEventServiceImpl implements IncidentOrEventService {
	
	private IncidentOrEventDAO incidentOrEventDAO;
	
	
	public void setIncidentOrEventDAO(IncidentOrEventDAO incidentOrEventDAO) {
		this.incidentOrEventDAO = incidentOrEventDAO;
	}

	/** This method save the IncidentOrEvent objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param incidentOrEvent
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addIncidentOrEvent(IncidentOrEvent incidentOrEvent) {
		
		incidentOrEventDAO.addIncidentOrEvent(incidentOrEvent);
		
	}

	/** This method gets all the IncidentOrEvent objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of IncidentOrEvent objects
	 */
	@Override
	public List<IncidentOrEvent> incidentOrEventLists() {
		
		return incidentOrEventDAO.incidentOrEventLists();
	}

	/** This method update the IncidentOrEvent objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param incidentOrEvent
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateIncidentOrEvent(IncidentOrEvent incidentOrEvent) {
		
		incidentOrEventDAO.updateIncidentOrEvent(incidentOrEvent);
		
	}

	/** This method gets all the IncidentOrEvent objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of IncidentOrEvent objects
	 */
	@Override
	public IncidentOrEvent getByIncidentOrEventID(Integer id) {
		
		return incidentOrEventDAO.getByIncidentOrEventID(id);
	}

	/** This method delete the IncidentOrEvent objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteIncidentOrEvent(Integer id) {
		
		incidentOrEventDAO.deleteIncidentOrEvent(id);
		
	}

}
