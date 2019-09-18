package com.ets.controller.entity.pharmacy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Pharmacy;
import com.ets.service.pharmacy.PharmacyServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 24-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PharmacyEntityController Class
 *Description: Pharmacy Entity Non-GUI Controller class
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

public class PharmacyEntityController {

	//private static ClassPathXmlApplicationContext context;

	private PharmacyServiceImpl pharmacyServiceImpl;

	private ObservableList<Pharmacy> observableList;

	public PharmacyEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		pharmacyServiceImpl = (PharmacyServiceImpl) Global.context
				.getBean("pharmacyService");
		observableList = FXCollections.observableArrayList();

	}

	

	/** This method save the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param pharmacy
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void savePharmacy(Pharmacy pharmacy) {

		pharmacyServiceImpl.addPharmacy(pharmacy);
		//this.closeApplicationConrext();
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
	public ObservableList<Pharmacy> viewPharmacy() {

		observableList = FXCollections.observableArrayList(pharmacyServiceImpl
				.pharmacyList());
		//this.closeApplicationConrext();
		return observableList;

	}
	
	/** This method gets all the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param phamacyName , city , state
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Pharmacy objects
	 */
		public ObservableList<Pharmacy> searchPharmacy(String phamacyName , String city , String state) {

			observableList = FXCollections.observableArrayList(pharmacyServiceImpl.searchPharmacy(phamacyName, city, state));
			//this.closeApplicationConrext();
			return observableList;

		}
		
		/** This method gets all the Pharmacy objects currently present in the system .
		 * 
		 * @author Sumanta Deyashi
		 * @param phamacyName 
		 * @since 24-02-2016
		 * @version 1.0
		 * 
		 * @return ObservableList of Pharmacy objects
		 */
	public ObservableList<Pharmacy> searchPharmacy(String phamacyName) {
          
		observableList = FXCollections.observableArrayList(pharmacyServiceImpl
				.searchPharmacy(phamacyName));
		//this.closeApplicationConrext();
		return observableList;

	}

	/** This method gets all the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param phamacyName 
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Pharmacy objects
	 */
	public ObservableList<Pharmacy> searchPharmacyUsingTabKey(String phamacyName) {
             
		observableList = FXCollections.observableArrayList(pharmacyServiceImpl.searchPharmacyUsingTabKey(phamacyName)
				);
		//this.closeApplicationConrext();
		return observableList;

	}


	
	/** This method update the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param pharmacy
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void updatePharmacy(Pharmacy pharmacy){
		     
		pharmacyServiceImpl.updatePharmacy(pharmacy);
		////this.closeApplicationConrext();
	}
	
	/** This method delete the Pharmacy objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void removePharmacy(Integer id){
		
		pharmacyServiceImpl.deletePharmacy(id);
		//this.closeApplicationConrext();
		
	}
	
	

}
