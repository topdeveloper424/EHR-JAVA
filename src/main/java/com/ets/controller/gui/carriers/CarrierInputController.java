package com.ets.controller.gui.carriers;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 09-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of InsuranceCarrierGUIController Class
 *Description: EnterInsuranceCarrier.fxml Controller class
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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.billingAccount.BillingAccountEntityController;
import com.ets.controller.entity.carrier.CarrierEntityController;
import com.ets.controller.entity.carrierRule.CarrierRuleEntityController;
import com.ets.controller.entity.complex.ComplexEntityController;
import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.controller.entity.district.DistrictEntityController;
import com.ets.controller.entity.region.RegionEntityController;
import com.ets.controller.gui.billingAccounts.BillingAccountViewController;
import com.ets.controller.gui.complex.ComplexViewController;
import com.ets.controller.gui.contact.ContactViewController;
import com.ets.controller.gui.district.DistrictViewController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.region.RegionViewController;
import com.ets.model.Address;
import com.ets.model.BillingAccount;
import com.ets.model.Carrier;
import com.ets.model.CarrierRule;
import com.ets.model.Complex;
import com.ets.model.Contact;
import com.ets.model.District;
import com.ets.model.Region;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

public class CarrierInputController implements Initializable {

	@FXML
	private TextField carrierCodeTextField;

	@FXML
	private TextField playerBillingAccnoutTextField;

	@FXML
	private Button playerBillingAccnoutButton;

	@FXML
	private TextField carrierNameTextField;

	@FXML
	private TextField addressTextField;

	@FXML
	private TextField cityTextField;

	@FXML
	private TextField stateTextField;

	@FXML
	private TextField zipTextField;

	@FXML
	private TextField telephoneTextField;

	@FXML
	private TextField extTextField;

	@FXML
	private TextField faxTextField;

	@FXML
	private TextField emailTextField;

	@FXML
	private TextField sourceFaxTextField;

	@FXML
	private TextField contactTextField;

	@FXML
	private Button contactButton;

	@FXML
	private TextField planNameTextField;

    @FXML
    private ChoiceBox<String> playTypeChoiceBox;

	@FXML
	private TextField icd10EffectTextField;

	@FXML
	private TextField parentPlayerTextField;

	@FXML
	private TextField sopCodeTextField;

	@FXML
	private Button icd10Button;

	@FXML
	private Button parentPlayerButton;

	@FXML
	private Button sopButton;

	@FXML
	private Button contactsButton;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	@FXML
	private TextField feinTextField;

	@FXML
	private TextField wcbCodeTextField;

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
	private Button deleteButton;

	@FXML
	private Button changeButton;

	@FXML
	private CheckBox pcpRequiredCheckBox;

	@FXML
	private CheckBox pcpReferalRequiredForSpecialistServiveCheckBox;

	@FXML
	private CheckBox xRayNotCoveredCheckBox;

	@FXML
	private CheckBox suppliesNotCoveredCheckBox;

	@FXML
	private CheckBox medsNotCovered;

	@FXML
	private CheckBox acceptLocumTenumCheckBox;

	@FXML
	private CheckBox authorizationRequired;

	@FXML
	private TextField authorizationPhoneTextField;

	@FXML
	private TextField authorizationContactTextField;

	@FXML
	private TextField authorizationTemplateTextField;
	  @FXML
	    void enterKeyPressedForOkButton(KeyEvent event) {
		  if(event.getCode() == KeyCode.ENTER){
			  try {
					
					Address address = new Address();
					
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
					
					/*try{
						
						Integer integer = Integer.parseInt(contactTextField.getText());
						
						if(integer.SIZE > 0){
							
							Contact contact = new ContactEntityController().viewById(Integer.parseInt(contactTextField.getText()));
							carrier.setContact(contact);
							
						}
						
						}catch(NumberFormatException e){
							
							 System.out.println("not a number");
							
						}*/
					
					if(contactTextField.getText().isEmpty()){
						
						System.out.println("Contact is empty");
						
					}else{
						
						Contact contact = new ContactEntityController().viewById(Integer.parseInt(contactTextField.getText()));
						carrier.setContact(contact);
						
					}
					
					carrier.setFeinCode(feinTextField.getText());
					carrier.setInactive(inactiveCheckBox.isSelected());
					carrier.setName(carrierNameTextField.getText());
					carrier.setPlanName(planNameTextField.getText());
					carrier.setPlanType( playTypeChoiceBox.getSelectionModel().getSelectedItem());
									
					carrier.setWebCode(wcbCodeTextField.getText());
					
					new CarrierEntityController().saveOrUpdate(carrier);
					carrierViewController.viewCarrier();
					
					new FXFormCommonUtilities().closeForm(okButton);
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}

		  
	    }}
	  
	  @FXML
	    void enterKeyPressedForCancleButtons(KeyEvent event) {
		  if(event.getCode() == KeyCode.ENTER){
          
			  try {
					new FXFormCommonUtilities().closeForm(cancelButton);
				} catch (Exception ex) {
					ex.printStackTrace();
				} }
	  }

	@FXML
	private Button authorizationTemplateButton;

