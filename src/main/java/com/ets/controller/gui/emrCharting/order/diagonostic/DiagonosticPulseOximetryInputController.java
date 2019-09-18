package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class DiagonosticPulseOximetryInputController implements Initializable{
	
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton OnRoom;

	    @FXML
	    private ToggleGroup jamar;

	    @FXML
	    private RadioButton OnSupplimental;
	    
	    private OrderDiagonosticTestInputController orderDiagonosticTestInputController;

		public void setOrderDiagonosticTestInputController(
					OrderDiagonosticTestInputController orderDiagonosticTestInputController) {
				this.orderDiagonosticTestInputController = orderDiagonosticTestInputController;
			}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder pmhSocialHitoryStr = new StringBuilder(orderDiagonosticTestInputController.str);
			pmhSocialHitoryStr.append("\n\n ");
			orderDiagonosticTestInputController.str = pmhSocialHitoryStr.toString();

			
			if(OnRoom.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Pulse Oximetry was ordered On Room Air. ");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(OnSupplimental.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("Pulse Oximetry was ordered On Supplemental O2.");
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
