package com.ets.dao.incidentOrEvent;

import java.util.List;

import com.ets.model.IncidentOrEvent;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of IncidentOrEventDAO Interface
 *Description: IncidentOrEvent Entity DAO class
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

public interface IncidentOrEventDAO {
	
	public void addIncidentOrEvent(IncidentOrEvent incidentOrEvent);
	
	public List<IncidentOrEvent> incidentOrEventLists();
	
	public void updateIncidentOrEvent(IncidentOrEvent incidentOrEvent);
	
	public IncidentOrEvent getByIncidentOrEventID(Integer id);
	
	public void deleteIncidentOrEvent(Integer id);

}
