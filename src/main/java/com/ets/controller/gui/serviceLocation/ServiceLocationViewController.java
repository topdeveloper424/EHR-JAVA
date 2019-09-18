package com.ets.controller.gui.serviceLocation;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ServiceLocationViewController implements Initializable {

	@FXML
    private Button addButton;

    @FXML
    private Button changeButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button closeButton;

    @FXML
    private Button topButton;

    @FXML
    private Button upButton;

    @FXML
    private Button downButton;

    @FXML
    private Button bottomButton;
    
	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		addButton.setOnAction((event) -> {
			try {
			
				String formName = formPath.context.getMessage("AddServiceLocation", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddServiceLocation", null, Locale.US);
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
