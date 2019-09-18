package com.ets.service.providerBlockDayExcepion;

import java.util.Date;
import java.util.List;

import com.ets.model.Provider;
import com.ets.model.ProviderBlockDayException;

public interface ProviderBlockDayExceptionService {
	public void saveOrUpdate(List<String> dateList,Provider provider);
    public List<ProviderBlockDayException> viewProviderById(String excDateStartSt,String excDateendSt ,Provider provider);
    public void delete(String startDate,String endDate,Provider provider);
}
