package com.ets.service.recurEntry;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.recurEntry.RecurEntryDAO;

import com.ets.model.RecurEntry;

@Service
@Transactional
public class RecurEntryServiceImpl implements RecurEntryService {

	private RecurEntryDAO recurEntryDAO;

	public void setRecurEntryDAO(RecurEntryDAO recurEntryDAO) {
		this.recurEntryDAO = recurEntryDAO;
	}

	@Override
	public void saveOrUpdate(RecurEntry recurEntry) {
		
		recurEntryDAO.saveOrUpdate(recurEntry);
	}

}
