package com.ets.controller.entity.equipmentModel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.EquipmentModel;

import com.ets.service.equipmentModel.EquipmentModelServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EquipmentModelEntityController {
	//private static ClassPathXmlApplicationContext context;

	private EquipmentModelServiceImpl equipmentModelServiceImpl;

	private ObservableList<EquipmentModel> observableList;

	public EquipmentModelEntityController() {

	//	context = new ClassPathXmlApplicationContext("spring.xml");

		equipmentModelServiceImpl = (EquipmentModelServiceImpl) Global.context.getBean("equipmentModelService");

		observableList = FXCollections.observableArrayList();

	}

	
	 public void save(EquipmentModel equipmentModel){
		 
		 equipmentModelServiceImpl.add(equipmentModel);
		// this.closeApplicationContext();
	 }
	 
	 public ObservableList<EquipmentModel> viewEquipmentModel() {

			observableList = FXCollections.observableArrayList(equipmentModelServiceImpl.list());
			//.closeApplicationContext();
			return observableList;
		}
	 
	 public void updateEquipmentModel(EquipmentModel equipmentModel) {

		 equipmentModelServiceImpl.update(equipmentModel);
			//this.closeApplicationContext();
		}
	 
	 public void removeEquipmentModel(Integer id) {

		 equipmentModelServiceImpl.delete(id);
			//this.closeApplicationContext();
		}

	 public ObservableList<EquipmentModel> getByID(Integer id) {

			observableList = FXCollections.observableArrayList(equipmentModelServiceImpl.getByID(id));
			//this.closeApplicationContext();
			return observableList;
		}
}
