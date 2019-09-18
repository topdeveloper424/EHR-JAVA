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

public class WalkingStandingInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton NoprolongedRadio;

    @FXML
    private ToggleGroup bend;

    @FXML
    private RadioButton noWalkingStandingRadio;

    @FXML
    private TextField timeText;

    @FXML
    private RadioButton noWalkingRadio;

    @FXML
    private RadioButton walkingStandingLimitedRadio;

    @FXML
    private RadioButton standingLimitedRadio;

    @FXML
    private RadioButton noStandingRadio;

    @FXML
    private RadioButton walkingLimitedRadio;
	
	
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

			
				
				if(NoprolongedRadio.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("No prolonged walking or standing ");
					orderWorkRestrictionInputController.str = str11.toString();
					
				}if(noWalkingStandingRadio.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
					str1.append("No walking or standing ");
					orderWorkRestrictionInputController.str = str1.toString();
					
				}if(walkingStandingLimitedRadio.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("Walking and standing limited ");
					orderWorkRestrictionInputController.str = str11.toString();
					
				}if(standingLimitedRadio.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
					str1.append("Standing limited ");
					orderWorkRestrictionInputController.str = str1.toString();
					
				}if(noWalkingRadio.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("No walking ");
					orderWorkRestrictionInputController.str = str11.toString();
					
				}if(noStandingRadio.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
					str1.append("No standing ");
					orderWorkRestrictionInputController.str = str1.toString();
					
				}if(walkingLimitedRadio.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("walking limited ");
					orderWorkRestrictionInputController.str = str11.toString();
					
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
