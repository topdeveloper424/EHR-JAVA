package com.ets.service.denialOrShortPayReason;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.denialOrShortPayReason.DenialOrShortPayReasonDAO;
import com.ets.model.DenialOrShortPayReason;


/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 02-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DenialOrShortPayReasonServiceImpl Class
 *Description: DenialOrShortPayReason Entity Service Class
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
public class DenialOrShortPayReasonServiceImpl implements DenialOrShortPayReasonService{
	
	private DenialOrShortPayReasonDAO denialOrShortPayReasonDAO;

	public void setDenialOrShortPayReasonDAO(DenialOrShortPayReasonDAO denialOrShortPayReasonDAO) {
		this.denialOrShortPayReasonDAO = denialOrShortPayReasonDAO;
	}

	/** This method save the DenialOrShortPayReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param denialOrShortPayReason
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void add(DenialOrShortPayReason denialOrShortPayReason) {
		denialOrShortPayReasonDAO.add(denialOrShortPayReason);
		
	}

	/** This method gets all the DenialOrShortPayReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DenialOrShortPayReason objects
	 */
	
	@Override
	public List<DenialOrShortPayReason> list() {
		
		return denialOrShortPayReasonDAO.list();
	}

	/** This method update the denialOrShortPayReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param denialOrShortPayReason
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void update(DenialOrShortPayReason denialOrShortPayReason) {
		denialOrShortPayReasonDAO.update(denialOrShortPayReason);
		
	}

	/** This method gets all the DenialOrShortPayReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DenialOrShortPayReason objects
	 */
	
	@Override
	public DenialOrShortPayReason getByID(Integer id) {
		
		return denialOrShortPayReasonDAO.getByID(id);
	}

	/** This method Remove the DenialOrShortPayReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void delete(Integer id) {
		denialOrShortPayReasonDAO.delete(id);
		
	}
	

}
