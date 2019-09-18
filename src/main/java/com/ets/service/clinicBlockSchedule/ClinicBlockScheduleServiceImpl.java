package com.ets.service.clinicBlockSchedule;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.clinicBlockSchedule.ClinicBlockScheduleDAO;
import com.ets.model.ClinicBlockSchedule;

@Service
@Transactional
public class ClinicBlockScheduleServiceImpl  implements ClinicBlockScheduleService{

	
	private ClinicBlockScheduleDAO clinicBlockScheduleDAO;
	
	public void setClinicBlockScheduleDAO(ClinicBlockScheduleDAO clinicBlockScheduleDAO) {
		this.clinicBlockScheduleDAO = clinicBlockScheduleDAO;
	}

	@Override
	public void saveOrUpdate(List<ClinicBlockSchedule> clinic) {
		clinicBlockScheduleDAO.saveOrUpdate(clinic);
		
	}

	@Override
	public List<ClinicBlockSchedule> viewByDate(List<Date> date) {
		// TODO Auto-generated method stub
		return clinicBlockScheduleDAO.viewByDate(date);
	}

	@Override
	public void delete(List<ClinicBlockSchedule> clinicBlockScheduleId) {
		clinicBlockScheduleDAO.delete(clinicBlockScheduleId);
		
	}

	
}
