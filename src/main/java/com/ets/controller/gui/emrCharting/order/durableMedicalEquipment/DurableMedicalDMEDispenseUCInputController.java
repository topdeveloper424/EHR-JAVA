package com.ets.controller.gui.emrCharting.order.durableMedicalEquipment;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DurableMedicalDMEDispenseUCInputController implements Initializable{
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox AnkleACane;

    @FXML
    private CheckBox AnkleAluminium;

    @FXML
    private CheckBox ankleACE;

    @FXML
    private CheckBox AnkleASplint;

    @FXML
    private CheckBox ForearmAluminum;

    @FXML
    private CheckBox forearmACEBandage;

    @FXML
    private CheckBox forearmArmSling;

    @FXML
    private CheckBox shoulderArmSling;
	
	
	private OrderDurableMedicalEquipmentInputController orderDurableMedicalEquipmentInputController;

	public void setOrderDurableMedicalEquipmentInputController(
			OrderDurableMedicalEquipmentInputController orderDurableMedicalEquipmentInputController) {
		this.orderDurableMedicalEquipmentInputController = orderDurableMedicalEquipmentInputController;
	}

	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event) -> {

			StringBuilder dispenseUCStr = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
			dispenseUCStr.append("\n\n ");
			orderDurableMedicalEquipmentInputController.str = dispenseUCStr.toString();

			if(AnkleACane.isSelected() || AnkleAluminium.isSelected() 
					|| ankleACE.isSelected() || AnkleASplint.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str1.append("Patient was given the following DME and instructed on use: ");
				orderDurableMedicalEquipmentInputController.str = str1.toString();
				
				if(AnkleACane.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" a cane,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(AnkleAluminium.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("aluminum crutches (pair),");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(ankleACE.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("CT Scan Requested,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(AnkleASplint.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("ACE bandage,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("a splint.");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			
				
				
			}
			
			
			
			
			
			if(ForearmAluminum.isSelected() || forearmArmSling.isSelected() 
					|| forearmACEBandage.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str1.append("Patient was given the following DME and instructed on use: ");
				orderDurableMedicalEquipmentInputController.str = str1.toString();
				
				if(ForearmAluminum.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" aluminum splint,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(forearmArmSling.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" arm sling,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(forearmACEBandage.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("ACE bandage,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(".");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
							
				
			}
			
			
			if(shoulderArmSling.isSelected() || forearmACEBandage.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str1.append(" Patient was given the following DME and instructed on use: ");
				orderDurableMedicalEquipmentInputController.str = str1.toString();
				
				if(shoulderArmSling.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" arm sling ,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(forearmACEBandage.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("ACE bandage/wrap.");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				
				
			}
			
		
			

			++orderDurableMedicalEquipmentInputController.formCount;
			orderDurableMedicalEquipmentInputController.setDurableMedicalEquipmentModelUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		
		
		skipBtn.setOnAction((event) -> {
			try {
				
				++orderDurableMedicalEquipmentInputController.formCount;
				orderDurableMedicalEquipmentInputController.setDurableMedicalEquipmentModelUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
