package com.ets.service.billingservicetype;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.billingservicetype.BillingServiceTypeDAO;
import com.ets.model.BillingServiceType;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BillingTypeServiceImpl Class
 *Description: BillingServiceType Entity Service class
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
public class BillingTypeServiceImpl implements BillingTypeService {
	
	private BillingServiceTypeDAO billingServiceTypeDAO;

	public void setBillingServiceTypeDAO(BillingServiceTypeDAO billingServiceTypeDAO) {
		this.billingServiceTypeDAO = billingServiceTypeDAO;
	}

	/** This method save the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param billingServiceType
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void addBillingServiceType(BillingServiceType billingServiceType) {
		
		billingServiceTypeDAO.addBillingServiceType(billingServiceType);
		
		
	}

	/** This method gets all the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BillingServiceType objects
	 */
	@Override
	public List<BillingServiceType> billingServiceTypeLists() {
		
		return billingServiceTypeDAO.billingServiceTypeLists();
	}

	/** This method update the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param billingServiceType
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void updateBillingServiceType(BillingServiceType billingServiceType) {
		
		billingServiceTypeDAO.updateBillingServiceType(billingServiceType);
		
	}

	/** This method gets all the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BillingServiceType objects
	 */
	@Override
	public BillingServiceType getByBillingServiceTypeID(Integer id) {
		
		return billingServiceTypeDAO.getByBillingServiceTypeID(id);
	}

	/** This method remove the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void deleteBillingServiceType(Integer id) {
		
		billingServiceTypeDAO.deleteBillingServiceType(id);
		
	}

	/** This method gets  the BillingServiceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 31-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BillingServiceType objects
	 */
	
	@Override
	public BillingServiceType viewById(Integer id) {
		// TODO Auto-generated method stub
		return billingServiceTypeDAO.viewById(id);
	}
	
	

}
