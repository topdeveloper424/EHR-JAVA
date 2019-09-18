package com.ets.service.bodyZone;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.boyZone.BodyZoneDAO;
import com.ets.model.BodyZone;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BodyZoneServiceImpl Class
 *Description: BodyZone Entity Service class
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
public class BodyZoneServiceImpl implements BodyZoneService{
	
	private BodyZoneDAO bodyZoneDAO;

	public void setBodyZoneDAO(BodyZoneDAO bodyZoneDAO) {
		this.bodyZoneDAO = bodyZoneDAO;
	}


	/** This method save the body zone objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param bodyZone
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void addBodyZone(BodyZone bodyZone) {
		
		bodyZoneDAO.addBodyZone(bodyZone);
		
	}

	/** This method gets all the body zone objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BodyZone objects
	 */
	@Override
	public List<BodyZone> bodyZoneList() {
		
		return bodyZoneDAO.bodyZoneList();
	}


	/** This method update the body zone objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param bodyZone
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void updateBodyZone(BodyZone bodyZone) {
		
		this.bodyZoneDAO.updateBodyZone(bodyZone);
		
	}

	/** This method gets all the body zone objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BodyZone objects
	 */
	@Override
	public BodyZone getbyBodyZoneID(Integer id) {
		
		return bodyZoneDAO.getbyBodyZoneID(id);
	}

	/** This method Delete the body zone objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void deleteBodyZoneCode(Integer id) {
		
		bodyZoneDAO.deleteBodyZoneCode(id);
	}
	
	

}
