package com.ets.controller.gui.clinician;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinic.ClinicEntityController;
import com.ets.controller.entity.clinician.ClinicianEntityController;
import com.ets.controller.gui.clinic.ClinicViewController;
import com.ets.model.Clinic;
import com.ets.model.Clinician;
import com.ets.utils.DateConvert;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ClinicianEditController implements Initializable {
	
	 @FXML
	    private TextField codeTextField;

	    @FXML
	    private ChoiceBox<String> clinicianTypeChoiceBox;

	    @FXML
	    private TextField firstNameTextField;

	    @FXML
	    private TextField middleNameTextField;

	    @FXML
	    private TextField lastNameTextField;

	    @FXML
	    private TextField suffixTextField;

	    @FXML
	    private TextField loohUpNameTextField;

	    @FXML
	    private TextField homeClinicTextField;

	    @FXML
	    private Button clinicBtn;

	    @FXML
	    private TextField licenseTextField;

	    @FXML
	    private TextField federalIDTextField;

	    @FXML
	    private TextField licStateTextField;

	    @FXML
	    private TextField cadhcTextField;

	    @FXML
	    private DatePicker licenseEffectiveDate;

	    @FXML
	    private DatePicker licenseExpireDate;

	    @FXML
	    private TextField idTextField;

	    @FXML
	    private Button updateButton;

	    @FXML
	    private Button closeBtn;

	    @FXML
	    private CheckBox inactiveCheckBox;

	    @FXML
	    private RadioButton individualField;

	    @FXML
	    private ToggleGroup blockSchedule;

	    @FXML
	    private RadioButton groupPooled;
	    @FXML
	    void enterKeyPressedForclinicBtn(KeyEvent event) {
	    	if(event.getCode() == KeyCode.ENTER){
	    		try {

	    			String formName = formPath.context.getMessage("Clinic", null, Locale.US);
	    			String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
	    			formPath.closeApplicationContext();

	    			ClinicViewController clinicViewController =
	    					(ClinicViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
	    					clinicViewController.setClinicianEditController(this);

	    		} catch (Exception ex) {
	    			ex.printStackTrace();
	    		}
	    		
	    }}

	    
	    @FXML
	    void enterKeyPressedForCancleButton(KeyEvent event) {
	    	if(event.getCode() == KeyCode.ENTER){
	    		try {
					new FXFormCommonUtilities().closeForm(closeBtn);
				} catch (Exception ex) {
					ex.printStackTrace();
				}	

	    }}

	    @FXML
	    void enterKeyPressedForUpdateButton(KeyEvent event) {
	    	if(event.getCode() == KeyCode.ENTER){
	    		try {
	    			
	    			String blockSchedule = null;
	    			
	    			if(individualField.isSelected()){
	    				
	    				blockSchedule = "Individual Page";
	    				
	    			}else {
	    				
	    				blockSchedule = "Group Pooled";
	    			}
	    			

	    			Clinician clinician = new Clinician();
	    			
	    			clinician.setId(Integer.parseInt(idTextField.getText()));
	                clinician.setCode(codeTextField.getText());
	    			clinician.setFirstName(firstNameTextField.getText());
	    			clinician.setMiddleName(middleNameTextField.getText());
	    			
	    			
	    			if(homeClinicTextField.getText().isEmpty()){
	    				
	    			}else{
	    				
	    				Clinic clinic = new ClinicEntityController().viewByName(homeClinicTextField.getText());
	    				clinician.setHomeClinic(clinic);
	    				
	    			}


	    			clinician.setLastName(lastNameTextField.getText());
	    			clinician.setSuffix(suffixTextField.getText());
	    			clinician.setLookupName(loohUpNameTextField.getText());
	    			clinician.setFederalId(federalIDTextField.getText());
	    			clinician.setLicenseState(licStateTextField.getText());
	    			clinician.setLicenseNo(licenseTextField.getText());
	        
	    			LocalDate localDate = licenseEffectiveDate.getValue();
	    			
	    			if(localDate != null){
	    				
	    				Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	    				
	    				clinician.setLicenseEffectiveDate(date);
	    				
	    			}
	    			
	    			LocalDate localDate1 = licenseExpireDate.getValue();
	    			
	    			if(localDate1 != null){
	    				
	    				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
	    				
	    				clinician.setLicenseExpiryDate(date1);
	    				
	    			}
	    			
	    			clinician.setType(clinicianTypeChoiceBox.getSelectionModel().getSelectedItem());
	    			clinician.setBlockSchedule(blockSchedule);
	    			clinician.setInactive(inactiveCheckBox.isSelected());
	    			
	    			//ClinicianEntityController  clinicianEntityController=new ClinicianEntityController();
	    		    //clinicianEntityController.saveOrUpdate(clinician);
	    			
	    			new ClinicianEntityController().saveOrUpdate(clinician);
	    			
	    			
	    		}catch(Exception e){
	    			
	    			e.printStackTrace();
	    		}
	     
	    	}}

	    
	    private ClinicianViewController clinicianViewController;
	    	    
	    public void setClinicianViewController(ClinicianViewController clinicianViewController) {
			this.clinicianViewController = clinicianViewController;
		}


		private Clinician clinician;
	    

	public void setClinician(Clinician clinician) {
			this.clinician = clinician;
			
			idTextField.setText(Integer.toString(clinician.getId()));
			
			if("Individual Page".equals(clinician.getBlockSchedule())){
				
				individualField.setSelected(true);
				
			}else if ("Group Pooled".equals(clinician.getBlockSchedule())) {
				
				groupPooled.setSelected(true);
				
			}
			
			codeTextField.setText(clinician.getCode());
			firstNameTextField.setText(clinician.getFirstName());
			
			if(clinician.getHomeClinic() != null){
				
				homeClinicTextField.setText(clinician.homeClinicProperty().getValue().getName());
			}
			
			
			middleNameTextField.setText(clinician.getMiddleName());
			lastNameTextField.setText(clinician.getLastName());
			suffixTextField.setText(clinician.getSuffix());
			loohUpNameTextField.setText(clinician.getLookupName());
			federalIDTextField.setText(clinician.getFederalId());
			licStateTextField.setText(clinician.getLicenseState());
			licenseTextField.setText(clinician.getLicenseNo());
			
			Date date1 = clinician.getLicenseEffectiveDate();
			
			if(date1 != null){
				
				 LocalDate localDate1 = new DateConvert().dateToLocalDate(date1);
									
				 licenseEffectiveDate.setValue(localDate1);
				
			}
			
			Date date2 = clinician.getLicenseExpiryDate();
			
			if(date2 != null){
				
				 LocalDate localDate2 = new DateConvert().dateToLocalDate(date2);
									
				 licenseExpireDate.setValue(localDate2);
				
			}
			
		clinicianTypeChoiceBox.setValue(clinician.getType());
		
		if(clinician.getInactive() == true){
			
			inactiveCheckBox.setSelected(true);
		}
			
			
		}
	
public void setClinic(String clinicName){
    	
    	homeClinicTextField.setText(clinicName);
    }
	
	
	FXMLFormPath formPath = new FXMLFormPath();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		List<String> list = new ArrayList<String>();

		list.add("RN");
		list.add("LPN");
		list.add("MA");
		list.add("NP");
		list.add("PA");
		list.add("Other Clinician");

	ObservableList obList = FXCollections.observableList(list);
	clinicianTypeChoiceBox.getItems().clear();
	clinicianTypeChoiceBox.setItems(obList);
	
	clinicBtn.setOnAction((event) -> {
		try {

			String formName = formPath.context.getMessage("Clinic", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
			formPath.closeApplicationContext();

			ClinicViewController clinicViewController =
					(ClinicViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					clinicViewController.setClinicianEditController(this);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	});
		
	
	
	updateButton.setOnAction((event) -> {
		try {
			
			String blockSchedule = null;
			
			if(individualField.isSelected()){
				
				blockSchedule = "Individual Page";
				
			}else {
				
				blockSchedule = "Group Pooled";
			}
			

			Clinician clinician = new Clinician();
			
			clinician.setId(Integer.parseInt(idTextField.getText()));
            clinician.setCode(codeTextField.getText());
			clinician.setFirstName(firstNameTextField.getText());
			clinician.setMiddleName(middleNameTextField.getText());
			
			
			if(homeClinicTextField.getText().isEmpty()){
				
			}else{
				
				Clinic clinic = new ClinicEntityController().viewByName(homeClinicTextField.getText());
				clinician.setHomeClinic(clinic);
				
			}


			clinician.setLastName(lastNameTextField.getText());
			clinician.setSuffix(suffixTextField.getText());
			clinician.setLookupName(loohUpNameTextField.getText());
			clinician.setFederalId(federalIDTextField.getText());
			clinician.setLicenseState(licStateTextField.getText());
			clinician.setLicenseNo(licenseTextField.getText());
    
			LocalDate localDate = licenseEffectiveDate.getValue();
			
			if(localDate != null){
				
				Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				clinician.setLicenseEffectiveDate(date);
				
			}
			
			LocalDate localDate1 = licenseExpireDate.getValue();
			
			if(localDate1 != null){
				
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				clinician.setLicenseExpiryDate(date1);
				
			}
			
			clinician.setType(clinicianTypeChoiceBox.getSelectionModel().getSelectedItem());
			clinician.setBlockSchedule(blockSchedule);
			clinician.setInactive(inactiveCheckBox.isSelected());
			
			//ClinicianEntityController  clinicianEntityController=new ClinicianEntityController();
		    //clinicianEntityController.saveOrUpdate(clinician);
			
			new ClinicianEntityController().saveOrUpdate(clinician);
			clinicianViewController.viewClinician();
			new FXFormCommonUtilities().closeForm(updateButton);
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	});
	
		
		// Centralised Form cancel
				closeBtn.setOnAction((event) -> {
					try {
						new FXFormCommonUtilities().closeForm(closeBtn);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
		
	}

}
