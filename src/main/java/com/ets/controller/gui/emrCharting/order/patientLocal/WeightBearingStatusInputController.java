package com.ets.controller.gui.emrCharting.order.patientLocal;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

public class WeightBearingStatusInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox NonWeightCheck;

    @FXML
    private CheckBox TouchDownCheck;

    @FXML
    private CheckBox PartialWeightCheck;

    @FXML
    private CheckBox FullWeightCheck;

    @FXML
    private TextArea otherWeightTextarea;

    @FXML
    private CheckBox cruchesCheck;

    @FXML
    private CheckBox walkerCheck;
	
	
	private OrderPatientLocalMeasureInputController orderPatientLocalMeasureInputController;

	public void setOrderPatientLocalMeasureInputController(
			OrderPatientLocalMeasureInputController orderPatientLocalMeasureInputController) {
		this.orderPatientLocalMeasureInputController = orderPatientLocalMeasureInputController;
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder ctScanStr = new StringBuilder(orderPatientLocalMeasureInputController.str);
			ctScanStr.append("\n\nWeight-bearing status is:  ");
			orderPatientLocalMeasureInputController.str = ctScanStr.toString();

			
		
				
				
				if(NonWeightCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str1.append("Non wieght-bearing,");
					orderPatientLocalMeasureInputController.str = str1.toString();
					
				}if(TouchDownCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str11.append("Touch down weightbearing,");
					orderPatientLocalMeasureInputController.str = str11.toString();
					
				}if(PartialWeightCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str1.append(" Partial weight-bearing,");
					orderPatientLocalMeasureInputController.str = str1.toString();
					
				}if(FullWeightCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str11.append("Full weight-bearing,");
					orderPatientLocalMeasureInputController.str = str11.toString();
					
				}
				
			
			
				if(otherWeightTextarea.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(orderPatientLocalMeasureInputController.str);
				str11.append("" +otherWeightTextarea.getText() +". " );
				orderPatientLocalMeasureInputController.str = str11.toString();
				
			}
				
				
				if(cruchesCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str1.append(" Must use crutches.");
					orderPatientLocalMeasureInputController.str = str1.toString();
					
				}
				
				if(walkerCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str11.append(" Must use walker.");
					orderPatientLocalMeasureInputController.str = str11.toString();
					
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
