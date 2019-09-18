package com.ets.controller.gui.visionTesting;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class VisionTestEquipmentViewController implements Initializable {
	
    @FXML
    private Button addBtn;

    @FXML
    private Button closeBtn;
    
    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		addBtn.setOnAction((event) -> {
			try {
			//  Load and Display - Select_Visit_Category_Code.fxml Form
				String formName = formPath.context.getMessage("AddEquipment", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddEquipment", null, Locale.US);
				formPath.closeApplicationContext();
			
				new FXFormCommonUtilities().displayForm( formName , formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		closeBtn.setOnAction((event) -> {
			try {
				//cancel centralized form
				new FXFormCommonUtilities().closeForm( closeBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
