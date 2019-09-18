package com.ets.dao.drugScreenResult;

import java.util.List;

import com.ets.model.DrugScreenResult;

public interface DrugScreenResultDAO {
	
  public void saveOrUpdate(DrugScreenResult drugScreenResult);
  public List<DrugScreenResult> ViewDrugScreenResult();
  public void delete(Integer id);
  public DrugScreenResult viewByPatientVisitId(Integer patVisitId);
  public DrugScreenResult viewByMedicalChargeId(Integer patVisitId,Integer medActChargeId);
  public void deleteMedActCharge(Integer id);
}
