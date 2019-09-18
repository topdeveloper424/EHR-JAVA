package com.ets.controller.gui.medicalCondition;

/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EnterMedicalConditionCodeController Class
 *Description: EnterMedicalConditionCode.fxml Controller class
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification: Insert And Retrive Operation Done
 *Owner: Sumanta Deyashi
 *Date: 17-02-2016
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

*/

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ets.controller.entity.medicalCondition.MedicalConditionCodeEntityController;
import com.ets.controller.entity.medicalactivity.MedicalActivityEntityController;
import com.ets.controller.gui.medicalActivity.MedicalActivityViewController;
import com.ets.model.MedicalActivity;
import com.ets.model.MedicalCondition;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MedicalConditionCodeInputController implements Initializable {

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private RadioButton illnessRadioButton;

	@FXML
	private RadioButton historyRadioButton;

	@FXML
	private RadioButton allergyRadioButton;

	@FXML
	private RadioButton injuryRadioButton;

	@FXML
	private RadioButton exposureRadioButton;

	@FXML
	private CheckBox infectiousCheckBox;

	@FXML
	private TextField vaccineTextField;

	@FXML
	private TextField sevondVaccineTextField;

	@FXML
	private TextField immuneTestTextField;

	@FXML
	private TextField DiagTestTextField;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private ToggleGroup group;

	@FXML
	private Button okButton;

	@FXML
	private Button vaccineButton;

	@FXML
	private Button vaccine2Button;

	@FXML
	private Button immuneTestButton;

	@FXML
	private Button diagTestButton;

	@FXML
	private RadioButton noneRadioButton;

	@FXML
	private RadioButton hivAccessRadioButton;

	@FXML
	private RadioButton drugTestRadioButton;

	@FXML
	private RadioButton eapAccessRadioButton;

	@FXML
	private Button cancelButton;

	@FXML
	private CheckBox oshaRecordableCheckBox;
	
	public void setVaccine(String vaccine) {

		this.vaccineTextField.setText(vaccine);
	}
	
	public void setSecondVaccine(String secondVaccine) {

		this.sevondVaccineTextField.setText(secondVaccine);
	}
	
	public void setImmuneTest(String immuneTest){
		
		this.immuneTestTextField.setText(immuneTest);
		
	}
	
	public void setDiagTest(String diagTest){
		
		this.DiagTestTextField.setText(diagTest);
		
	}
	
	private MedicalConditionCodeViewController medicalConditionCodeViewController;
	
	public void setMedicalConditionCodeViewController(
			MedicalConditionCodeViewController medicalConditionCodeViewController) {
		this.medicalConditionCodeViewController = medicalConditionCodeViewController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		okButton.setOnAction((event) -> {

			String type = null;

			if (illnessRadioButton.isSelected()) {
				type = "Illness";
			} else if (historyRadioButton.isSelected()) {
				type = "History";
			} else if (allergyRadioButton.isSelected()) {
				type = "Allergy";
			} else if (exposureRadioButton.isSelected()) {
				type = "Exposure";
			} else if (injuryRadioButton.isSelected()) {
				type = "Injury";
			}
			
			String security = null;
			
			if(noneRadioButton.isSelected()){
				security = "None";
			}
			else if (hivAccessRadioButton.isSelected()) {
				
				security = "HIV Access";
				
			}
			else if (drugTestRadioButton.isSelected()) {
				
				security = "Drug Test";
				
			}
			else if (eapAccessRadioButton.isSelected()) {
				
				security = "EAP Access";
				
			}
			
			
			
			MedicalCondition medicalCondition = new MedicalCondition();
			medicalCondition.setCode(this.codeTextField.getText());
			medicalCondition.setDescrip(this.descriptionTextField.getText());
			medicalCondition.setType(type);
			medicalCondition.setInfectious(infectiousCheckBox.isSelected());
			medicalCondition.setSecurity(security);
			medicalCondition.setOshaRecordable(oshaRecordableCheckBox.isSelected());
			medicalCondition.setInactive(inactiveCheckBox.isSelected());
			
			if(vaccineTextField.getText().isEmpty()){
				
				System.out.println("Vaccine is Empty");
				
			}else{
				
				MedicalActivity medicalActivity1 = new MedicalActivityEntityController().viewByCode(vaccineTextField.getText());
				medicalCondition.setVaccine(medicalActivity1);
				
			}
			
			if(sevondVaccineTextField.getText().isEmpty()){
				
				System.out.println("Second Vaccine is Empty");
				
				
			}else{
				
				MedicalActivity medicalActivity2 = new MedicalActivityEntityController().viewByCode(sevondVaccineTextField.getText());
				medicalCondition.setSecondVaccine(medicalActivity2);
				
			}
			
			if(immuneTestTextField.getText().isEmpty()){
				
				System.out.println("Immunne is Empty");
				
			}else{
				
				MedicalActivity medicalActivity3 = new MedicalActivityEntityController().viewByCode(immuneTestTextField.getText());
				medicalCondition.setImmuneTest(medicalActivity3);
				
			}
			
			if(DiagTestTextField.getText().isEmpty()){
				
				System.out.println("Diag Test is Empty");
				
			}else{
				
				MedicalActivity medicalActivity4 = new MedicalActivityEntityController().viewByCode(DiagTestTextField.getText());
				medicalCondition.setDiagTest(medicalActivity4);
				
			}
						
			
			medicalCondition.setInactive(this.inactiveCheckBox.isSelected());

			new MedicalConditionCodeEntityController().addOrUpdateMedicalCondition(medicalCondition);
			
			medicalConditionCodeViewController.populateMedicalConditionTable(new MedicalConditionCodeEntityController().getMedicalList());
			
			new FXFormCommonUtilities().closeForm(cancelButton);
			
		});

		vaccineButton.setOnAction((event) -> {
			try {
				// Load and Display - setup_medical_activitytemplt.fxml Form
				String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
				formPath.closeApplicationContext();
				MedicalActivityViewController medicalActivityViewController =
				(MedicalActivityViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				//medicalActivityViewController.setMedicalConditionCodeInputController(this);
				medicalActivityViewController.setMedicalConditionCodeInputController(this , vaccineButton);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		vaccine2Button.setOnAction((event) -> {
			try {
				// Load and Display - setup_medical_activitytemplt.fxml Form
				String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
				formPath.closeApplicationContext();

				MedicalActivityViewController medicalActivityViewController =
						(MedicalActivityViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
						//medicalActivityViewController.setMedicalConditionCodeInputController(this);
				medicalActivityViewController.setMedicalConditionCodeInputController(this , vaccine2Button);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		immuneTestButton.setOnAction((event) -> {
			try {
				// Load and Display - setup_medical_activitytemplt.fxml Form
				String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
				formPath.closeApplicationContext();

				MedicalActivityViewController medicalActivityViewController =
						(MedicalActivityViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
						//medicalActivityViewController.setMedicalConditionCodeInputController(this);
				medicalActivityViewController.setMedicalConditionCodeInputController(this , immuneTestButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		diagTestButton.setOnAction((event) -> {
			try {
				// Load and Display - setup_medical_activitytemplt.fxml Form
				String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
				formPath.closeApplicationContext();

				MedicalActivityViewController medicalActivityViewController =
						(MedicalActivityViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
						//medicalActivityViewController.setMedicalConditionCodeInputController(this);
				medicalActivityViewController.setMedicalConditionCodeInputController(this , diagTestButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		cancelButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
