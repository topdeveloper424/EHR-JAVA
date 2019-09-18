package com.ets.controller.gui.emrCharting.order.workRestriction;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.order.OrderWorkRestrictionInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class HandGraspInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton rightRadio;

    @FXML
    private ToggleGroup bend;

    @FXML
    private RadioButton leftRadio;
	
	
	private OrderWorkRestrictionInputController  orderWorkRestrictionInputController;

	public void setOrderWorkRestrictionInputController(
			OrderWorkRestrictionInputController orderWorkRestrictionInputController) {
		this.orderWorkRestrictionInputController = orderWorkRestrictionInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder ctScanStr = new StringBuilder(orderWorkRestrictionInputController.str);
			ctScanStr.append("\n\n ");
			orderWorkRestrictionInputController.str = ctScanStr.toString();

			
				
				if(rightRadio.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("Limit repetitive motions of the right hand.");
					orderWorkRestrictionInputController.str = str11.toString();
					
				}if(leftRadio.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
					str1.append("Limit repetitive motions of the left hand.");
					orderWorkRestrictionInputController.str = str1.toString();
					
				}
				
				
				
			

			++orderWorkRestrictionInputController.formCount;
			orderWorkRestrictionInputController.setWorkRestrictionUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		
		
		skipBtn.setOnAction((event) -> {
			try {
				
				++orderWorkRestrictionInputController.formCount;
				orderWorkRestrictionInputController.setWorkRestrictionUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
