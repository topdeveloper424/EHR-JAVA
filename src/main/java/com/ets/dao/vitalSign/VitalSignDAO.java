package com.ets.dao.vitalSign;

import java.util.List;

import com.ets.model.PatientVisit;
import com.ets.model.VitalReader;
import com.ets.model.VitalSign;

public interface VitalSignDAO {

	  public void saveOrUpdate(VitalSign vitalSign);
	  public List<VitalSign> viewVitalSign(PatientVisit patientVisit);
	
	
}
