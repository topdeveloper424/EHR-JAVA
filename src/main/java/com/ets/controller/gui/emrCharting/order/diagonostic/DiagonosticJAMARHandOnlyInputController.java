package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class DiagonosticJAMARHandOnlyInputController implements Initializable{
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton JAMARLeft;

	    @FXML
	    private ToggleGroup jamar;

	    @FXML
	    private RadioButton JAMARBilateral;

	    @FXML
	    private RadioButton JAMARRight;

	    @FXML
	    private RadioButton dominantRight;

	    @FXML
	    private ToggleGroup dominant;

	    @FXML
	    private RadioButton dominantLeft;

	    @FXML
	    private RadioButton dominantAmbidextrous;
	
	 private OrderDiagonosticTestInputController orderDiagonosticTestInputController;

	    public void setOrderDiagonosticTestInputController(
				OrderDiagonosticTestInputController orderDiagonosticTestInputController) {
			this.orderDiagonosticTestInputController = orderDiagonosticTestInputController;
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder ctScanStr = new StringBuilder(orderDiagonosticTestInputController.str);
			ctScanStr.append("\n\n ");
			orderDiagonosticTestInputController.str = ctScanStr.toString();

			if(JAMARBilateral.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("JAMAR, Affected Extremity: Bilateral");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			
			if(JAMARLeft.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("JAMAR, Affected Extremity: Left");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}
						
			if(JAMARRight.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("JAMAR, Affected Extremity: Right");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			
			
			if(dominantAmbidextrous.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append(" Dominant Hand: Ambidextrous.");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(dominantLeft.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append(" Dominant Hand: Left.");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			if(dominantRight.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append(" Dominant Hand: Right.");
				orderDiagonosticTestInputController.str = str11.toString();
				
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
