package com.ets.controller.gui.medicalActivityCharge;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25/11/2016
 * *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalActivityChargeInputController Class
 *Description: Left_Panel.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:  Neha Sahadev
 *Owner:   Neha Sahadev
 *Date: 29/11/2016
 *Version: 0.02
 *Description: Class Name Change
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

*/


import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinician.ClinicianEntityController;
import com.ets.controller.entity.medicalActivityCharge.MedicalActivityChargeEntityController;
import com.ets.controller.entity.medicalactivity.MedicalActivityEntityController;
import com.ets.controller.gui.clinician.ClinicianViewController;
import com.ets.controller.gui.medicalActivity.MedicalActivityViewController;
import com.ets.model.Clinician;
import com.ets.model.MedicalActivity;
import com.ets.model.MedicalActivityCharge;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.ContextMenuEvent;

public class MedicalActivityChargeInputController implements Initializable {
	
	 @FXML
	    private TextField activityCodeText;

	    @FXML
	    private TextField cptCodeText;

	    @FXML
	    private TextField drugQtyText;

	    @FXML
	    private TextField billingQtyText;

	    @FXML
	    private RadioButton billableActivityRadioButton;

	    @FXML
	    private ToggleGroup billableStatus;

	    @FXML
	    private RadioButton noChargeActivityRadioButton;

	    private boolean flag = false;
	    
	    @FXML
	    private RadioButton billingCompletedRadioButton;

	    @FXML
	    private TextField billingModifierText;

	    @FXML
	    private ChoiceBox<String> billingStatusChoiceBox;

	    @FXML
	    private TextField uomText;

	    @FXML
	    private TextArea billingCommentTextArea;

	    @FXML
	    private ChoiceBox<String> overridePayerChoiceBox;
	    
	    @FXML
	    private TextField overrideFeeText;

	    @FXML
	    private ChoiceBox<String> locationChoiceBox;

	    @FXML
	    private TextField ndcText;

	    @FXML
	    private DatePicker activityDate;

	    @FXML
	    private Button medicalActivityButton;

	    @FXML
	    private ComboBox<String> resultCodeChoiceBox;

	    @FXML
	    private TextField summaryText;

	    @FXML
	    private TextField ndcCodeText;

	    @FXML
	    private TextField clinicianText;
	    
	    @FXML
	    private Label clinicianNameLabel;

	    @FXML
	    private Button clinicianButton;

	    @FXML
	    private DatePicker nextDueDate;

	    @FXML
	    private CheckBox noCostActivityCheckBox;

	    @FXML
	    private TextField activityCostText;

	    @FXML
	    private Button okBtn;

	    @FXML
	    private Button cancelBtn;
	    
	    
	    
