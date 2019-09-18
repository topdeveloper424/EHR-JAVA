package com.ets.controller.gui.emrCharting.order.consult;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ConsultPcpUcInputController implements Initializable {
	
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox includeCheck;
	 private OrderConsultInputController orderConsultInputController;

		public void setOrderConsultInputController(OrderConsultInputController orderConsultInputController) {
				this.orderConsultInputController = orderConsultInputController;
			}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		doneBtn.setOnAction((event) -> {

			StringBuilder acupunctureReferalStr = new StringBuilder(orderConsultInputController.str);
			acupunctureReferalStr.append("\n\n ");
			orderConsultInputController.str = acupunctureReferalStr.toString();

			if(includeCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderConsultInputController.str);
				str1.append("Patient advised to follow up with their Primary Care Physician (PCP) with two days.  If symptoms worsen before PCP visit return to the Urgent Care.  If symptoms are severe,  go to the nearest emergency room.");
				orderConsultInputController.str = str1.toString();
				
			}
			
		
			

			++orderConsultInputController.formCount;
			orderConsultInputController.setConsultUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		
		
		skipBtn.setOnAction((event) -> {
			try {
				
				++orderConsultInputController.formCount;
				orderConsultInputController.setConsultUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
