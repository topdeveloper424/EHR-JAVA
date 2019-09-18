package com.ets.service.pharmacy;

import java.util.List;

import com.ets.model.Pharmacy;

public interface PharmacyService {

	public void addPharmacy(Pharmacy pharmacy);

	public List<Pharmacy> pharmacyList();

	public void updatePharmacy(Pharmacy pharmacy);

	public Pharmacy getByPharmacyID(Integer id);

	public void deletePharmacy(Integer id);
	
	public List<Pharmacy> searchPharmacy(String phamacyName );
	
	public List<Pharmacy> searchPharmacy(String phamacyName , String city , String state);
	
	public List<Pharmacy> searchPharmacyUsingTabKey(String phamacyName );

}
