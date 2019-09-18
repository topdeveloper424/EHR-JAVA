package com.ets.service.clinicClosed;

import java.util.Date;
import java.util.List;

import com.ets.model.ClinicClosed;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicClosedService Interface
 *Description: ClinicClosed Entity Service Interface
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

public interface ClinicClosedService {

public void saveOrUpdate(ClinicClosed clinicClosed);

public void saveOrUpdateNoDuplicate(ClinicClosed clinicClosed);

public void delete(Integer id);

public List<ClinicClosed> viewByDate(String str1 , String str2, Integer cId);
public void deleteByDate(Date date);
}
