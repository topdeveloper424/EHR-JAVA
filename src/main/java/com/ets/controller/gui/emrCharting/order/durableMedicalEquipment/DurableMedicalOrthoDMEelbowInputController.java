package com.ets.controller.gui.emrCharting.order.durableMedicalEquipment;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DurableMedicalOrthoDMEelbowInputController implements Initializable {
	
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox SlingCheck;

	    @FXML
	    private CheckBox shoulderCheck;

	    @FXML
	    private CheckBox gunCheck;

	    @FXML
	    private CheckBox elbowCheck;

	    @FXML
	    private CheckBox tenisCheck;

	    @FXML
	    private CheckBox hingedCheck;
	
	
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

			if(SlingCheck.isSelected() || shoulderCheck.isSelected()
					|| gunCheck.isSelected() || tenisCheck.isSelected()
					|| elbowCheck.isSelected() || hingedCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str1.append("Patient was fitted with ");
				orderDurableMedicalEquipmentInputController.str = str1.toString();
				
				if(SlingCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("a sling ,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(shoulderCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("a shoulder immobilizer,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(gunCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("a gun-slinger immobilizer,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(tenisCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" a tennis elbow strap,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}if(elbowCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" an elbow sleeve,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(hingedCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("a hinged elbow brace,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" and instructed in use of the device.");
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
