package com.ets.controller.gui.contact;

import java.net.URL;
import java.util.Locale;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinician.ClinicianEntityController;
import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.controller.gui.Laboratories.LaboratoryEditController;
import com.ets.controller.gui.Laboratories.LaboratoryInputController;
import com.ets.controller.gui.billingAccounts.BillingAccountEditController;
import com.ets.controller.gui.billingAccounts.BillingAccountInputController;
import com.ets.controller.gui.carriers.CarrierEditController;
import com.ets.controller.gui.carriers.CarrierInputController;
import com.ets.controller.gui.clinic.ClinicInputController;
import com.ets.controller.gui.company.CompanyEditController;
import com.ets.controller.gui.company.CompanyInputController;
import com.ets.controller.gui.complex.ComplexEditController;
import com.ets.controller.gui.complex.ComplexInputController;
import com.ets.controller.gui.drugScreenTestResultReport.EmployerReportGUIController;
import com.ets.controller.gui.mcoTpaBillPreview.McoTpaBillEditController;
import com.ets.controller.gui.mcoTpaBillPreview.McoTpaBillInputController;
import com.ets.model.Clinician;
import com.ets.model.Company;
import com.ets.model.Complex;
import com.ets.model.Contact;
import com.ets.model.PatientInsuranceCarrier;
import com.ets.model.SICCode;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ContactViewController implements Initializable{
	
	   @FXML
	    private AnchorPane searchContactFx;

	    @FXML
	    private TableView<Contact> ContactTable;

	    @FXML
	    private TableColumn<Contact, String> ContactOrganizationCol;

	    @FXML
	    private TableColumn<Contact,String> contactNameCol;

	    @FXML
	    private TableColumn<Contact, String> ContactTelephoneCol;

	    @FXML
	    private Button addButton;

	    @FXML
	    private Button changeButton;

	    @FXML
	    private Button deleteButton;

	    @FXML
	    private Button closeButton;
	    
	    @FXML
	    private Button selectButton;

	    @FXML
	    private Button topButton;

	    @FXML
	    private Button upButton;

	    @FXML
	    private Button downButton;

	    @FXML
	    private Button bottomButton;

	    @FXML
	    private TextField ContactsearchText;

	    @FXML
	    private ComboBox<?> ContactselectText;
	    
	    private Button button;
	    
		private EmployerReportGUIController employerReportGUIController;
		

		public void setEmployerReportGUIController(EmployerReportGUIController employerReportGUIController) {
			this.employerReportGUIController = employerReportGUIController;
		}

	    @FXML
	    void doubleClick(MouseEvent event) {
	    	
	    	if (event.getClickCount() == 2) {
				try {
					Contact contact = ContactTable.getSelectionModel().getSelectedItem();
					int index = ContactTable.getSelectionModel().getSelectedIndex();

					String formName = formPath.context.getMessage("EditContact", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.EditContact", null, Locale.US);

					String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
					String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

					formPath.closeApplicationContext();

					if (contact != null) {

						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
						Parent root1 = (Parent) fxmlLoader.load();
						Stage stage = new Stage();
						stage.initModality(Modality.APPLICATION_MODAL);
						stage.setTitle(formTitle);
						stage.setScene(new Scene(root1));
						ContactEditController editController = fxmlLoader.getController();
						editController.setContact(contact);
						editController.setContactViewController(this,index);
						stage.show();

					} else {

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle(infoDialogBoxTitle);
						alert.setHeaderText(null);
						alert.setContentText(editInfo);
						alert.showAndWait();

					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
	    	
	    }
	    
	    private ClinicInputController clinicInputController;
	    
	    public void setClinicInputController(ClinicInputController clinicInputController) {
			this.clinicInputController = clinicInputController;
		}
	    
	    private BillingAccountInputController billingAccountInputController;
	    
		public void setBillingAccountInputController(BillingAccountInputController billingAccountInputController) {
			this.billingAccountInputController = billingAccountInputController;
		}
		
		private BillingAccountEditController billingAccountEditController;
		
		
		public void setBillingAccountEditController(BillingAccountEditController billingAccountEditController) {
			this.billingAccountEditController = billingAccountEditController;
		}

		public CompanyInputController companyInputController;
		
		public void setCompanyInputController(CompanyInputController companyInputController) {
			this.companyInputController = companyInputController;
		}
		
		public CompanyEditController companyEditController;
	    private Company company;	
		public void setCompanyEditController(CompanyEditController companyEditController,Button button){
			this.companyEditController = companyEditController;
			this.button = button;
			
			viewContact();
			
		}

		private CarrierInputController carrierInputController;
		
		public void setCarrierInputController(CarrierInputController carrierInputController) {
			this.carrierInputController = carrierInputController;
			
		}
		
		private CarrierEditController carrierEditController;
		
		public void setCarrierEditController(CarrierEditController carrierEditController) {
			this.carrierEditController = carrierEditController;
		}
		
		private McoTpaBillInputController mcoTpaBillInputController;
		
		public void setMcoTpaBillInputController(McoTpaBillInputController mcoTpaBillInputController) {
			this.mcoTpaBillInputController = mcoTpaBillInputController;
		}
		
		private McoTpaBillEditController mcoTpaBillEditController;
		
		public void setMcoTpaBillEditController(McoTpaBillEditController mcoTpaBillEditController) {
			this.mcoTpaBillEditController = mcoTpaBillEditController;
		}
		
		private LaboratoryInputController laboratoryInputController;
		
		public void setLaboratoryInputController(LaboratoryInputController laboratoryInputController) {
			this.laboratoryInputController = laboratoryInputController;
		}
		
		private LaboratoryEditController laboratoryEditController;
		
		public void setLaboratoryEditController(LaboratoryEditController laboratoryEditController) {
			this.laboratoryEditController = laboratoryEditController;
		}
		
		public void viewContact(){
			
			
	    	ContactOrganizationCol.setCellValueFactory(cellValue -> cellValue.getValue().deptProperty());
	    	contactNameCol.setCellValueFactory(cellValue -> cellValue.getValue().fullNameProperty());
	    	//ContactTelephoneCol.setCellValueFactory(cellValue->cellValue.getValue().getAddress().phoneProperty());
				    	
	    	ObservableList observableList= FXCollections.observableArrayList();
	    	
            
	    	
	    	
	    	if(companyEditController != null){
	    		System.out.println("Entered If companyEditctrl");
	    	if(button.getId().equals("mainContactButtonEdit")||button.getId().equals("CompanyContactsBtnEdit")){
	    		 System.out.println("Entered Condition");
	    		observableList= FXCollections.observableArrayList();
	    		observableList =  new ContactEntityController().viewByCompId(CompanyEditController.company.getId());
	    		System.out.println("size "+observableList.size());
	    		ContactTable.setItems(observableList);
	    	//	CompanyEditController.company = new Company();
	    	
	    	}
	    	}
	    	 
	    	else{
	    		  if(employerReportGUIController==null){
	  	    		
	  	    		System.out.println("Entered EmployerReportController >>>>");
	  	    		observableList= FXCollections.observableArrayList();
	  	    		observableList =  new ContactEntityController().viewByCompId(Global.patient.getCompany().getId());
	  	    		System.out.println("size "+observableList.size());
	  	    		ContactTable.setItems(observableList);
	  	    		
	  	    		
	  	    	}else{
	    		
               System.out.println("Entered Else block .....");
	    		for (Contact obContactList : ContactInputController.contactList) {
	    			
	    			observableList.add(obContactList);	
	    			System.out.println(obContactList.getFullName());
	    			
	    			
				}
	    		System.out.println("observableList size " +observableList.size());
	    		ContactTable.setItems(observableList);
	    		
	    	}
	    	}
			
		}

	    FXMLFormPath formPath = new FXMLFormPath();
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 if(companyEditController==null){  
		   viewContact();
		 }
		   addButton.setOnAction((event) -> {
				try {
					// Load Complex Details Entry form .

					String formName = formPath.context.getMessage("AddContact", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.AddContact", null, Locale.US);
					formPath.closeApplicationContext();
					ContactInputController contactInputController =
					(ContactInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					contactInputController.setContactViewController(this);
					

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
		   
		   changeButton.setOnAction((event) -> {
				try {
					

					Contact contact = ContactTable.getSelectionModel().getSelectedItem();
					int index = ContactTable.getSelectionModel().getSelectedIndex();

					String formName = formPath.context.getMessage("EditContact", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.EditContact", null, Locale.US);

					String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
					String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

					formPath.closeApplicationContext();

					if (contact != null) {

						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
						Parent root1 = (Parent) fxmlLoader.load();
						Stage stage = new Stage();
						stage.initModality(Modality.APPLICATION_MODAL);
						stage.setTitle(formTitle);
						stage.setScene(new Scene(root1));
						ContactEditController editController = fxmlLoader.getController();
						editController.setContact(contact);
						editController.setContactViewController(this,index);
						stage.show();

					} else {

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle(infoDialogBoxTitle);
						alert.setHeaderText(null);
						alert.setContentText(editInfo);
						alert.showAndWait();

					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
		   
		   deleteButton.setOnAction((event) -> {
				
				try {

					String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
					String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
					String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
					String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

					formPath.closeApplicationContext();

					Integer contactIndex =  ContactTable.getSelectionModel().getSelectedIndex();
                    Contact contact = ContactTable.getSelectionModel().getSelectedItem();
					if (contactIndex > -1) {

						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle(conformDialogBoxTitle);
						alert.setHeaderText(conformDelete);
						alert.setContentText(null);

						Optional<ButtonType> result = alert.showAndWait();
						
						if (result.get() == ButtonType.OK) {
							
							//Contact contact = new ContactEntityController().view().get(contactIndex);
							 
                             if(companyInputController!=null){
                            	int ind= ContactInputController.contactList.indexOf(ContactTable.getSelectionModel().getSelectedItem());
                            	System.out.println("########## ind ind "+ind);
                            	if(ind!=-1){
                            		 ContactInputController.contactList.remove(ContactTable.getSelectionModel().getSelectedItem()); 
                            	 }
                             }else if(companyEditController!=null){
                            	 new ContactEntityController().delete(contact.getId());
                             }
							
							 viewContact();

						} else {
                           //user select cancel
						}

					} else {

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle(infoDialogBoxTitle);
						alert.setHeaderText(null);
						alert.setContentText(deleteInfo);

						alert.showAndWait();

					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
		   
		   selectButton.setOnAction((event) -> {
			   
				Contact contact = this.ContactTable.getSelectionModel().getSelectedItem();

				if (clinicInputController != null) {
					
					this.clinicInputController.setContact(contact.getId());
					
				} else if (billingAccountInputController != null) {
					
					billingAccountInputController.setContact(contact.getId());
					
				}else if (billingAccountEditController != null) {
					
					billingAccountEditController.setContact(contact.getId());
					
				}else if (companyInputController != null) {
					
					companyInputController.setContact(contact);
					
				}else if (companyEditController != null) {
					
					companyEditController.setContact(contact);
					
				}else if (carrierInputController != null) {
					
					carrierInputController.setContact(contact.getId());
					
				}else if (carrierEditController != null) {
					
					carrierEditController.setContact(contact.getId());
					
				}else if (mcoTpaBillInputController != null) {
					
					mcoTpaBillInputController.setContact(contact.getId());
					
				}else if (mcoTpaBillEditController != null) {
					
					mcoTpaBillEditController.setContact(contact.getId());
					
				}else if (laboratoryInputController != null) {
					
					laboratoryInputController.setContact(contact.getId());
					
				}else if (laboratoryEditController != null) {
					
					laboratoryEditController.setContact(contact.getId());
					
				}else if(employerReportGUIController!=null)
				{
					employerReportGUIController.setContact(contact);
				}

					new FXFormCommonUtilities().closeForm(selectButton);
				

			});
		   
		   closeButton.setOnAction((event) -> {
				try {
					new FXFormCommonUtilities().closeForm( closeButton );
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
		   
		  
	}

	
	
	
}
