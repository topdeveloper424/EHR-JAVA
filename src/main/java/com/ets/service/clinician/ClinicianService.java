package com.ets.service.clinician;

import java.util.List;

import com.ets.model.Clinician;
import com.ets.model.Provider;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianService Interface
 *Description: Clinician Entity Service Interface
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
public interface ClinicianService {
	
	public void saveOrUpdate(Clinician clinician);
	
	public List<Clinician> view();
	
	public void delete(Integer id);
	
	public Clinician viewById(Integer id);
	public Clinician viewByCode(String code);

}
