package com.ets.service.vitalSign;

import java.util.List;

import com.ets.model.PatientVisit;
import com.ets.model.VitalSign;

public interface VitalSignService {

	  public void saveOrUpdate(VitalSign vitalSign);
	  public List<VitalSign> viewVitalSign(PatientVisit patientVisit);
}
