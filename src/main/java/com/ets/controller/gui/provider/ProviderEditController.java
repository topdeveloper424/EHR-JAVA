package com.ets.controller.gui.provider;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.provider.ProviderEntityController;
import com.ets.model.Address;
import com.ets.model.Provider;
import com.ets.utils.DateConvert;
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

public class ProviderEditController implements Initializable {
	
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
    private TextField licStateTextField;

    @FXML
    private TextField classTextField;

    @FXML
    private TextField specialityTextField;

    @FXML
    private DatePicker licenceEffectiveDateTextField;

    @FXML
    private DatePicker deaEffectiveDateTextField;

    @FXML
    private DatePicker licenceExpireDateTextField;

    @FXML
    private DatePicker deaExpireDateTextField;

    @FXML
    private DatePicker certificateExpireTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private Button addProviderNetworkBtn;

    @FXML
    private Button salesReportBtn;

    @FXML
    private Button addAccountPinBtn;

    @FXML
    private Button updateButton;

    @FXML
    private Button cancelButton;

    @FXML
    private CheckBox inactiveCheckBox;

    @FXML
    private RadioButton externalRadioButton;

    @FXML
    private ToggleGroup medicalType;

    @FXML
    private RadioButton internalRadioButton;
    
    
private ProviderViewController providerViewController;

@FXML
void enterKeyPressedForUpdateButton(KeyEvent event) {
	
	if(event.getCode() == KeyCode.ENTER){
		String medicalType = null;
		
		if(internalRadioButton.isSelected()){
			
			medicalType = "Internal";
			
		}else if (externalRadioButton.isSelected()) {
			
			medicalType = "External";
		}
		
		try {
			
			Address address = new Address();
			
			address.setId(provider.getAddress().getId());
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
			
			provider.setId(Integer.parseInt(idTextField.getText()));
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
			
			new FXFormCommonUtilities().closeForm(updateButton);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
@FXML
void enterKeyPressedCanclerOkButton(KeyEvent event) {
	if(event.getCode() == KeyCode.ENTER){
		
		try {
			new FXFormCommonUtilities().closeForm(cancelButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
	}
	}


    
	public void setProviderViewController(ProviderViewController providerViewController) {
		this.providerViewController = providerViewController;
	}
	
	private Provider provider;
	
	public void setProvider(Provider provider) {
		this.provider = provider;
		
		/*String str = provider.getName();
		 StringTokenizer st = new StringTokenizer(str);*/
		 
		idTextField.setText(Integer.toString(provider.getId()));
		codeTextField.setText(provider.getCode());
		npiTextField.setText(provider.getNpi());
		
		
			
			firstNameTextField.setText(provider.getFirstName());
			
		
			middleNameTextField.setText(provider.getMiddleName());
		
			
			lastNameTextField.setText(provider.getLastName());
			
			suffixTextField.setText(provider.getSuffix());
		
		
		listingNameTextField.setText(provider.getListingName());
		federalIdTextField.setText(provider.getFederalId());
		licStateTextField.setText(provider.getLicenseState());
		classTextField.setText(provider.getClassCode());
		licenceTextField.setText(provider.getDeaLicenseNo());
		
		Date date1 = provider.getDeaLicenseEffectiveDate();
		
		if(date1 != null){
			
			 LocalDate localDate1 = new DateConvert().dateToLocalDate(date1);
			
			/*Instant instant1 = Instant.ofEpochMilli(date1.getTime());
			LocalDateTime res = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());
			LocalDate localDate1 = res.toLocalDate();*/
						
			licenceEffectiveDateTextField.setValue(localDate1);
			
		}
		
		Date date2 = provider.getDeaIdExpiryDate();
		
		if(date2 != null){
			
			 LocalDate localDate2 = new DateConvert().dateToLocalDate(date2);
								
			licenceExpireDateTextField.setValue(localDate2);
			
		}
		
		deaTextField.setText(provider.getDeaId());
		
		Date date3 = provider.getDeaIdExpiryDate();
		
		if(date3 != null){
			
			 LocalDate localDate3 = new DateConvert().dateToLocalDate(date3);
								
			deaEffectiveDateTextField.setValue(localDate3);
			
		}
		
		Date date4 = provider.getDeaIdExpiryDate();
		
		if(date4 != null){
			
			LocalDate localDate4 = new DateConvert().dateToLocalDate(date4);
								
			deaExpireDateTextField.setValue(localDate4);
			
		}
		
		
		credentialTextField.setText(provider.getCredential());
		specialityTextField.setText(provider.getSpeciality());
		
		addressTextField.setText(provider.addressProperty().getValue().getLocalAddress());
		cityTextField.setText(provider.addressProperty().getValue().getCity());
		stateTextField.setText(provider.addressProperty().getValue().getState());
		zipTextField.setText(provider.addressProperty().getValue().getZip());
		telephoneTextField.setText(provider.addressProperty().getValue().getPhone());
		extensionTextField.setText(provider.addressProperty().getValue().getExt());
		faxTextField.setText(provider.addressProperty().getValue().getFax());
		emailTextField.setText(provider.addressProperty().getValue().getEmail());
		countryComboBox.setValue(provider.addressProperty().getValue().getCountry());
		typeComboBox.setValue(provider.getProviderType());
		//referalTypeChoiceBox.setValue(provider.getReferType());
		
		if(provider.getMedicalType() != null){
			
			if(provider.getMedicalType().equals("Internal")){
				
				internalRadioButton.setSelected(true);
				
			}else if (provider.getMedicalType().equals("External")) {
				
				externalRadioButton.setSelected(true);
			}
			
		}
				
		
		if(provider.getProviderIsMro() == true){
			
			mroCheckBox.setSelected(true);
		}
		
		if (provider.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		}
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
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
	});*/

	/*salesReportBtn.setOnAction((event) -> {
		try {
			// Load Medical Group Details Entry form .

			String formName = formPath.context.getMessage("SalesRepresentative", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.SalesRepresentative", null, Locale.US);
			formPath.closeApplicationContext();
			
			new FXFormCommonUtilities().displayForm(formName, formTitle);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	});

	addAccountPinBtn.setOnAction((event) -> {
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
	
	
	
	updateButton.setOnAction((event) -> {
		
		String medicalType = null;
		
		if(internalRadioButton.isSelected()){
			
			medicalType = "Internal";
			
		}else if (externalRadioButton.isSelected()) {
			
			medicalType = "External";
		}
		
		try {
			
			Address address = new Address();
			
			address.setId(provider.getAddress().getId());
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
			
			provider.setId(Integer.parseInt(idTextField.getText()));
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
			
			new FXFormCommonUtilities().closeForm(updateButton);
			
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
