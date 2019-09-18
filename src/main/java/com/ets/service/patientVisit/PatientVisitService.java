package com.ets.service.patientVisit;

import java.util.Date;
import java.util.List;

import com.ets.model.MedicalActivityCharge;
import com.ets.model.PatientAppointment;
import com.ets.model.PatientVisit;

public interface PatientVisitService {
	
	public void saveOrUpdate(PatientVisit patientVisit);
	public List<PatientVisit> view();
	public List<PatientVisit> viewByDate(Date fromDate,Date toDate);
	public List<PatientVisit> viewByDateOne(Date fromDate);
	public List<PatientVisit> viewByPat(Integer patId);
	public List<PatientVisit> viewByDate(Date date);
	public PatientVisit ViewByNameAndDate(String firstName , String latName , String inTime);
	public void delete(Integer id);
	public PatientVisit viewByPatientVisitId(Integer id);
	public List<PatientVisit> viewBypatIdAndVDate(Integer patId , Date visitDate);
	public void deleteIcd(PatientVisit patvisitId);
	public void setProtocol(Integer protocolId);
    public List<PatientVisit> viewByProtocolId(Integer protocolId);
	public List<PatientVisit> searchPatient(Date fromDate, Date toDate, Integer Id);

}
