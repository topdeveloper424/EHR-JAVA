package com.ets.service.medicalactivity;



import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.model.MedicalActivity;
import com.ets.dao.medicalactivity.MedicalActivityDAO;
/**
 *Original Author: Shazarin Farha on Behalf of ETS for Client Company
 *File Creation Date: 09-05-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalActivityServiceImpl Class
 *Description: Medical Activity Entity Service class
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
public class MedicalActivityServiceImpl implements MedicalActivityService {
	
	private MedicalActivityDAO medicalActivityDAO;
	
	public void setMedicalActivityDAO(MedicalActivityDAO medicalActivityDAO) {
		this.medicalActivityDAO = medicalActivityDAO;
	}
	
	/** This method save the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param medicalActivity
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addMedicalActivity(MedicalActivity medicalActivity) {
		medicalActivityDAO.addMedicalActivity(medicalActivity);
		
	}
	
	/** This method gets all the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param Nothing
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicalActivity objects
	 */
	@Override
	public List<MedicalActivity> medicalActivityList() {
		
		return medicalActivityDAO.medicalActivityList();
	}

	/** This method update the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param medicalActivity
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateMedicalActivity(MedicalActivity medicalActivity) {
		
		medicalActivityDAO.updateMedicalActivity(medicalActivity);
		
	}

	/** This method gets all the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param id
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicalActivity objects
	 */
	@Override
	public MedicalActivity getByMedicalActivityID(Integer id) {
		
		return medicalActivityDAO.getByMedicalActivityID(id);
	}

	/** This method delete the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param id
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteMedicalActivity(Integer id) {
		
		medicalActivityDAO.deleteMedicalActivity(id);
		
	}

	@Override
	public List<MedicalActivity> viewMedicalActivityById(Integer id) {
		
		return medicalActivityDAO.viewMedicalActivityById(id);
	}

	/** This method delete the MedicalActivity objects currently present in the system .
	 * 
	 * @author Shazarin Farha
	 * @param code
	 * @since 09-05-2016
	 * @version 1.0
	 * 
	 * @return object
	 */
	@Override
	public MedicalActivity viewByCode(String code) {
		
		return medicalActivityDAO.viewByCode(code);
	}

	@Override
	public MedicalActivity searchByDescription(String descp) {
		// TODO Auto-generated method stub
		return medicalActivityDAO.searchByDescription(descp);
	}
	
	

}
