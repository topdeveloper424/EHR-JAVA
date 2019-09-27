package com.ets.controller.gui.medicalActivityCharge;

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
import com.ets.controller.gui.drugScreen.DrugScreenResultEditController;
import com.ets.controller.gui.drugScreen.DrugScreenResultInputController;
import com.ets.controller.gui.medicalActivity.MedicalActivityViewController;
import com.ets.model.Clinician;
import com.ets.model.DrugScreenResult;
import com.ets.model.MedicalActivity;
import com.ets.model.MedicalActivityCharge;
import com.ets.utils.DateConvert;
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

public class MedicalActivityChargeEditController implements Initializable{
	
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
    private ChoiceBox<String> locationChoiceBox;

    @FXML
    private TextField ndcText;

    @FXML
    private DatePicker activityDate;

    @FXML
    private Button medicalActivityButton;

    @FXML
    private TextField overrideFeeText;

    private Boolean flag = false;

    @FXML
    private TextField summaryText;

    @FXML
    private TextField ndcCodeText;

    @FXML
    private TextField clinicianText;

    @FXML
    private Button clinicianButton;

    @FXML
    private DatePicker nextDueDate;

    @FXML
    private Label clinicianNameLabel;

    @FXML
    private ComboBox<String> resultCodeChoiceBox;

    @FXML
    private CheckBox noCostActivityCheckBox;

    @FXML
    private TextField activityCostText;

    @FXML
    private Button updateBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button testInfoBtn;
 
