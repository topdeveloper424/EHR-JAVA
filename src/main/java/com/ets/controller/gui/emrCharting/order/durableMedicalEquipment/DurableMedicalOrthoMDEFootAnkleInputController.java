package com.ets.controller.gui.emrCharting.order.durableMedicalEquipment;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DurableMedicalOrthoMDEFootAnkleInputController implements Initializable {
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox StrrupsplintCheck;

	    @FXML
	    private CheckBox fractureCheck;

	    @FXML
	    private CheckBox asoCheck;

	    @FXML
	    private CheckBox CrutchesCheck;

	    @FXML
	    private CheckBox postopCheck;
	    
	    
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

			if(StrrupsplintCheck.isSelected() || fractureCheck.isSelected()
					|| asoCheck.isSelected() || postopCheck.isSelected()
					|| CrutchesCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str1.append("Patient was fitted with ");
				orderDurableMedicalEquipmentInputController.str = str1.toString();
				
				if(StrrupsplintCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" a stirrup splint,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(fractureCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("a fracture boot,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(asoCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("an ASO,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(postopCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" a post-op shoe,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}if(CrutchesCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append( "crutches,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
								
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" and instructed in the use of the device.");
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
