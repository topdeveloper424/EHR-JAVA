package com.ets.controller.gui.referalProvider;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 10-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ReferalProviderGUIController Class
 *Description: EnterReferalProvider.fxml Controller class
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

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.referalProvider.ReferalProviderEntityController;
import com.ets.model.Address;
import com.ets.model.ReferalProvider;
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ReferalProviderInputController implements Initializable {

	@FXML
	private TextField codeTextField;

	@FXML
	private ChoiceBox<String> typeComboBox;

	@FXML
	private TextField npiTextField;

	@FXML
	private TextField firstnameTextField;

	@FXML
	private TextField middleNameTextField;

	@FXML
	private TextField lastNameTextField;

	@FXML
	private TextField suffixTextField;

	@FXML
	private TextField listingNemeTextField;

	@FXML
	private TextField localAddressTextField;

	@FXML
	private TextField cityTextField;

	@FXML
	private TextField telephoneTextField;

	@FXML
	private TextField externalTextField;

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
	private TextField federalIDTextField;

	@FXML
	private TextField licenceTextField;

	@FXML
	private TextField deaTextField;

	@FXML
	private TextField credencialTextField;

	@FXML
	private TextField medicalGroupTextField;

	@FXML
	private TextField licStateTextField;

	@FXML
	private TextField classTextField;
	
    @FXML
    private DatePicker licenseEffectiveDate;

    @FXML
    private DatePicker licenseExpireDate;

    @FXML
    private DatePicker deaEffectiveDate;

    @FXML
    private DatePicker deaExpireDate;

    @FXML
    private DatePicker medGrpEffectiveDate;

    @FXML
    private DatePicker termTextField;

	@FXML
	private TextField specialityTextField;

	@FXML
	private ChoiceBox<String> referalTypeChoiceBox;

	@FXML
	private Button okButton;

	@FXML
	private CheckBox inactiveCheckBox;
	
	@FXML
	private TextField providerTextField;

	@FXML
	private Button medicalGroupBtn;

	@FXML
	private Button salesReportBtn;

	@FXML
	private Button providerBtn;

	@FXML
	private Button cancelBtn;

    @FXML
    void enterKeyPressedForOkButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    		
    	try {
			
			Address address = new Address();
			
			address.setlocalAddress(localAddressTextField.getText());
			address.setCity(cityTextField.getText());
			address.setState(stateTextField.getText());
			address.setZip(zipTextField.getText());
			address.setPhone(telephoneTextField.getText());
			address.setExt(extensionTextField.getText());
			address.setCountry(countryComboBox.getSelectionModel().getSelectedItem());
			address.setFax(faxTextField.getText());
			address.setEmail(emailTextField.getText());
			
			
			new AddressEntityController().add(address);
			
			
			ReferalProvider referalProvider = new ReferalProvider();
			
			referalProvider.setAddress(address);
			
			referalProvider.setClassCode(classTextField.getText());
			referalProvider.setCode(codeTextField.getText());
			referalProvider.setCredential(credencialTextField.getText());
			referalProvider.setDeaId(deaTextField.getText());
			
			LocalDate localDate1 = deaEffectiveDate.getValue();
			if(localDate1 != null){
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				referalProvider.setDeaIdEffectiveDate(date1);
			}
			
			LocalDate localDate2 = deaExpireDate.getValue();
			if(localDate2 != null){
				Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				referalProvider.setDeaIdExpiryDate(date2);
			}
			
			LocalDate localDate3 = licenseEffectiveDate.getValue();
			if(localDate3 != null){
				Date date3 = Date.from(localDate3.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				
				referalProvider.setDeaLicenseEffectiveDate(date3);
			}
			
			LocalDate localDate4 = licenseExpireDate.getValue();
			if(localDate4 != null){
				Date date4 = Date.from(localDate4.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				referalProvider.setDeaLicenseExpiryDate(date4);
				
			}
							
			referalProvider.setDeaLicenseNo(licenceTextField.getText());
			referalProvider.setFederalId(federalIDTextField.getText());
			referalProvider.setInactive(inactiveCheckBox.isSelected());
			referalProvider.setLicenseState(licStateTextField.getText());
			referalProvider.setListingName(listingNemeTextField.getText());
			referalProvider.setFirstName(firstnameTextField.getText());
			referalProvider.setMiddleName(middleNameTextField.getText());
			referalProvider.setLastName(lastNameTextField.getText());
			referalProvider.setSuffix(suffixTextField.getText());
			
			referalProvider.setNpi(npiTextField.getText());
		
			referalProvider.setReferType(referalTypeChoiceBox.getSelectionModel().getSelectedItem());
			referalProvider.setRefProviderType(typeComboBox.getSelectionModel().getSelectedItem());
			referalProvider.setSpeciality(specialityTextField.getText());
			
			new ReferalProviderEntityController().saveOrUpdate(referalProvider);
			
			referalProviderViewController.viewReferalProvider();
			
			new FXFormCommonUtilities().closeForm(okButton);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

    	}

    }
    @FXML
    void enterKeyPressedForCancleButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	
    	try {
			new FXFormCommonUtilities().closeForm(cancelBtn);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }}

	
	
	private ReferalProviderViewController referalProviderViewController;
	
	public void setReferalProviderViewController(ReferalProviderViewController referalProviderViewController) {
		this.referalProviderViewController = referalProviderViewController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		List<String> list = new ArrayList<String>();

		list.add("Phisicians");
		list.add("PT/Rehab");
		list.add("Group");
		list.add("Other");

		ObservableList<String> providerTypeList = FXCollections.observableList(list);
		typeComboBox.getItems().clear();
		typeComboBox.setItems(providerTypeList);

		List<String> list2 = new ArrayList<String>();

		list2.add("USA");
		list2.add("Canada");
		list2.add("Mexico");

		ObservableList<String> countryList = FXCollections.observableList(list2);
		countryComboBox.getItems().clear();
		countryComboBox.setItems(countryList);

		List<String> list3 = new ArrayList<String>();

		list3.add("PCP");
		list3.add("PT");
		list3.add("Other Speciality");

		ObservableList<String> referType = FXCollections.observableList(list3);
		referalTypeChoiceBox.getItems().clear();
		referalTypeChoiceBox.setItems(referType);

		/*medicalGroupBtn.setOnAction((event) -> {
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

		providerBtn.setOnAction((event) -> {
			try {
				// Load Provider Details Entry form .

				String formName = formPath.context.getMessage("AddViewProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddViewProvider", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		okButton.setOnAction((event) -> {
			try {
				
				Address address = new Address();
				
				address.setlocalAddress(localAddressTextField.getText());
				address.setCity(cityTextField.getText());
				address.setState(stateTextField.getText());
				address.setZip(zipTextField.getText());
				address.setPhone(telephoneTextField.getText());
				address.setExt(extensionTextField.getText());
				address.setCountry(countryComboBox.getSelectionModel().getSelectedItem());
				address.setFax(faxTextField.getText());
				address.setEmail(emailTextField.getText());
				
				
				new AddressEntityController().add(address);
				
				
				ReferalProvider referalProvider = new ReferalProvider();
				
				referalProvider.setAddress(address);
				
				referalProvider.setClassCode(classTextField.getText());
				referalProvider.setCode(codeTextField.getText());
				referalProvider.setCredential(credencialTextField.getText());
				referalProvider.setDeaId(deaTextField.getText());
				
				LocalDate localDate1 = deaEffectiveDate.getValue();
				if(localDate1 != null){
					Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
					
					referalProvider.setDeaIdEffectiveDate(date1);
				}
				
				LocalDate localDate2 = deaExpireDate.getValue();
				if(localDate2 != null){
					Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
					
					referalProvider.setDeaIdExpiryDate(date2);
				}
				
				LocalDate localDate3 = licenseEffectiveDate.getValue();
				if(localDate3 != null){
					Date date3 = Date.from(localDate3.atStartOfDay(ZoneId.systemDefault()).toInstant());
					
					
					referalProvider.setDeaLicenseEffectiveDate(date3);
				}
				
				LocalDate localDate4 = licenseExpireDate.getValue();
				if(localDate4 != null){
					Date date4 = Date.from(localDate4.atStartOfDay(ZoneId.systemDefault()).toInstant());
					
					referalProvider.setDeaLicenseExpiryDate(date4);
					
				}
								
				referalProvider.setDeaLicenseNo(licenceTextField.getText());
				referalProvider.setFederalId(federalIDTextField.getText());
				referalProvider.setInactive(inactiveCheckBox.isSelected());
				referalProvider.setLicenseState(licStateTextField.getText());
				referalProvider.setListingName(listingNemeTextField.getText());
				referalProvider.setFirstName(firstnameTextField.getText());
				referalProvider.setMiddleName(middleNameTextField.getText());
				referalProvider.setLastName(lastNameTextField.getText());
				referalProvider.setSuffix(suffixTextField.getText());
				
				referalProvider.setNpi(npiTextField.getText());
			
				referalProvider.setReferType(referalTypeChoiceBox.getSelectionModel().getSelectedItem());
				referalProvider.setRefProviderType(typeComboBox.getSelectionModel().getSelectedItem());
				referalProvider.setSpeciality(specialityTextField.getText());
				
				new ReferalProviderEntityController().saveOrUpdate(referalProvider);
				
				referalProviderViewController.viewReferalProvider();
				
				new FXFormCommonUtilities().closeForm(okButton);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		cancelBtn.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
