package com.ets.service.patient;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientServiceImpl Class
 *Description: Patient Entity Service class
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

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.patient.PatientDAO;
import com.ets.model.Patient;

import javafx.util.Callback;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	private PatientDAO patientDAO;

	public void setPatientDAO(PatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

	@Override
	public void saveOrupdate(Patient patient) {
		patientDAO.saveOrUpdate(patient);

	}

	@Override
	public List<Patient> searchPatientByName(String firstName, String lastName, Date dob,Integer clinic) {
		
		
		return  patientDAO.searchPatientByName(firstName,lastName,dob,clinic) ;
	}

	@Override
	public Patient getById(Integer id) {
		
		return patientDAO.getById(id);
	}

	@Override
	public List<Patient> view(Integer id) {
		
		return patientDAO.view(id);
	}

	@Override
	public Patient viewByPatientId(Integer id) {
		
		return patientDAO.viewByPatientId(id);
	}

	public List<Patient> viewSortedPatients(String c) {
		// TODO Auto-generated method stub
		return patientDAO.viewSortedPatients(c);
	}

	@Override
	public List<Patient> search(Date date1, Date date2) {
		
		
		return  patientDAO.search(date1,date2) ;
	}

	
	
}
