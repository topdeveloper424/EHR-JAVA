package com.ets.controller.gui.emrCharting.order.durableMedicalEquipment;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DurableMedicalOrthoDMEHandWristInputController implements Initializable {
	
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox cookUPWristCheck;

    @FXML
    private CheckBox thumbCheck;

    @FXML
    private CheckBox reverseCheck;

    @FXML
    private CheckBox straxCheck;

    @FXML
    private CheckBox armCheck;

    @FXML
    private CheckBox bountonniereCheck;
	
	
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

			if(cookUPWristCheck.isSelected() || thumbCheck.isSelected()
					|| reverseCheck.isSelected() || straxCheck.isSelected()
					|| bountonniereCheck.isSelected() || armCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str1.append("Patient fitted with ");
				orderDurableMedicalEquipmentInputController.str = str1.toString();
				
				if(cookUPWristCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" cock-up wrist splint, ");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(thumbCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("thumb-spica splint,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(reverseCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" reverse knuckle bender splint,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(straxCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("stax splint,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(bountonniereCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" boutonniere splint,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}if(armCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" arm sling ");
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
