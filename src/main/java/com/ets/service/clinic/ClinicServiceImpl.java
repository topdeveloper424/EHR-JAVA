package com.ets.service.clinic;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.clinic.ClinicDAO;
import com.ets.model.Clinic;
import com.ets.model.Patient;

import javafx.fxml.Initializable;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 17-05-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicServiceImpl Class
 *Description: Clinic Entity Service class
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
public class ClinicServiceImpl implements ClinicService {

	private ClinicDAO clinicDAO;

	public void setClinicDAO(ClinicDAO clinicDAO) {
		this.clinicDAO = clinicDAO;
	}

	/** This method save the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param clinic
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void add(Clinic clinic) {
		clinicDAO.add(clinic);
		
	}
	
/*	@Override
	public List<Patient> searchClinicByName(String firstName, String lastName, Date dob,Integer clinic) {
		
		
		return  clinicDAO.searchClinicByName(firstName,lastName,dob,clinic) ;
	}*/

	/** This method gets all the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Clinic objects
	 */
	@Override
	public List<Clinic> list() {
		
		return clinicDAO.list();
	}

	/** This method update the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param clinic
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void update(Clinic clinic) {
		clinicDAO.update(clinic);
		
	}

	/** This method gets  the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Clinic objects
	 */
	@Override
	public Clinic getByID(Integer id) {
		
		return clinicDAO.getByID(id);
	}

	/** This method delete  the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	
	@Override
	public void delete(Integer id) {
		clinicDAO.delete(id);
		
	}

	/** This method get  the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param clinicName
	 * @since 17-05-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public List<Clinic> search(String clinicName) {
		
		return clinicDAO.search(clinicName);
	}
	
	/** This method get  the Clinic objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param 
	 * @since 26-08-2016
	 * @version 1.0
	 * 
	 * @return clinicName
	 */

	@Override
	public Clinic viewByName(String clinicName) {
		
		return clinicDAO.viewByName(clinicName);
		
	}
	
	
}
