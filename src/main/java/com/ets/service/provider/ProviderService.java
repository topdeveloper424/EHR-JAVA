package com.ets.service.provider;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ProviderService Interface
 *Description: Provider Entity Service Interface
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

import com.ets.model.Provider;

public interface ProviderService {
	
	public void addOrUpdate(Provider provider);
	
	public List<Provider> view();
	public void delete(Integer id);
	public Provider viewById(Integer id);
	public Provider viewByCode(String code);
	public List<Provider> viewByClinicId(Integer clinicId);

}
