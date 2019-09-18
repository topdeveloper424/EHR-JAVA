package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DiagonosticLabOrderMicroBiologyInputController implements Initializable{
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox urinalysisCheck;

	    @FXML
	    private CheckBox urineCheck;

	    @FXML
	    private CheckBox strepCheck;

	    @FXML
	    private CheckBox bloodCultureCheck;

	    @FXML
	    private CheckBox woundCheck;

	    @FXML
	    private CheckBox stoolForOPCheck;

	    @FXML
	    private CheckBox stoolCheck;

	    @FXML
	    private CheckBox uricCheck;

    
	
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

			if(urinalysisCheck.isSelected() || urineCheck.isSelected()
					|| strepCheck.isSelected() || woundCheck.isSelected()
					|| bloodCultureCheck.isSelected() || stoolForOPCheck.isSelected()
					|| stoolCheck.isSelected() || uricCheck.isSelected()){
				
				StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
				str.append("Ordered the following microbiology panel(s): ");
				orderDiagonosticTestInputController.str = str.toString();
				
				if(urinalysisCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" urinalysis,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(urineCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" urine culture, ");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(strepCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" strep culture, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(woundCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" wound culture,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(bloodCultureCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" blood culture,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(stoolForOPCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("stool for O+ P,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(stoolCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" stool for occult blood");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(uricCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("stool for uric acid ");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("");
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