	@FXML
	private CheckBox AutoGenerateAuthorizationNumberCheckBox;
	
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
	
	private CarrierViewController carrierViewController;
	
	public void setCarrierViewController(CarrierViewController carrierViewController) {
		this.carrierViewController = carrierViewController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		playerBillingAccnoutButton.setOnAction((event) -> {
			
				try {
					String formName = formPath.context.getMessage("BillingAccounts", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.BillingAccounts", null, Locale.US);
					formPath.closeApplicationContext();
					
					BillingAccountViewController billingAccountViewController = 
					  (BillingAccountViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					billingAccountViewController.setCarrierInputController(this);
					
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
				contactViewController.setCarrierInputController(this);
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*sopButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("SOP", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SOP", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*************************************
		 * Start of regionBtn.setOnAction(..)
		 *****************************************************//*

		regionButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.Region", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			*//********************************
			 * Start of Task definition
			 *****************************************************************//*
			Task<ObservableList<Region>> task =

					new Task<ObservableList<Region>>() {

						@Override
						protected ObservableList<Region> call() throws Exception {

							final ObservableList<Region> regionList = new RegionEntityController().viewRegion();

							if (isCancelled()) {
								return null;
							}
							return regionList;

						}
					};
			*//*************************
			 * End of Task definition
			 *****************************************************************//*

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");

				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Region", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Region", null, Locale.US);
				formPath.closeApplicationContext();
			
				RegionViewController regionViewController = (RegionViewController)new FXFormCommonUtilities().regionDisplayForm(formName, formTitle, task.getValue());
				regionViewController.setCarrierInputController(this);

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {

				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		*//*************************************
		 * End of regionBtn.setOnAction(..)
		 *************************************************************//*

		*//*************************************
		 * Start of districtBtn.setOnAction(..)
		 *****************************************************//*

		districtButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.District", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			*//********************************
			 * Start of Task definition
			 *****************************************************************//*
			Task<ObservableList<District>> task =

					new Task<ObservableList<District>>() {

						@Override
						protected ObservableList<District> call() throws Exception {

							final ObservableList<District> districtList = new DistrictEntityController().viewDistrict();

							if (isCancelled()) {
								return null;
							}
							return districtList;

						}
					};
			*//*************************
			 * End of Task definition
			 *****************************************************************//*

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");

				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("District", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.District", null, Locale.US);
				formPath.closeApplicationContext();

			DistrictViewController districtViewController = (DistrictViewController) new FXFormCommonUtilities().districtDisplayForm(formName, formTitle, task.getValue());
				districtViewController.setCarrierInputController(this);

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {

				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		*//*************************************
		 * End of districtBtn.setOnAction(..)
		 *************************************************************//*

		*//*************************************
		 * Start of complexBtn.setOnAction(..)
		 *****************************************************//*

		complexButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.Complex", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			*//********************************
			 * Start of Task definition
			 *****************************************************************//*
			Task<ObservableList<Complex>> task =

					new Task<ObservableList<Complex>>() {

						@Override
						protected ObservableList<Complex> call() throws Exception {

							final ObservableList<Complex> complexList = new ComplexEntityController().viewComplex();

							if (isCancelled()) {
								return null;
							}
							return complexList;

						}
					};
			*//*************************
			 * End of Task definition
			 *****************************************************************//*

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");

				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Complex", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Complex", null, Locale.US);
				formPath.closeApplicationContext();

				ComplexViewController complexViewController = (ComplexViewController) new FXFormCommonUtilities().complexDisplayForm(formName, formTitle, task.getValue());
				complexViewController.setCarrierInputController(this);

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {

				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		*//*************************************
		 * End of complexBtn.setOnAction(..)
		 *************************************************************/

		/*parentPlayerButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ParentPlayer", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ParentPlayer", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*authorizationTemplateButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AuthorizationTemplate", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AuthorizationTemplate", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
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
		
		okButton.setOnAction((event) -> {
			try {
				
				Address address = new Address();
				
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
				
				/*try{
					
					Integer integer = Integer.parseInt(contactTextField.getText());
					
					if(integer.SIZE > 0){
						
						Contact contact = new ContactEntityController().viewById(Integer.parseInt(contactTextField.getText()));
						carrier.setContact(contact);
						
					}
					
					}catch(NumberFormatException e){
						
						 System.out.println("not a number");
						
					}*/
				
				if(contactTextField.getText().isEmpty()){
					
					System.out.println("Contact is empty");
					
				}else{
					
					Contact contact = new ContactEntityController().viewById(Integer.parseInt(contactTextField.getText()));
					carrier.setContact(contact);
					
				}
				
				carrier.setFeinCode(feinTextField.getText());
				carrier.setInactive(inactiveCheckBox.isSelected());
				carrier.setName(carrierNameTextField.getText());
				carrier.setPlanName(planNameTextField.getText());
				carrier.setPlanType( playTypeChoiceBox.getSelectionModel().getSelectedItem());
								
				carrier.setWebCode(wcbCodeTextField.getText());
				
				new CarrierEntityController().saveOrUpdate(carrier);
				carrierViewController.viewCarrier();
				
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
