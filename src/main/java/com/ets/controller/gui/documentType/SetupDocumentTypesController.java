package com.ets.controller.gui.documentType;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;

public class SetupDocumentTypesController implements Initializable{


    @FXML
    private Button add;

    @FXML
    private Button clsbtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		FXMLFormPath formPath = new FXMLFormPath();
		
		// TODO Auto-generated method stub
				add.setOnAction((event) -> {
					try {

					//  Load and Display - Macro_text_defination.fxml Form
						
						String formName = formPath.context.getMessage("AddDocumentImageTypes", null, Locale.US);
						formPath.closeApplicationContext();
						String formTitle = "Setup Document Type" ;
						new FXFormCommonUtilities().displayForm( formName , formTitle);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					
				});
				
				clsbtn.setOnAction((event) -> {
					try {
						//cancel centralized form
						new FXFormCommonUtilities().closeForm( clsbtn);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
	}

}
