package com.ets.controller.gui.emrCharting.pmh.allergy;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.medication.MedicationEntityController;
import com.ets.controller.gui.allergyCategory.AllergyCategoryViewController;
import com.ets.controller.gui.emrCharting.pmh.PMHAllergyInputController;
import com.ets.controller.gui.medicationCode.MedicationCodeViewController;
import com.ets.model.Medication;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 21-04-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AspirinInputController Class
 *Description: aspirin.fxml GUI Controller class
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
public class AspirinInputController implements Initializable {
	
	  @FXML
	    private Button SkipButton;

	    @FXML
	    private Button DoneButton;

	    @FXML
	    private TextArea additionalNoteTextArea;

	    @FXML
	    private Button medicationSearchBtn;

	    @FXML
	    private TextField allergyReactionText;

	    @FXML
	    private DatePicker onsetDate;

	    @FXML
	    private DatePicker endDate;

	    @FXML
	    private TextField onsetAge;

	    @FXML
	    private TextField onsetYear;

	    @FXML
	    private RadioButton propensityToAdverseDrugRadio;

	    @FXML
	    private ToggleGroup allergy;

	    @FXML
	    private RadioButton propensityToAdverseFoodRadio;

	    @FXML
	    private RadioButton propensityToAdverseSubstancesRadio;

	    @FXML
	    private RadioButton propensityToAdverseRadio;

	    @FXML
	    private RadioButton drugAllergyRadio;

	    @FXML
	    private RadioButton foodAllergyRadio;

	    @FXML
	    private RadioButton allergyToSubstancesRadio;

	    @FXML
	    private RadioButton drugIntoleranceRadio;

	    @FXML
	    private RadioButton foodIntoleranceRadio;

	    @FXML
	    private CheckBox anaphylaxisCheck;

	    @FXML
	    private CheckBox diarrheaCheck;

	    @FXML
	    private CheckBox dizzinessCheck;

	    @FXML
	    private CheckBox feverCheck;

	    @FXML
	    private CheckBox flushingCheck;

	    @FXML
	    private CheckBox headacheCheck;

	    @FXML
	    private CheckBox itchingCheck;

	    @FXML
	    private CheckBox nauseaCheck;

	    @FXML
	    private RadioButton anaphylaxisMildRadio;

	    @FXML
	    private ToggleGroup anaphylaxisGrp;

	    @FXML
	    private RadioButton diarrheaMild;

	    @FXML
	    private ToggleGroup diarrheagrp;

	    @FXML
	    private RadioButton dizzinessMild;

	    @FXML
	    private ToggleGroup dizzinessgrp;

	    @FXML
	    private RadioButton feverMild;

	    @FXML
	    private ToggleGroup feverGrp;

	    @FXML
	    private RadioButton flushingMild;

	    @FXML
	    private ToggleGroup flushingGrp;

	    @FXML
	    private RadioButton headacheMild;

	    @FXML
	    private ToggleGroup headacheGrp;

	    @FXML
	    private RadioButton itchingMild;

	    @FXML
	    private ToggleGroup skinGrp;

	    @FXML
	    private RadioButton nauseaMild;

	    @FXML
	    private ToggleGroup nauseaGrp;

	    @FXML
	    private RadioButton anaphylaxisMildModerateRadio;

	    @FXML
	    private RadioButton diarrheaMildModerate;

	    @FXML
	    private RadioButton dizzinessMildModerate;

	    @FXML
	    private RadioButton feverMildModerate;

	    @FXML
	    private RadioButton flushingMildModerate;

	    @FXML
	    private RadioButton itchingMildModerate;

	    @FXML
	    private RadioButton nauseaMildModerate;

	    @FXML
	    private RadioButton headacheMildModerate;

	    @FXML
	    private RadioButton anaphylaxisModerateRadio;

	    @FXML
	    private RadioButton diarrheaModerate;

	    @FXML
	    private RadioButton dizzinessModerate;

	    @FXML
	    private RadioButton feverModerate;

	    @FXML
	    private RadioButton flushingModerate;

	    @FXML
	    private RadioButton headacheModerate;

	    @FXML
	    private RadioButton itchingModerate;

	    @FXML
	    private RadioButton nauseaModerate;

	    @FXML
	    private RadioButton anaphylaxisModerateSeverRadio;

	    @FXML
	    private RadioButton diarrheaModerateSever;

	    @FXML
	    private RadioButton dizzinessModerateSever;

	    @FXML
	    private RadioButton feverModerateSevere;

	    @FXML
	    private RadioButton flushingModerateSevere;

	    @FXML
	    private RadioButton headacheModerateSevere;

	    @FXML
	    private RadioButton itchingModerateSevere;

	    @FXML
	    private RadioButton nauseaModerateSevere;

	    @FXML
	    private RadioButton anaphylaxisSeverRadio;

	    @FXML
	    private RadioButton diarrheaSever;

	    @FXML
	    private RadioButton dizzinessSevere;

