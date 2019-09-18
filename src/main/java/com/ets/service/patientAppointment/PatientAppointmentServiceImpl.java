package com.ets.service.patientAppointment;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.patientAppointment.PatientAppointmentDAO;
import com.ets.model.PatientAppointment;

@Service
@Transactional
public class PatientAppointmentServiceImpl implements PatientAppointmentService {
	
	private PatientAppointmentDAO patientAppointmentDAO;

	public void setPatientAppointmentDAO(PatientAppointmentDAO patientAppointmentDAO) {
		this.patientAppointmentDAO = patientAppointmentDAO;
	}

	@Override
	public void saveOrUpdate(PatientAppointment patientAppointment) {

		patientAppointmentDAO.save(patientAppointment);
	}

	@Override
	public List<PatientAppointment> viewByDate(Date date) {
		// TODO Auto-generated method stub
		return patientAppointmentDAO.viewByDate(date);
	}

	@Override

	public List<PatientAppointment> viewById(Integer patentId) {
		// TODO Auto-generated method stub
		return patientAppointmentDAO.viewById(patentId);
	}

	public List<PatientAppointment> viewByProiderAndDate(Date date, Integer id) {
		
		return patientAppointmentDAO.viewByProiderAndDate(date, id);

	}

	@Override
	public List<PatientAppointment> viewByNameAndDate(String firstName, String lastName, Date date) {
		
		return patientAppointmentDAO.viewByNameAndDate(firstName, lastName, date);
	}

	@Override
	public List<PatientAppointment> viewByNameDateProviderId(String firstName, String lastName, Date date,
			String purpose) {
		// TODO Auto-generated method stub
		return patientAppointmentDAO.viewByNameDateProviderId(firstName, lastName, date,purpose);
	}

	@Override

public List<PatientAppointment>viewByNameDateProviderAndTime(Date date,String time,String provider){

		// TODO Auto-generated method stub
		return patientAppointmentDAO.viewByNameDateProviderAndTime(date, time, provider);
	}

	@Override
	public List<PatientAppointment> viewByNameDateProviderPurpose(String firstName, String lastName, Date date,
			String purpose, String providerFirst, String providerLast, String status) {
		// TODO Auto-generated method stub
		return patientAppointmentDAO.viewByNameDateProviderPurpose(firstName, lastName, date, purpose, providerFirst, providerLast, status);
	}

	@Override
	public void delete(Integer id) {
		patientAppointmentDAO.delete(id);
		
	}

	@Override
	public List<PatientAppointment> viewByBothProvider(String firstName, String lastName, String firstName1,
			String lastName1, Date date) {
		// TODO Auto-generated method stub
		return patientAppointmentDAO.viewByBothProvider(firstName, lastName, firstName1, lastName1, date);
	}

	@Override
	public List<PatientAppointment> viewByProvider(String firstName, String lastname) {
		// TODO Auto-generated method stub
		return patientAppointmentDAO.viewByProvider(firstName, lastname);
	}

}
