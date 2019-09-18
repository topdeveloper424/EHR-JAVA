package com.ets.controller.gui.vitalSignRange;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class VitalSignRangeInputController implements Initializable {
	
	 @FXML
	    private Button addVitalSignValueButton;

	    @FXML
	    private Button cancelButton;
	    
	    @FXML
	    private Button okBtn;
	    
	    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		addVitalSignValueButton.setOnAction((event) -> {
			try {
			
				String formName = formPath.context.getMessage("AddVitalSignValue", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddVitalSignValue", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		// Centralised Form cancel
		cancelButton.setOnAction((event) -> {
					try {
						new FXFormCommonUtilities().closeForm(cancelButton);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
		
		
		
		
		
	}

}
