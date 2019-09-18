package com.ets.dao.medicationClass;

import java.util.List;

import com.ets.model.MedicationClass;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicationClassDAO Interface
 *Description: MedicationClass Entity DAO Interface
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

public interface MedicationClassDAO {
	
	public void add(MedicationClass medicationClass);

	public List<MedicationClass> list();

	public void update(MedicationClass medicationClass);

	public MedicationClass getByID(Integer id);

	public MedicationClass getByName(String name);


	public void delete(Integer id);

}
