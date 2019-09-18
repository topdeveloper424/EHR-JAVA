package com.ets.service.tpa;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.tpa.TpaDAO;
import com.ets.model.Tpa;

@Service
@Transactional
public class TpaServiceImpl implements TpaService {
	
	private TpaDAO tpaDAO;

	public void setTpaDAO(TpaDAO tpaDAO) {
		this.tpaDAO = tpaDAO;
	}

	@Override
	public void addOrUpdate(Tpa tpa) {
		
		tpaDAO.addOrUpdate(tpa);
		
	}

	@Override
	public List<Tpa> view() {
		
		return tpaDAO.view();
	}

	@Override
	public Tpa viewByCode(String code) {
		// TODO Auto-generated method stub
		return tpaDAO.viewByCode(code);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		tpaDAO.delete(id);
		
	}
	

}
