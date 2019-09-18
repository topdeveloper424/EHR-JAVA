package com.ets.controller.gui.emrCharting.order.durableMedicalEquipment.smartForm;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SmartFormInputController Class
 *Description: SmartForm.fxm GUI Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.order.durableMedicalEquipment.OrderDurableMedicalEquipmentInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class SmartFormInputController implements Initializable {
	
	 	@FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;
	
	private OrderDurableMedicalEquipmentInputController durableMedicalEquipmentInputController;

	public void setDurableMedicalEquipmentInputController(
			OrderDurableMedicalEquipmentInputController durableMedicalEquipmentInputController) {
		this.durableMedicalEquipmentInputController = durableMedicalEquipmentInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		skipBtn.setOnAction((event) -> {
			try {
				
				new FXFormCommonUtilities().closeForm( skipBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
