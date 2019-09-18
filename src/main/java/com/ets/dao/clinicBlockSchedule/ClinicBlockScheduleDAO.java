package com.ets.dao.clinicBlockSchedule;

import java.util.Date;
import java.util.List;

import com.ets.model.Clinic;
import com.ets.model.ClinicBlockSchedule;

public interface ClinicBlockScheduleDAO {
	
	public void saveOrUpdate(List<ClinicBlockSchedule> clinic);
	
	public List<ClinicBlockSchedule> viewByDate(List<Date> date);
	
	public void delete(List<ClinicBlockSchedule> clinicBlockScheduleId);
	
	/*public void update(ClinicBlockSchedule clinic);
	
	public Clinic getByID(Integer id);
	
	public void delete(Integer id);*/
}
