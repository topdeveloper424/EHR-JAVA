package com.ets.controller.gui.emrCharting.order.durableMedicalEquipment;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DurableMedicalDmeDispenseBackTorsoInputController implements Initializable {

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox DoublepullCheck;

	@FXML
	private CheckBox halfMoonCheck;

	@FXML
	private CheckBox backTrackCheck;

	@FXML
	private CheckBox deluxeRibCheck;

	@FXML
	private CheckBox ringCushionCheck;
	
	 FXMLFormPath formPath = new FXMLFormPath();

	private OrderDurableMedicalEquipmentInputController orderDurableMedicalEquipmentInputController;

	public void setOrderDurableMedicalEquipmentInputController(
			OrderDurableMedicalEquipmentInputController orderDurableMedicalEquipmentInputController) {
		this.orderDurableMedicalEquipmentInputController = orderDurableMedicalEquipmentInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		


		doneBtn.setOnAction((event) -> {
			
	
			StringBuilder durableReferalStr = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
			durableReferalStr.append("\n\n ");
			orderDurableMedicalEquipmentInputController.str = durableReferalStr.toString();

			if(DoublepullCheck.isSelected()||halfMoonCheck.isSelected()||backTrackCheck.isSelected()||
					ringCushionCheck.isSelected()||deluxeRibCheck.isSelected()){

				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("Patient was given the following DME and instructed on its use : ");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			if(DoublepullCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str1.append("double pull sacrolumbar support,");
				orderDurableMedicalEquipmentInputController.str = str1.toString();
				
			}
			
             if(halfMoonCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str1.append(" half moon lumbar pillow,");
				orderDurableMedicalEquipmentInputController.str = str1.toString();
				
			}
             
             if(backTrackCheck.isSelected()){
 				
 				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
 				str1.append("back track,");
 				orderDurableMedicalEquipmentInputController.str = str1.toString();
 				
 			} if(ringCushionCheck.isSelected()){
 				
 				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
 				str1.append(", ring cushion (doughnut pillow),");
 				orderDurableMedicalEquipmentInputController.str = str1.toString();
 				
 			}
               if(deluxeRibCheck.isSelected()){
 				
 				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
 				str1.append("deluxe rib belt (female).");
 				orderDurableMedicalEquipmentInputController.str = str1.toString();
 				
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
