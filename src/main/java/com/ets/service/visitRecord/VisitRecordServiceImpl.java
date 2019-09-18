package com.ets.service.visitRecord;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.visitRecord.VisitRecordDAO;
import com.ets.model.VisitRecord;

@Transactional
@Service
public class VisitRecordServiceImpl implements VisitRecordService {

	private VisitRecordDAO visitRecordDAO;

	public void setVisitRecordDAO(VisitRecordDAO visitRecordDAO) {
		this.visitRecordDAO = visitRecordDAO;
	}

	@Override
	public void addOrUpdate(VisitRecord visitRecord) {

		visitRecordDAO.addOrUpdate(visitRecord);

	}

}
