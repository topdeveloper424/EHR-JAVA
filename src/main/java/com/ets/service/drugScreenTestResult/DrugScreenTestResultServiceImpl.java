package com.ets.service.drugScreenTestResult;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.drugScreenDrugTestResult.DrugScreenTestResultDAO;
import com.ets.model.DrugScreenTestResult;

@Service
@Transactional
public class DrugScreenTestResultServiceImpl implements DrugScreenTestResultService {
	
	private DrugScreenTestResultDAO drugScreenTestResultDAO;

	public void setDrugScreenTestResultDAO(DrugScreenTestResultDAO drugScreenTestResultDAO) {
		this.drugScreenTestResultDAO = drugScreenTestResultDAO;
	}

	@Override
	public void saveOrUpdate(DrugScreenTestResult drugScreenTestResult) {
		
		drugScreenTestResultDAO.saveOrUpdate(drugScreenTestResult);
		
	}

				
	@Override
	public void deleteDrugScreenResult(Integer id){
		drugScreenTestResultDAO.deleteDrugScreenResult(id);
	}
	
			
	@Override
	public List<DrugScreenTestResult> view() {
		
		return drugScreenTestResultDAO.view();
	}

	@Override
	public List<DrugScreenTestResult> viewByPatient(Integer id) {
		
		return drugScreenTestResultDAO.viewByPatient(id);
	}

	@Override
	public DrugScreenTestResult viewByPatientId(Integer id) {
		// TODO Auto-generated method stub
		return drugScreenTestResultDAO.viewByPatientId(id);
	}

	@Override
	public List<DrugScreenTestResult> viewByPatientVisit(Integer id) {
		// TODO Auto-generated method stub
		return drugScreenTestResultDAO.viewByPatientVisit(id);
	}

	@Override
	public List<DrugScreenTestResult> viewByPatientVisitAndMedActivity(Integer pVisitid, String medCode, Integer drugScreenId) {
		// TODO Auto-generated method stub
		return drugScreenTestResultDAO.viewByPatientVisitAndMedActivity(pVisitid, medCode, drugScreenId);
		
	}

	@Override
	public List<DrugScreenTestResult> viewByDrugScreenDrugName(Integer pVisitid, String medCode, Integer drugScreenId,
			String drugName) {
		// TODO Auto-generated method stub
		return drugScreenTestResultDAO.viewByDrugScreenDrugName(pVisitid, medCode, drugScreenId, drugName);
	}

}
