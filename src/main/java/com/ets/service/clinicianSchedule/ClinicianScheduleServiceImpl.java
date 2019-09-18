package com.ets.service.clinicianSchedule;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.clinicianSchedule.ClinicianScheduleDAO;
import com.ets.model.ClinicianSchedule;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianScheduleServiceImpl Class
 *Description: ClinicianSchedule Entity Service Class
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
public class ClinicianScheduleServiceImpl implements ClinicianScheduleService {

	private ClinicianScheduleDAO clinicianScheduleDAO;
	
	public void setClinicianScheduleDAO(ClinicianScheduleDAO clinicianScheduleDAO) {
		this.clinicianScheduleDAO = clinicianScheduleDAO;
	}

	@Override
	public void saveOrUpdate(ClinicianSchedule clinicianSchedule) {
		clinicianScheduleDAO.saveOrUpdate(clinicianSchedule);
		
		
	}

	@Override
	public List<ClinicianSchedule> viewClinicianScheduleId(Integer id) {
		// TODO Auto-generated method stub
		return clinicianScheduleDAO.viewClinicianScheduleId(id);
	}

	@Override
	public List<ClinicianSchedule> view() {
		// TODO Auto-generated method stub
		return clinicianScheduleDAO.view();
	}

	
}
