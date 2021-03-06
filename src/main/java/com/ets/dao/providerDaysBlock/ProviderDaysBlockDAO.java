package com.ets.dao.providerDaysBlock;

import java.util.List;

import com.ets.model.Provider;
import com.ets.model.ProviderDaysBlockTime;

public interface ProviderDaysBlockDAO {
	public void saveOrUpdate(List<ProviderDaysBlockTime> providerDaysBlockTimes);
	public List<ProviderDaysBlockTime> getProviderDaysBlockTimes(Provider providerId,String weekDay);
	public void DeleteBlocks(List<ProviderDaysBlockTime> providerDaysBlockTimes);
	public List<ProviderDaysBlockTime> viewProviderById(Provider provider);
}
