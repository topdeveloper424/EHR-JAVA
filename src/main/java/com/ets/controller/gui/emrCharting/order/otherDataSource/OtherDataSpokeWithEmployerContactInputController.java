package com.ets.controller.gui.emrCharting.order.otherDataSource;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class OtherDataSpokeWithEmployerContactInputController implements Initializable{
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextField nameText;
	    
	    
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

			
				if(nameText.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(orderOtherDataSourceInputController.str);
				str11.append("Spoke with following employer representative regarding patient's injury, evaluation, or work status " +nameText.getText() +". " );
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
