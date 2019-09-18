package com.ets.service.medication;

import java.util.List;

import com.ets.model.Medication;

public interface MedicationService {

	public void saveOrUpdate(Medication medication);
	public List<Medication> view();
	public Medication searchByName(String medName);
}
