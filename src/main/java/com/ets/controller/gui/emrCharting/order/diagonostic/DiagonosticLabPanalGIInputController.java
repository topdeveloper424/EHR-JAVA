package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DiagonosticLabPanalGIInputController implements Initializable{
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox CBCCheck;

	    @FXML
	    private CheckBox amylaseCheck;

	    @FXML
	    private CheckBox hepaticCheck;

	    @FXML
	    private CheckBox lipaseCheck;
	
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

			if(CBCCheck.isSelected() || amylaseCheck.isSelected()
					|| hepaticCheck.isSelected() || lipaseCheck.isSelected()){
				
				StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
				str.append("Ordered the following lab panel(s) to be sent to an outside lab: ");
				orderDiagonosticTestInputController.str = str.toString();
				
				if(CBCCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("CBC,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(amylaseCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Amylase,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(hepaticCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Hepatic Panel,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(lipaseCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Lipase");
					orderDiagonosticTestInputController.str = str1.toString();
					
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
