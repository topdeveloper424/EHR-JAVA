package com.ets.controller.gui.providerNetwork;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 11-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ProviderNetworkGUIController Class
 *Description: EnterProviderNetwork.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.note.NoteEntityController;
import com.ets.model.Note;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ProviderNetworkInputController implements Initializable {
	
	@FXML
    private Button carrierBtn;
	
	@FXML
    private Button closeBtn;
	
	  @FXML
	    private TextField descriptionTextField;

	    @FXML
	    private CheckBox inactiveNote;

	    @FXML
	    private Button okButton;
	
	FXMLFormPath formPath = new FXMLFormPath();

@Override
public void initialize(URL location, ResourceBundle reources) {
	
	carrierBtn.setOnAction((event) -> {
		try {
			// Load Third Party Details Entry form .
		
			String formName = formPath.context.getMessage("Carrier", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.Carrier", null, Locale.US);
			formPath.closeApplicationContext();
		
			new FXFormCommonUtilities().displayForm( formName , formTitle);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	});
	
	// Centralised Form cancel
	closeBtn.setOnAction((event) -> {
					try {
						new FXFormCommonUtilities().closeForm( closeBtn );
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
	
		
	
}

}
