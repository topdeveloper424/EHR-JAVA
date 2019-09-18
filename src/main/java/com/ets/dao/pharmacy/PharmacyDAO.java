package com.ets.dao.pharmacy;

import java.util.List;

import com.ets.model.Pharmacy;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 24-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PharmacyDAO Interface
 *Description: Pharmacy Entity DAO Interface
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

public interface PharmacyDAO {
	
	public void addPharmacy(Pharmacy pharmacy);
	
	public List<Pharmacy> pharmacyList();
	
	public void updatePharmacy(Pharmacy pharmacy);
	
	public Pharmacy getByPharmacyID(Integer id);
	
	public void deletePharmacy(Integer id);
	
	public List<Pharmacy> searchPharmacy(String phamacyName );
	
	public List<Pharmacy> searchPharmacy(String phamacyName , String city , String state);
	
	public List<Pharmacy> searchPharmacyUsingTabKey(String phamacyName );

}
