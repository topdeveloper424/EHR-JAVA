package com.ets.service.drugScreenResult;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.drugScreenResult.DrugScreenResultDAO;
import com.ets.model.DrugScreenResult;

@Service
@Transactional
public class DrugScreenResultServiceImpl implements DrugScreenResultService{
	
	private DrugScreenResultDAO drugScreenResultDAO;

	public void setDrugScreenResultDAO(DrugScreenResultDAO drugScreenResultDAO) {
		this.drugScreenResultDAO = drugScreenResultDAO;
	}

	@Override
	public void saveOrUpdate(DrugScreenResult drugScreenResult) {
		drugScreenResultDAO.saveOrUpdate(drugScreenResult);
		
	}

	@Override
	public List<DrugScreenResult> ViewDrugScreenResult() {
		
		return drugScreenResultDAO.ViewDrugScreenResult();
	}

	@Override
	public void delete(Integer id) {
		drugScreenResultDAO.delete(id);
		
	}

	@Override
	public DrugScreenResult viewByPatientVisitId(Integer patVisitId) {
		
		return drugScreenResultDAO.viewByPatientVisitId(patVisitId);
	}

	@Override
	public DrugScreenResult viewByMedicalChargeId(Integer patVisitId, Integer medActChargeId) {
		return drugScreenResultDAO.viewByMedicalChargeId(patVisitId,medActChargeId);
	}

	@Override
	public void deleteMedActCharge(Integer id) {
		// TODO Auto-generated method stub
		drugScreenResultDAO.deleteMedActCharge(id);
		
	}

	
	}
