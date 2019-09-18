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

public class ReportingGUIController implements Initializable{
	
	@FXML
    private AnchorPane reportingPanelAnchorpane;
	
	@FXML
    private Button cashReconBtn;
	
    @FXML
    private Button clinicBtn;

    @FXML
    private Button companyBtn;

    @FXML
    private Button homeBtn;
    
    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cashReconBtn.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("CashReconsilation", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.CashReconsilation", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		// Load Navigation Panel for SetupAdmin .
		homeBtn.setOnAction((event) -> {
					try {
						// Clear from view Current Navigation Panel
						reportingPanelAnchorpane.getChildren().clear();
						// Display SetupAdmin Navigational Panel
						String formName = formPath.context.getMessage("Home", null, Locale.US);
						formPath.closeApplicationContext();
						reportingPanelAnchorpane.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
	}

}
