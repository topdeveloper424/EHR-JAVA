package com.ets.service.incidentOrEvent;

import java.util.List;

import com.ets.model.IncidentOrEvent;

public interface IncidentOrEventService {

	public void addIncidentOrEvent(IncidentOrEvent incidentOrEvent);

	public List<IncidentOrEvent> incidentOrEventLists();

	public void updateIncidentOrEvent(IncidentOrEvent incidentOrEvent);

	public IncidentOrEvent getByIncidentOrEventID(Integer id);

	public void deleteIncidentOrEvent(Integer id);

}