	    @FXML
	    void resultCodeCompleteSelect(ActionEvent event) {
	    		    	
	    	if(resultCodeChoiceBox.getSelectionModel().getSelectedItem().equals("C-Completed")&&((activityCodeName.equals("RPD DS10"))||(activityCodeName.equals("RPD DS")))){
	    			    		
	    		try {

					String formName = formPath.context.getMessage("EnterDrugScreen", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.EnterDrugScreen", null, Locale.US);
					formPath.closeApplicationContext();
					new FXFormCommonUtilities().displayForm(formName, formTitle);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
	    		
	    		
	    	}else if (resultCodeChoiceBox.getSelectionModel().getSelectedItem().equals("R-Refused")) {
	    		
	    		System.out.println("R-Refused RUN");
				
			}else if (resultCodeChoiceBox.getSelectionModel().getSelectedItem().equals("W-Waved")) {
				
				System.out.println("W-Waved RUN");
				
			}else if (resultCodeChoiceBox.getSelectionModel().getSelectedItem().equals("X-Cancelled")) {
				
				System.out.println("X-Cancelled RUN");
				
			}else if (resultCodeChoiceBox.getSelectionModel().getSelectedItem().equals("9-Elsewhere")) {
				
				System.out.println("9-Elsewhere RUN");
				
			}else if (resultCodeChoiceBox.getSelectionModel().getSelectedItem().equals("?-Requested")) {
				
				System.out.println("?-Requested RUN");
				
			}
	    	

	    }
	    
	    private MedicalActivityChargeViewController medicalActivityChargeViewController;
	    
	    
	    public MedicalActivityChargeViewController getMedicalActivityChargeViewController() {
			return medicalActivityChargeViewController;
		}




		public void setMedicalActivityChargeViewController(
				MedicalActivityChargeViewController medicalActivityChargeViewController, Boolean flag) {
			this.flag = flag;
			this.medicalActivityChargeViewController = medicalActivityChargeViewController;
		}

		public static String activityCodeName = null;
	    
	    public void setActivityCode(MedicalActivity medicalActivity){
	    	
	    	activityCodeText.setText(medicalActivity.getCode());
	    	activityCodeName = activityCodeText.getText();
	    	
	    	
	    	 if(medicalActivity.getCptCode4Hcpcs()!=null){
				  cptCodeText.setText(medicalActivity.getCptCode4Hcpcs().getCode()); 
			   }
	    	
	    }
	    
	    
	    
	    
	    public void setCPTCode(String code){
	    	if(code != null){
	    		cptCodeText.setText(code);
	    	}
	    	
	    }
	    
	    private Clinician clinician;

		public void setClinician(Clinician clinician) {
			this.clinician = clinician;
			clinicianText.setText(clinician.getCode());
			clinicianNameLabel.setText(clinician.getSuffix()+""+clinician.getFirstName()+""+clinician.getMiddleName()+""+clinician.getLastName());
		}

	   /* public void setClinicianId(String id){
	    	
	    	clinicianText.setText(id);
	    	
	    }
	    
	    public void setClinicianName(String name){
	    	
	    	clinicianNameLabel.setText(name);
	    }
	    */
	    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		List<String> list1 = new ArrayList<String>();

		list1.add("Completed");
		list1.add("Refused");
		list1.add("Cancelled");
		list1.add("Requested");

		ObservableList typeList = FXCollections.observableList(list1);
		billingStatusChoiceBox.getItems().clear();
		billingStatusChoiceBox.setItems(typeList);
		
		List<String> list2 = new ArrayList<String>();

		list2.add("C-Completed");
		list2.add("R-Refused");
		list2.add("W-Waved");
		list2.add("X-Cancelled");
		list2.add("9-Elsewhere");
		list2.add("?-Requested");

		ObservableList resultList = FXCollections.observableList(list2);
		resultCodeChoiceBox.getItems().clear();
		resultCodeChoiceBox.setItems(resultList);
		
		List<String> list3 = new ArrayList<String>();

		list3.add("Default");
		list3.add("Employer");
		list3.add("Carrier");
		
		ObservableList overrideList = FXCollections.observableList(list3);
		overridePayerChoiceBox.getItems().clear();
		overridePayerChoiceBox.setItems(overrideList);
		
		medicalActivityButton.setOnAction((event) -> {
			try {
				// Load and Display - setup_medical_activitytemplt.fxml Form
				String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
				formPath.closeApplicationContext();
				MedicalActivityViewController medicalActivityViewController =
				(MedicalActivityViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				
				medicalActivityViewController.setMedicalActivityChargeInputController(this ,medicalActivityButton);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		clinicianButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("Clinician", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinician", null, Locale.US);
				formPath.closeApplicationContext();
				ClinicianViewController clinicianViewController =
				(ClinicianViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				
				clinicianViewController.setMedicalActivityChargeInputController(this);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		okBtn.setOnAction((event) -> {
			try {
				
				
				MedicalActivityCharge medicalActivityCharge = new MedicalActivityCharge();
				
				if(!this.medicalActivityChargeViewController.checkDuplicate(this.activityCodeText.getText())) {
					medicalActivityCharge.setActivityCost(activityCostText.getText());
					
					LocalDate localDate1 = activityDate.getValue();
					if(localDate1 != null){
						
						Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
						
						medicalActivityCharge.setActivityDate(date1);
						
					}
					
					medicalActivityCharge.setBillingComment(billingCommentTextArea.getText());
					medicalActivityCharge.setBillingModifier(billingModifierText.getText());
					medicalActivityCharge.setBillingQty(billingQtyText.getText());
					medicalActivityCharge.setBillingStatus(billingStatusChoiceBox.getSelectionModel().getSelectedItem());
									
					if(clinicianText.getText().isEmpty()){
						
					}else{
						
						Clinician clinician = new ClinicianEntityController().viewByCode(clinicianText.getText());
						medicalActivityCharge.setClinician(clinician);
					}
					/*medicalActivityCharge.setLabOrderNo();
					medicalActivityCharge.setLabSampleId(labSampleId);*/
					
					if(activityCodeText.getText().isEmpty()){
						
					}else{
						
						MedicalActivity medicalActivity = new MedicalActivityEntityController().viewByCode(activityCodeText.getText());
						medicalActivityCharge.setMedicalActivity(medicalActivity);
						
					}
					
					medicalActivityCharge.setNdcCode(ndcCodeText.getText());
					
					LocalDate localDate2 = nextDueDate.getValue();
					if(localDate2 != null){
						
						Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
						
						medicalActivityCharge.setNextDueDate(date2);
						
					}
					medicalActivityCharge.setPatient(Global.patient);
					if(this.flag) {
						medicalActivityCharge.setPatientVisit(Global.patientVisitObj);					
					}
					medicalActivityCharge.setNoCost(noCostActivityCheckBox.isSelected());
					medicalActivityCharge.setResultCode(resultCodeChoiceBox.getSelectionModel().getSelectedItem());
					medicalActivityCharge.setOverridePayer(overridePayerChoiceBox.getSelectionModel().getSelectedItem());
					medicalActivityCharge.setOverrideFee(overrideFeeText.getText());
					medicalActivityCharge.setBillingModifier(billingModifierText.getText());
					medicalActivityCharge.setUom(uomText.getText());
					medicalActivityCharge.setDrugQuant(drugQtyText.getText());
					medicalActivityCharge.setLocationGiven(locationChoiceBox.getSelectionModel().getSelectedItem());
					medicalActivityCharge.setBillingComment(billingCommentTextArea.getText());
					medicalActivityCharge.setNdcCode(ndcText.getText());
					medicalActivityCharge.setLocationGiven(locationChoiceBox.getSelectionModel().getSelectedItem());
					medicalActivityCharge.setResultCode(billingStatusChoiceBox.getSelectionModel().getSelectedItem());
					medicalActivityCharge.setActivityCost(activityCostText.getText());
					if(noCostActivityCheckBox.isSelected()){
						
						medicalActivityCharge.setNoCost(true);
						
					}
					new MedicalActivityChargeEntityController().saveOrUpdate(medicalActivityCharge);
					medicalActivityChargeViewController.viewMedicalActivityCharge();
					
					new FXFormCommonUtilities().closeForm(okBtn);
				}
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		cancelBtn.setOnAction((event) -> {
			try {
				//cancel centralized form
				new FXFormCommonUtilities().closeForm( cancelBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
		
	}

}
