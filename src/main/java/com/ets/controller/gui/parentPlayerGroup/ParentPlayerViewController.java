package com.ets.controller.gui.parentPlayerGroup;



import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-06-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ViewAllParentPlayerController Class
 *Description: SelectCorporateParentPlayerOrganization.fxml Controller class
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
public class ParentPlayerViewController implements Initializable {
	
	@FXML
	private TextField searchTextField;
	
	@FXML
	private CheckBox includeInactiveCheckBox;
	
	@FXML
	private ChoiceBox playerTypeChoiceBox;
	
	@FXML
    private Button topButton;
	
	@FXML
    private Button upButton;
	
	@FXML
    private Button downButton;
	
	@FXML
    private Button bottomButton;
	
	@FXML
    private Button addButton;

	@FXML
	private Button closeButton;
	    
	@FXML
	private Button changeButton;
	    
	@FXML
	private Button deleteButton;
	    
    
    FXMLFormPath formPath = new FXMLFormPath();
	
	@Override
	public void initialize(URL location, ResourceBundle resource) {
		
		addButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("AddParentPlayer", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddParentPlayer", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm( formName , formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		// Centralised Form cancel
		closeButton.setOnAction((event) -> {
								try {
									new FXFormCommonUtilities().closeForm( closeButton );
								} catch (Exception ex) {
									ex.printStackTrace();
								}
							});
				
		
	}

}
