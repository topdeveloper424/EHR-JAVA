package com.ets.dao.clinician;

import java.util.List;

import com.ets.model.Clinician;
import com.ets.model.Provider;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 21-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianDAO Interface
 *Description: Clinician Entity DAO Interface
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

public interface ClinicianDAO {

	public void saveOrUpdate(Clinician clinician);

	public List<Clinician> view();

	public void delete(Integer id);
	
	public Clinician viewByCode(String code);
	
	public Clinician viewById(Integer id);
}
