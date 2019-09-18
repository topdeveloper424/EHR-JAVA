package com.ets.controller.gui.icd10;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.icd10Codes.Icd10CodesEntityController;
import com.ets.controller.entity.medicalCondition.MedicalConditionCodeEntityController;
import com.ets.controller.gui.medicalCondition.MedicalConditionCodeViewController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Icd10Codes;
import com.ets.model.MedicalCondition;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ICD10CodeViewDetailsController implements Initializable {

	 @FXML
	    private TextField codeTextField;

	    @FXML
	    private TextField descriptiontextField;

	    @FXML
	    private TextField bodySyatemTextField;

	    @FXML
	    private TextField classicficationtextField;

	    @FXML
	    private TextField medicalConditionTextfield;

	    @FXML
	    private Button medicalConditionButton;

	    @FXML
	    private CheckBox inactiveCheckBox;

	    @FXML
	    private Button updateButton;

	    @FXML
	    private Button cancelButton;

	    @FXML
	    private TextField idTextField;
	    
	    private ICD10ViewController icd10ViewController;
	    

	public void setIcd10ViewController(ICD10ViewController icd10ViewController) {
			this.icd10ViewController = icd10ViewController;
		}

	private Icd10Codes icd10Codes;

	public void setIcd10Codes(Icd10Codes icd10Codes) {
		this.icd10Codes = icd10Codes;
		
		idTextField.setText(Integer.toString(icd10Codes.getId()));
		codeTextField.setText(this.icd10Codes.getCode());
		descriptiontextField.setText(this.icd10Codes.getDescrip());
		bodySyatemTextField.setText(icd10Codes.getBodySystem());
		classicficationtextField.setText(icd10Codes.getClassification());
		
		/*if(icd10Codes.getMedicalCondition() != null){
			
			medicalConditionTextfield.setText(icd10Codes.medicalConditionProperty().getValue().getCode());
			
		}
		*/
		
		if(icd10Codes.getInactive() == true){
			
			inactiveCheckBox.setSelected(true);
		}

	}
	
public void setMedicalCondition(String code){
		
		medicalConditionTextfield.setText(code);
		
	}

	
	
	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			try {
				
				Icd10Codes icd10Codes = new Icd10Codes();
				
				
				icd10Codes.setId(Integer.parseInt(idTextField.getText()));
				icd10Codes.setBodySystem(bodySyatemTextField.getText());
				icd10Codes.setClassification(classicficationtextField.getText());
				icd10Codes.setCode(codeTextField.getText());
				icd10Codes.setDescrip(descriptiontextField.getText());
				
				/*if(medicalConditionTextfield.getText().isEmpty()){
					
				}else{
					
					MedicalCondition medicalCondition = new MedicalConditionCodeEntityController().viewByCode(medicalConditionTextfield.getText());
					icd10Codes.setMedicalCondition(medicalCondition);
					
				}*/
								
				icd10Codes.setInactive(inactiveCheckBox.isSelected());
				
				new Icd10CodesEntityController().saveOrUpdateIcd10Codes(icd10Codes);
				
				icd10ViewController.viewICD10Code();
				
				new FXFormCommonUtilities().closeForm(updateButton);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		/*************************************
		 * Start of medicalConditionButton.setOnAction(..)
		 *****************************************************/

		/*medicalConditionButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.MedicalCondition", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			*//********************************
			 * Start of Task definition
			 *****************************************************************//*
			Task<ObservableList<MedicalCondition>> task =

					new Task<ObservableList<MedicalCondition>>() {

						@Override
						protected ObservableList<MedicalCondition> call() throws Exception {

							final ObservableList<MedicalCondition> medicalConditionList = new MedicalConditionCodeEntityController()
									.getMedicalList();

							if (isCancelled()) {
								return null;
							}
							return medicalConditionList;

						}
					};
			*//*************************
			 * End of Task definition
			 *****************************************************************//*

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("MedicalCondition", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalCondition", null, Locale.US);
				formPath.closeApplicationContext();
				
				MedicalConditionCodeViewController medicalConditionCodeViewController = (MedicalConditionCodeViewController) 
							new FXFormCommonUtilities().medicalConditionDisplayForm2(formName, formTitle, task.getValue());
				medicalConditionCodeViewController.setIcd10CodeEditController(this);
				

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});*/
		/*************************************
		 * End of medicalConditionButton.setOnAction(..)
		 *************************************************************/
		
		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
