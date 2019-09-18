package com.ets.service.clinicianBlockTime;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.clinicianBlockTime.ClinicianBlockTimeDAO;
import com.ets.model.Clinician;
import com.ets.model.ClinicianBlockTime;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianBlockTimeServiceImpl Class
 *Description: ClinicianBlockTime Entity Service Class
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
public class ClinicianBlockTimeServiceImpl  implements ClinicianBlockTimeService {
    private ClinicianBlockTimeDAO clinicianBlockTimeDAO;
   
	public void setClinicianBlockTimeDAO(ClinicianBlockTimeDAO clinicianBlockTimeDAO) {
		this.clinicianBlockTimeDAO = clinicianBlockTimeDAO;
	}

	
	@Override
	public void saveOrUpdate(List<ClinicianBlockTime> clinicianBlockTimes) {
		clinicianBlockTimeDAO.saveOrUpdate(clinicianBlockTimes);
		
	}

	@Override
	public List<ClinicianBlockTime> viewByDate(List<Date> date, Clinician clinician) {
		// TODO Auto-generated method stub
		return clinicianBlockTimeDAO.viewByDate(date, clinician);
	}

	@Override
	public void delete(List<ClinicianBlockTime> providerBlockTime) {
		clinicianBlockTimeDAO.delete(providerBlockTime);
		
	}

	@Override
	public void deleteBlockTimeByDate(Date stD, Date enD, Clinician clinician) {
		clinicianBlockTimeDAO.deleteBlockTimeByDate(stD, enD, clinician);
		
	}

	
}
