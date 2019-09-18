package com.ets.service.foodAllergy;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.foodSubstance.FoodAllergyDAO;
import com.ets.model.FoodAllergy;



@Service
@Transactional
public class FoodAllergyServiceImpl  implements FoodAllergyService{
  private FoodAllergyDAO foodAllergyDAO;

public void setFoodAllergyDAO(FoodAllergyDAO foodAllergyDAO) {
	this.foodAllergyDAO = foodAllergyDAO;
}

	@Override
	public void saveOrUpdate(FoodAllergy foodAllergy) {
		foodAllergyDAO.saveOrUpdate(foodAllergy);
		
	}

	@Override
	public List<FoodAllergy> view() {
		// TODO Auto-generated method stub
		return foodAllergyDAO.view();
	}

	@Override
	public FoodAllergy searchByDescrip(String substanceName) {
		// TODO Auto-generated method stub
		return foodAllergyDAO.searchByDescrip(substanceName);
	}

}
