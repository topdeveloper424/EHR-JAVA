package com.ets.service.visitCategory;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.visitCategory.VisitCategoryDAO;
import com.ets.model.VisitCategory;

@Transactional
@Service
public class VisitCategoryServiceImpl implements VisitCategoryService {
	
	private VisitCategoryDAO visitCategoryDAO;

	public void setVisitCategoryDAO(VisitCategoryDAO visitCategoryDAO) {
		this.visitCategoryDAO = visitCategoryDAO;
	}

	@Override
	public void addOrUpdate(VisitCategory visitCategory) {
		
		visitCategoryDAO.addOrUpdate(visitCategory);
		
	}

	@Override
	public List<VisitCategory> view() {
		
		return visitCategoryDAO.view();
	}

	@Override
	public void delete(Integer id) {
		
		visitCategoryDAO.delete(id);
		
	}

	@Override
	public VisitCategory viewByCode(String code) {
		// TODO Auto-generated method stub
		return visitCategoryDAO.viewByCode(code);
	}
	

}
