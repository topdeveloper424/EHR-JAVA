package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class DiagonosticUrinalysisUrineTestOrderInputController implements Initializable {
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox urineDipCheck;

	    @FXML
	    private CheckBox urineHCGCheck;

	    @FXML
	    private CheckBox urineInstantCheck;
	
	private OrderDiagonosticTestInputController orderDiagonosticTestInputController;

	public void setOrderDiagonosticTestInputController(
				OrderDiagonosticTestInputController orderDiagonosticTestInputController) {
			this.orderDiagonosticTestInputController = orderDiagonosticTestInputController;
		}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		doneBtn.setOnAction((event) -> {

			StringBuilder pmhSocialHitoryStr = new StringBuilder(orderDiagonosticTestInputController.str);
			pmhSocialHitoryStr.append("\n\n ");
			orderDiagonosticTestInputController.str = pmhSocialHitoryStr.toString();

			
						
			
			if(urineDipCheck.isSelected() 
					
					|| urineHCGCheck.isSelected() || urineInstantCheck.isSelected()){
				
				StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
				str.append("Ordered the following test(s) to be performed in house: ");
				orderDiagonosticTestInputController.str = str.toString();
				
				if(urineDipCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Urine dip stick Without Scope, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(urineHCGCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Urine HCG ( Pregnancy Test), ");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(urineInstantCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Urine - Instant Analysis ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}
				
				StringBuilder str12 = new StringBuilder(orderDiagonosticTestInputController.str);
				str12.append(".");
				orderDiagonosticTestInputController.str = str12.toString();
				
			}
			
			
			

			++orderDiagonosticTestInputController.formCount;
			orderDiagonosticTestInputController.setDiagonosisTestUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		
		
		skipBtn.setOnAction((event) -> {
			try {
				
				++orderDiagonosticTestInputController.formCount;
				orderDiagonosticTestInputController.setDiagonosisTestUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}


}
