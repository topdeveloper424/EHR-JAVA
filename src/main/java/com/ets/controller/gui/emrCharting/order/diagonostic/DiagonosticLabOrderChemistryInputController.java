package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DiagonosticLabOrderChemistryInputController implements Initializable{
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox CompCheck;

	    @FXML
	    private CheckBox glucoseCheck;

	    @FXML
	    private CheckBox ElectrolytesCheck;

	    @FXML
	    private CheckBox lipidPanelCheck;

	    @FXML
	    private CheckBox basicCheck;

	    @FXML
	    private CheckBox tshCheck;

	    @FXML
	    private CheckBox GlycohemoglobinCheck;

	    @FXML
	    private CheckBox uricAcidCheck;

	    @FXML
	    private CheckBox urineCheck;

	
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

			if(CompCheck.isSelected() || glucoseCheck.isSelected()
					|| ElectrolytesCheck.isSelected() || basicCheck.isSelected()
					|| lipidPanelCheck.isSelected() || tshCheck.isSelected()
					|| GlycohemoglobinCheck.isSelected() || urineCheck.isSelected()
					|| uricAcidCheck.isSelected() ){
				
				StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
				str.append("Ordered the following chemistry panel(s): ");
				orderDiagonosticTestInputController.str = str.toString();
				
				if(CompCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("comp metabolic profile,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(glucoseCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" glucose,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(ElectrolytesCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("electrolytes, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(basicCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" basic metabolic profile,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(lipidPanelCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("lipid panel,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(tshCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("TSH,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(GlycohemoglobinCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" glycohemoglobin,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(urineCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" urine microalbumin,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(uricAcidCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("lipid panel");
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
