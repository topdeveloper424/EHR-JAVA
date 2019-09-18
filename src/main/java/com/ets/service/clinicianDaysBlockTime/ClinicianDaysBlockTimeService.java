package com.ets.service.clinicianDaysBlockTime;

import java.util.List;

import com.ets.model.Clinician;
import com.ets.model.ClinicianDaysBlockTime;



public interface ClinicianDaysBlockTimeService {
	public void saveOrUpdate(List<ClinicianDaysBlockTime> clinicianDaysBlockTimes);
	public List<ClinicianDaysBlockTime> getClinicianDaysBlockTime(Clinician clinician,String weekDay);
	public void DeleteBlocks(List<ClinicianDaysBlockTime> clinicianDaysBlockTimes);
	public List<ClinicianDaysBlockTime> viewClinicianById(Clinician clinician);
}
