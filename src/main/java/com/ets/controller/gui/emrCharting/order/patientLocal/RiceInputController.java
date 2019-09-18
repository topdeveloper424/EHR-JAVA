package com.ets.controller.gui.emrCharting.order.patientLocal;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class RiceInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox aceWrapCheck;

    @FXML
    private CheckBox ankleCheck;

    @FXML
    private CheckBox kneeCheck;
	
	private OrderPatientLocalMeasureInputController orderPatientLocalMeasureInputController;

	public void setOrderPatientLocalMeasureInputController(
			OrderPatientLocalMeasureInputController orderPatientLocalMeasureInputController) {
		this.orderPatientLocalMeasureInputController = orderPatientLocalMeasureInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder ctScanStr = new StringBuilder(orderPatientLocalMeasureInputController.str);
			ctScanStr.append("\n\n ");
			orderPatientLocalMeasureInputController.str = ctScanStr.toString();

			
			if(aceWrapCheck.isSelected() || ankleCheck.isSelected()
					|| kneeCheck.isSelected()){
				
				StringBuilder str121 = new StringBuilder(orderPatientLocalMeasureInputController.str);
				str121.append("Rest, Ice, Compression and Elevation. Compression can be accomplished with; ");
				orderPatientLocalMeasureInputController.str = str121.toString();
				
				
				
				if(aceWrapCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str1.append("Ace wrap, ");
					orderPatientLocalMeasureInputController.str = str1.toString();
					
				}if(ankleCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str11.append("Ankle sleeve, ");
					orderPatientLocalMeasureInputController.str = str11.toString();
					
				}if(kneeCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str1.append("Knee sleeve .");
					orderPatientLocalMeasureInputController.str = str1.toString();
					
				}
				
				StringBuilder str = new StringBuilder(orderPatientLocalMeasureInputController.str);
				str.append("Importance of follow-up stressed.");
				orderPatientLocalMeasureInputController.str = str.toString();
				
			}
			
				
			

			++orderPatientLocalMeasureInputController.formCount;
			orderPatientLocalMeasureInputController.setPatientLocalMeasureUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		
		
		skipBtn.setOnAction((event) -> {
			try {
				
				++orderPatientLocalMeasureInputController.formCount;
				orderPatientLocalMeasureInputController.setPatientLocalMeasureUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
