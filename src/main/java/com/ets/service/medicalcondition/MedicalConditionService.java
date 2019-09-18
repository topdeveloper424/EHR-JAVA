package com.ets.service.medicalcondition;

import java.util.List;

import com.ets.model.MedicalCondition;

public interface MedicalConditionService {
	
public void addMedicalCondition(MedicalCondition medicalCondition);
	
	public List<MedicalCondition> listMedicalConditions();
	
	public void updateMedicalCondition(MedicalCondition medicalCondition);
	
	public MedicalCondition viewByCode(String code);
	public void delete(Integer id);

}
