package com.ets.controller.gui.emrCharting.order.durableMedicalEquipment;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DurableMedicalOrthoDMEKneeInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox CrutchesCheck;

	    @FXML
	    private CheckBox softCheck;

	    @FXML
	    private CheckBox hingedCheck;

	    @FXML
	    private CheckBox kneeImmobilizerCheck;
	
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

			if(CrutchesCheck.isSelected() || softCheck.isSelected()
					|| hingedCheck.isSelected() || kneeImmobilizerCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str1.append("Patient provided with ");
				orderDurableMedicalEquipmentInputController.str = str1.toString();
				
				if(CrutchesCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("crutches,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(softCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" a soft knee brace,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(hingedCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" a hinged knee brace,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(kneeImmobilizerCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("a knee immobilizer,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
								
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(", and instructed in the use of the device.");
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
