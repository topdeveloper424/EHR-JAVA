package com.ets.service.medActResultCode;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.medActResultCode.MedActResultCodeDAO;
import com.ets.model.MedActResultCode;


/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 31-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedActResultCodeServiceImpl Class
 *Description: MedActResultCode Entity Service class
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
public class MedActResultCodeServiceImpl implements MedActResultCodeService {
	
	private MedActResultCodeDAO medActResultCodeDAO;

	public void setMedActResultCodeDAO(MedActResultCodeDAO medActResultCodeDAO) {
		this.medActResultCodeDAO = medActResultCodeDAO;
	}

	/** This method Save or update the medActResultCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param medActResultCode
	 * @since 31-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void addOrUpdate(MedActResultCode medActResultCode) {
		
		medActResultCodeDAO.addOrUpdate(medActResultCode);
		
	}
	

}
