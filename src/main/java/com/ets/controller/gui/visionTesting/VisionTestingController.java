package com.ets.controller.gui.visionTesting;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class VisionTestingController implements Initializable{
	
	  @FXML
	    private Button add;

  @FXML
  private Button clsbtn;
  
  FXMLFormPath formPath = new FXMLFormPath();
  
  @Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		clsbtn.setOnAction((event) -> {
			try {
				//cancel centralized form
				new FXFormCommonUtilities().closeForm( clsbtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		add.setOnAction((event) -> {
		try {

		//  Load and Display - Macro_text_defination.fxml Form
			
			String formName = formPath.context.getMessage("AddVisionTesting", null, Locale.US);
			formPath.closeApplicationContext();
			String formTitle = "Enter Visit Testing Parameter" ;
			new FXFormCommonUtilities().displayForm( formName , formTitle);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
		
	});
	}

}
