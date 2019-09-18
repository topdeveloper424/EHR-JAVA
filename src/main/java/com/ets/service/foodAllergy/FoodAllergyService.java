package com.ets.service.foodAllergy;

import java.util.List;

import com.ets.model.FoodAllergy;

public interface FoodAllergyService {
	public void saveOrUpdate(FoodAllergy foodAllergy);

	public List<FoodAllergy> view();
	
	public FoodAllergy searchByDescrip(String substanceName);

}
