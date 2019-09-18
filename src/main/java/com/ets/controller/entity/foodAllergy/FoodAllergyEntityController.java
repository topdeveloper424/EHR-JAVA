package com.ets.controller.entity.foodAllergy;

import com.ets.model.FoodAllergy;

import com.ets.service.foodAllergy.FoodAllergyServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FoodAllergyEntityController {

	private FoodAllergyServiceImpl foodAllergyServiceImpl;
	private ObservableList<FoodAllergy> observableList;

	public FoodAllergyEntityController() {
		// context =new ClassPathXmlApplicationContext("spring.xml");
		foodAllergyServiceImpl = (FoodAllergyServiceImpl) Global.context.getBean("foodAllergyService");
		observableList = FXCollections.observableArrayList();
	}

	public void saveOrUpdate(FoodAllergy foodAllergy) {
		
		foodAllergyServiceImpl.saveOrUpdate(foodAllergy);

	}

	public ObservableList<FoodAllergy> view() {

		observableList = FXCollections.observableArrayList(foodAllergyServiceImpl.view());

		return observableList;
	}

	public  FoodAllergy searchByDescrip(String substanceName) {

		observableList = FXCollections.observableArrayList(foodAllergyServiceImpl.searchByDescrip(substanceName));

		return observableList.get(0);
	}
}