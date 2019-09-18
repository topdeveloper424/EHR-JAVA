package com.ets.controller.gui.Laboratories;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.billingAccount.BillingAccountEntityController;
import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.controller.entity.laboratory.LaboratoryEntityController;
import com.ets.controller.gui.billingAccounts.BillingAccountViewController;
import com.ets.controller.gui.contact.ContactViewController;
import com.ets.model.Address;
import com.ets.model.BillingAccount;
import com.ets.model.Contact;
import com.ets.model.Laboratory;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LaboratoryEditController implements Initializable {
	
	@FXML
    private TextField codeTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField telephoneTextField;

    @FXML
    private TextField emailTextField;

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
    private TextField contactTextField;

    @FXML
    private Button contactButton;

    @FXML
    private TextField externalIdTextField;

    @FXML
    private TextField sourceFaxTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField regionTextField;

    @FXML
    private TextField districtTextField;

    @FXML
    private TextField complexTextField;
    
    @FXML
    private Button playerBillingAccountButton;

    @FXML
    private Button regionButton;

    @FXML
    private Button complexButton;

    @FXML
    private Button districtButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button cancelButton;

    @FXML
    private CheckBox inactiveCheckBox;
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
    void enterKeyPressedForContactButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {
			String formName = formPath.context.getMessage("ViewContact", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ViewContact", null, Locale.US);
			formPath.closeApplicationContext();
			ContactViewController contactViewController =
			 (ContactViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			contactViewController.setLaboratoryEditController(this);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	}
    }

    @FXML
    void enterKeyPressedForPlayerBillingAccount(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {
			String formName = formPath.context.getMessage("BillingAccounts", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.BillingAccounts", null, Locale.US);
			formPath.closeApplicationContext();
			
			BillingAccountViewController billingAccountViewController = 
			  (BillingAccountViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			billingAccountViewController.setLaboratoryEditController(this);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	}
    }

    @FXML
    void enterKeyPressedForUpdateButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {
			
			Address address = new Address();
			
			address.setId(laboratory.getAddress().getId());
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
			
			Laboratory laboratory = new Laboratory();
			
			laboratory.setId(Integer.parseInt(idTextField.getText()));
			laboratory.setAddress(address);
			laboratory.setCode(codeTextField.getText());
			
			if (playerBillingAccnoutTextField.getText().isEmpty()) {
				
				System.out.println("Billing Account is Empty");
				
			}else{
				
				BillingAccount billingAccount = new BillingAccountEntityController().viewByCode(playerBillingAccnoutTextField.getText());
				laboratory.setBillingAccount(billingAccount);
				
			}

			if (contactTextField.getText().isEmpty()) {
				
				System.out.println("Contact is Empty");
				
			}else{
				
				Contact contact = new ContactEntityController().viewById(Integer.parseInt(contactTextField.getText()));
				laboratory.setContact(contact);
				
			}
			
			laboratory.setInactive(inactiveCheckBox.isSelected());
			laboratory.setName(nameTextField.getText());
							
			
			new LaboratoryEntityController().saveOrUpdate(laboratory);
			laboratoryViewController.viewLaboratory();
			new FXFormCommonUtilities().closeForm(updateButton);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	}
    }

    
    public void setCarrierBillingAccount(String code){
		
		playerBillingAccnoutTextField.setText(code);
	}
	
	public void setContact(Integer id){
		contactTextField.setText(Integer.toString(id));
	}
    
    private Laboratory laboratory;
        
    public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
		
		idTextField.setText(Integer.toString(laboratory.getId()));
		codeTextField.setText(laboratory.getCode());
		nameTextField.setText(laboratory.getName());
		addressTextField.setText(laboratory.addressProperty().getValue().getLocalAddress());
		cityTextField.setText(laboratory.addressProperty().getValue().getCity());
		stateTextField.setText(laboratory.addressProperty().getValue().getState());
		zipTextField.setText(laboratory.addressProperty().getValue().getZip());
		telephoneTextField.setText(laboratory.addressProperty().getValue().getPhone());
		extTextField.setText(laboratory.addressProperty().getValue().getExt());
		faxTextField.setText(laboratory.addressProperty().getValue().getFax());
		emailTextField.setText(laboratory.addressProperty().getValue().getEmail());
		sourceFaxTextField.setText(laboratory.addressProperty().getValue().getSecureFax());
		
		if(laboratory.getContact() != null){
			
			contactTextField.setText(Integer.toString(laboratory.contactProperty().getValue().getId()));
		}
		if(laboratory.getBillingAccount() != null){
			playerBillingAccnoutTextField.setText(laboratory.billingAccountProperty().getValue().getCode());
		}
		
		if (laboratory.getInactive() == true) {
			
			inactiveCheckBox.setSelected(true);
			
		}
		
		
	}
    
    private LaboratoryViewController laboratoryViewController;
    
	public void setLaboratoryViewController(LaboratoryViewController laboratoryViewController) {
		this.laboratoryViewController = laboratoryViewController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		playerBillingAccountButton.setOnAction((event) -> {
			
			try {
				String formName = formPath.context.getMessage("BillingAccounts", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.BillingAccounts", null, Locale.US);
				formPath.closeApplicationContext();
				
				BillingAccountViewController billingAccountViewController = 
				  (BillingAccountViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				billingAccountViewController.setLaboratoryEditController(this);
				
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
			contactViewController.setLaboratoryEditController(this);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	});
		
		updateButton.setOnAction((event) -> {
			try {
				
				Address address = new Address();
				
				address.setId(laboratory.getAddress().getId());
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
				
				Laboratory laboratory = new Laboratory();
				
				laboratory.setId(Integer.parseInt(idTextField.getText()));
				laboratory.setAddress(address);
				laboratory.setCode(codeTextField.getText());
				
				if (playerBillingAccnoutTextField.getText().isEmpty()) {
					
					System.out.println("Billing Account is Empty");
					
				}else{
					
					BillingAccount billingAccount = new BillingAccountEntityController().viewByCode(playerBillingAccnoutTextField.getText());
					laboratory.setBillingAccount(billingAccount);
					
				}

				if (contactTextField.getText().isEmpty()) {
					
					System.out.println("Contact is Empty");
					
				}else{
					
					Contact contact = new ContactEntityController().viewById(Integer.parseInt(contactTextField.getText()));
					laboratory.setContact(contact);
					
				}
				
				laboratory.setInactive(inactiveCheckBox.isSelected());
				laboratory.setName(nameTextField.getText());
								
				
				new LaboratoryEntityController().saveOrUpdate(laboratory);
				laboratoryViewController.viewLaboratory();
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
