package com.ets.controller.gui.clinic;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.clinic.ClinicEntityController;
import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.controller.gui.contact.ContactViewController;
import com.ets.model.Address;
import com.ets.model.Clinic;
import com.ets.model.Contact;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 22-07-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicInputController Class
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


public class ClinicInputController implements Initializable {

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField localAddressTextField;

	@FXML
	private TextField cityTextField;

	@FXML
	private TextField countyTextField;

	@FXML
	private TextField district1TextField;

	@FXML
	private TextField zipTextField;

	@FXML
	private TextField telephoneTextField;

	@FXML
	private TextField emailTextField;

	@FXML
	private TextField contractTextField;

	@FXML
	private TextField faxTextField;

	@FXML
	private TextField regionTextField;

	@FXML
	private TextField complexTextField;

	@FXML
	private Button regionButton;

	@FXML
	private Button districtButton;

	@FXML
	private Button complexButton;

	@FXML
	private TextField extTextField;

	@FXML
	private ComboBox<String> serviceTypeComboBox;

	@FXML
	private TextField stateTextField;
	
    @FXML
    private Button contactButton;

	@FXML
	private TextField federalIdTextField;

	@FXML
	private TextField medicinIdTextField;

	@FXML
	private TextField npiIdTextField;

	@FXML
	private TextField cliaIdTextField;

	@FXML
	private ChoiceBox<?> workCompInvoiceComboBox;

	@FXML
	private ChoiceBox<?> privatePracticeInvoiceComboBox;

	@FXML
	private TextField cmsServiceTextField;

	@FXML
	private TextField insurenceTextField;

	@FXML
	private TextField gcpiTextField;

	@FXML
	private TextField expenseTextField;

	@FXML
	private TextField pliTextField;

	@FXML
	private TreeTableView<?> payerAccountTable;

	@FXML
	private TreeTableColumn<?, ?> accountCollumn;

	@FXML
	private TreeTableColumn<?, ?> payerNameCollumn;

	@FXML
	private TreeTableColumn<?, ?> groupIdCollumn;

	@FXML
	private Button payerAccountaddButton;

	@FXML
	private Button payerAccountChangeButton;

	@FXML
	private Button payerAccountdeleteButton;

	@FXML
	private TextField pharmacySearchButton;

	@FXML
	private TableView<?> pharmacyTable;

	@FXML
	private TableColumn<?, ?> ecsCollumn;

	@FXML
	private TableColumn<?, ?> nameCollumn;

	@FXML
	private TableColumn<?, ?> addressCollumn;

	@FXML
	private TableColumn<?, ?> cityCollumn;

	@FXML
	private TableColumn<?, ?> stateCollumn;

	@FXML
	private TableColumn<?, ?> zipCollumn;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private TextField federalIdNumberTextField;

	@FXML
	private TextField stateLicenseNumberTextField;

	@FXML
	private TextField medicadeIdNumberTextField;

	@FXML
	private TextField npiNumberTextField;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;
	
	@FXML
    void enterKeyPressedForCancelButton(KeyEvent event) {
		if(event.getCode() == KeyCode.ENTER){
			 try {

				// cancel centralized form
					new FXFormCommonUtilities().closeForm(cancelButton);
				 
    }catch (Exception ex) {
		ex.printStackTrace();
	} 
	 }
	}

