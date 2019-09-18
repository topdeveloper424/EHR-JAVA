package com.ets.service.clinicianDaysBlockException;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.clinicianDaysBlockException.ClinicianDaysBlockExceptionDao;
import com.ets.model.Clinician;
import com.ets.model.ClinicianBlockDayException;

@Service
@Transactional
public class ClinicianDaysBlockExceptionServiceImpl  implements ClinicianDaysBlockExceptionService{

	private ClinicianDaysBlockExceptionDao ClinicianDaysBlockExceptionDao;
	
	public ClinicianDaysBlockExceptionDao getClinicianDaysBlockExceptionDao() {
		return ClinicianDaysBlockExceptionDao;
	}

	public void setClinicianDaysBlockExceptionDao(ClinicianDaysBlockExceptionDao clinicianDaysBlockExceptionDao) {
		ClinicianDaysBlockExceptionDao = clinicianDaysBlockExceptionDao;
	}

	@Override
	public void saveOrUpdate(List<String> dateList, Clinician clinician) {
		ClinicianDaysBlockExceptionDao.saveOrUpdate(dateList, clinician);
		
	}

	@Override
	public List<ClinicianBlockDayException> viewClinicianById(String excDateStartSt, String excDateendSt,
			Clinician clinician) {
		// TODO Auto-generated method stub
		return ClinicianDaysBlockExceptionDao.viewClinicianById(excDateStartSt, excDateendSt, clinician);
	}

	@Override
	public void delete(String startDate, String endDate, Clinician clinician) {
		ClinicianDaysBlockExceptionDao.delete(startDate, endDate, clinician);
		
	} 
	
	
}
