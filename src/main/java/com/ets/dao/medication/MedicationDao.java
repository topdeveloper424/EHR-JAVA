package com.ets.dao.medication;

import java.util.List;

import com.ets.model.AllergyCategory;
import com.ets.model.Medication;


public interface MedicationDao {

	public void saveOrUpdate(Medication medication);
	public List<Medication> view();
	
	public Medication searchByDescrip(String descrip);
	
	
}
