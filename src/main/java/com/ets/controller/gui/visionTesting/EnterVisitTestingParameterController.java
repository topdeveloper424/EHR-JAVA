package com.ets.controller.gui.visionTesting;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class EnterVisitTestingParameterController implements Initializable{
	
	 @FXML
	    private Button medicalActivityBtn;

	    @FXML
	    private Button visitCategoryBtn;

	    @FXML
	    private Button close;
	    @FXML
	    private Button vteqp;


	    FXMLFormPath formPath = new FXMLFormPath();
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			close.setOnAction((event) -> {
				try {
					//cancel centralized form
					new FXFormCommonUtilities().closeForm( close);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			
			medicalActivityBtn.setOnAction((event) -> {
				try {
				//  Load and Display - Select_medical_activity.fxml Form
					String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
					formPath.closeApplicationContext();
					
					new FXFormCommonUtilities().displayForm( formName , formTitle);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			
			visitCategoryBtn.setOnAction((event) -> {
				try {
				//  Load and Display - Select_Visit_Category_Code.fxml Form
					String formName = formPath.context.getMessage("VisitCategory", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.VisitCategory", null, Locale.US);
					formPath.closeApplicationContext();
					
					new FXFormCommonUtilities().displayForm( formName , formTitle);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			
			vteqp.setOnAction((event) -> {
				try {

				//  Load and Display - Macro_text_defination.fxml Form
					String formName = formPath.context.getMessage("Equipment", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.Equipment", null, Locale.US);
					formPath.closeApplicationContext();
					new FXFormCommonUtilities().displayForm( formName , formTitle);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			
				
			});
		}

	}


