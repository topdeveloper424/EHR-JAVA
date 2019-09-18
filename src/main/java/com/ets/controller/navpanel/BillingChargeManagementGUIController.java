package com.ets.controller.navpanel;



import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class BillingChargeManagementGUIController implements Initializable{
	
		@FXML
    	private AnchorPane billingPanelAnchorPane;
	  
	    @FXML
	    private Button reviewChargesByCompanyButton;

	    @FXML
	    private Button reviewChargesByAccountButton;

	    @FXML
	    private Button reviewChargesByPatientButton;

	    @FXML
	    private Button clinicButton;

	    @FXML
	    private Button closeButton;
	    
	    @FXML
    	private Button reviewChargesByDateButton;
	    
    
	  FXMLFormPath formPath = new FXMLFormPath();
	  
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		/*reviewChargesByDateButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("SelectChargesByDate", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SelectChargesByDate", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
		closeButton.setOnAction((event) -> {
			try {
				// Clear from view Current Navigation Panel
				billingPanelAnchorPane.getChildren().clear();
				// Display SetupAdmin Navigation Panel
				String formName = formPath.context.getMessage("BillingPanel", null, Locale.US);
				formPath.closeApplicationContext();
				billingPanelAnchorPane.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}
	
}
