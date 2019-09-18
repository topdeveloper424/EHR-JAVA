package com.ets.dao.providerDaysBlockException;

import java.util.Date;
import java.util.List;

import com.ets.model.Provider;
import com.ets.model.ProviderBlockDayException;
import com.ets.model.ProviderDaysBlockTime;

public interface ProviderBlockDayExceptionDAO {
	public void saveOrUpdate(List<String> dateList,Provider provider);
    public List<ProviderBlockDayException> viewProviderById(String excDateStartSt,String excDateendSt ,Provider provider);
    public void delete(String startDate,String endDate,Provider provider);
}
