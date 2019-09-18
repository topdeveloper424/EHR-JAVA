package com.ets.controller.gui.emrCharting.order.patientLocal;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class PatientLocalMeasureInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox HeatToCheck;

	    @FXML
	    private CheckBox affectedAreaCheck;

	    @FXML
	    private CheckBox ElevationCheck;

	    @FXML
	    private CheckBox SalineCheck;

	    @FXML
	    private CheckBox HumidificationCheck;

	    @FXML
	    private CheckBox ClearCheck;

	    @FXML
	    private CheckBox iceWrapCheck;

	    @FXML
	    private CheckBox bratCheck;

	    @FXML
	    private TextField hoursText;

	    @FXML
	    private RadioButton hourRadio;

	    @FXML
	    private ToggleGroup tim;

	    @FXML
	    private RadioButton dayRadio;

	
	
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

			
			if(HeatToCheck.isSelected() || ElevationCheck.isSelected()
					|| SalineCheck.isSelected() || ClearCheck.isSelected()
					|| bratCheck.isSelected() || HumidificationCheck.isSelected()
					|| iceWrapCheck.isSelected() || affectedAreaCheck.isSelected()){
				
				StringBuilder str121 = new StringBuilder(orderPatientLocalMeasureInputController.str);
				str121.append("Recommended patient take the following local measures at home: ");
				orderPatientLocalMeasureInputController.str = str121.toString();
				
				
						
				if(HeatToCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str1.append("heat to affected area, ");
					orderPatientLocalMeasureInputController.str = str1.toString();
					
				}if(ElevationCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str11.append("elevation, ");
					orderPatientLocalMeasureInputController.str = str11.toString();
					
				}if(SalineCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str1.append("saline gargles, ");
					orderPatientLocalMeasureInputController.str = str1.toString();
					
				}if(ClearCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str11.append("clear liquids ");
					orderPatientLocalMeasureInputController.str = str11.toString();
					
				}if(bratCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str1.append("BRAT diet, ");
					orderPatientLocalMeasureInputController.str = str1.toString();
					
				}if(HumidificationCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str11.append("humidification, ");
					orderPatientLocalMeasureInputController.str = str11.toString();
					
				}if(iceWrapCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str1.append("ice wrap, ");
					orderPatientLocalMeasureInputController.str = str1.toString();
					
				}if(affectedAreaCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str11.append("ice to affected area, ");
					orderPatientLocalMeasureInputController.str = str11.toString();
					
				}
				
				StringBuilder str = new StringBuilder(orderPatientLocalMeasureInputController.str);
				str.append(".");
				orderPatientLocalMeasureInputController.str = str.toString();
				
			}
			
			
				if(hoursText.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(orderPatientLocalMeasureInputController.str);
				str11.append("Every " +hoursText.getText() +" " );
				orderPatientLocalMeasureInputController.str = str11.toString();
				
			}
				
				
				if(hourRadio.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str1.append("hours.");
					orderPatientLocalMeasureInputController.str = str1.toString();
					
				}
				
				if(dayRadio.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderPatientLocalMeasureInputController.str);
					str11.append("days.");
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
