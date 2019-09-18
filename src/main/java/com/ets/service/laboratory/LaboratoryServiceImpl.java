package com.ets.service.laboratory;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.laboratory.LaboratoryDAO;
import com.ets.model.Laboratory;

@Transactional
@Service
public class LaboratoryServiceImpl implements LaboratoryService {
	
	private LaboratoryDAO laboratoryDAO;

	public void setLaboratoryDAO(LaboratoryDAO laboratoryDAO) {
		this.laboratoryDAO = laboratoryDAO;
	}

	@Override
	public void addOrUpdate(Laboratory laboratory) {
		
		laboratoryDAO.addOrUpdate(laboratory);
		
	}

	@Override
	public List<Laboratory> view() {
		
		return laboratoryDAO.view();
	}

	@Override
	public void delete(Integer id) {
		
		laboratoryDAO.delete(id);
		
	}

	@Override
	public Laboratory viewByCode(String code) {
		
		return laboratoryDAO.viewByCode(code);
	}
	

}
