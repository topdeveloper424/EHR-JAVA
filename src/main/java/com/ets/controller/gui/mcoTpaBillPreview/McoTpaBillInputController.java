package com.ets.controller.gui.mcoTpaBillPreview;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 09-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CompMcoTpaBillGUIController Class
 *Description: EnterCompMCOTPAOrBillReviewOrganization.fxml Controller class
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
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.billingAccount.BillingAccountEntityController;
import com.ets.controller.entity.complex.ComplexEntityController;
import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.controller.entity.district.DistrictEntityController;
import com.ets.controller.entity.region.RegionEntityController;
import com.ets.controller.entity.tpa.TpaEntityController;
import com.ets.controller.gui.billingAccounts.BillingAccountViewController;
import com.ets.controller.gui.complex.ComplexViewController;
import com.ets.controller.gui.contact.ContactViewController;
import com.ets.controller.gui.district.DistrictViewController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.region.RegionViewController;
import com.ets.model.Address;
import com.ets.model.BillingAccount;
import com.ets.model.Complex;
import com.ets.model.Contact;
import com.ets.model.District;
import com.ets.model.Region;
import com.ets.model.Tpa;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class McoTpaBillInputController implements Initializable {

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField playerBillingAccnoutTextField;

	@FXML
	private Button playerBillingAccountButton;

	@FXML
	private TextField nameTextField;

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
	private TextField contactTextField;

	@FXML
	private Button contactButton;

	@FXML
	private RadioButton mcoRadioButton;

	@FXML
	private RadioButton tpaRadioButton;

	@FXML
	private RadioButton billReviewRadioButton;

	@FXML
	private RadioButton otherRadioButton;
	
	  @FXML
	    private ToggleGroup planType;

	@FXML
	private TextField parentOrgTextField;

	@FXML
	private Button parentOrgButton;

	@FXML
	private TextField icd10EffectTextField;

	@FXML
	private Button icd10EffectButton;

	@FXML
	private Button protocolsButton;

	@FXML
	private CheckBox inactiveCheckBox;

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
	private Button okButton;

	@FXML
	private Button cancelButton;
	

    @FXML
    void enterKeyPressedForOkButton(KeyEvent event) {
    	  if(event.getCode() == KeyCode.ENTER)
         {
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
  				tpa.setAddress(address);
  				tpa.setCode(codeTextField.getText());
  					
  				if(playerBillingAccnoutTextField.getText().isEmpty()){
  					
  					System.out.println("Billing Account Empty");
  					
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
  				new FXFormCommonUtilities().closeForm(cancelButton);
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

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		playerBillingAccountButton.setOnAction((event) -> {
			
			try {
				String formName = formPath.context.getMessage("BillingAccounts", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.BillingAccounts", null, Locale.US);
				formPath.closeApplicationContext();
				
				BillingAccountViewController billingAccountViewController = 
				  (BillingAccountViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				billingAccountViewController.setMcoTpaBillInputController(this);
				
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
			contactViewController.setMcoTpaBillInputController(this);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	});

		/*************************************
		 * Start of regionBtn.setOnAction(..)
		 *****************************************************//*

		regionButton.setOnAction((event) -> {
			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.Region", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
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
				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Region", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Region", null, Locale.US);
				formPath.closeApplicationContext();

				RegionViewController regionViewController = (RegionViewController)new FXFormCommonUtilities().regionDisplayForm(formName, formTitle, task.getValue());
				regionViewController.setMcoTpaBillInputController(this);

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				// Start background thread for database record retrieval .
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

			// Need the ProgressBar controller to access the progress bar in
			// this method
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
				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("District", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.District", null, Locale.US);
				formPath.closeApplicationContext();

				DistrictViewController districtViewController = (DistrictViewController) new FXFormCommonUtilities().districtDisplayForm(formName, formTitle, task.getValue());
				districtViewController.setMcoTpaBillInputController(this);

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				// Start background thread for database record retrieval .
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

			// Need the ProgressBar controller to access the progress bar in
			// this method
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
				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Complex", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Complex", null, Locale.US);
				formPath.closeApplicationContext();

				ComplexViewController complexViewController= (ComplexViewController) new FXFormCommonUtilities().
				complexDisplayForm(formName, formTitle, task.getValue());
				
				complexViewController.setMcoTpaBillInputController(this);
				

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});*/
		/*************************************
		 * End of complexBtn.setOnAction(..)
		 *************************************************************/

		/*parentOrgButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ParentPlayer", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ParentPlayer", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
		okButton.setOnAction((event) -> {
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
				tpa.setAddress(address);
				tpa.setCode(codeTextField.getText());
					
				if(playerBillingAccnoutTextField.getText().isEmpty()){
					
					System.out.println("Billing Account Empty");
					
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
