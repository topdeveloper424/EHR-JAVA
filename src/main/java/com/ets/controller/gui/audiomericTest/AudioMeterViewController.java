package com.ets.controller.gui.audiomericTest;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AudioMeterViewController implements Initializable {
	
	   @FXML
	    private Button addButton;

	    @FXML
	    private Button closeButton;
	    
	    FXMLFormPath formPath = new FXMLFormPath();

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			addButton.setOnAction((event) -> {
				try {

					String formName = formPath.context.getMessage("AddAudioMeter", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.AddAudioMeter", null, Locale.US);
					formPath.closeApplicationContext();

					new FXFormCommonUtilities().displayForm(formName, formTitle);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			
			closeButton.setOnAction((event) -> {
				try {
					// cancel centralized form
					new FXFormCommonUtilities().closeForm(closeButton);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			
		}

}
