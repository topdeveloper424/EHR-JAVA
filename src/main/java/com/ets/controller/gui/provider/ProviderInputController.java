package com.ets.controller.gui.provider;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.provider.ProviderEntityController;
import com.ets.model.Address;
import com.ets.model.Provider;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

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

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 10-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ProviderInputController Class
 *Description: Enter.fxml Controller class
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

public class ProviderInputController implements Initializable {

	@FXML
	private TextField codeTextField;

	@FXML
	private CheckBox mroCheckBox;

	@FXML
	private ChoiceBox<String> typeComboBox;

	@FXML
	private TextField npiTextField;

	@FXML
	private TextField firstNameTextField;

	@FXML
	private TextField middleNameTextField;

	@FXML
	private TextField lastNameTextField;

	@FXML
	private TextField suffixTextField;

	@FXML
	private TextField listingNameTextField;

	@FXML
	private TextField addressTextField;

	@FXML
	private TextField cityTextField;

	@FXML
	private TextField telephoneTextField;

	@FXML
	private TextField externalCodeTextField;

	@FXML
	private TextField stateTextField;

	@FXML
	private TextField zipTextField;

	@FXML
	private TextField extensionTextField;

	@FXML
	private ChoiceBox<String> countryComboBox;

	@FXML
	private TextField emailTextField;

	@FXML
	private TextField faxTextField;

	@FXML
	private TextField federalIdTextField;

	@FXML
	private TextField licenceTextField;

	@FXML
	private TextField deaTextField;

	@FXML
	private TextField registryTextField;

	@FXML
	private TextField credentialTextField;

	@FXML
	private TextField medicalGroupTextField;

	@FXML
	private TextField licStateTextField;

	@FXML
	private TextField classTextField;

	
	 @FXML
	    private DatePicker licenceEffectiveDateTextField;

	    @FXML
	    private DatePicker deaEffectiveDateTextField;

	    @FXML
	    private DatePicker licenceExpireDateTextField;

	    @FXML
	    private DatePicker deaExpireDateTextField;

	    @FXML
	    private DatePicker termTextField;

	    @FXML
	    private DatePicker effectiveTextField;
	    
	    @FXML
	    private DatePicker certificateExpireTextField;
	
	@FXML
	private TextField specialityTextField;

	

	@FXML
	private Button medicalGroupButton;

	@FXML
	private Button addProviderNetworkBtn;

	@FXML
	private Button salesReportBtn;

	@FXML
	private Button addAccountPinBtn;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private RadioButton externalRadioButton;

	@FXML
	private RadioButton internalRadioButton;
	
    @FXML
    private ToggleGroup medicalType;
    
    @FXML
    void enterKeyPressedForOkButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
			 
			
		String medicalType = null;
		
		if(internalRadioButton.isSelected()){
			
			medicalType = "Internal";
			
		}else if (externalRadioButton.isSelected()) {
			
			medicalType = "External";
		}
		
