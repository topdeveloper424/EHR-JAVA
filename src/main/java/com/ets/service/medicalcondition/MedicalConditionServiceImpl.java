package com.ets.service.medicalcondition;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.medicalcondition.MedicalConditionDao;
import com.ets.model.MedicalCondition;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 17-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalConditionServiceImpl Class
 *Description: MedicalCondition Entity Service class
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
@Service
@Transactional
public class MedicalConditionServiceImpl implements MedicalConditionService {
	
	private MedicalConditionDao medicalConditionDAO;
	
	
	public void setMedicalConditionDAO(MedicalConditionDao medicalConditionDAO) {
		this.medicalConditionDAO = medicalConditionDAO;
	}
	/** This method save the MedicalCondition objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param medicalCondition
	 * @since 17-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addMedicalCondition(MedicalCondition medicalCondition) {
		
		medicalConditionDAO.addMedicalCondition(medicalCondition);
		
	}
	/** This method gets all the MedicalCondition objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 17-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicalCondition objects
	 */
	@Override
	public List<MedicalCondition> listMedicalConditions() {
		
		return medicalConditionDAO.listMedicalConditions();
	}

	/** This method update the MedicalCondition objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param medicalCondition
	 * @since 17-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateMedicalCondition(MedicalCondition medicalCondition) {
		
		medicalConditionDAO.updateMedicalCondition(medicalCondition);
		
	}
	
	/** This method gets all the MedicalCondition objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param code
	 * @since 17-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicalCondition objects
	 */
	@Override
	public MedicalCondition viewByCode(String code) {
		
		return medicalConditionDAO.viewByCode(code);
	}
	@Override
	public void delete(Integer id) {
		medicalConditionDAO.delete(id);
		
	}

}
