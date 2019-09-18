package com.ets.controller.gui.billingAccounts;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.billingAccount.BillingAccountEntityController;
import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.controller.gui.contact.ContactViewController;
import com.ets.model.Address;
import com.ets.model.BillingAccount;
import com.ets.model.Contact;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BillingAccountEditController implements Initializable{
	
	@FXML
    private TextField codeTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField mainBillingAddressTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField stateTextField;

    @FXML
    private TextField zipTextField;

    @FXML
    private ChoiceBox<String> countryChoiceBox;

    @FXML
    private TextField telephoneTextField;

    @FXML
    private TextField extensionTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField faxTextField;

    @FXML
    private TextField sourceFaxTextField;

    @FXML
    private TextField mainContactTextField;

    @FXML
    private Button mainContactButton;

    @FXML
    private RadioButton employerRadioButton;

    @FXML
    private RadioButton carrierRadioButton;

    @FXML
    private RadioButton mcoTpaRadioButton;

    @FXML
    private RadioButton labRadioButton;

    @FXML
    private RadioButton contractTpaRadioButton;

    @FXML
    private CheckBox sentToCollectionsCheckBox;

    @FXML
    private DatePicker collectionDate;

    @FXML
    private TextField idTextField;

    @FXML
    private CheckBox standingPricingCheckBox;

    @FXML
    private ChoiceBox<String> standardFeeScheduleChoiceBox;

    @FXML
    private Spinner<?> dsicountPremiumSpinner;

    @FXML
    private CheckBox excludeNameInvoicePrintingCheckBox;

    @FXML
    private CheckBox printAtternateIDFromPatientsCompanyCheckBox;

    @FXML
    private TextField disvountLevelTextField;

    @FXML
    private ChoiceBox<String> ssnPrintOptionsChoiceBox;

    @FXML
    private ChoiceBox<String> invoiceStyleChoiceBox;

    @FXML
    private Button topButton;

    @FXML
    private Button upButton;

    @FXML
    private Button downButton;

    @FXML
    private Button bottomButton;

    @FXML
    private Button addButton;

    @FXML
    private Button changeButton;

    @FXML
    private Button deleteButton;

    @FXML
    private CheckBox printContactCheckBox;

    @FXML
    private TextArea billingAddreddTextArea;

    @FXML
    private TextArea notesForTheBillingAccountsTextArea;

    @FXML
    private Button updateButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button contactsButton;
    
    private BillingAccount billingAccount;
        
    public void setBillingAccount(BillingAccount billingAccount) {
		this.billingAccount = billingAccount;
		
		if(billingAccount.getAcType().equals("Employer")){
			
			employerRadioButton.setSelected(true);
			
		}else if (billingAccount.getAcType().equals("Carrier")) {
			
			carrierRadioButton.setSelected(true);
			
		}else if (billingAccount.getAcType().equals("MCO/TPA")) {
			
			mcoTpaRadioButton.setSelected(true);
			
		}else if (billingAccount.getAcType().equals("Lab")) {
			
			labRadioButton.setSelected(true);
			
		}else if (billingAccount.getAcType().equals("Contract TPA")) {
			
			contractTpaRadioButton.setSelected(true);
			
		}
			
		mainBillingAddressTextField.setText(billingAccount.addressProperty().getValue().getLocalAddress());
		cityTextField.setText(billingAccount.addressProperty().getValue().getCity());
		stateTextField.setText(billingAccount.addressProperty().getValue().getState());
		zipTextField.setText(billingAccount.addressProperty().getValue().getZip());
		countryChoiceBox.setValue(billingAccount.addressProperty().getValue().getCountry());
		telephoneTextField.setText(billingAccount.addressProperty().getValue().getPhone());
		extensionTextField.setText(billingAccount.addressProperty().getValue().getExt());
		faxTextField.setText(billingAccount.addressProperty().getValue().getFax());
		emailTextField.setText(billingAccount.addressProperty().getValue().getEmail());
		sourceFaxTextField.setText(billingAccount.addressProperty().getValue().getSecureFax());
		
		idTextField.setText(Integer.toString(billingAccount.getId()));
		codeTextField.setText(billingAccount.getCode());
		
Date date1 = billingAccount.getCollectDate();
		
		if(date1 != null){
			
			 LocalDate localDate1 = new DateConvert().dateToLocalDate(date1);
								
			 collectionDate.setValue(localDate1);
			
		}
		
		if(billingAccount.getCollectSent() == true){
			
			sentToCollectionsCheckBox.setSelected(true);
		}
		
		/*if(billingAccount.getContact() != null){
			
			mainContactTextField.setText(Integer.toString(billingAccount.contactProperty().getValue().getId()));
		}*/
		
		mainContactTextField.setText(billingAccount.getMainContact());
		standardFeeScheduleChoiceBox.setValue(billingAccount.getStdFeeSchedule());
		nameTextField.setText(billingAccount.getName());
		
		if(billingAccount.getStdPrice() == true){
			
			standingPricingCheckBox.setSelected(true);
		}
			
			
			
	}

	private BillingAccountViewController billingAccountViewController;
    
    
    public void setBillingAccountViewController(BillingAccountViewController billingAccountViewController) {
		this.billingAccountViewController = billingAccountViewController;
	}
    
public void setContact(Integer id){
    	
    	mainContactTextField.setText(Integer.toString(id));
    }

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
List<String> list1 = new ArrayList<String>();
		
		list1.add("USA");
		list1.add("Mexico");
		list1.add("Canada");
		
		ObservableList countryList = FXCollections.observableList(list1);
		countryChoiceBox.getItems().clear();
		countryChoiceBox.setItems(countryList);
		
		List<String> list2 = new ArrayList<String>();
		
		list2.add("Default");
		list2.add("Employer Services");
		list2.add("Worker's Comp");
		list2.add("Private Practice");
		list2.add("Medicare");
		list2.add("Clinic");
		
		ObservableList scheduleList = FXCollections.observableList(list1);
		standardFeeScheduleChoiceBox.getItems().clear();
		standardFeeScheduleChoiceBox.setItems(scheduleList);
		
		
				updateButton.setOnAction((event) -> {
					try {
						
						String acType = null;
						
						if(employerRadioButton.isSelected()){
							
							acType = "Employer";
							
						}else if (carrierRadioButton.isSelected()) {
							
							acType = "Carrier";
							
						}else if (mcoTpaRadioButton.isSelected()) {
							
							acType = "MCO/TPA";
							
						}else if (labRadioButton.isSelected()) {
							
							acType = "Lab";
							
						}else if (contractTpaRadioButton.isSelected()) {
							
							acType = "Contract TPA";
						}
						
						
						
						Address address = new Address();
						
						address.setId(billingAccount.getAddress().getId());
						address.setlocalAddress(mainBillingAddressTextField.getText());
						address.setCity(cityTextField.getText());
						address.setState(stateTextField.getText());
						address.setZip(zipTextField.getText());
						address.setCountry(countryChoiceBox.getSelectionModel().getSelectedItem());
						address.setPhone(telephoneTextField.getText());
						address.setExt(extensionTextField.getText());
						address.setFax(faxTextField.getText());
						address.setEmail(emailTextField.getText());
						address.setSecureFax(sourceFaxTextField.getText());
						
						new AddressEntityController().add(address);
						
						BillingAccount billingAccount = new BillingAccount();
						
						billingAccount.setId(Integer.parseInt(idTextField.getText()));
						billingAccount.setAcType(acType);
						billingAccount.setAddress(address);
						//billingAccount.setAdjustPercent(adjustPercent);
						billingAccount.setCode(codeTextField.getText());
						
						LocalDate localDate1 = collectionDate.getValue();
						
						if(localDate1 != null){
							
						Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
												
						billingAccount.setCollectDate(date1);
						}
						
						billingAccount.setCollectSent(sentToCollectionsCheckBox.isSelected());
						
						if(mainContactTextField.getText().length() > 0){
							
							billingAccount.setMainContact(mainContactTextField.getText());
							
						}/*else{
							
							Contact contact = new ContactEntityController().viewById(Integer.parseInt(mainContactTextField.getText()));
							billingAccount.setContact(contact);
							
						}*/
						
						
						billingAccount.setStdFeeSchedule(standardFeeScheduleChoiceBox.getSelectionModel().getSelectedItem());
						billingAccount.setName(nameTextField.getText());
						billingAccount.setStdPrice(standingPricingCheckBox.isSelected());
						
						new BillingAccountEntityController().saveOrUpdate(billingAccount);
						billingAccountViewController.viewBillingAccount();
						new FXFormCommonUtilities().closeForm(updateButton);
						
						
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
				
				mainContactButton.setOnAction((event) -> {
					try {
						String formName = formPath.context.getMessage("ViewContact", null, Locale.US);
						String formTitle = formPath.context.getMessage("Title.ViewContact", null, Locale.US);
						formPath.closeApplicationContext();
						ContactViewController contactViewController =
						 (ContactViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
						contactViewController.setBillingAccountEditController(this);
						
						
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
		
		// Centralised Form cancel
				cancelButton.setOnAction((event) -> {
					try {
						new FXFormCommonUtilities().closeForm(cancelButton);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
		
		
	}
	
}
