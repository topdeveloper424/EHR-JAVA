package com.ets.service.medActBilling;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.medActBilling.MedActBillingDAO;
import com.ets.model.MedActBilling;

@Service
@Transactional
public class MedActBillingServiceImpl implements MedActBillingService {
	
	private MedActBillingDAO medActBillingDAO;

	public void setMedActBillingDAO(MedActBillingDAO medActBillingDAO) {
		this.medActBillingDAO = medActBillingDAO;
	}

	@Override
	public void addOrUpdate(MedActBilling medActBilling) {
		
		medActBillingDAO.addOrUpdate(medActBilling);
		
	}
	

}
