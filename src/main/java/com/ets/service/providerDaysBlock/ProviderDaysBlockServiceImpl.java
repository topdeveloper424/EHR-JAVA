package com.ets.service.providerDaysBlock;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.providerDaysBlock.ProviderDaysBlockDAO;
import com.ets.model.Provider;
import com.ets.model.ProviderDaysBlockTime;

@Service
@Transactional
public class ProviderDaysBlockServiceImpl implements ProviderDaysBlockService {

	private ProviderDaysBlockDAO providerDaysBlockDAO;
	
	public void setProviderDaysBlockDAO(ProviderDaysBlockDAO providerDaysBlockDAO) {
		this.providerDaysBlockDAO = providerDaysBlockDAO;
	}

	@Override
	public void saveOrUpdate(List<ProviderDaysBlockTime> providerDaysBlockTimes) {
		providerDaysBlockDAO.saveOrUpdate(providerDaysBlockTimes);
		
	}

	@Override
	public List<ProviderDaysBlockTime> getProviderDaysBlockTimes(Provider providerId, String weekDay) {
		// TODO Auto-generated method stub
		return providerDaysBlockDAO.getProviderDaysBlockTimes(providerId, weekDay);
	}

	@Override
	public void DeleteBlocks(List<ProviderDaysBlockTime> providerDaysBlockTimes) {
	
		providerDaysBlockDAO.DeleteBlocks(providerDaysBlockTimes);
		
	}

	@Override
	public List<ProviderDaysBlockTime> viewProviderById(Provider provider) {
		return providerDaysBlockDAO.viewProviderById(provider);
		
	}
	
}
