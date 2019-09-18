package com.ets.controller.gui.emrCharting.order.consult;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ConsultAcupunctureReferalInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton session2Radio;

	    @FXML
	    private ToggleGroup fre;

	    @FXML
	    private RadioButton session3Radio;

	    @FXML
	    private RadioButton week3Radio;

	    @FXML
	    private ToggleGroup dura;

	    @FXML
	    private RadioButton week4Radio;

	    @FXML
	    private RadioButton week5Radio;

	    @FXML
	    private RadioButton week6Radio;
	    
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

			if(session2Radio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderConsultInputController.str);
				str1.append("I recommended a consultation with a qualified acupuncturist at a frequency of 2 sessions per week");
				orderConsultInputController.str = str1.toString();
				
			}
			
			if(session3Radio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
				str11.append("I recommended a consultation with a qualified acupuncturist at a frequency of 3 sessions per week");
				orderConsultInputController.str = str11.toString();
				
			}
			
			
			
			
			if(week3Radio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderConsultInputController.str);
				str1.append(" for 3 weeks.");
				orderConsultInputController.str = str1.toString();
				
			}
			
			if(week4Radio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
				str11.append(" for 4 weeks.");
				orderConsultInputController.str = str11.toString();
				
			}if(week5Radio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderConsultInputController.str);
				str1.append(" for 5 weeks.");
				orderConsultInputController.str = str1.toString();
				
			}
			
			if(week6Radio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
				str11.append(" for 6 weeks.");
				orderConsultInputController.str = str11.toString();
				
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
