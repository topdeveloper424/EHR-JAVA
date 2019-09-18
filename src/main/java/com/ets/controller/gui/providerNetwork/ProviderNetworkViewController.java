package com.ets.controller.gui.providerNetwork;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 11-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ViewProviderNetworkController Class
 *Description: SelectProviderNetwork.fxml Controller class
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

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

@SuppressWarnings("restriction")
public class ProviderNetworkViewController implements Initializable {
	
	@FXML
    private Button addBtn;

    @FXML
    private Button closeBtn;
    
	FXMLFormPath formPath = new FXMLFormPath();

	
	@Override
	public void initialize(URL location, ResourceBundle resource) {
		
		addBtn.setOnAction((event) -> {
			try {
				// Load Network Provider Details Entry form .
				
				String formName = formPath.context.getMessage("AddProviderNetWork", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddProviderNetWork", null, Locale.US);
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