		try {
			
			Address address = new Address();
			
			address.setlocalAddress(addressTextField.getText());
			address.setCity(cityTextField.getText());
			address.setState(stateTextField.getText());
			address.setZip(zipTextField.getText());
			address.setPhone(telephoneTextField.getText());
			address.setCountry(countryComboBox.getSelectionModel().getSelectedItem());
			address.setFax(faxTextField.getText());
			address.setEmail(emailTextField.getText());
							
			new AddressEntityController().add(address);

			Provider provider = new Provider();
			
			provider.setAddress(address);
			provider.setClinic(Global.clinic);
			provider.setClassCode(classTextField.getText());
			provider.setCode(codeTextField.getText());
			provider.setCredential(credentialTextField.getText());
			provider.setDeaId(deaTextField.getText());
			
			LocalDate localDate1 = deaEffectiveDateTextField.getValue();
			if(localDate1 != null){
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				provider.setDeaIdEffectiveDate(date1);
			}
			
			LocalDate localDate2 = deaExpireDateTextField.getValue();
			if(localDate2 != null){
				Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
				provider.setDeaIdExpiryDate(date2);
				
			}
			
			LocalDate localDate3 = licenceEffectiveDateTextField.getValue();
			if(localDate2 != null){
				Date date3 = Date.from(localDate3.atStartOfDay(ZoneId.systemDefault()).toInstant());
									
				provider.setDeaLicenseEffectiveDate(date3);
				
			}
			
			LocalDate localDate4 = licenceExpireDateTextField.getValue();
			if(localDate4 != null){
				Date date4 = Date.from(localDate4.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				provider.setDeaLicenseExpiryDate(date4);
			}
							
			provider.setDeaLicenseNo(deaTextField.getText());
			provider.setFederalId(federalIdTextField.getText());
			provider.setInactive(inactiveCheckBox.isSelected());
			provider.setLicenseState(licStateTextField.getText());
			provider.setListingName(listingNameTextField.getText());
							
			provider.setMedicalType(medicalType);
			provider.setFirstName(firstNameTextField.getText());
			provider.setMiddleName(middleNameTextField.getText());
			provider.setLastName(lastNameTextField.getText());
			provider.setSuffix(suffixTextField.getText());
			provider.setNpi(npiTextField.getText());
			provider.setProviderIsMro(mroCheckBox.isSelected());
			provider.setProviderType(typeComboBox.getSelectionModel().getSelectedItem());
			provider.setSpeciality(specialityTextField.getText());
			
			new ProviderEntityController().saveOrUpdate(provider);
			
			providerViewController.viewProvider();
			
			new FXFormCommonUtilities().closeForm(okButton);
			
		}catch(Exception e){
			e.printStackTrace();
		}}

    }
    
    @FXML
    void enterKeyPressedForCancleButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    		
    	try {
			new FXFormCommonUtilities().closeForm(cancelButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	}
    }


  
   
    
    
    private ProviderViewController providerViewController;
    
	public void setProviderViewController(ProviderViewController providerViewController) {
		this.providerViewController = providerViewController;
	}
	


	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {
		
		
		

		List<String> list = new ArrayList<String>();

			list.add("Phisicians");
			list.add("PT/Rehab");
			list.add("NP");
			list.add("PA");
			list.add("APN");
			list.add("Group");
			list.add("Chiropractor");
			list.add("Orthopedist");
			list.add("Other");

		ObservableList<String> obList = FXCollections.observableList(list);
		typeComboBox.getItems().clear();
		typeComboBox.setItems(obList);

		List<String> list2 = new ArrayList<String>();

			list2.add("USA");
			list2.add("Canada");
			list2.add("Mexico");
			
			ObservableList<String> obList2 = FXCollections.observableList(list2);
			countryComboBox.getItems().clear();
			countryComboBox.setItems(obList2);
			
			

		/*medicalGroupButton.setOnAction((event) -> {
			try {
				// Load Medical Group Details Entry form .

				String formName = formPath.context.getMessage("MedicalGroup", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalGroup", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		salesReportBtn.setOnAction((event) -> {
			try {
				// Load Medical Group Details Entry form .

				String formName = formPath.context.getMessage("SalesRepresentative", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SalesRepresentative", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*addAccountPinBtn.setOnAction((event) -> {
			try {
				// Load Medical Group Details Entry form .

				String formName = formPath.context.getMessage("Account", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Account", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
		
		
		okButton.setOnAction((event) -> {
			
			String medicalType = null;
			
			if(internalRadioButton.isSelected()){
				
				medicalType = "Internal";
				
			}else if (externalRadioButton.isSelected()) {
				
				medicalType = "External";
			}
			
			try {
				
				Address address = new Address();
				
				address.setlocalAddress(addressTextField.getText());
				address.setCity(cityTextField.getText());
				address.setState(stateTextField.getText());
				address.setZip(zipTextField.getText());
				address.setPhone(telephoneTextField.getText());
				address.setCountry(countryComboBox.getSelectionModel().getSelectedItem());
				address.setFax(faxTextField.getText());
				address.setEmail(emailTextField.getText());
								
				new AddressEntityController().add(address);

				Provider provider = new Provider();
				
				provider.setAddress(address);
				provider.setClinic(Global.clinic);
				provider.setClassCode(classTextField.getText());
				provider.setCode(codeTextField.getText());
				provider.setCredential(credentialTextField.getText());
				provider.setDeaId(deaTextField.getText());
				
				LocalDate localDate1 = deaEffectiveDateTextField.getValue();
				if(localDate1 != null){
					Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
					
					provider.setDeaIdEffectiveDate(date1);
				}
				
				LocalDate localDate2 = deaExpireDateTextField.getValue();
				if(localDate2 != null){
					Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
					provider.setDeaIdExpiryDate(date2);
					
				}
				
				LocalDate localDate3 = licenceEffectiveDateTextField.getValue();
				if(localDate2 != null){
					Date date3 = Date.from(localDate3.atStartOfDay(ZoneId.systemDefault()).toInstant());
										
					provider.setDeaLicenseEffectiveDate(date3);
					
				}
				
				LocalDate localDate4 = licenceExpireDateTextField.getValue();
				if(localDate4 != null){
					Date date4 = Date.from(localDate4.atStartOfDay(ZoneId.systemDefault()).toInstant());
					
					provider.setDeaLicenseExpiryDate(date4);
				}
								
				provider.setDeaLicenseNo(deaTextField.getText());
				provider.setFederalId(federalIdTextField.getText());
				provider.setInactive(inactiveCheckBox.isSelected());
				provider.setLicenseState(licStateTextField.getText());
				provider.setListingName(listingNameTextField.getText());
								
				provider.setMedicalType(medicalType);
				provider.setFirstName(firstNameTextField.getText());
				provider.setMiddleName(middleNameTextField.getText());
				provider.setLastName(lastNameTextField.getText());
				provider.setSuffix(suffixTextField.getText());
				provider.setNpi(npiTextField.getText());
				provider.setProviderIsMro(mroCheckBox.isSelected());
				provider.setProviderType(typeComboBox.getSelectionModel().getSelectedItem());
				provider.setSpeciality(specialityTextField.getText());
				
				new ProviderEntityController().saveOrUpdate(provider);
				
				providerViewController.viewProvider();
				
				new FXFormCommonUtilities().closeForm(okButton);
				
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
