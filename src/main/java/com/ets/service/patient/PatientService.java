package com.ets.service.patient;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientService Interface
 *Description: Patient Entity Service Interface
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
import java.util.Date;
import java.util.List;

import com.ets.model.Patient;

public interface PatientService {
	public void saveOrupdate(Patient patient);

	public List<Patient> searchPatientByName(String firstName, String lastName, Date dob, Integer clinic);
	
	public Patient getById(Integer id);
	public List<Patient> view(Integer id);
	public Patient viewByPatientId(Integer id);
	public List<Patient> viewSortedPatients(String c);
	public List<Patient> search(Date date1, Date date2);
}