	    @FXML
	    private RadioButton feverSevere;

	    @FXML
	    private RadioButton flushingSevere;

	    @FXML
	    private RadioButton headacheSevere;

	    @FXML
	    private RadioButton itchingMildSevere;

	    @FXML
	    private RadioButton nauseaSevere;

	    @FXML
	    private RadioButton anaphylaxisFatal;

	    @FXML
	    private RadioButton diarrheaFatal;

	    @FXML
	    private RadioButton dizzinessFatal;

	    @FXML
	    private RadioButton feverFatal;

	    @FXML
	    private RadioButton flushingFatal;

	    @FXML
	    private RadioButton headacheFatal;

	    @FXML
	    private RadioButton itchingFatal;

	    @FXML
	    private RadioButton nauseafatal;

	    @FXML
	    private RadioButton anaphylaxisUnspecified;

	    @FXML
	    private RadioButton diarrheaUnspecified;

	    @FXML
	    private RadioButton dizzinessUnspecified;

	    @FXML
	    private RadioButton feverUnspecified;

	    @FXML
	    private RadioButton flushingUnspecified;

	    @FXML
	    private RadioButton headacheUnspecified;

	    @FXML
	    private RadioButton itchingUnspecified;

	    @FXML
	    private RadioButton nauseaUnspecified;

	    @FXML
	    private Label medicationNameLabel;
	    
	    private PMHAllergyInputController pMHAllergyInputController;
	    

	    public void setpMHAllergyInputController(PMHAllergyInputController pMHAllergyInputController) {
			this.pMHAllergyInputController = pMHAllergyInputController;
		}

	    FXMLFormPath formpath = new FXMLFormPath();
	    
	    
	    public void setMedication(String name){
	    	
	    	allergyReactionText.setText(name);
	    		
	    	
	    
	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Medication medication = new MedicationEntityController().searchByName("Aspirin OTC, Adult");
		allergyReactionText.setText(medication.getMedicationName());
		
		
		
		
		DoneButton.setOnAction((event) -> {

			StringBuilder pmhAllergyStr = new StringBuilder(pMHAllergyInputController.str);
			pmhAllergyStr.append("\n");
			pMHAllergyInputController.str = pmhAllergyStr.toString();

			
			if (allergyReactionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(pMHAllergyInputController.str);
				str1.append(allergyReactionText.getText()+ " , " );
				pMHAllergyInputController.str = str1.toString();
				
			}if (onsetAge.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(pMHAllergyInputController.str);
				str1.append("since age " +onsetAge.getText() + " , ");
				pMHAllergyInputController.str = str1.toString();

			}if (onsetYear.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(pMHAllergyInputController.str);
				str1.append("since " +onsetYear.getText() + " , ");
				pMHAllergyInputController.str = str1.toString();
				
			}
			
			if (anaphylaxisCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHAllergyInputController.str);
				str1.append("reacted with anaphylaxis, ");
				pMHAllergyInputController.str = str1.toString();

			}if (diarrheaCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHAllergyInputController.str);
				str1.append("diarrhea due to drug, ");
				pMHAllergyInputController.str = str1.toString();

			}if (dizzinessCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHAllergyInputController.str);
				str1.append("dizziness, ");
				pMHAllergyInputController.str = str1.toString();

			}if (feverCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(pMHAllergyInputController.str);
				str1.append("fever, ");
				pMHAllergyInputController.str = str1.toString();

			}if (flushingCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHAllergyInputController.str);
				str1.append("flushing, ");
				pMHAllergyInputController.str = str1.toString();

			}if (headacheCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHAllergyInputController.str);
				str1.append("headache, ");
				pMHAllergyInputController.str = str1.toString();

			}if (itchingCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHAllergyInputController.str);
				str1.append("itching of skin, ");
				pMHAllergyInputController.str = str1.toString();

			}if (nauseaCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHAllergyInputController.str);
				str1.append("nausea, ");
				pMHAllergyInputController.str = str1.toString();

			}
			
			StringBuilder str1 = new StringBuilder(pMHAllergyInputController.str);
			str1.append(".");
			pMHAllergyInputController.str = str1.toString();
			

			

			++pMHAllergyInputController.formCount;
			pMHAllergyInputController.setAllergyUI();
			new FXFormCommonUtilities().closeForm(DoneButton);
			

		});
		
		
		medicationSearchBtn.setOnAction((event)->{
		
			try {
				
				String formName = formpath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);
				formpath.closeApplicationContext();
				MedicationCodeViewController medicationCodeViewController =  (MedicationCodeViewController) new FXFormCommonUtilities().displayForm(formName,
						formTitle);
				medicationCodeViewController.setAspirinInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
	});

		SkipButton.setOnAction((event) -> {
			try {
				++pMHAllergyInputController.formCount;
				pMHAllergyInputController.setAllergyUI();
				new FXFormCommonUtilities().closeForm(SkipButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
