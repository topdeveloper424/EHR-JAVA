package com.ets.service.clinicClosed;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.clinicClosed.ClinicClosedDAO;
import com.ets.model.ClinicClosed;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicClosedServiceImpl Class
 *Description: ClinicClosed Entity Service Class
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
public class ClinicClosedServiceImpl implements ClinicClosedService {

	private ClinicClosedDAO clinicClosedDAO;

	public void setClinicClosedDAO(ClinicClosedDAO clinicClosedDAO) {
		this.clinicClosedDAO = clinicClosedDAO;
	}
	@Override
	public void saveOrUpdate(ClinicClosed clinicClosed) {
		clinicClosedDAO.saveOrUpdate(clinicClosed);

	}
	@Override
	public void delete(Integer id) {

		clinicClosedDAO.delete(id);


	}
	@Override
	public List<ClinicClosed> viewByDate(String str1, String str2, Integer cId) {

		return clinicClosedDAO.viewByDate(str1, str2, cId);
	}

	@Override
	public void saveOrUpdateNoDuplicate(ClinicClosed clinicClosed) {
		clinicClosedDAO.saveOrUpdateNoDuplicate(clinicClosed);
	}
	@Override
	public void deleteByDate(Date date) {
		clinicClosedDAO.deleteByDate(date);
		
	}

}