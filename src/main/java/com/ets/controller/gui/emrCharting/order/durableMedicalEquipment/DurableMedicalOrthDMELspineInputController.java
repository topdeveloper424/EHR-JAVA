package com.ets.controller.gui.emrCharting.order.durableMedicalEquipment;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DurableMedicalOrthDMELspineInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox lumberCheck;

	    @FXML
	    private CheckBox TLSOCheck;

	
	
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

			
			
			if(lumberCheck.isSelected() || TLSOCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str1.append("Patient was fitted with ");
				orderDurableMedicalEquipmentInputController.str = str1.toString();
				
				if(lumberCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("a lumbar corset brace,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(TLSOCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("a TLSO,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("and instructed in the use of the device.");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
						
				
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
