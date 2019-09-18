package com.ets.service.pvVitals;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.pvVitals.PvVitalsDAO;
import com.ets.model.PvVitals;

@Service
@Transactional
public class PvVitalsServiceImpl implements PvVitalsService {
	
	private PvVitalsDAO pvVitalsDAO;

	public void setPvVitalsDAO(PvVitalsDAO pvVitalsDAO) {
		this.pvVitalsDAO = pvVitalsDAO;
	}

	@Override
	public void saveOrUpdate(PvVitals pvVitals) {
		
		pvVitalsDAO.saveOrUpdate(pvVitals);
		
	}
	

}