    @FXML
    void enterKeyPressedForOkButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
			 try {

				 Address address = new Address();
					address.setCity(cityTextField.getText());
					address.setCounty(countyTextField.getText());
					address.setState(stateTextField.getText());
					address.setDistrict(district1TextField.getText());
					address.setEmail(emailTextField.getText());
					address.setPhone(telephoneTextField.getText());
					address.setExt(extTextField.getText());
					address.setFax(faxTextField.getText());
					address.setZip(zipTextField.getText());
					address.setlocalAddress(localAddressTextField.getText());
					new AddressEntityController().add(address);

					Clinic clinic = new Clinic();
					clinic.setCode(codeTextField.getText());
					clinic.setName(this.nameTextField.getText());
					clinic.setPrimaryServiceType(serviceTypeComboBox.getSelectionModel().getSelectedItem());
					
					clinic.setAddress(address); // store Address Id into Clinic
					
					/*try{
						
						Integer integer = Integer.parseInt(contractTextField.getText());
						
						if(integer.SIZE > 0){
							
							Contact contact = new ContactEntityController().viewById(Integer.parseInt(contractTextField.getText()));
							clinic.setContact(contact);
							
						}
						
						}catch(NumberFormatException e){
							
							 System.out.println("not a number");
							
						}*/
					
					if(contractTextField.getText().isEmpty()){
						
						System.out.println("Contact is Empty");
						
					}else{
						
						Contact contact = new ContactEntityController().viewById(Integer.parseInt(contractTextField.getText()));
						clinic.setContact(contact);
					}
									
					clinic.setCliaNo(cliaIdTextField.getText());
					clinic.setFederalTaxIdNo(federalIdTextField.getText());
					clinic.setMedicareIdNo(medicinIdTextField.getText());
					clinic.setNpiNo(npiIdTextField.getText());
					clinic.setInactive(inactiveCheckBox.isSelected());

					new ClinicEntityController().saveClinic(clinic);
					clinicViewController.clinicView();
				
						// cancel Input form
						new FXFormCommonUtilities().closeForm(okButton);
					
				 
   }catch (Exception ex) {
		ex.printStackTrace();
	} 
	 }
    }

	private ClinicViewController clinicViewController;

	public void setClinicViewController(ClinicViewController clinicViewController) {
		this.clinicViewController = clinicViewController;
	}
	
	public void setContact(Integer contact){
		
		contractTextField.setText(Integer.toString(contact));
		
	}
	
	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		List<String> list = new ArrayList<String>();
		list.add("Occupational Health");
		list.add("Employee Health Populations");
		list.add("Urgent Care/Private Practice");

		ObservableList servicelist = FXCollections.observableList(list);

		serviceTypeComboBox.setItems(servicelist);

		okButton.setOnAction((event) -> {
			try {
				Address address = new Address();
				address.setCity(cityTextField.getText());
				address.setCounty(countyTextField.getText());
				address.setState(stateTextField.getText());
				address.setDistrict(district1TextField.getText());
				address.setEmail(emailTextField.getText());
				address.setPhone(telephoneTextField.getText());
				address.setExt(extTextField.getText());
				address.setFax(faxTextField.getText());
				address.setZip(zipTextField.getText());
				address.setlocalAddress(localAddressTextField.getText());
				new AddressEntityController().add(address);

				Clinic clinic = new Clinic();
				clinic.setCode(codeTextField.getText());
				clinic.setName(this.nameTextField.getText());
				clinic.setPrimaryServiceType(serviceTypeComboBox.getSelectionModel().getSelectedItem());
				
				clinic.setAddress(address); // store Address Id into Clinic
				
				/*try{
					
					Integer integer = Integer.parseInt(contractTextField.getText());
					
					if(integer.SIZE > 0){
						
						Contact contact = new ContactEntityController().viewById(Integer.parseInt(contractTextField.getText()));
						clinic.setContact(contact);
						
					}
					
					}catch(NumberFormatException e){
						
						 System.out.println("not a number");
						
					}*/
				
				if(contractTextField.getText().isEmpty()){
					
					System.out.println("Contact is Empty");
					
				}else{
					
					Contact contact = new ContactEntityController().viewById(Integer.parseInt(contractTextField.getText()));
					clinic.setContact(contact);
				}
								
				clinic.setCliaNo(cliaIdTextField.getText());
				clinic.setFederalTaxIdNo(federalIdTextField.getText());
				clinic.setMedicareIdNo(medicinIdTextField.getText());
				clinic.setNpiNo(npiIdTextField.getText());
				clinic.setInactive(inactiveCheckBox.isSelected());

				new ClinicEntityController().saveClinic(clinic);
				clinicViewController.clinicView();
			
					// cancel Input form
					new FXFormCommonUtilities().closeForm(okButton);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		contactButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("ViewContact", null, Locale.US);
				
				String formTitle = formPath.context.getMessage("Title.ViewContact", null, Locale.US);
				formPath.closeApplicationContext();
				ContactViewController contactViewControlle =
				(ContactViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				contactViewControlle.setClinicInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});


		cancelButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
