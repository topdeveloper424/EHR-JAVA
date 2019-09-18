package com.ets.service.providerBlockTime;
import java.util.Date;
import java.util.List;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffBlockTimeServiceImpl Class
 *Description: ProviderBlockTime Entity Service class
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.providerBlockTime.StaffBlockTimeDAO;
import com.ets.model.Provider;
import com.ets.model.ProviderBlockTime;


@Service
@Transactional
public class StaffBlockTimeServiceImpl implements StaffBlockTimeService {

	private StaffBlockTimeDAO staffBlockTimeDAO;

	public void setStaffBlockTimeDAO(StaffBlockTimeDAO staffBlockTimeDAO) {
		this.staffBlockTimeDAO = staffBlockTimeDAO;
	}

	@Override
	public void saveOrUpdate(List<ProviderBlockTime> staffBlockTime) {

		staffBlockTimeDAO.saveOrUpdate(staffBlockTime);
	}

	@Override
	public List<ProviderBlockTime> viewByDate(List<Date> date, Provider provider) {
		// TODO Auto-generated method stub
		return staffBlockTimeDAO.viewByDate(date, provider);
	}

	@Override
	public void delete(List<ProviderBlockTime> providerBlockTime) {
		staffBlockTimeDAO.delete(providerBlockTime);
		
	}

	@Override
	public void deleteBlockTimeByDate(Date stD, Date enD, Provider provider) {
		staffBlockTimeDAO.deleteBlockTimeByDate(stD, enD, provider);
		
	}

}
