package com.ets.controller.gui.emrCharting.order.workRestriction;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.order.OrderWorkRestrictionInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class LiftingPoundsInputController implements Initializable {
	
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton leftRadio;

    @FXML
    private ToggleGroup bend;

    @FXML
    private RadioButton rightRadio;

    @FXML
    private RadioButton eitherRadio;

    @FXML
    private TextField liftingText;

	
	
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

			
			if(liftingText.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
				str11.append("No lifting greater than " +liftingText.getText() +" pounds" );
				orderWorkRestrictionInputController.str = str11.toString();
				
			}
				if(leftRadio.isSelected()){
						
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append(" with left arm.");
					orderWorkRestrictionInputController.str = str11.toString();
					
				}if(rightRadio.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
					str1.append(" with right arm.");
					orderWorkRestrictionInputController.str = str1.toString();
					
				}
				
				
				
               if(eitherRadio.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
					str1.append(" with either arm.");
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
