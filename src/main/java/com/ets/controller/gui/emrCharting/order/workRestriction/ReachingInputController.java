package com.ets.controller.gui.emrCharting.order.workRestriction;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.order.OrderWorkRestrictionInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ReachingInputController implements Initializable {
	
	
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox AboveShoulderCheck;

	    @FXML
	    private CheckBox AboveHeadCheck;

	    @FXML
	    private CheckBox AwayfromBodyCheck;
	
	
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

			
				
				if(AboveShoulderCheck.isSelected() || AboveHeadCheck.isSelected()
						|| AwayfromBodyCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("No reaching ");
					orderWorkRestrictionInputController.str = str11.toString();
					
					
					if(AboveShoulderCheck.isSelected()){
						
						StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
						str1.append("above shoulder level. ");
						orderWorkRestrictionInputController.str = str1.toString();
						
					}
					
					if(AboveHeadCheck.isSelected()){
						
						StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
						str1.append("above head. ");
						orderWorkRestrictionInputController.str = str1.toString();
						
					}
					
					if(AwayfromBodyCheck.isSelected()){
						
						StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
						str1.append("above head. ");
						orderWorkRestrictionInputController.str = str1.toString();
						
					}
					
					
					
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
