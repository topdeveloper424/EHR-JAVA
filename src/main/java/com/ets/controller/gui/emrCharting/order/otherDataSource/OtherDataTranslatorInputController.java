package com.ets.controller.gui.emrCharting.order.otherDataSource;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

public class OtherDataTranslatorInputController implements Initializable{
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox spanishCheck;

	    @FXML
	    private CheckBox otherCheck;

	    @FXML
	    private TextArea firstNameText;
	
	
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

			
			if(spanishCheck.isSelected() || otherCheck.isSelected()){
				
				StringBuilder str121 = new StringBuilder(orderOtherDataSourceInputController.str);
				str121.append("Language Interpreted Into English: ");
				orderOtherDataSourceInputController.str = str121.toString();
				
				
				
				if(spanishCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderOtherDataSourceInputController.str);
					str1.append("Spanish ");
					orderOtherDataSourceInputController.str = str1.toString();
					
				}if(otherCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderOtherDataSourceInputController.str);
					str11.append("Other ");
					orderOtherDataSourceInputController.str = str11.toString();
					
				}
				
								
			}
			
			
				if(firstNameText.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(orderOtherDataSourceInputController.str);
				str11.append(" First and Last Name of Interpreter (Min 15 minutes): " +firstNameText.getText() +" . " );
				orderOtherDataSourceInputController.str = str11.toString();
				
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
