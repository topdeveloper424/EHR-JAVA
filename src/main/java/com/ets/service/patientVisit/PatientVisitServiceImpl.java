package com.ets.service.patientVisit;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.patientVisit.PatientVisitDAO;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.Patient;
import com.ets.model.PatientAppointment;
import com.ets.model.PatientVisit;

import javafx.util.Callback;

@Service
@Transactional
public class PatientVisitServiceImpl implements PatientVisitService {
	
	private PatientVisitDAO patientVisitDAO;

	public void setPatientVisitDAO(PatientVisitDAO patientVisitDAO) {
		this.patientVisitDAO = patientVisitDAO;
	}

	@Override
	public void saveOrUpdate(PatientVisit patientVisit) {
		
		patientVisitDAO.saveOrUpdate(patientVisit);
		
	}

	@Override
	public List<PatientVisit> view() {
		
		return patientVisitDAO.view();
	}

	@Override
	public List<PatientVisit> viewByDate(Date fromDate,Date toDate) {
		
		return patientVisitDAO.viewByDate(fromDate, toDate);
	}

	@Override
	public List<PatientVisit> viewByDateOne(Date fromDate) {
		
		return patientVisitDAO.viewByDateOne(fromDate);
	}

	@Override
	public List<PatientVisit> viewByPat(Integer patId) {
		// TODO Auto-generated method stub
		return patientVisitDAO.viewByPat(patId);
	}

	@Override
	public List<PatientVisit> viewByDate(Date date) {
		// TODO Auto-generated method stub
		return patientVisitDAO.viewByDate(date);
	}

	@Override
	public PatientVisit ViewByNameAndDate(String firstName, String latName, String inTime) {
		
		return patientVisitDAO.ViewByNameAndDate(firstName, latName, inTime);
	}

	@Override
	public void delete(Integer id) {
		patientVisitDAO.delete(id);
		
	}

	@Override
	public PatientVisit viewByPatientVisitId(Integer id) {
		
		return patientVisitDAO.viewByPatientVisitId(id);
	}

	
	
	
	
	
	@Override
	public List<PatientVisit> viewBypatIdAndVDate(Integer patId, Date visitDate) {
		
		return patientVisitDAO.viewBypatIdAndVDate(patId, visitDate);
	}

	@Override
	public void deleteIcd(PatientVisit patvisitId) {
		patientVisitDAO.delete(patvisitId.getId());
		
	}

	@Override
	public List<PatientVisit> viewByProtocolId(Integer protocolId) {
		// TODO Auto-generated method stub
		return patientVisitDAO.viewByProtocolId(protocolId);
	}

	@Override
	public void setProtocol(Integer protocolId) {
		patientVisitDAO.setProtocol(protocolId);
		
	}

	@Override
	public List<PatientVisit> searchPatient(Date fromDate, Date toDate,Integer Id) {
		
		
		return  patientVisitDAO.searchPatient(fromDate,toDate,Id) ;
	}


}
