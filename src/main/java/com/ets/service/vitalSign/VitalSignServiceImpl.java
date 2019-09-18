package com.ets.service.vitalSign;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.vitalSign.VitalSignDAO;
import com.ets.model.PatientVisit;
import com.ets.model.VitalSign;

@Service
@Transactional
public class VitalSignServiceImpl implements VitalSignService {
	
	private VitalSignDAO vitalSignDAO;


	public void setVitalSignDAO(VitalSignDAO vitalSignDAO) {
		this.vitalSignDAO = vitalSignDAO;
	}

	@Override
	public void saveOrUpdate(VitalSign vitalSign) {
		vitalSignDAO.saveOrUpdate(vitalSign);
		
	}

	@Override
	public List<VitalSign> viewVitalSign(PatientVisit patientVisit) {
		// TODO Auto-generated method stub
		return vitalSignDAO.viewVitalSign(patientVisit);
	}

}
