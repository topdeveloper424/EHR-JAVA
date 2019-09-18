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
import com.ets.controller.gui.company.CompanyEditController;
import com.ets.controller.gui.company.CompanyInputController;
import com.ets.controller.gui.contact.ContactViewController;
import com.ets.model.Address;
import com.ets.model.BillingAccount;
import com.ets.model.Contact;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;

public class BillingAccountInputController implements Initializable{
	
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
    private ChoiceBox<?> ssnPrintOptionsChoiceBox;

    @FXML
    private ChoiceBox<?> invoiceStyleChoiceBox;

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
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button contactsButton;
    
    public void setContact(Integer id){
    	
    	mainContactTextField.setText(Integer.toString(id));
    }

	
	private BillingAccountViewController billingAccountViewController;
		
	public void setBillingAccountViewController(BillingAccountViewController billingAccountViewController) {
		this.billingAccountViewController = billingAccountViewController;
	}
	
	private BillingAccount billingAccount;
	
	public void setBillingAccount(BillingAccount billingAccount) {
		this.billingAccount = billingAccount;
	}


	public CompanyInputController companyInputController;
	
	
	public void setCompanyInputController(CompanyInputController companyInputController , BillingAccount billingAccount) {
		this.companyInputController = companyInputController;
		this.billingAccount = billingAccount;
		viewInitialBillingDetail();
	}
	
	private CompanyEditController companyEditController;
	
	public void setCompanyEditController(CompanyEditController companyEditController , BillingAccount billingAccount) {
		this.companyEditController = companyEditController;
		this.billingAccount = billingAccount;
		viewInitialBillingDetail();
	}
	
	public void viewInitialBillingDetail(){
		
		codeTextField.setText(billingAccount.getCode());
		nameTextField.setText(billingAccount.getName());
		mainBillingAddressTextField.setText(billingAccount.getAddress().getLocalAddress());
		cityTextField.setText(billingAccount.getAddress().getCity());
		stateTextField.setText(billingAccount.getAddress().getState());
		zipTextField.setText(billingAccount.getAddress().getZip());
		countryChoiceBox.setValue(billingAccount.getAddress().getCountry());
		mainContactTextField.setText(billingAccount.getMainContact());
		telephoneTextField.setText(billingAccount.getAddress().getPhone());
		emailTextField.setText(billingAccount.getAddress().getEmail());
		faxTextField.setText(billingAccount.getAddress().getFax());
		
		
	}

	FXMLFormPath formPath = new FXMLFormPath();
	
	public static BillingAccount billingAccount2 = null;


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
		
		
				okButton.setOnAction((event) -> {
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
						
						//BillingAccount billingAccount = new BillingAccount();
						
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
							
							//Contact contact = new ContactEntityController().viewById(Integer.parseInt(mainContactTextField.getText()));
							//billingAccount.setContact(contact);
							
						}*/
						
						billingAccount.setStdFeeSchedule(standardFeeScheduleChoiceBox.getSelectionModel().getSelectedItem());
						billingAccount.setName(nameTextField.getText());
						billingAccount.setStdPrice(standingPricingCheckBox.isSelected());
						
						new BillingAccountEntityController().saveOrUpdate(billingAccount);
						billingAccount2 = billingAccount;
						companyInputController.setbillingAccount(billingAccount2.getCode());
						System.out.println("Billing Account Id :---- " +billingAccount2.getId());
						//billingAccountViewController.viewBillingAccount();
						new FXFormCommonUtilities().closeForm(okButton);
						
						
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
						contactViewController.setBillingAccountInputController(this);						
						
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
				// Centralised Form cancel
				cancelButton.setOnAction((event) -> {
					try {
						
						String formName = formPath.context.getMessage("BillingAccounts", null, Locale.US);
						String formTitle = formPath.context.getMessage("Title.BillingAccounts", null, Locale.US);
						formPath.closeApplicationContext();
						
						BillingAccountViewController billingAccountViewController = 
						  (BillingAccountViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
						billingAccountViewController.setBillingAccountInputController(this);
						
						new FXFormCommonUtilities().closeForm(cancelButton);
						
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
	}
	
}

