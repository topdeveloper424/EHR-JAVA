package com.ets.service.medActSurvelRule;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.medActSurvelRule.MedActSurvelRuleDAO;
import com.ets.model.MedActSurvelRule;

@Service
@Transactional
public class MedActSurvelRuleServiceImpl implements MedActSurvelRuleService {
	
	private MedActSurvelRuleDAO medActSurvelRuleDAO;

	public void setMedActSurvelRuleDAO(MedActSurvelRuleDAO medActSurvelRuleDAO) {
		this.medActSurvelRuleDAO = medActSurvelRuleDAO;
	}

	@Override
	public void addOrUpdate(MedActSurvelRule medActSurvelRule) {
		
		medActSurvelRuleDAO.addOrUpdate(medActSurvelRule);
		
	}
	

}
