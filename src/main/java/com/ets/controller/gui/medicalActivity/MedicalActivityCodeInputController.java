package com.ets.controller.gui.medicalActivity;


/**Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 Module Name:
 *Parameter Definition: Type object of EnterMedicalActivityCodeController Class
 *Description: EnterMedicalActivityCode.fxml Controller class
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.
*/


import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.billingServiceType.BillingServiceTypeEntityController;
import com.ets.controller.entity.cpt4.Cpt4EntityController;
import com.ets.controller.entity.medActBilling.MedActBillingEntityController;
import com.ets.controller.entity.medActResultCode.MedActResultCodeEntityController;
import com.ets.controller.entity.medActSurvelRule.MedActSurvelRuleEntityController;
import com.ets.controller.entity.medicalactivity.MedicalActivityEntityController;
import com.ets.controller.gui.billingServiceType.BillingServiceTypeViewController;
import com.ets.controller.gui.cptOrHcpcs.CPTorHCPCSCodeViewController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.BillingServiceType;
import com.ets.model.CptCode4Hcpcs;
import com.ets.model.MedActBilling;
import com.ets.model.MedActResultCode;
import com.ets.model.MedActSurvelRule;
import com.ets.model.MedicalActivity;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;

public class MedicalActivityCodeInputController implements Initializable {

	@FXML
	private TextField activityCodeTextField;

	@FXML
	private TextField descrptionTextField;

	@FXML
	private ChoiceBox activityTypeChoiceBox;

	@FXML
	private SplitMenuButton triggerEntitySplitMenuButton;

	@FXML
	private Spinner stepRequiredSpinner;

	@FXML
	private TextField defaulfBilingQuantityTextField;

	@FXML
	private TextField cptCodeTextField;

	@FXML
	private ToggleGroup secutity;

	@FXML
	private RadioButton noSpecialSecurityRadioButton;

	@FXML
	private RadioButton hivAccessRadioButton;

	@FXML
	private RadioButton drugTestAccesRadioButton;

	@FXML
	private RadioButton eapAccessRadioButton;

	@FXML
	private TextField onlyUpOnAgeTextField;

	@FXML
	private TextField stopAtAgeTextField;

	@FXML
	private ComboBox<String> onlyUpOnSexComboBox;

	@FXML
	private ComboBox<String> onlyForEthinicsComboBox;

	/*@FXML
	private CheckBox activityCodeInactiveCheckBox;*/

	@FXML
	private Spinner<Integer> stepRequiredSpinnerField;

	@FXML
	private ToggleGroup repeatBasis;

	@FXML
	private TextField regularInterval;

	@FXML
	private TextField frequency;

	@FXML
	private TextField onlyUponAge;

	@FXML
	private TextField stopAtAge;

	@FXML
	private ChoiceBox<String> onlyUpOnSexChoiceBox;

	@FXML
	private ChoiceBox<String> onlyForEthinicsChoiceBox;

	@FXML
	private TextField resultCode1;

	@FXML
	private TextField resultCode2;

	@FXML
	private TextField resultCode3;

	@FXML
	private TextField resultCode4;

	@FXML
	private TextField resultCode5;

	@FXML
	private TextField resultCode6;

	@FXML
	private TextField resultMeaning1;

	@FXML
	private TextField resultMeaning2;

	@FXML
	private TextField resultMeaning3;

	@FXML
	private TextField resultMeaning4;

	@FXML
	private TextField resultMeaning5;

	@FXML
	private TextField resultMeaning6;

	@FXML
	private TextField billingServicetypeTextBox;

	@FXML
	private Button billingServiceTypeButton;

	@FXML
	private TextField currentCharge;

	@FXML
	private TextField futureCharge;

	@FXML
	private DatePicker currentEffectiveDate;

	@FXML
	private DatePicker futureEffectiveDate;
	
    @FXML
    private CheckBox noChargeItemCheckBox;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	@FXML
	private Button cptCodeButton;

	@FXML
	private ChoiceBox acType;

	@FXML
	private RadioButton noReapetRadionButton;

	@FXML
	private RadioButton regularIntervalRadioButton;

	@FXML
	private RadioButton birthDayRadioButton;
	
	private MedicalActivityViewController medicalActivityViewController;
		
	public void setMedicalActivityViewController(MedicalActivityViewController medicalActivityViewController) {
		this.medicalActivityViewController = medicalActivityViewController;
	}

	public void setBillingServiceType(Integer billingId) {

		this.billingServicetypeTextBox.setText(Integer.toString(billingId));
	}
	
