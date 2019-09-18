package com.ets.service.patientInsuranceCarrier;
import java.util.List;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientInsuranceCarrierServieImpl Class
 *Description: PatientInsuranceCarrier Entity Service class
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.patientInsuranceCarrier.PatientInsuranceCarrierDAO;
import com.ets.model.PatientInsuranceCarrier;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientInsuranceCarrierServieImpl Class
 *Description: PatientInsuranceCarrier Entity Service Class
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
public class PatientInsuranceCarrierServieImpl implements PatientInsuranceCarrierServie {
	
	private PatientInsuranceCarrierDAO patientInsuranceCarrierDAO;

	public void setPatientInsuranceCarrierDAO(PatientInsuranceCarrierDAO patientInsuranceCarrierDAO) {
		this.patientInsuranceCarrierDAO = patientInsuranceCarrierDAO;
	}

	@Override
	public void saveOrUpdate(PatientInsuranceCarrier patientInsuranceCarrier) {
		
		patientInsuranceCarrierDAO.saveOrUpdate(patientInsuranceCarrier);
		
	}

	@Override
	public List<PatientInsuranceCarrier> view() {
		
		return patientInsuranceCarrierDAO.view();
	}

	@Override
	public PatientInsuranceCarrier viewById(Integer id) {
		
		return patientInsuranceCarrierDAO.viewById(id);
	}

	@Override
	public void delete(Integer id) {
		patientInsuranceCarrierDAO.delete(id);
		
	}
	

}
