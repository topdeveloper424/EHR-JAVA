package com.ets.controller.gui.contact;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.controller.entity.note.NoteEntityController;

import com.ets.controller.gui.company.CompanyEditController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolEditController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolInputController;
import com.ets.model.Address;
import com.ets.model.Contact;
import com.ets.model.Note;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ContactInputController implements Initializable{

	  @FXML
	    private TextField firstnameText;

	    @FXML
	    private TextField lastNameFx;

	    @FXML
	    private TextField FullNameText;

	    @FXML
	    private TextField TitleText;

	    @FXML
	    private TextField DepartmentText;

	    @FXML
	    private TextField AddressText;

	    @FXML
	    private TextField CityText;

	    @FXML
	    private TextField StateText;

	    @FXML
	    private TextField ZipText;

	    @FXML
	    private ChoiceBox<String> CountryDropDwn;

	    @FXML
	    private TextField PhoneText;

	    @FXML
	    private TextField Ext;

	    @FXML
	    private TextField FaxText;

	    @FXML
	    private TextField CellphoneText;

	    @FXML
	    private TextField Emailtext;

	    @FXML
	    private ChoiceBox<String> ContactTpyeDrop;

	    @FXML
	    private Button okButton;

	    @FXML
	    private Button cancelButton;
	    
	    @FXML
	    void contactFullNameMouseClicked(MouseEvent event) {
	    	
	    	FullNameText.setText(firstnameText.getText() + " " + lastNameFx.getText());

	    }
	    
	private ContactViewController contactViewController;
    
	public void setContactViewController(ContactViewController contactViewController) {
		this.contactViewController = contactViewController;
	}

	private CompanyProtocolInputController companyProtocolInputController;
    
    public void setCompanyProtocolInputController(CompanyProtocolInputController companyProtocolInputController) {
			this.companyProtocolInputController = companyProtocolInputController;
			
		}
    
    private Integer selectedContectIndex;
    private Integer indexOfstaticContactList;
   
    
    private CompanyProtocolEditController companyProtocolEditController;    

   public void setCompanyProtocolEditController(CompanyProtocolEditController companyProtocolEditController) {
		this.companyProtocolEditController = companyProtocolEditController;
	}
   private Contact contactFromEditProtocol;
  
   public void setCompanyProtocolEditController(CompanyProtocolEditController companyProtocolEditController,Contact contact,Integer selectedContectIndex) {
		this.companyProtocolEditController = companyProtocolEditController;
		this.contactFromEditProtocol = contact;
		this.selectedContectIndex = selectedContectIndex;
		CountryDropDwn.setValue(contactFromEditProtocol.getCountry());
		ContactTpyeDrop.setValue(contactFromEditProtocol.getContactType());
		firstnameText.setText(contactFromEditProtocol.getFirstName());
		lastNameFx.setText(contactFromEditProtocol.getLastName());
		FullNameText.setText(contactFromEditProtocol.getFullName());
		TitleText.setText(contactFromEditProtocol.getTitle());
		DepartmentText.setText(contactFromEditProtocol.getDept());
		AddressText.setText(contactFromEditProtocol.getLocalAddress());
		CityText.setText(contactFromEditProtocol.getCity());
		StateText.setText(contactFromEditProtocol.getState());
		ZipText.setText(contactFromEditProtocol.getZip());
		PhoneText.setText(contactFromEditProtocol.getPhone());
		Ext.setText(contactFromEditProtocol.getExt());
		CellphoneText.setText(contactFromEditProtocol.getMobile());
		FaxText.setText(contactFromEditProtocol.getFax());
		Emailtext.setText(contactFromEditProtocol.getEmail());
		
	}
public static List<Contact> contactList =  new ArrayList<Contact>();
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		
		List<String> countrydrop= new ArrayList<String>();
		countrydrop.add("USA");
		countrydrop.add("CANADA");
		countrydrop.add("MEXICO");
		ObservableList country= FXCollections.observableList(countrydrop);
		CountryDropDwn.getItems().clear();
		CountryDropDwn.setItems(country);
		
		List<String> contractTypeDropdrop= new ArrayList<String>();
		
		contractTypeDropdrop.add("Sales");
		contractTypeDropdrop.add("Surveillance");
		contractTypeDropdrop.add("Worker's Comp");
		contractTypeDropdrop.add("All Clinical");
		contractTypeDropdrop.add("Billing");
		contractTypeDropdrop.add("Other");
		
		ObservableList contractTypeList= FXCollections.observableList(contractTypeDropdrop);
		ContactTpyeDrop.getItems().clear();
		ContactTpyeDrop.setItems(contractTypeList);
	
		 okButton.setOnAction((event) -> {
				try {
					
					
					
					Contact contact=new Contact();
					/*if(contactFromEditProtocol!=null){
						contact = contactFromEditProtocol;	
					}
					if(contactEdFromInputcontroller!=null){
						contact = contactEdFromInputcontroller;	
						
					}*/
					
					
					
					contact.setFirstName(firstnameText.getText());
					contact.setLastName(lastNameFx.getText());
					contact.setFullName(FullNameText.getText());
					System.out.println("%%%%%%%"+FullNameText.getText());
					System.out.println("&&&&&&"+contact.getFullName());
					contact.setTitle(TitleText.getText());
					contact.setDept(DepartmentText.getText());
					contact.setlocalAddress(AddressText.getText());
					contact.setCity(CityText.getText());
					contact.setState(StateText.getText());
					contact.setZip(ZipText.getText());
					contact.setPhone(PhoneText.getText());
					contact.setExt(Ext.getText());
					contact.setCountry(CountryDropDwn.getSelectionModel().getSelectedItem());
					contact.setMobile(CellphoneText.getText());
					contact.setFax(FaxText.getText());
					contact.setEmail(Emailtext.getText());
					contact.setContactType(ContactTpyeDrop.getSelectionModel().getSelectedItem());
                   // new ContactEntityController().saveOrUpdate(contact);
					
				//	contactViewController.viewContact();
					   if(contactViewController!=null){
						if(contactViewController.companyEditController!=null){
							contact.setCompany(CompanyEditController.company); 
							new ContactEntityController().saveOrUpdate(contact);
							contactViewController.viewContact();
							
						}else if(contactViewController.companyInputController!=null){
							contactList.add(contact);
							contactViewController.viewContact();
						}
						
						
					}
					
					if(companyProtocolInputController!=null){
						if(companyProtocolInputController.companyProtocolViewController.companyInputController!=null){
						
								// add to static list
							contactList.add(contact);
							companyProtocolInputController.viewContact();
							
							
						}else if(companyProtocolInputController.companyProtocolViewController.companyEditController!=null){
							contact.setCompany(CompanyEditController.company); 
							new ContactEntityController().saveOrUpdate(contact);
							
							companyProtocolInputController.viewContact();
														
						}
					}
					
					if(companyProtocolEditController!=null){
						if(companyProtocolEditController.companyProtocolViewController!=null?companyProtocolEditController.companyProtocolViewController.companyInputController!=null:false){
						
								// add to static list
							contactList.add(contact);
							companyProtocolEditController.viewContact();
							
							
						}else if(companyProtocolEditController.companyProtocolViewController!=null?companyProtocolEditController.companyProtocolViewController.companyEditController!=null:false){
							contact.setCompany(CompanyEditController.company); 
							new ContactEntityController().saveOrUpdate(contact);
							
							companyProtocolEditController.viewContact();
														
						}else if(companyProtocolEditController.encounterFormInputController!=null){
							if(companyProtocolEditController.companyProtocolFromEncounter.getCompany()!=null){
							contact.setCompany(companyProtocolEditController.companyProtocolFromEncounter.getCompany());	
                            new ContactEntityController().saveOrUpdate(contact);
							
							companyProtocolEditController.viewContact();
							System.out.println("@@@@@@@@@@@@@@@@ saved1 ");
							}else if(Global.patient.getCompany()!=null){
								contact.setCompany(Global.patient.getCompany());
								new ContactEntityController().saveOrUpdate(contact);
								
								companyProtocolEditController.viewContact();
								System.out.println("@@@@@@@@@@@@@@@@ saved2 ");
							}
							
							}
						
						
					}
					
					
				  /*  
					new ContactEntityController().saveOrUpdate(contact);
					
					contactViewController.viewContact();
					*/
					
					/*for( ;i<=j;i++){
						
						contactList.add(i, contact);	
						System.out.println();
					}*/
				/*    if(contactViewController!=null){
					if(contactViewController.companyEditController != null){
						contact.setCompany(CompanyEditController.company);
						new ContactEntityController().saveOrUpdate(contact);
						
					} contactViewController.viewContact();
				    }*//*else{
						contactList.add(contact);	
						System.out.println("contact size from contInpContrl"+contactList.size());
						
				    
				    }*/
				 	
				    /*   if(companyProtocolInputControllerEd!=null){
				    	if(contactEdFromInputcontroller!=null){//edit from comp input
				    		System.out.println("index  "+indexOfstaticContactList);
				    		contact.setCompany(CompanyEditController.company);
							new ContactEntityController().saveOrUpdate(contact);
							
				    		//contactList.add(indexOfstaticContactList, contact);
				    		//companyProtocolInputControllerEd.refreshContactFromProtocolEdit(selectedContectIndex, contact);
				    	}else if(companyProtocolInputControllerAdd!=null){
				    		if(CompanyEditController.company!=null){
				    			  contact.setCompany(CompanyEditController.company);
				    			  new ContactEntityController().saveOrUpdate(contact);
				    			  contactList=new ArrayList<Contact>();
								  contactList= new ContactEntityController().viewByCompId(CompanyEditController.company.getId());
				    		}else{//comp not exits
				    			contactList.add(contact);	
				    			companyProtocolInputControllerAdd.viewContact();
				    		}
				    		
				    	    	
				    	   
				    	}
				    	
				    }
				    if(companyProtocolEditController!=null){//company has direct relation with contact so we are saving company rather than taking it in list and save later
				    	
						if(CompanyEditController.company!=null){
							if(CompanyEditController.company.getId()!=null){
							contact.setCompany(CompanyEditController.company);
							new ContactEntityController().saveOrUpdate(contact);
							 contactList=new ArrayList<Contact>();
							 contactList= new ContactEntityController().viewByCompId(CompanyEditController.company.getId());
						}
						}
						if(contactFromEditProtocol!=null){
							//companyProtocolEditController.refreshContactFromProtocolEdit(selectedContectIndex,contact);
						}else{
						   companyProtocolEditController.viewContact();
						  
						 }
						contactList=new ArrayList<Contact>();
						
						
					}
				   */
				    
				    new FXFormCommonUtilities().closeForm( okButton );
					

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
		 
		 cancelButton.setOnAction((event) -> {
				try {
				
					new FXFormCommonUtilities().closeForm( cancelButton );
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
				
	}
   
}