	public void setCptCodeOrHecpcs(String code){
		
		this.cptCodeTextField.setText(code);
		
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		List<String> list = new ArrayList<String>();
		list.add("Vaccine/Immunization");
		list.add("Madication");
		list.add("Lab Test");
		list.add("Imaging");
		list.add("Other Screen/Test");
		list.add("Physical/Assessment");
		list.add("Health/Wellness");
		list.add("Surgery");
		list.add("Other Medical Procedure");
		list.add("Administrative");
		list.add("Supplies");
		list.add("Tax");
		ObservableList obList = FXCollections.observableList(list);
		activityTypeChoiceBox.getItems().clear();
		activityTypeChoiceBox.setItems(obList);

		List<String> list2 = new ArrayList<String>();
		list2.add("Male");
		list2.add("Female");
		ObservableList obList2 = FXCollections.observableList(list2);
		onlyUpOnSexChoiceBox.setItems(obList2);
		// onlyUpOnSexChoiceBox.setValue("Select Sex");

		List<String> list3 = new ArrayList<String>();
		list3.add("Asian");
		list3.add("Black");
		list3.add("Caucasian");
		list3.add("Hispanic");
		ObservableList obList3 = FXCollections.observableList(list3);
		onlyForEthinicsChoiceBox.setItems(obList3);
		// onlyForEthinicsChoiceBox.setValue("Select Ethnic");

		SpinnerValueFactory factoryInteger = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
		stepRequiredSpinnerField.setValueFactory(factoryInteger);

		cptCodeButton.setOnAction((event) -> {
			
			try {
				//// Load and Display - Select_CPT-4_or_HCPCS_Code.fxml Form
				String formName = formPath.context.getMessage("CPT4", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.CPT4", null, Locale.US);
				formPath.closeApplicationContext();
				CPTorHCPCSCodeViewController cptorHCPCSCodeViewController =
				(CPTorHCPCSCodeViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				cptorHCPCSCodeViewController.setMedicalActivityCodeInputController(this);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		/*************************************
		 * Start of respiratorModelBtn.setOnAction(..)
		 *****************************************************/

		billingServiceTypeButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.BillingService", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<BillingServiceType>> task =

					new Task<ObservableList<BillingServiceType>>() {

						@Override
						protected ObservableList<BillingServiceType> call() throws Exception {

							final ObservableList<BillingServiceType> billingServiceTypeList = new BillingServiceTypeEntityController()
									.viewBillingService();

							if (isCancelled()) {
								return null;
							}
							return billingServiceTypeList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("BillingService", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.BillingService", null, Locale.US);
				formPath.closeApplicationContext();
				
				BillingServiceTypeViewController billingServiceTypeViewController =  (BillingServiceTypeViewController) new FXFormCommonUtilities().billingServiceTypeDisplayForm(formName, formTitle, task.getValue());
				billingServiceTypeViewController.setMedicalActivityCodeInputController(this);

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************
		 * End of respiratorModelBtn.setOnAction(..)
		 *************************************************************/

		okButton.setOnAction((event) -> {
			
			try {
    
				if(activityCodeTextField.getText()==null){
				String security = null;

				if (noSpecialSecurityRadioButton.isSelected()) {
					security = "No Special Security";
				} else if (hivAccessRadioButton.isSelected()) {
					security = "HIV Acess";
				} else if (drugTestAccesRadioButton.isSelected()) {
					security = "Drug Test Acess";
				} else if (eapAccessRadioButton.isSelected()) {
					security = "EAP Acess";
				}

				String repeat = null;

				if (noReapetRadionButton.isSelected()) {

					repeat = "No Repeat";
				} else if (regularIntervalRadioButton.isSelected()) {

					repeat = "Regular Interva";

				} else if (birthDayRadioButton.isSelected()) {

					repeat = "Birthday";
				}

				MedActSurvelRule medActSurvelRule = new MedActSurvelRule();

				medActSurvelRule.setRepeat(repeat);
				medActSurvelRule.setRegularInterval(regularInterval.getText());
				medActSurvelRule.setFrequency(frequency.getText());
				medActSurvelRule.setOnlyForEthnic(onlyForEthinicsChoiceBox.getSelectionModel().getSelectedItem());
				medActSurvelRule.setOnlyForSex(onlyUpOnSexChoiceBox.getSelectionModel().getSelectedItem());
				medActSurvelRule.setStopAtAge(stopAtAge.getText());
				medActSurvelRule.setUponAge(onlyUponAge.getText());

				new MedActSurvelRuleEntityController().saveOrUpdate(medActSurvelRule);

				MedActBilling medActBilling = new MedActBilling();

				medActBilling.setEmployerChargeCurrent(currentCharge.getText());

				LocalDate localDate1 = currentEffectiveDate.getValue();
				if(localDate1 != null){
					Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
					medActBilling.setEmployerChargeEffective(date1);
				}
				
				
				
				if(billingServicetypeTextBox.getText().isEmpty()){
					
					
					
				}else{
					BillingServiceType billingServiceType = new BillingServiceTypeEntityController().viewById(Integer.parseInt(billingServicetypeTextBox.getText()));
					medActBilling.setBillingServiceType(billingServiceType);
				}
				
				medActBilling.setEmployerChargeFuture(futureCharge.getText());

				LocalDate localDate2 = futureEffectiveDate.getValue();
				if(localDate2 != null){
					
					Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
					medActBilling.setEmployerChargeFutureEffective(date2);
					
				}
				
				medActBilling.setNoChargeItem(noChargeItemCheckBox.isSelected());
				
				new MedActBillingEntityController().saveOrUpdate(medActBilling);

				
				
				MedicalActivity medicalActivity = new MedicalActivity();

				medicalActivity.setActivityType((String) activityTypeChoiceBox.getSelectionModel().getSelectedItem());
				
				if(cptCodeTextField.getText().isEmpty()){
					
					
				}else{
					
					CptCode4Hcpcs cptCode4Hcpcs = new Cpt4EntityController().viewByCode(cptCodeTextField.getText());
					medicalActivity.setCptCode4Hcpcs(cptCode4Hcpcs);
					
				}
				
				medicalActivity.setBillingServiceType(medActBilling);
				medicalActivity.setCode(activityCodeTextField.getText());
				
				
				
				medicalActivity.setDescrip(descrptionTextField.getText());
				medicalActivity.setSecurity(security);
				medicalActivity.setStepsRequired(stepRequiredSpinnerField.getValue());
				//medicalActivity.setInactive(activityCodeInactiveCheckBox.isSelected());
				medicalActivity.setMedActSurvelRule(medActSurvelRule);

				new MedicalActivityEntityController().saveMedicalActivity(medicalActivity);
				
				if(resultCode1.getText() != null && resultMeaning1.getText() != null){
					MedActResultCode medActResultCode1 = new MedActResultCode();

					medActResultCode1.setCode(resultCode1.getText());
					medActResultCode1.setMeaning(resultMeaning1.getText());

					new MedActResultCodeEntityController().saveOrUpdate(medActResultCode1);
				}
				else if(resultCode2.getText() != null && resultMeaning2.getText() != null){
					MedActResultCode medActResultCode2 = new MedActResultCode();

					medActResultCode2.setCode(resultCode2.getText());
					medActResultCode2.setMeaning(resultMeaning2.getText());

					new MedActResultCodeEntityController().saveOrUpdate(medActResultCode2);
				}
				
				else if (resultCode3.getText() != null && resultMeaning3.getText() != null) {
					
					MedActResultCode medActResultCode3 = new MedActResultCode();

					medActResultCode3.setCode(resultCode3.getText());
					medActResultCode3.setMeaning(resultMeaning3.getText());

					new MedActResultCodeEntityController().saveOrUpdate(medActResultCode3);
					
				}
				else if (resultCode4.getText() != null && resultMeaning4.getText() != null) {
					
					MedActResultCode medActResultCode4 = new MedActResultCode();

					medActResultCode4.setCode(resultCode4.getText());
					medActResultCode4.setMeaning(resultMeaning4.getText());

					new MedActResultCodeEntityController().saveOrUpdate(medActResultCode4);
										
				}
				
				else if(resultCode5.getText() != null && resultMeaning5.getText() != null){
					
					MedActResultCode medActResultCode5 = new MedActResultCode();
					
					medActResultCode5.setCode(resultCode5.getText());
					medActResultCode5.setMeaning(resultMeaning5.getText());

					new MedActResultCodeEntityController().saveOrUpdate(medActResultCode5);
					
				}
				else if(resultCode6.getText() != null && resultMeaning6.getText() != null){
					
					MedActResultCode medActResultCode6 = new MedActResultCode();

					medActResultCode6.setCode(resultCode6.getText());
					medActResultCode6.setMeaning(resultMeaning6.getText());

					new MedActResultCodeEntityController().saveOrUpdate(medActResultCode6);
					
				}
				
				medicalActivityViewController.viewMedicalActivity();
				
				new FXFormCommonUtilities().closeForm(okButton);
				
				}else{
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Codes cannot be empty!");

					alert.showAndWait();
				}

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
