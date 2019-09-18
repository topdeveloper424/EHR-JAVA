package com.ets.dao.medicalcondition;

import java.util.List;

import com.ets.model.MedicalCondition;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 17-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalConditionDAO Interface
 *Description: MedicalCondition Entity DAO Interface
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

public interface MedicalConditionDao {
	
	public void addMedicalCondition(MedicalCondition medicalCondition);
	
	public List<MedicalCondition> listMedicalConditions();
	
	public void updateMedicalCondition(MedicalCondition medicalCondition);
	
	public MedicalCondition viewByCode(String code);
	public void delete(Integer id);
	
	

}
