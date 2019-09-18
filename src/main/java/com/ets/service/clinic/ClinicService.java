package com.ets.service.clinic;

import java.util.Date;
import java.util.List;

import com.ets.model.Clinic;
import com.ets.model.Patient;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 17-05-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicService Interface
 *Description: Clinic Entity Service Interface
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
public interface ClinicService {
	
	public void add(Clinic clinic);
	
	public List<Clinic> list();
	
	public void update(Clinic clinic);
	
	public Clinic getByID(Integer id);
	
	
	/*public List<Patient> searchClinicByName(String firstName, String lastName, Date dob, Integer clinic);*/
	
	
	
	
	
	public void delete(Integer id);
	
	public List<Clinic> search(String clinicName);
	
	public Clinic viewByName(String clinicName);
}
