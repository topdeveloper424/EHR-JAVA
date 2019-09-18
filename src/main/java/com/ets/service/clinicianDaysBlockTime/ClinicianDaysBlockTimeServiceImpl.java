package com.ets.service.clinicianDaysBlockTime;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.clinicianDaysBlockTime.ClinicianDaysBlockTimeDao;
import com.ets.model.Clinician;
import com.ets.model.ClinicianDaysBlockTime;

@Service
@Transactional
public class ClinicianDaysBlockTimeServiceImpl implements ClinicianDaysBlockTimeService{

	private ClinicianDaysBlockTimeDao clinicianDaysBlockTimeDao;
	public void setClinicianDaysBlockTimeDao(ClinicianDaysBlockTimeDao clinicianDaysBlockTimeDao) {
		this.clinicianDaysBlockTimeDao = clinicianDaysBlockTimeDao;
	}
	@Override
	public void saveOrUpdate(List<ClinicianDaysBlockTime> clinicianDaysBlockTimes) {
		clinicianDaysBlockTimeDao.saveOrUpdate(clinicianDaysBlockTimes);
		
	}
	@Override
	public List<ClinicianDaysBlockTime> getClinicianDaysBlockTime(Clinician clinician, String weekDay) {
		// TODO Auto-generated method stub
		return clinicianDaysBlockTimeDao.getClinicianDaysBlockTime(clinician, weekDay);
	}
	@Override
	public void DeleteBlocks(List<ClinicianDaysBlockTime> clinicianDaysBlockTimes) {
		clinicianDaysBlockTimeDao.DeleteBlocks(clinicianDaysBlockTimes);
		
	}
	@Override
	public List<ClinicianDaysBlockTime> viewClinicianById(Clinician clinician) {
		// TODO Auto-generated method stub
		return clinicianDaysBlockTimeDao.viewProviderById(clinician);
	}

}