    @FXML
    void resultCodeCompleteSelect(ActionEvent event) {
    		    	
    	if(resultCodeChoiceBox.getSelectionModel().getSelectedItem().equals("C-Completed")&&((activityCodeName.equals("RPD DS10"))||(activityCodeName.equals("RPD DS")))){
    			    		
    		try {
    			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+medicalActivityChargeOb.getId());

    			
    			System.out.println("resultCodeChoiceBox.getSelectionModel().getSelectedItem()" +resultCodeChoiceBox.getSelectionModel().getSelectedItem());
    			System.out.println("activityCodeName "+activityCodeName);
				String formName = formPath.context.getMessage("EnterDrugScreen", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EnterDrugScreen", null, Locale.US);
				//medicalActivityChargeOb.setMedicalchargeObject();
				formPath.closeApplicationContext();
				DrugScreenResultInputController object = 
				(DrugScreenResultInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				object.setMedicalchargeObject(this,medicalActivityChargeOb);
				medicalActivityChargeOb.setResultCode(resultCodeChoiceBox.getSelectionModel().getSelectedItem());
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
    		
    		
    	}
    	/*else if (resultCodeChoiceBox.getSelectionModel().getSelectedItem().equals("R-Refused")) {
    		
    		System.out.println("R-Refused RUN");
    		
			
		}else if (resultCodeChoiceBox.getSelectionModel().getSelectedItem().equals("W-Waved")) {
			
			System.out.println("W-Waved RUN");
			
		}else if (resultCodeChoiceBox.getSelectionModel().getSelectedItem().equals("X-Cancelled")) {
			
			System.out.println("X-Cancelled RUN");
			
		}else if (resultCodeChoiceBox.getSelectionModel().getSelectedItem().equals("9-Elsewhere")) {
			
			System.out.println("9-Elsewhere RUN");
			
		}else if (resultCodeChoiceBox.getSelectionModel().getSelectedItem().equals("?-Requested")) {
			
			System.out.println("?-Requested RUN");
			
		}*/
    	else
    	{
    		medicalActivityChargeOb.setResultCode(resultCodeChoiceBox.getSelectionModel().getSelectedItem());
    	}
    }
    
    public static String activityCodeName = null;
    
    public void setActivityCode(MedicalActivity medicalActivity){
    	
    	activityCodeText.setText(medicalActivity.getCode());
    	activityCodeName = activityCodeText.getText();
    	
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
		clinicianNameLabel.setText(clinician.getSuffix());
		//+""+clinician.getFirstName()+""+clinician.getMiddleName()+""+clinician.getLastName());
	}

    
   /* public void setClinicianId(String id){
    	
    	clinicianText.setText(id);
    	
    }*/
    
   /* public void setClinicianName(String name){
    	
    	clinicianNameLabel.setText(name);
    }*/
    
    public MedicalActivityCharge medicalActivityChargeOb;
    
    public void setMedicalActivityCharge(MedicalActivityCharge medicalActivityCharge) {
		this.medicalActivityChargeOb = medicalActivityCharge;
		
	   if(medicalActivityChargeOb.getCheckBillingStatus()==false){
		
		
		
		if(medicalActivityChargeOb.getMedicalActivity() != null){
			
			activityCodeText.setText(medicalActivityChargeOb.medicalActivityProperty().getValue().getCode());
		   if(medicalActivityChargeOb.getMedicalActivity().getCptCode4Hcpcs()!=null){
			  cptCodeText.setText(medicalActivityChargeOb.getMedicalActivity().getCptCode4Hcpcs().getCode()); 
		   }
		
		
		}
		
		
		Date date1 = medicalActivityChargeOb.getActivityDate();
		Date date2 = medicalActivityChargeOb.getNextDueDate();
		if(date2 !=null){
			
			LocalDate localDate2 = new DateConvert().dateToLocalDate(date2);
			nextDueDate.setValue(localDate2);
		}
		
		if(date1 != null){
			
			 LocalDate localDate1 = new DateConvert().dateToLocalDate(date1);
								
			 activityDate.setValue(localDate1);
			
		}
	//	drugQtyText.setText(medicalActivityChargeOb.get);
		
		/*if("Billable Activity".equals(medicalActivityCharge.get)){
			
			billableActivityRadioButton.setSelected(true);
			
		}else if ("No Charge Activity".equals(medicalActivityCharge.ge)) {
			
			noChargeActivityRadioButton.setSelected(true);
			
			
		}else if ("Biling Completed".equals(medicalActivityCharge.ge)) {
			
			billingCompletedRadioButtonl.setSelected(true);
			
		}*/
		noCostActivityCheckBox.setSelected(medicalActivityCharge.getNoCost());
		resultCodeChoiceBox.setValue(medicalActivityCharge.getResultCode());
		
		
		billingStatusChoiceBox.setValue(medicalActivityChargeOb.getBillingStatus());
		billingQtyText.setText(medicalActivityChargeOb.getBillingQty());
		overridePayerChoiceBox.setValue(medicalActivityChargeOb.getOverridePayer());
		overrideFeeText.setText(medicalActivityChargeOb.getOverrideFee());
		billingModifierText.setText(medicalActivityChargeOb.getBillingModifier());
		uomText.setText(medicalActivityChargeOb.getUom());
		drugQtyText.setText(medicalActivityChargeOb.getDrugQuant());
		locationChoiceBox.setValue(medicalActivityChargeOb.getLocationGiven());
		billingCommentTextArea.setText(medicalActivityChargeOb.getBillingComment());
		ndcText.setText(medicalActivityChargeOb.getNdcCode());
		ndcCodeText.setText(medicalActivityChargeOb.getNdcCode());
		activityCostText.setText(medicalActivityChargeOb.getActivityCost());
		if(medicalActivityChargeOb.getNoCost()==true){
			noCostActivityCheckBox.setSelected(true);
			
		}
		if(medicalActivityChargeOb.getClinician()!=null){
		clinicianText.setText(medicalActivityChargeOb.getClinician().getFirstName()+" "+medicalActivityChargeOb.getClinician().getLastName());
		}
		//Global.patientVisitObj = medicalActivityCharge.getPatientVisit();
		
	   
	   
	   }else{
		   
		
			if(medicalActivityChargeOb.getMedicalActivity() != null){
				
				activityCodeText.setText(medicalActivityChargeOb.medicalActivityProperty().getValue().getCode());
			   if(medicalActivityChargeOb.getMedicalActivity().getCptCode4Hcpcs()!=null){
				  cptCodeText.setText(medicalActivityChargeOb.getMedicalActivity().getCptCode4Hcpcs().getCode()); 
			   }
			
			
			}
			
			
			Date date1 = medicalActivityChargeOb.getActivityDate();
			
			if(date1 != null){
				
				 LocalDate localDate1 = new DateConvert().dateToLocalDate(date1);
									
				 activityDate.setValue(localDate1);
				
			}
		//	drugQtyText.setText(medicalActivityChargeOb.get);
			
			/*if("Billable Activity".equals(medicalActivityCharge.get)){
				
				billableActivityRadioButton.setSelected(true);
				
			}else if ("No Charge Activity".equals(medicalActivityCharge.ge)) {
				
				noChargeActivityRadioButton.setSelected(true);
				
				
			}else if ("Biling Completed".equals(medicalActivityCharge.ge)) {
				
				billingCompletedRadioButtonl.setSelected(true);
				
			}*/
			noCostActivityCheckBox.setSelected(medicalActivityCharge.getNoCost());
			resultCodeChoiceBox.setValue(medicalActivityCharge.getResultCode());
			
			
			billingStatusChoiceBox.setValue(medicalActivityChargeOb.getBillingStatus());
			billingQtyText.setText(medicalActivityChargeOb.getBillingQty());
			overridePayerChoiceBox.setValue(medicalActivityChargeOb.getOverridePayer());
			overrideFeeText.setText(medicalActivityChargeOb.getOverrideFee());
			billingModifierText.setText(medicalActivityChargeOb.getBillingModifier());
			uomText.setText(medicalActivityChargeOb.getUom());
			drugQtyText.setText(medicalActivityChargeOb.getDrugQuant());
			locationChoiceBox.setValue(medicalActivityChargeOb.getLocationGiven());
			billingCommentTextArea.setText(medicalActivityChargeOb.getBillingComment());
			ndcText.setText(medicalActivityChargeOb.getNdcCode());
			activityCodeText.setDisable(true);
			activityDate.setDisable(true);
			billingStatusChoiceBox.setDisable(true);
			billingQtyText.setDisable(true);
			overridePayerChoiceBox.setDisable(true);
			overrideFeeText.setDisable(true);
			resultCodeChoiceBox.setDisable(true);
			noCostActivityCheckBox.setDisable(true);
			billingCommentTextArea.setDisable(true);
			locationChoiceBox.setDisable(true);
			drugQtyText.setDisable(true);
			uomText.setDisable(true);
			cptCodeText.setDisable(true);
			billingModifierText.setDisable(true);
			ndcText.setDisable(true);
			if(medicalActivityChargeOb.getNoCost()==true){
				noCostActivityCheckBox.setSelected(true);
				noCostActivityCheckBox.setDisable(true);
				
			}
			resultCodeChoiceBox.setDisable(true);
			summaryText.setDisable(true);
			nextDueDate.setDisable(true);
			clinicianText.setDisable(true);
			ndcCodeText.setDisable(true);
			noCostActivityCheckBox.setDisable(true);
			activityCostText.setDisable(true);
			updateBtn.setDisable(true);
	   }
		
	}
    
    private MedicalActivityChargeViewController medicalActivityChargeViewController;
    
	public void setMedicalActivityChargeViewController(
			MedicalActivityChargeViewController medicalActivityChargeViewController, Boolean flag) {
		this.flag = flag;
		this.medicalActivityChargeViewController = medicalActivityChargeViewController;
		if((activityCodeText.getText().equals("RPD DS10"))||(activityCodeText.getText().equals("RPD DS"))){
			testInfoBtn.setVisible(true);
		}else{
			testInfoBtn.setVisible(false);
		}
		
	}

	FXMLFormPath formPath = new FXMLFormPath();
    
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<String> locationGivenList  = new ArrayList<String>();
		locationGivenList.add("Clinic");
		locationGivenList.add("Internal Provider");
		locationGivenList.add("External Provider");
		locationGivenList.add("Primary Care Physician");
		locationGivenList.add("Employee Departmant");
		locationGivenList.add("External Employer Location");
		ObservableList locationGivenObserv = FXCollections.observableList(locationGivenList);
		locationChoiceBox.setItems(locationGivenObserv);
		
		
		if(activityCodeText.getText().length() > 0){
			activityCodeName = activityCodeText.getText();
			System.out.println("Activity Code :  --------------" +activityCodeName);
		}
		
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
				
				medicalActivityViewController.setMedicalActivityChargeEditController(this ,medicalActivityButton);
				
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
				
				clinicianViewController.setMedicalActivityChargeEditController(this);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
		testInfoBtn.setOnAction((event)->{
			
			try {
    			
				String formName = formPath.context.getMessage("EnterDrugScreen", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EnterDrugScreen", null, Locale.US);
				//medicalActivityChargeOb.setMedicalchargeObject();
				
				System.out.println(medicalActivityChargeOb+"*9*9*9*9*9*9*9*9*9*9*9*9*9*9"+this);
				formPath.closeApplicationContext();
				DrugScreenResultInputController object = 
				(DrugScreenResultInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				object.setMedicalchargeObject(this,medicalActivityChargeOb);
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
    		
			
		});
		
		updateBtn.setOnAction((event) -> {
			try {
				
				MedicalActivityCharge medicalActivityCharge = new MedicalActivityCharge();
				
				medicalActivityCharge.setId(medicalActivityChargeOb.getId());
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
				new FXFormCommonUtilities().closeForm( updateBtn);
				
				
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
