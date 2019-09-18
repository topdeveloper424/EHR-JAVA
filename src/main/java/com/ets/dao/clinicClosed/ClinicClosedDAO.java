package com.ets.dao.clinicClosed;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicClosedDAO Interface
 *Description: Implementation class for ClinicClosed Interface
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

import java.util.Date;

import java.util.List;

import com.ets.model.ClinicClosed;


public interface ClinicClosedDAO {

  public void saveOrUpdate(ClinicClosed clinicClosed);

  public void saveOrUpdateNoDuplicate(ClinicClosed clinicClosed);

  public void delete(Integer id);

  public List<ClinicClosed> viewByDate(String str1 , String str2 , Integer cId);

  public ClinicClosed getByDate(String targetDate );
  public void deleteByDate(Date date);
}
