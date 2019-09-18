package com.ets.controller.gui.vitalSignRange;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class VitalSignRangeViewController implements Initializable {
	
	@FXML
    private Button addButton;

    @FXML
    private Button changeButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button closeButton;
    
    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		addButton.setOnAction((event) -> {
			try {
			
				String formName = formPath.context.getMessage("AddVitalSignRange", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddVitalSignRange", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		// Centralised Form cancel
				closeButton.setOnAction((event) -> {
					try {
						new FXFormCommonUtilities().closeForm(closeButton);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
		
	}

}
