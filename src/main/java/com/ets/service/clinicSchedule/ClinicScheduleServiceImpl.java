package com.ets.service.clinicSchedule;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.clinicSchedule.ClinicScheduleDAO;
import com.ets.model.ClinicSchedule;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 02-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicScheduleServiceImpl Class
 *Description: ClinicSchedule Entity Service Class
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
@Service
@Transactional
public class ClinicScheduleServiceImpl implements ClinicScheduleService {
	
	private ClinicScheduleDAO clinicScheduleDAO;

	public void setClinicScheduleDAO(ClinicScheduleDAO clinicScheduleDAO) {
		this.clinicScheduleDAO = clinicScheduleDAO;
	}

	@Override
	public List<ClinicSchedule> view() {
		
		return clinicScheduleDAO.view();
	}

	@Override
	public void saveOrUpdate(ClinicSchedule clinicSchedule) {
		clinicScheduleDAO.saveOrUpdate(clinicSchedule);
		
	}

	@Override
	public List<ClinicSchedule> viewClinicScheduleByClinicId(Integer cId) {
		
		return clinicScheduleDAO.viewClinicScheduleByClinicId(cId);
	}
	

}
