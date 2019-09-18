package com.ets.service.allergyCategory;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.allergyCategory.AllergyCategoryDAO;
import com.ets.model.AllergyCategory;

@Service
@Transactional
public class AllergyCategorySeviceImpl  implements AllergyCategoryService{
	
	private AllergyCategoryDAO allergyCategoryDAO;
	
	public void setAllergyCategoryDAO(AllergyCategoryDAO allergyCategoryDAO) {
		this.allergyCategoryDAO = allergyCategoryDAO;
	}

	@Override
	public void saveOrUpdate(AllergyCategory allergyCategory) {
		allergyCategoryDAO.saveOrUpdate(allergyCategory);
	}

	@Override
	public List<AllergyCategory> view() {
		
		return allergyCategoryDAO.view();
	}

	@Override
	public AllergyCategory searchByDescrip(String descrip) {
		// TODO Auto-generated method stub
		return allergyCategoryDAO.searchByDescrip(descrip);
	}

}
