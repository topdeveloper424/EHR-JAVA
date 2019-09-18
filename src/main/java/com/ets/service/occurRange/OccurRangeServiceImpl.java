package com.ets.service.occurRange;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.occurRange.OccurRangeDAO;
import com.ets.model.OccurRange;

@Service
@Transactional
public class OccurRangeServiceImpl implements OccurRangeService {
	private OccurRangeDAO occurRangeDAO;

	public void setOccurRangeDAO(OccurRangeDAO occurRangeDAO) {
		this.occurRangeDAO = occurRangeDAO;
	}

	@Override
	public void saveOrUpdate(OccurRange occurRange) {

		occurRangeDAO.saveOrUpdate(occurRange);
	}

}
