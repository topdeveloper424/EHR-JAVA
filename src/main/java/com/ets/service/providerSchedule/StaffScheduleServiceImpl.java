package com.ets.service.providerSchedule;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffScheduleServiceImpl Class
 *Description: ProviderSchedule Entity Service class
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

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.providerSchedule.StaffScheduleDAO;
import com.ets.model.ProviderSchedule;

@Service
@Transactional
public class StaffScheduleServiceImpl implements StaffScheduleService {

	private StaffScheduleDAO staffScheduleDAO;

	public void setStaffScheduleDAO(StaffScheduleDAO staffScheduleDAO) {
		this.staffScheduleDAO = staffScheduleDAO;
	}

	@Override
	public void saveOrUpdate(ProviderSchedule staffSchedule) {

		staffScheduleDAO.saveOrUpdate(staffSchedule);
	}

	@Override
	public List<ProviderSchedule> viewProviderScheduleById(Integer id) {
		
		return staffScheduleDAO.viewProviderScheduleById(id);
	}

	@Override
	public List<ProviderSchedule> view() {
		
		return staffScheduleDAO.view();
	}

}
