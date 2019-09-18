package com.ets.service.recurPattern;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.recurPattern.RecurPatternDAO;
import com.ets.model.RecurPattern;

@Service
@Transactional
public class RecurPatternServiceImpl implements RecurPatternService {
	private RecurPatternDAO recurPatternDAO;

	public void setRecurPatternDAO(RecurPatternDAO recurPatternDAO) {
		this.recurPatternDAO = recurPatternDAO;
	}

	@Override
	public void saveOrUpdate(RecurPattern recurPattern) {
		// TODO Auto-generated method stub
		recurPatternDAO.saveOrupdate(recurPattern);

	}

}
