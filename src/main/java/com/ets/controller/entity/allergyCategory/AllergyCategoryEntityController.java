package com.ets.controller.entity.allergyCategory;

import com.ets.model.AllergyCategory;
import com.ets.model.Clinician;
import com.ets.service.allergyCategory.AllergyCategorySeviceImpl;
import com.ets.service.clinician.ClinicianServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AllergyCategoryEntityController {

	private AllergyCategorySeviceImpl allergyCategorySeviceImpl;
	private ObservableList<AllergyCategory> observableList;

	public AllergyCategoryEntityController() {
		// context =new ClassPathXmlApplicationContext("spring.xml");
		allergyCategorySeviceImpl = (AllergyCategorySeviceImpl) Global.context.getBean("allergyCategoryService");
		observableList = FXCollections.observableArrayList();
	}

	public void saveOrUpdate(AllergyCategory allergyCategory) {
		allergyCategorySeviceImpl.saveOrUpdate(allergyCategory);

	}

	public ObservableList<AllergyCategory> view() {

		observableList = FXCollections.observableArrayList(allergyCategorySeviceImpl.view());

		return observableList;
	}

	public  AllergyCategory searchByDescrip(String descrip) {

		observableList = FXCollections.observableArrayList(allergyCategorySeviceImpl.searchByDescrip(descrip));

		return observableList.get(0);
	}
}
