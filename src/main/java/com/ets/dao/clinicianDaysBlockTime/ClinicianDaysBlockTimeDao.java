package com.ets.dao.clinicianDaysBlockTime;

import java.util.List;

import com.ets.model.Clinician;
import com.ets.model.ClinicianDaysBlockTime;
import com.ets.model.Provider;
import com.ets.model.ProviderDaysBlockTime;

public interface ClinicianDaysBlockTimeDao {
	public void saveOrUpdate(List<ClinicianDaysBlockTime> clinicianDaysBlockTimes);
	public List<ClinicianDaysBlockTime> getClinicianDaysBlockTime(Clinician clinician,String weekDay);
	public void DeleteBlocks(List<ClinicianDaysBlockTime> clinicianDaysBlockTimes);
	public List<ClinicianDaysBlockTime> viewProviderById(Clinician clinician);
}