package com.ets.service.medicationClass;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.medicationClass.MedicationClassDAO;
import com.ets.model.MedicationClass;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicationClassServiceImpl Class
 *Description: MedicationClass Entity Service class
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
public class MedicationClassServiceImpl implements MedicationClassService {
	
	private MedicationClassDAO medicationClassDAO;

	public void setMedicationClassDAO(MedicationClassDAO medicationClassDAO) {
		this.medicationClassDAO = medicationClassDAO;
	}
	/** This method save the MedicationClass objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param medicationClass
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void add(MedicationClass medicationClass) {

		medicationClassDAO.add(medicationClass);
		
	}
	/** This method gets all the MedicationClass objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicationClass objects
	 */
	@Override
	public List<MedicationClass> list() {
		
		return medicationClassDAO.list();
	}
	/** This method update the MedicationClass objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param medicationClass
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void update(MedicationClass medicationClass) {

		medicationClassDAO.update(medicationClass);
		
	}
	/** This method gets all the MedicationClass objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of MedicationClass objects
	 */
	@Override
	public MedicationClass getByID(Integer id) {
		
		return medicationClassDAO.getByID(id);
	}
	/** This method delete the MedicationClass objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void delete(Integer id) {
	
		medicationClassDAO.delete(id);
		
	}

	@Override
	public MedicationClass getByName(String name) {
		// TODO Auto-generated method stub
		return medicationClassDAO.getByName(name);
	}

	

}
