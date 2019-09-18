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

public class BendingTwistingInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton NoBendingOrTwistingRadio;

    @FXML
    private ToggleGroup bend;

    @FXML
    private RadioButton NoTwistingRadio;

    @FXML
    private RadioButton NoBendingRadio;

    @FXML
    private RadioButton BendingLimitedRadio;

    @FXML
    private RadioButton BendingOrTwistingLimitedRadio;

    @FXML
    private RadioButton TwistingLimitedRadio;

    @FXML
    private TextField timeText;
	
	
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

			
			
				if(NoBendingOrTwistingRadio.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("No bending or twisting ");
					orderWorkRestrictionInputController.str = str11.toString();
					
				}if(NoBendingRadio.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
					str1.append("No bending ");
					orderWorkRestrictionInputController.str = str1.toString();
					
				}if(NoTwistingRadio.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("No twisting ");
					orderWorkRestrictionInputController.str = str11.toString();
					
				}if(BendingOrTwistingLimitedRadio.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
					str1.append("Bending or twisting limited ");
					orderWorkRestrictionInputController.str = str1.toString();
					
				}if(BendingLimitedRadio.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("Bending limited ");
					orderWorkRestrictionInputController.str = str11.toString();
					
				}if(TwistingLimitedRadio.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
					str1.append("Twisting limited ");
					orderWorkRestrictionInputController.str = str1.toString();
					
				}
				
				
				
				if(timeText.getText().length() > 0){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("to " +timeText.getText() +" hours per day." );
					orderWorkRestrictionInputController.str = str11.toString();
					
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
