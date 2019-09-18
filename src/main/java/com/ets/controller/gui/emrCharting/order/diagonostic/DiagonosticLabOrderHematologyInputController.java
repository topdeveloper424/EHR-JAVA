package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DiagonosticLabOrderHematologyInputController implements Initializable{
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox cbcWithCheck;

	    @FXML
	    private CheckBox hemoglobinCheck;

	    @FXML
	    private CheckBox stoolForCheck;

	    @FXML
	    private CheckBox pttCheck;

	    @FXML
	    private CheckBox ptprothrombinCheck;
	    
	
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

			if(cbcWithCheck.isSelected() || hemoglobinCheck.isSelected()
					|| stoolForCheck.isSelected() || ptprothrombinCheck.isSelected()
					|| pttCheck.isSelected() ){
				
				StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
				str.append("Ordered the following hematology panel(s): 	");
				orderDiagonosticTestInputController.str = str.toString();
				
				if(cbcWithCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" CBC with differential,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(hemoglobinCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" hemoglobin / hematocrit,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(stoolForCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" stool for occult blood,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(ptprothrombinCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" PT - Prothrombin Time (Send Out),");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(pttCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" PTT - Partial Thromb Time  (Send Out)");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append(".");
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
