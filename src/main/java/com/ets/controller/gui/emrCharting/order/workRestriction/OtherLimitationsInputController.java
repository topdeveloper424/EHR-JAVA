package com.ets.controller.gui.emrCharting.order.workRestriction;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.order.OrderWorkRestrictionInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class OtherLimitationsInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextArea freeText;
	
	
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

				
				if(freeText.getText().length() > 0){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("Other limitations include: " +freeText.getText() +". " );
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
