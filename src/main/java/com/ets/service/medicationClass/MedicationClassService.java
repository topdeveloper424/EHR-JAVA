package com.ets.service.medicationClass;

import java.util.List;

import com.ets.model.MedicationClass;

public interface MedicationClassService {
	
	public void add(MedicationClass medicationClass);

	public List<MedicationClass> list();

	public void update(MedicationClass medicationClass);

	public MedicationClass getByID(Integer id);

	public MedicationClass getByName(String name);


	public void delete(Integer id);

}
