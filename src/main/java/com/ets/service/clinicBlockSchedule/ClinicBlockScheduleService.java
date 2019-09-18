package com.ets.service.clinicBlockSchedule;

import java.util.Date;
import java.util.List;

import com.ets.model.ClinicBlockSchedule;

public interface ClinicBlockScheduleService {
public void saveOrUpdate(List<ClinicBlockSchedule> clinic);
	
public List<ClinicBlockSchedule> viewByDate(List<Date> date);
public void delete(List<ClinicBlockSchedule> clinicBlockScheduleId);	
	/*public void update(ClinicBlockSchedule clinic);
	
	public Clinic getByID(Integer id);
	
	public void delete(Integer id);*/
}
