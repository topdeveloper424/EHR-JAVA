package com.ets.dao.foodSubstance;

import java.util.List;

import com.ets.model.AllergyCategory;
import com.ets.model.FoodAllergy;

public interface FoodAllergyDAO {

	public void saveOrUpdate(FoodAllergy foodAllergy);

	public List<FoodAllergy> view();
	
	public FoodAllergy searchByDescrip(String substanceName);
}
