package com.ets.controller.entity.carrier;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Carrier;
import com.ets.model.Complex;
import com.ets.service.carrier.CarrierServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Original Author: Sumanta Deyahi on Behalf of ETS for Client Company File
 * Creation Date: 06-09-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of CarrierEntityController Class Description: Carrier
 * Entity Non-GUI Controller class Copyright 2016 @Eclipse Technoconsulting
 * Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 */

public class CarrierEntityController {

	//private static ClassPathXmlApplicationContext context;
	private CarrierServiceImpl carrierServiceImpl;
	private ObservableList<Carrier> observableList;

	public CarrierEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		carrierServiceImpl = (CarrierServiceImpl) Global.context.getBean("carrierService");
		observableList = FXCollections.observableArrayList();

	}

	
	public void saveOrUpdate(Carrier carrier) {

		carrierServiceImpl.addOrUpdate(carrier);
		//this.closeApplicationConrext();

	}

	public ObservableList<Carrier> view() {

		observableList = FXCollections.observableArrayList(carrierServiceImpl.view());

		//this.closeApplicationConrext();
		return observableList;

	}

	public Carrier viewByCode(String code) {

		observableList = FXCollections.observableArrayList(carrierServiceImpl.viewByCode(code));

		//this.closeApplicationConrext();
		return observableList.get(0);

	}

	public void delete(Integer id) {
		carrierServiceImpl.delete(id);
		//context.close();
	}

}
