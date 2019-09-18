package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class DiagonosticOrthostaticBloodPressureInputController implements Initializable{
	
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton Cellutitis;

	    @FXML
	    private ToggleGroup sel;

	    @FXML
	    private RadioButton Typhoid;

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

				
				if(Cellutitis.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Orthostatics Ordered L03.311-Cellulitis of abdominal wall.");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(Typhoid.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Orthostatics Ordered A01.04-");
					orderDiagonosticTestInputController.str = str1.toString();
					
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
