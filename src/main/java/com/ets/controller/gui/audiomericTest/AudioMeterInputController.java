package com.ets.controller.gui.audiomericTest;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;



import com.ets.model.AudioMeterTestParamGen;



import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AudioMeterInputController implements Initializable {

	@FXML
	private Button equipmentModelBtn;

	@FXML
	private Button okBtn;

	@FXML
	private Button cancelBtn;
	
	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		equipmentModelBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewEquipmentModel", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewEquipmentModel", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		cancelBtn.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(cancelBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
		
		
		/*okBtn.setOnAction((event)-> {
			
			AudioMeterTestParamGen audioMeterTest = new AudioMeterTestParamGen();
			//audioMeterTest.setSignifyNoResponse();
			
			
			
			
			
			
			
		         });*/
		
	        }
	 	 
	}


