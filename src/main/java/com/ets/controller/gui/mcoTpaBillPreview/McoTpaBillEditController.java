package com.ets.controller.gui.mcoTpaBillPreview;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.billingAccount.BillingAccountEntityController;
import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.controller.entity.tpa.TpaEntityController;
import com.ets.controller.gui.billingAccounts.BillingAccountViewController;
import com.ets.controller.gui.contact.ContactViewController;
import com.ets.model.Address;
import com.ets.model.BillingAccount;
import com.ets.model.Contact;
import com.ets.model.Tpa;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class McoTpaBillEditController implements Initializable {
	
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
    private Button playerBillingAccountButton;

    @FXML
    private RadioButton mcoRadioButton;

    @FXML
    private ToggleGroup planType;

    @FXML
    private RadioButton tpaRadioButton;

    @FXML
    private RadioButton billReviewRadioButton;

    @FXML
    private RadioButton otherRadioButton;

    @FXML
    private TextField contactTextField;

    @FXML
    private Button contactButton;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField regionTextField;

    @FXML
    private TextField districtTextField;

    @FXML
    private TextField complexTextField;
    
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
    private Button protocolsButton;
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

    @FXML
    void enterKeyPressedForProtocolsButton(KeyEvent event) {
    	

    }

    @FXML
    void enterKeyPressedForUpdateButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
try {
				
				String planType = null;

				if (mcoRadioButton.isSelected()) {
					planType = "MCO";
				} else if (tpaRadioButton.isSelected()) {
					planType = "TPA";
				} else if (billReviewRadioButton.isSelected()) {
					planType = "Bill Review";
				} else if (otherRadioButton.isSelected()) {
					planType = "Other";
				}
				
				Address address = new Address();
				
				address.setId(tpa.getAddress().getId());
				address.setlocalAddress(addressTextField.getText());
				address.setCity(cityTextField.getText());
				address.setState(stateTextField.getText());
				address.setZip(zipTextField.getText());
				address.setPhone(telephoneTextField.getText());
				address.setExt(extTextField.getText());
				address.setFax(faxTextField.getText());
				address.setEmail(emailTextField.getText());
				
				new AddressEntityController().add(address);
				
				Tpa tpa = new Tpa();
				
				tpa.setId(Integer.parseInt(idTextField.getText()));
				tpa.setAddress(address);
				tpa.setCode(codeTextField.getText());
				
				if(playerBillingAccnoutTextField.getText().isEmpty()){
					
					System.out.println("Billing Account is Empty");
					
				}else{
					
					BillingAccount billingAccount = new BillingAccountEntityController().viewByCode(playerBillingAccnoutTextField.getText());
					tpa.setBillingAccount(billingAccount);	
					
				}
				
				if(contactTextField.getText().isEmpty()){
					
					System.out.println("Contact is Empty");
					
				}else{
					
					Contact contact = new ContactEntityController().viewById(Integer.parseInt(contactTextField.getText()));
					tpa.setContact(contact);
					
				}
				
				tpa.setInactive(inactiveCheckBox.isSelected());
				tpa.setName(nameTextField.getText());
				tpa.setPlanType(planType);
				
				
				new TpaEntityController().saveOrUpdate(tpa);
				mcoTpaBillViewController.viewTPA();
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
			contactViewController.setMcoTpaBillEditController(this);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	}
    }
    
    public void setComplex(String complex){
		
		complexTextField.setText(complex);
		
	}
	
	public void setDistrict(String district){
		
		districtTextField.setText(district);
		
	}
	
	public void setRegion(String region){
		
		regionTextField.setText(region);
		
	}
	
	public void setCarrierBillingAccount(String code){
		
		playerBillingAccnoutTextField.setText(code);
	}
	
	public void setContact(Integer id){
		contactTextField.setText(Integer.toString(id));
	}
    
    private McoTpaBillViewController mcoTpaBillViewController;
    
    public void setMcoTpaBillViewController(McoTpaBillViewController mcoTpaBillViewController) {
		this.mcoTpaBillViewController = mcoTpaBillViewController;
	}


	private Tpa tpa;
    
	public void setTpa(Tpa tpa) {
		this.tpa = tpa;
		
		idTextField.setText(Integer.toString(tpa.getId()));
		codeTextField.setText(tpa.getCode());
		nameTextField.setText(tpa.getName());
		addressTextField.setText(tpa.addressProperty().getValue().getLocalAddress());
		cityTextField.setText(tpa.addressProperty().getValue().getCity());
		stateTextField.setText(tpa.addressProperty().getValue().getState());
		zipTextField.setText(tpa.addressProperty().getValue().getZip());
		telephoneTextField.setText(tpa.addressProperty().getValue().getPhone());
		extTextField.setText(tpa.addressProperty().getValue().getExt());
		faxTextField.setText(tpa.addressProperty().getValue().getFax());
		emailTextField.setText(tpa.addressProperty().getValue().getEmail());
		
		if(tpa.getContact() != null){
			
			contactTextField.setText(Integer.toString(tpa.contactProperty().getValue().getId()));
		}
		if(tpa.getBillingAccount() != null){
			playerBillingAccnoutTextField.setText(tpa.billingAccountProperty().getValue().getCode());
		}
		
		if("MCO".equals(tpa.getPlanType())){
			
			mcoRadioButton.setSelected(true);
			
		}else if("TPA".equals(tpa.getPlanType())){
			
			tpaRadioButton.setSelected(true);
		}else if("Bill Review".equals(tpa.getPlanType())){
			
			billReviewRadioButton.setSelected(true);
		}else if("Other".equals(tpa.getPlanType())){
			
			otherRadioButton.setSelected(true);
		}
		
		if (tpa.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		}
		
		
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
				billingAccountViewController.setMcoTpaBillEditController(this);
				
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
			contactViewController.setMcoTpaBillEditController(this);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	});
		
		updateButton.setOnAction((event) -> {
			try {
				
				String planType = null;

				if (mcoRadioButton.isSelected()) {
					planType = "MCO";
				} else if (tpaRadioButton.isSelected()) {
					planType = "TPA";
				} else if (billReviewRadioButton.isSelected()) {
					planType = "Bill Review";
				} else if (otherRadioButton.isSelected()) {
					planType = "Other";
				}
				
				Address address = new Address();
				
				address.setId(tpa.getAddress().getId());
				address.setlocalAddress(addressTextField.getText());
				address.setCity(cityTextField.getText());
				address.setState(stateTextField.getText());
				address.setZip(zipTextField.getText());
				address.setPhone(telephoneTextField.getText());
				address.setExt(extTextField.getText());
				address.setFax(faxTextField.getText());
				address.setEmail(emailTextField.getText());
				
				new AddressEntityController().add(address);
				
				Tpa tpa = new Tpa();
				
				tpa.setId(Integer.parseInt(idTextField.getText()));
				tpa.setAddress(address);
				tpa.setCode(codeTextField.getText());
				
				if(playerBillingAccnoutTextField.getText().isEmpty()){
					
					System.out.println("Billing Account is Empty");
					
				}else{
					
					BillingAccount billingAccount = new BillingAccountEntityController().viewByCode(playerBillingAccnoutTextField.getText());
					tpa.setBillingAccount(billingAccount);	
					
				}
				
				if(contactTextField.getText().isEmpty()){
					
					System.out.println("Contact is Empty");
					
				}else{
					
					Contact contact = new ContactEntityController().viewById(Integer.parseInt(contactTextField.getText()));
					tpa.setContact(contact);
					
				}
				
				tpa.setInactive(inactiveCheckBox.isSelected());
				tpa.setName(nameTextField.getText());
				tpa.setPlanType(planType);
				
				
				new TpaEntityController().saveOrUpdate(tpa);
				mcoTpaBillViewController.viewTPA();
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
