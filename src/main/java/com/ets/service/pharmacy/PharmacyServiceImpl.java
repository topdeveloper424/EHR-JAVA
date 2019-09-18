package com.ets.service.pharmacy;



import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.pharmacy.PharmacyDAO;
import com.ets.model.Pharmacy;
/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 24-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PharmacyServiceImpl Class
 *Description: Pharmacy Entity Service class
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
public class PharmacyServiceImpl implements PharmacyService {
	
	private PharmacyDAO pharmacyDAO;

	public void setPharmacyDAO(PharmacyDAO pharmacyDAO) {
		this.pharmacyDAO = pharmacyDAO;
	}

	/** This method save the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param pharmacy
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addPharmacy(Pharmacy pharmacy) {
		
		pharmacyDAO.addPharmacy(pharmacy);
		
	}

	/** This method gets all the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Pharmacy objects
	 */
	@Override
	public List<Pharmacy> pharmacyList() {
		
		return pharmacyDAO.pharmacyList();
	}

	/** This method update the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param pharmacy
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updatePharmacy(Pharmacy pharmacy) {
		
		pharmacyDAO.updatePharmacy(pharmacy);
		
	}

	/** This method gets all the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Pharmacy objects
	 */
	@Override
	public Pharmacy getByPharmacyID(Integer id) {
		
		return pharmacyDAO.getByPharmacyID(id);
	}


	/** This method delete the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Pharmacy objects
	 */
	@Override
	public void deletePharmacy(Integer id) {
		
		pharmacyDAO.deletePharmacy(id);
		
	}

	@Override
	public List<Pharmacy> searchPharmacy(String phamacyName , String city , String state) {
		
		return pharmacyDAO.searchPharmacy(phamacyName, city, state);
	}
	/** This method gets all the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param name , city , state
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Pharmacy objects
	 */
	@Override
	public List<Pharmacy> searchPharmacy(String phamacyName) {
		
		return pharmacyDAO.searchPharmacy(phamacyName);
	}

	@Override
	public List<Pharmacy> searchPharmacyUsingTabKey(String phamacyName) {
		// TODO Auto-generated method stub
		return pharmacyDAO.searchPharmacyUsingTabKey(phamacyName);
	}
	
	
	
	

}
