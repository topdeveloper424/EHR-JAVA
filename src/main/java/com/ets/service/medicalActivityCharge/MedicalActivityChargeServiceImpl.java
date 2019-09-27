package com.ets.service.medicalActivityCharge;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.medicalActivityCharge.MedicalActivityChargeDAO;
import com.ets.model.Clinic;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.PatientVisit;

@Service
@Transactional
public class MedicalActivityChargeServiceImpl implements MedicalActivityChargeService{
   
	private MedicalActivityChargeDAO medicalActivityChargeDAO;
	public void setMedicalActivityChargeDAO(MedicalActivityChargeDAO medicalActivityChargeDAO) {
		this.medicalActivityChargeDAO = medicalActivityChargeDAO;
	}

	@Override
	public void saveOrUpdate(MedicalActivityCharge medicalActivityCharge) {
		medicalActivityChargeDAO.saveOrUpdate(medicalActivityCharge);
		
	}

	/*@Override
	public List<MedicalActivityCharge> viewMedicalActivityCharge() {
	
		return medicalActivityChargeDAO.viewMedicalActivityCharge();
				
	}*/

	
	
	
	
	
	
	
	
	@Override
	public List<MedicalActivityCharge> list() {
		
		
		return medicalActivityChargeDAO.list();
	}
	
	
	
	
	
	
	
	@Override
	public List<MedicalActivityCharge> viewMedicalActivityCharge(Integer id,Boolean checkBillingStatus) {
	
		return medicalActivityChargeDAO.viewMedicalActivityCharge(id,checkBillingStatus);
				
	}
	
	
	
	@Override
	public void delete(Integer id) {
		medicalActivityChargeDAO.delete(id);
		
	}

	@Override
	public List<MedicalActivityCharge> viewByMedicalActivityId(Integer id) {
		
		return medicalActivityChargeDAO.viewByMedicalActivityId(id);
	}

	@Override
	public List<MedicalActivityCharge> searchByDateAndOverride(Date fromDate, Date toDate, String Override) {
		
		return medicalActivityChargeDAO.searchByDateAndOverride(fromDate, toDate, Override);
	}

	@Override
	public MedicalActivityCharge searchForDrugScreen(Date date, String medicalActivityCode, PatientVisit patientVisit) {
		// TODO Auto-generated method stub
		return medicalActivityChargeDAO.searchForDrugScreen(date, medicalActivityCode, patientVisit);
	}

	@Override
	public List<MedicalActivityCharge> searchByDatePatientBillingStatus(Date date) {
		// TODO Auto-generated method stub
		return medicalActivityChargeDAO.searchByDatePatientBillingStatus(date);
	}

	@Override
	public List<MedicalActivityCharge> searchByPatientVisit(Integer patientVisitId) {
		// TODO Auto-generated method stub
		return medicalActivityChargeDAO.searchByPatientVisit(patientVisitId);
	}

	@Override
	public List<MedicalActivityCharge> searchByPatient(Integer patientId) {
		// TODO Auto-generated method stub
		return medicalActivityChargeDAO.searchByPatient(patientId);
	}
	
	@Override
	public Double getTotalChargeForPatVisit(Integer patVisitId) {
		// TODO Auto-generated method stub
		return medicalActivityChargeDAO.getTotalChargeForPatVisit(patVisitId);
	}	
	
}
