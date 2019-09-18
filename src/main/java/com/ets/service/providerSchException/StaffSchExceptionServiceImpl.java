package com.ets.service.providerSchException;
import java.util.Date;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StaffSchExceptionServiceImpl Class
 *Description: ProviderSchException Entity Service class
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

import com.ets.dao.providerSchException.StaffSchExceptionDAO;
import com.ets.model.Provider;
import com.ets.model.ProviderSchException;

@Service
@Transactional

public class StaffSchExceptionServiceImpl implements StaffSchExceptionService {
	private StaffSchExceptionDAO staffSchExceptionDAO;

	public void setStaffSchExceptionDAO(StaffSchExceptionDAO staffSchExceptionDAO) {
		this.staffSchExceptionDAO = staffSchExceptionDAO;
	}

	@Override
	public void saveOrUpdate(List<ProviderSchException> staffSchException) {

		staffSchExceptionDAO.saveOrUpdate(staffSchException);

	}

	@Override
	public void delete(Integer id) {
		staffSchExceptionDAO.delete(id);

	}

	@Override
	public List<ProviderSchException> viewProviderSchExceptionBetweenDateById(Provider provider, String stdate,String endDate) {

		return staffSchExceptionDAO.viewProviderSchExcByIdAndDate(provider, stdate, endDate);
	}

	@Override
	public void saveOrUpdateNoDuplicate(ProviderSchException staffSchException) {
		// TODO Auto-generated method stub
		staffSchExceptionDAO.saveOrUpdateNoDuplicate(staffSchException);
		
	}

	@Override
	public void deleteBetweenDates(Date st, Date end,Provider provider) {
		staffSchExceptionDAO.deleteBetweenDates(st, end,provider);
		
	}

}
