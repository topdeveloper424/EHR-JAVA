package com.ets.dao.providerSchRecurException;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffSchRecurExceptionDAO Interface
 *Description: ProviderSchRecurException Entity DAO Interface
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
import java.util.List;

import com.ets.model.ProviderSchRecurException;

public interface StaffSchRecurExceptionDAO {

	public void saveOrUpdate(ProviderSchRecurException  staffSchRecurException);
	public void delete(Integer id);
	public List<ProviderSchRecurException> view();
	public List<ProviderSchRecurException> viewStaffSchRecurExceptionById(Integer Id);
	public List<ProviderSchRecurException> viewStaffSchRecurExceptionByProviderId(Integer Id);
	public List<ProviderSchRecurException> viewStaffSchRecurExceptionByClinicianId(Integer Id);
}
