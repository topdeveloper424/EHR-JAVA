package com.ets.controller.gui.carriers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.billingAccount.BillingAccountEntityController;
import com.ets.controller.entity.carrier.CarrierEntityController;
import com.ets.controller.entity.carrierRule.CarrierRuleEntityController;
import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.controller.gui.billingAccounts.BillingAccountViewController;
import com.ets.controller.gui.contact.ContactViewController;
import com.ets.model.Address;
import com.ets.model.BillingAccount;
import com.ets.model.Carrier;
import com.ets.model.CarrierRule;
import com.ets.model.Contact;
import com.ets.model.VisitCategory;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CarrierEditController implements Initializable {
	
	@FXML
    private TextField carrierCodeTextField;

    @FXML
    private TextField carrierNameTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField telephoneTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField contactTextField;

    @FXML
    private TextField extTextField;

    @FXML
    private TextField playerBillingAccnoutTextField;

    @FXML
    private TextField stateTextField;

    @FXML
    private TextField zipTextField;

    @FXML
    private TextField faxTextField;

    @FXML
    private TextField sourceFaxTextField;

    @FXML
    private TextField planNameTextField;

    @FXML
    private ChoiceBox<String> playTypeChoiceBox;

    @FXML
    private Button contactButton;

    @FXML
    private Button playerBillingAccnoutButton;

    @FXML
    private TextField carriedIdTextField;

    @FXML
    private TextField regionTextField;

    @FXML
    private TextField districtTextField;

    @FXML
    private TextField complexTextField;

    @FXML
    private Button regionButton;

    @FXML
    private Button districtButton;

    @FXML
    private Button complexButton;

    @FXML
    private TextField feinTextField;

    @FXML
    private TextField wcbCodeTextField;

    @FXML
    private CheckBox xRayNotCoveredCheckBox;

    @FXML
    private CheckBox suppliesNotCoveredCheckBox;

    @FXML
    private CheckBox medsNotCovered;

    @FXML
    private CheckBox authorizationRequired;

    @FXML
    private TextField authorizationPhoneTextField;

    @FXML
    private TextField authorizationContactTextField;

    @FXML
    private Button updateButton;

    @FXML
    private Button cancelButton;

    @FXML
    private CheckBox inactiveCheckBox;

    @FXML
    private Button contactsButton;
    @FXML
    void enterKeyPressedForCancleButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {
			new FXFormCommonUtilities().closeForm(cancelButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }}

    @FXML
    void enterKeyPressedForContactsButton(KeyEvent event) {

    }

    @FXML
    void enterKeyPressedForPlayerBillingAccnoutButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){

		try {
			String formName = formPath.context.getMessage("BillingAccounts", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.BillingAccounts", null, Locale.US);
			formPath.closeApplicationContext();
			
			BillingAccountViewController billingAccountViewController = 
			  (BillingAccountViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			billingAccountViewController.setCarrierEditController(this);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}}

    }

    @FXML
    void enterKeyPressedForUpdateButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {
			
			Address address = new Address();
			
			address.setId(carrier.getAddress().getId());
			address.setlocalAddress(addressTextField.getText());
			address.setCity(cityTextField.getText());
			address.setState(stateTextField.getText());
			address.setZip(zipTextField.getText());
			address.setPhone(telephoneTextField.getText());
			address.setExt(extTextField.getText());
			address.setFax(faxTextField.getText());
			address.setEmail(emailTextField.getText());
			address.setSecureFax(sourceFaxTextField.getText());
			
			new AddressEntityController().add(address);
			
			CarrierRule carrierRule = new CarrierRule();
			carrierRule.setId(carrier.getCarrierRule().getId());
			carrierRule.setAuthContact(authorizationContactTextField.getText());
			carrierRule.setAuthPhone(authorizationPhoneTextField.getText());
			carrierRule.setAuthReq(authorizationRequired.isSelected());
			carrierRule.setExcludeMed(medsNotCovered.isSelected());
			carrierRule.setExcludeSupplies(suppliesNotCoveredCheckBox.isSelected());
			carrierRule.setExcludeXray(xRayNotCoveredCheckBox.isSelected());
			
			new CarrierRuleEntityController().addOrUpdate(carrierRule);
			
			
			Carrier carrier = new Carrier();
			
			
			carrier.setCode(carrierCodeTextField.getText());
			carrier.setAddress(address);
			carrier.setCarrierRule(carrierRule);
			
			if(playerBillingAccnoutTextField.getText().isEmpty()){
				
				System.out.println("Billing Account is Empty");
					
				}
			else{
				
				BillingAccount billingAccount = new BillingAccountEntityController().viewByCode(playerBillingAccnoutTextField.getText());
				carrier.setBillingAccount(billingAccount);
				
			}
			
			if(contactTextField.getText().isEmpty()){
				
				System.out.println("Contact is empty");
				
			}else{
				
				Contact contact = new ContactEntityController().viewById(Integer.parseInt(contactTextField.getText()));
				carrier.setContact(contact);
				
			}
			
			/*try{
				
				Integer integer = Integer.parseInt(contactTextField.getText());
				
				if(integer.SIZE > 0){
					
					Contact contact = new ContactEntityController().viewById(Integer.parseInt(contactTextField.getText()));
					carrier.setContact(contact);
					
				}
				
				}catch(NumberFormatException e){
					
					 System.out.println("not a number");
					
				}*/
			
			carrier.setId(Integer.parseInt(carriedIdTextField.getText()));
			carrier.setFeinCode(feinTextField.getText());
			carrier.setInactive(inactiveCheckBox.isSelected());
			carrier.setName(carrierNameTextField.getText());
			carrier.setPlanName(planNameTextField.getText());
			carrier.setPlanType( playTypeChoiceBox.getSelectionModel().getSelectedItem());
							
			carrier.setWebCode(wcbCodeTextField.getText());
			
			new CarrierEntityController().saveOrUpdate(carrier);
			carrierViewController.viewCarrier();
			
			new FXFormCommonUtilities().closeForm(updateButton);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
    }
    @FXML
    void enterKeyPressedForcontactSearchButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	
    	try {
			String formName = formPath.context.getMessage("ViewContact", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ViewContact", null, Locale.US);
			formPath.closeApplicationContext();
			ContactViewController contactViewController =
			 (ContactViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			contactViewController.setCarrierEditController(this);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	
    	}
    }
    
    private CarrierViewController carrierViewController;
	
	public void setCarrierViewController(CarrierViewController carrierViewController) {
		this.carrierViewController = carrierViewController;
	}
	
	public void setCarrierBillingAccount(String code){
		
		playerBillingAccnoutTextField.setText(code);
	}
	
	public void setContact(Integer id){
		contactTextField.setText(Integer.toString(id));
	}
	
	private Carrier carrier;
	

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
		
		carriedIdTextField.setText(Integer.toString(carrier.getId()));
		carrierCodeTextField.setText(carrier.getCode());
		carrierNameTextField.setText(carrier.getName());
		addressTextField.setText(carrier.addressProperty().getValue().getLocalAddress());
		cityTextField.setText(carrier.addressProperty().getValue().getCity());
		stateTextField.setText(carrier.addressProperty().getValue().getState());
		zipTextField.setText(carrier.addressProperty().getValue().getZip());
		telephoneTextField.setText(carrier.addressProperty().getValue().getPhone());
		extTextField.setText(carrier.addressProperty().getValue().getExt());
		faxTextField.setText(carrier.addressProperty().getValue().getFax());
		emailTextField.setText(carrier.addressProperty().getValue().getEmail());
		sourceFaxTextField.setText(carrier.addressProperty().getValue().getSecureFax());
		
		if(carrier.getContact() != null){
			
			contactTextField.setText(Integer.toString(carrier.contactProperty().getValue().getId()));
		}
		if(carrier.getBillingAccount() != null){
			playerBillingAccnoutTextField.setText(carrier.billingAccountProperty().getValue().getCode());
		}
		
		planNameTextField.setText(carrier.getPlanName());
		playTypeChoiceBox.setValue(carrier.getPlanType());
		feinTextField.setText(carrier.getFeinCode());
		wcbCodeTextField.setText(carrier.getWebCode());
		
		if (carrier.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		}
		
		if(carrier.carrierRuleProperty().getValue().getAuthReq()){
			
			authorizationRequired.setSelected(true);
			
		}
		if(carrier.carrierRuleProperty().getValue().getExcludeMed()){
			
			medsNotCovered.setSelected(true);
			
		}
		if(carrier.carrierRuleProperty().getValue().getExcludeSupplies()){
			
			suppliesNotCoveredCheckBox.setSelected(true);
			
		}
		if(carrier.carrierRuleProperty().getValue().getExcludeXray()){
			
			xRayNotCoveredCheckBox.setSelected(true);
	
		}
		
		authorizationContactTextField.setText(carrier.carrierRuleProperty().getValue().getAuthContact());
		authorizationPhoneTextField.setText(carrier.carrierRuleProperty().getValue().getAuthPhone());

		
	}

	FXMLFormPath formPath = new FXMLFormPath();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		playerBillingAccnoutButton.setOnAction((event) -> {
			
			try {
				String formName = formPath.context.getMessage("BillingAccounts", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.BillingAccounts", null, Locale.US);
				formPath.closeApplicationContext();
				
				BillingAccountViewController billingAccountViewController = 
				  (BillingAccountViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				billingAccountViewController.setCarrierEditController(this);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	
	contactButton.setOnAction((event) -> {
		try {
			String formName = formPath.context.getMessage("ViewContact", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ViewContact", null, Locale.US);
			formPath.closeApplicationContext();
			ContactViewController contactViewController =
			 (ContactViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			contactViewController.setCarrierEditController(this);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	});
		
		

		
List<String> planType = new ArrayList<String>();
		
		planType.add("Worker,s Comp");
		planType.add("Group Health");
		planType.add("Medicare");
		planType.add("Medicaid");
		planType.add("Medigap"); 
		planType.add("Tricare"); 
		planType.add("ChampVA"); 
		planType.add("FECA"); 
		planType.add("Blue Cross"); 
		planType.add("Blue Shield"); 
		planType.add("Other"); 
				
		ObservableList<String> planTypeList = FXCollections.observableList(planType);
		playTypeChoiceBox.setItems(planTypeList);
		
		updateButton.setOnAction((event) -> {
			try {
				
				Address address = new Address();
				
				address.setId(carrier.getAddress().getId());
				address.setlocalAddress(addressTextField.getText());
				address.setCity(cityTextField.getText());
				address.setState(stateTextField.getText());
				address.setZip(zipTextField.getText());
				address.setPhone(telephoneTextField.getText());
				address.setExt(extTextField.getText());
				address.setFax(faxTextField.getText());
				address.setEmail(emailTextField.getText());
				address.setSecureFax(sourceFaxTextField.getText());
				
				new AddressEntityController().add(address);
				
				CarrierRule carrierRule = new CarrierRule();
				carrierRule.setId(carrier.getCarrierRule().getId());
				carrierRule.setAuthContact(authorizationContactTextField.getText());
				carrierRule.setAuthPhone(authorizationPhoneTextField.getText());
				carrierRule.setAuthReq(authorizationRequired.isSelected());
				carrierRule.setExcludeMed(medsNotCovered.isSelected());
				carrierRule.setExcludeSupplies(suppliesNotCoveredCheckBox.isSelected());
				carrierRule.setExcludeXray(xRayNotCoveredCheckBox.isSelected());
				
				new CarrierRuleEntityController().addOrUpdate(carrierRule);
				
				
				Carrier carrier = new Carrier();
				
				
				carrier.setCode(carrierCodeTextField.getText());
				carrier.setAddress(address);
				carrier.setCarrierRule(carrierRule);
				
				if(playerBillingAccnoutTextField.getText().isEmpty()){
					
					System.out.println("Billing Account is Empty");
						
					}
				else{
					
					BillingAccount billingAccount = new BillingAccountEntityController().viewByCode(playerBillingAccnoutTextField.getText());
					carrier.setBillingAccount(billingAccount);
					
				}
				
				if(contactTextField.getText().isEmpty()){
					
					System.out.println("Contact is empty");
					
				}else{
					
					Contact contact = new ContactEntityController().viewById(Integer.parseInt(contactTextField.getText()));
					carrier.setContact(contact);
					
				}
				
				/*try{
					
					Integer integer = Integer.parseInt(contactTextField.getText());
					
					if(integer.SIZE > 0){
						
						Contact contact = new ContactEntityController().viewById(Integer.parseInt(contactTextField.getText()));
						carrier.setContact(contact);
						
					}
					
					}catch(NumberFormatException e){
						
						 System.out.println("not a number");
						
					}*/
				
				carrier.setId(Integer.parseInt(carriedIdTextField.getText()));
				carrier.setFeinCode(feinTextField.getText());
				carrier.setInactive(inactiveCheckBox.isSelected());
				carrier.setName(carrierNameTextField.getText());
				carrier.setPlanName(planNameTextField.getText());
				carrier.setPlanType( playTypeChoiceBox.getSelectionModel().getSelectedItem());
								
				carrier.setWebCode(wcbCodeTextField.getText());
				
				new CarrierEntityController().saveOrUpdate(carrier);
				carrierViewController.viewCarrier();
				
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
