package com.ets.service.providerSchedule;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffScheduleService Interface
 *Description: ProviderSchedule Entity Service Interface
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

import com.ets.model.ProviderSchedule;

public interface StaffScheduleService {
	
public void saveOrUpdate(ProviderSchedule staffSchedule);

public  List<ProviderSchedule> viewProviderScheduleById(Integer id);

public List<ProviderSchedule> view();

}
