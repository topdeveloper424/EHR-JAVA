package com.ets.service.patientAuthRep;
import java.util.List;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientAuthRepServiceImpl Class
 *Description: PatientAuthRep Entity Service class
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
import com.ets.dao.patientAuthRep.PatientAuthRepDAO;
import com.ets.model.PatientAuthRep;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientAuthRepServiceImpl Class
 *Description: PatientAuthRep Entity DAO Class
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
public class PatientAuthRepServiceImpl implements PatientAuthRepService {
	
	private PatientAuthRepDAO patientAuthRepDAO;

	public void setPatientAuthRepDAO(PatientAuthRepDAO patientAuthRepDAO) {
		this.patientAuthRepDAO = patientAuthRepDAO;
	}

	@Override
	public void saveOrUpdate(PatientAuthRep patientAuthRep) {
		
		patientAuthRepDAO.saveOrUpdate(patientAuthRep);
		
	}

	@Override
	public List<PatientAuthRep> view() {
		
		return patientAuthRepDAO.view();
	}

	@Override
	public PatientAuthRep viewById(Integer id) {
		
		return patientAuthRepDAO.viewById(id);
	}

	@Override
	public void delete(Integer id) {
		patientAuthRepDAO.delete(id);
		
	}
	

}
