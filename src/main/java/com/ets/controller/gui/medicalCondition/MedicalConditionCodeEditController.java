package com.ets.controller.gui.medicalCondition;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ets.controller.entity.exposureCode.ExposureCodeEntityController;
import com.ets.controller.entity.medicalCondition.MedicalConditionCodeEntityController;
import com.ets.controller.entity.medicalactivity.MedicalActivityEntityController;
import com.ets.controller.gui.medicalActivity.MedicalActivityViewController;
import com.ets.model.ExposureCode;
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

public class MedicalConditionCodeEditController implements Initializable {

	@FXML
	private TextField idTextField;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private RadioButton illnessRadioButton;

	@FXML
	private ToggleGroup group;
	
    @FXML
    private ToggleGroup security;

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
	private CheckBox oshaRecordableCheckBox;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button updateButton;

	@FXML
	private Button cancelButton;
	
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

	private MedicalConditionCodeViewController medicalConditionViewController;

	public void setMedicalConditionViewController(MedicalConditionCodeViewController medicalConditionViewController) {
		this.medicalConditionViewController = medicalConditionViewController;
	}

	private MedicalCondition MedicalCondition;

	public void setMedicalCondition(MedicalCondition medicalCondition) {
		MedicalCondition = medicalCondition;

		idTextField.setText(Integer.toString(medicalCondition.getId()));
		codeTextField.setText(medicalCondition.getCode());
		descriptionTextField.setText(medicalCondition.getDescrip());
		
		if(medicalCondition.getVaccine() != null){
			
			vaccineTextField.setText(medicalCondition.vaccineProperty().getValue().getCode());
		}
		if(medicalCondition.getSecondVaccine() != null){
			
			sevondVaccineTextField.setText(medicalCondition.secondVaccineProperty().getValue().getCode());
			
		}
		if(medicalCondition.getImmuneTest() != null){
			
			immuneTestTextField.setText(medicalCondition.immuneTestProperty().getValue().getCode());
			
		}
		if(medicalCondition.getDiagTest() != null){
			
			DiagTestTextField.setText(medicalCondition.diagTestProperty().getValue().getCode());
			
		}
		
		
		
		
		if ("Illness".equals(medicalCondition.getType())) {
			illnessRadioButton.setSelected(true);
		} else if ("History".equals(medicalCondition.getType())) {
			historyRadioButton.setSelected(true);
		} else if ("Allergy".equals(medicalCondition.getType())) {
			allergyRadioButton.setSelected(true);
		} else if ("Exposure".equals(medicalCondition.getType())) {
			exposureRadioButton.setSelected(true);
		} else if ("Injury".equals(medicalCondition.getType())) {
			injuryRadioButton.setSelected(true);
		}
		
		if("None".equals(medicalCondition.getSecurity())){
			
			noneRadioButton.setSelected(true);
			
		}else if ("HIV Access".equals(medicalCondition.getSecurity())) {
			
			hivAccessRadioButton.setSelected(true);
			
		}else if ("Drug Test".equals(medicalCondition.getSecurity())) {
			
			drugTestRadioButton.setSelected(true);
			
		}else if ("EAP Access".equals(medicalCondition.getSecurity())) {
			
			eapAccessRadioButton.setSelected(true);
			
		}
		
		if(medicalCondition.getOshaRecordable() == true){
			
			oshaRecordableCheckBox.setSelected(true);
			
		}else{
			
			oshaRecordableCheckBox.setSelected(false);
		}
		
		if(medicalCondition.getInfectious() == true){
			
			infectiousCheckBox.setSelected(true);
		}
		else{
			
			infectiousCheckBox.setSelected(false);
		}

		if (medicalCondition.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else  {
			inactiveCheckBox.setSelected(false);
		}

	}

	FXMLFormPath formPath = new FXMLFormPath();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {

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
			
			medicalConditionViewController
					.populateMedicalConditionTable(new MedicalConditionCodeEntityController().getMedicalList());
			try {
				new FXFormCommonUtilities().closeForm(updateButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

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
				medicalActivityViewController.setMedicalConditionCodeEditController(this, vaccineButton);

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
				medicalActivityViewController.setMedicalConditionCodeEditController(this, vaccine2Button);

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
				medicalActivityViewController.setMedicalConditionCodeEditController(this , immuneTestButton);

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
				medicalActivityViewController.setMedicalConditionCodeEditController(this , diagTestButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		

		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
