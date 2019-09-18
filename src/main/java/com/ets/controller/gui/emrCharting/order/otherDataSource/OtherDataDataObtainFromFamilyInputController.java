package com.ets.controller.gui.emrCharting.order.otherDataSource;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class OtherDataDataObtainFromFamilyInputController implements Initializable{
	
	

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox momCheck;

    @FXML
    private CheckBox dadCheck;

    @FXML
    private CheckBox caregiverCheck;
	
	
	private OrderOtherDataSourceInputController orderOtherDataSourceInputController;

	public void setOrderOtherDataSourceInputController(
			OrderOtherDataSourceInputController orderOtherDataSourceInputController) {
		this.orderOtherDataSourceInputController = orderOtherDataSourceInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder ctScanStr = new StringBuilder(orderOtherDataSourceInputController.str);
			ctScanStr.append("\n\n ");
			orderOtherDataSourceInputController.str = ctScanStr.toString();

			
				
				if(momCheck.isSelected() || dadCheck.isSelected()
						|| caregiverCheck.isSelected()){
					
					StringBuilder str121 = new StringBuilder(orderOtherDataSourceInputController.str);
					str121.append("Obtained Case Data From: ");
					orderOtherDataSourceInputController.str = str121.toString();
					
					
					if(momCheck.isSelected()){
						
						StringBuilder str1 = new StringBuilder(orderOtherDataSourceInputController.str);
						str1.append("Mom, ");
						orderOtherDataSourceInputController.str = str1.toString();
						
					}if(dadCheck.isSelected()){
						
						StringBuilder str11 = new StringBuilder(orderOtherDataSourceInputController.str);
						str11.append("Dad, ");
						orderOtherDataSourceInputController.str = str11.toString();
						
					}if(caregiverCheck.isSelected()){
						
						StringBuilder str1 = new StringBuilder(orderOtherDataSourceInputController.str);
						str1.append("caregiver, ");
						orderOtherDataSourceInputController.str = str1.toString();
						
					}
					
					
					
					StringBuilder str = new StringBuilder(orderOtherDataSourceInputController.str);
					str.append(".");
					orderOtherDataSourceInputController.str = str.toString();
					
				}
				
				
			

			++orderOtherDataSourceInputController.formCount;
			orderOtherDataSourceInputController.setOtherDataSource();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		
		
		skipBtn.setOnAction((event) -> {
			try {
				
				++orderOtherDataSourceInputController.formCount;
				orderOtherDataSourceInputController.setOtherDataSource();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
