package com.ets.dao.clinicianDaysBlockException;

import java.util.List;

import com.ets.model.Clinician;
import com.ets.model.ClinicianBlockDayException;
import com.ets.model.Provider;
import com.ets.model.ProviderBlockDayException;

public interface ClinicianDaysBlockExceptionDao {
	public void saveOrUpdate(List<String> dateList,Clinician clinician);
    public List<ClinicianBlockDayException> viewClinicianById(String excDateStartSt,String excDateendSt ,Clinician clinician);
    public void delete(String startDate,String endDate,Clinician clinician);
}
