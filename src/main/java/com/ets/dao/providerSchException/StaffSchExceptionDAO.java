package com.ets.dao.providerSchException;
import java.util.Date;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffSchExceptionDAO Interface
 *Description: ProviderSchException Entity DAO Interface
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

import com.ets.model.ClinicianSchException;
import com.ets.model.Provider;
import com.ets.model.ProviderSchException;

public interface StaffSchExceptionDAO {
public void saveOrUpdate(List<ProviderSchException> staffSchException);
public void saveOrUpdateNoDuplicate(ProviderSchException staffSchException);

public void delete(Integer id);
public void deleteBetweenDates(Date st,Date end,Provider provider);
public List<ProviderSchException> viewProviderSchExcByIdAndDate(Provider provider,String stDate,String enDate);

}
