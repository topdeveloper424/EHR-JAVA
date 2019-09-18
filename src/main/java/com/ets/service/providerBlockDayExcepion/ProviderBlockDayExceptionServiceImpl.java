package com.ets.service.providerBlockDayExcepion;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.providerDaysBlockException.ProviderBlockDayExceptionDAO;
import com.ets.model.Provider;
import com.ets.model.ProviderBlockDayException;
import com.ets.model.ProviderSchException;

@Service
@Transactional
public class ProviderBlockDayExceptionServiceImpl implements ProviderBlockDayExceptionService {
	
	private ProviderBlockDayExceptionDAO providerBlockDayExceptionDAO;
	
	public void setProviderBlockDayExceptionDAO(ProviderBlockDayExceptionDAO providerBlockDayExceptionDAO) {
		this.providerBlockDayExceptionDAO = providerBlockDayExceptionDAO;
	}

	@Override
	public void saveOrUpdate(List<String> dateList,Provider provider) {
		providerBlockDayExceptionDAO.saveOrUpdate(dateList,provider);
		
	}

	@Override
	public List<ProviderBlockDayException> viewProviderById(String excDateStartSt,String excDateendSt ,Provider provider) {
		// TODO Auto-generated method stub
		return providerBlockDayExceptionDAO.viewProviderById(excDateStartSt, excDateendSt, provider);
	}

	@Override
	public void delete(String startDate, String endDate, Provider provider) {
		providerBlockDayExceptionDAO.delete(startDate, endDate, provider);
		
	}

	

}
