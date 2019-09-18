package com.ets.dao.clinicianSchRecurException;

import java.util.List;

import com.ets.model.ClinicianSchRecurException;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianSchRecurExceptionDAO Interface
 *Description: ClinicianSchRecurException Entity DAO Interface
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

public interface ClinicianSchRecurExceptionDAO {
public void saveOrUpdate(ClinicianSchRecurException clinicianSchRecurException);
public void delete(Integer id);
public List<ClinicianSchRecurException> view();
public List<ClinicianSchRecurException> viewClinicianSchRecurExceptionById(Integer Id);

}
