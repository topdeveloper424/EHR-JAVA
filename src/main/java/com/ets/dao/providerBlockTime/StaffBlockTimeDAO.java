package com.ets.dao.providerBlockTime;
import java.util.Date;
import java.util.List;

import com.ets.model.ClinicBlockSchedule;
import com.ets.model.Provider;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffBlockTimeDAO Interface
 *Description: ProviderBlockTime Entity DAO Interface
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
import com.ets.model.ProviderBlockTime;

public interface StaffBlockTimeDAO {
public void saveOrUpdate(List<ProviderBlockTime> staffBlockTime);
public List<ProviderBlockTime> viewByDate(List<Date> date,Provider provider);

public void delete(List<ProviderBlockTime> providerBlockTime);
public void deleteBlockTimeByDate(Date stD,Date enD,Provider provider);


}
