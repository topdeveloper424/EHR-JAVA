package com.ets.controller.gui.contact;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.controller.gui.company.CompanyEditController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolEditController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolInputController;
import com.ets.model.CompanyProtocol;
import com.ets.model.Contact;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ContactEditController implements Initializable {
	
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
	    private Button updateButton;

	    @FXML
	    private Button cancelButton;
	    private Integer index;
        private CompanyProtocolInputController companyProtocolInputController;
        private Integer selectedContectIndex;
        private Integer indexOfstaticContactList;
        private Contact contactFromInputCompProtocol;
		public void setCompanyProtocolInputController(CompanyProtocolInputController companyProtocolInputController,Contact contact,Integer selectedContectIndex,Integer indexOfstaticContactList) {
			this.companyProtocolInputController = companyProtocolInputController;
			this.selectedContectIndex=selectedContectIndex;
			this.indexOfstaticContactList=indexOfstaticContactList;
			this.contactFromInputCompProtocol=contact;
		    System.out.println("index  "+indexOfstaticContactList);
	        CountryDropDwn.setValue(contactFromInputCompProtocol.getCountry());
			ContactTpyeDrop.setValue(contactFromInputCompProtocol.getContactType());
			firstnameText.setText(contactFromInputCompProtocol.getFirstName());
			lastNameFx.setText(contactFromInputCompProtocol.getLastName());
			FullNameText.setText(contactFromInputCompProtocol.getFullName());
			TitleText.setText(contactFromInputCompProtocol.getTitle());
			DepartmentText.setText(contactFromInputCompProtocol.getDept());
			AddressText.setText(contactFromInputCompProtocol.getLocalAddress());
			CityText.setText(contactFromInputCompProtocol.getCity());
			StateText.setText(contactFromInputCompProtocol.getState());
			ZipText.setText(contactFromInputCompProtocol.getZip());
			PhoneText.setText(contactFromInputCompProtocol.getPhone());
			Ext.setText(contactFromInputCompProtocol.getExt());
			CellphoneText.setText(contactFromInputCompProtocol.getMobile());
			FaxText.setText(contactFromInputCompProtocol.getFax());
			Emailtext.setText(contactFromInputCompProtocol.getEmail());
		}
       private CompanyProtocolEditController companyProtocolEditController;
    
	   public void setCompanyProtocolEditController(CompanyProtocolEditController companyProtocolEditController,Contact contact,Integer selectedContectIndex,Integer indexOfstaticContactList) {
	 	this.companyProtocolEditController = companyProtocolEditController;
	 	
		this.selectedContectIndex=selectedContectIndex;
		this.indexOfstaticContactList=indexOfstaticContactList;
		this.contactFromInputCompProtocol=contact;
	    System.out.println("index  "+indexOfstaticContactList);
        CountryDropDwn.setValue(contactFromInputCompProtocol.getCountry());
		ContactTpyeDrop.setValue(contactFromInputCompProtocol.getContactType());
		firstnameText.setText(contactFromInputCompProtocol.getFirstName());
		lastNameFx.setText(contactFromInputCompProtocol.getLastName());
		FullNameText.setText(contactFromInputCompProtocol.getFullName());
		TitleText.setText(contactFromInputCompProtocol.getTitle());
		DepartmentText.setText(contactFromInputCompProtocol.getDept());
		AddressText.setText(contactFromInputCompProtocol.getLocalAddress());
		CityText.setText(contactFromInputCompProtocol.getCity());
		StateText.setText(contactFromInputCompProtocol.getState());
		ZipText.setText(contactFromInputCompProtocol.getZip());
		PhoneText.setText(contactFromInputCompProtocol.getPhone());
		Ext.setText(contactFromInputCompProtocol.getExt());
		CellphoneText.setText(contactFromInputCompProtocol.getMobile());
		FaxText.setText(contactFromInputCompProtocol.getFax());
		Emailtext.setText(contactFromInputCompProtocol.getEmail());
	   
	   
	   
	   }


		@FXML
	    void contactFullNameMouseClicked(MouseEvent event) {
	    	FullNameText.setText(firstnameText.getText() + " " + lastNameFx.getText());
	    }

	
	private ContactViewController contactViewController;
	
	public void setContactViewController(ContactViewController contactViewController,int index) {
		this.contactViewController = contactViewController;
		this.index = index;
	}

	private Contact contact1;
	
	public void setContact(Contact contact) {
		this.contact1 = contact;
					
			//CountryDropDwn.setValue(contact.addressProperty().getValue().getCountry());
			
			/*CityText.setText(contact.addressProperty().getValue().getCity());
			StateText.setText(contact.addressProperty().getValue().getState());
			ZipText.setText(contact.addressProperty().getValue().getZip());
			PhoneText.setText(contact.addressProperty().getValue().getPhone());
			Ext.setText(contact.addressProperty().getValue().getExt());
			
			FaxText.setText(contact.addressProperty().getValue().getFax());
			Emailtext.setText(contact.addressProperty().getValue().getEmail());
			
			
			memoTextArea.setText(contact.noteProperty().getValue().getDescrp());
			memoText.setText(contact.noteProperty().getValue().getName());
			*/
			
			
			firstnameText.setText(contact1.getFirstName());
			DepartmentText.setText(contact1.getDept());
			//EncryptionpwdText.setText(contact.getEncryptPswd());
			
			/*if(contact.getInactive() == true){
				
				inactiveCheckBox.setSelected(true);
				
			}*/
			
			lastNameFx.setText(contact1.getLastName());
			FullNameText.setText(contact1.getFullName());
			System.out.println("****"+contact1.getFullName());
			AddressText.setText(contact1.getLocalAddress());
			CityText.setText(contact1.getCity());
			StateText.setText(contact1.getState());
			ZipText.setText(contact1.getZip());
			PhoneText.setText(contact1.getPhone());
			Ext.setText(contact1.getExt());
			CellphoneText.setText(contact1.getMobile());
			FaxText.setText(contact1.getFax());
			Emailtext.setText(contact1.getEmail());
			TitleText.setText(contact1.getTitle());
			CountryDropDwn.setValue(contact1.getCountry());
			ContactTpyeDrop.setValue(contact1.getContactType());
			
		    		
	
	}


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
	
		updateButton.setOnAction((event) -> {
			try {
				
				
				
				Contact contact=new Contact();
				if(contact1!=null){
					contact = contact1;
				}if(contactFromInputCompProtocol!=null){
					contact=contactFromInputCompProtocol;
				}if(companyProtocolEditController!=null){
					contact=contactFromInputCompProtocol;
				}
				
				contact.setFirstName(firstnameText.getText());
				contact.setLastName(lastNameFx.getText());
				contact.setFullName(FullNameText.getText());
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
				
                    if(contactViewController!=null){
				    if(contactViewController.companyEditController!=null){
				    	contact.setId(contact1.getId());
				    	contact.setCompany(CompanyEditController.company);
				    	System.out.println("^^^^^^^^"+CompanyEditController.company);
					new ContactEntityController().saveOrUpdate(contact);
					contactViewController.viewContact();
				    }
			     }
				    if(companyProtocolInputController!=null){// edit from static list which is not saved yet
				    	if(companyProtocolInputController.companyProtocolViewController.companyInputController!=null){
						System.out.println("########## indexOfstaticContactList 1 "+indexOfstaticContactList+ContactInputController.contactList.size());
						ContactInputController.contactList.set(indexOfstaticContactList, contact);
						companyProtocolInputController.refreshContactFromProtocolEdit(selectedContectIndex,contact);
						System.out.println("########## indexOfstaticContactList  2 "+indexOfstaticContactList+ContactInputController.contactList.size());
				    	
				    	}else if(companyProtocolInputController.companyProtocolViewController.companyEditController!=null){
				    	  contact.setCompany(CompanyEditController.company);
				    	  new ContactEntityController().saveOrUpdate(contact);
				    	  companyProtocolInputController.refreshContactFromProtocolEdit(selectedContectIndex,contact);
				    }
				    
				    }
					if(companyProtocolEditController!=null){
						if(companyProtocolEditController.companyProtocolViewController!=null?companyProtocolEditController.companyProtocolViewController.companyInputController!=null:false){
							System.out.println("########## indexOfstaticContactList 1 "+indexOfstaticContactList+ContactInputController.contactList.size());
							ContactInputController.contactList.set(indexOfstaticContactList, contact);
							companyProtocolEditController.refreshContactFromProtocolEdit(selectedContectIndex,contact);
							System.out.println("########## indexOfstaticContactList  2 "+indexOfstaticContactList+ContactInputController.contactList.size());
					    	
					    	}else if(companyProtocolEditController.companyProtocolViewController!=null?companyProtocolEditController.companyProtocolViewController.companyEditController!=null:false){
					    	  contact.setCompany(CompanyEditController.company);
					    	  new ContactEntityController().saveOrUpdate(contact);
					    	  companyProtocolEditController.refreshContactFromProtocolEdit(selectedContectIndex,contact);
					    }else if(companyProtocolEditController.encounterFormInputController!=null){
							if(companyProtocolEditController.companyProtocolFromEncounter.getCompany()!=null){
							contact.setCompany(companyProtocolEditController.companyProtocolFromEncounter.getCompany());	
                            new ContactEntityController().saveOrUpdate(contact);
							
							companyProtocolEditController.viewContact();
							System.out.println("@@@@@@@@@@@@@@@@ saved11 ");
							}else if(Global.patient.getCompany()!=null){
								contact.setCompany(Global.patient.getCompany());
								new ContactEntityController().saveOrUpdate(contact);
								
								companyProtocolEditController.viewContact();
								System.out.println("@@@@@@@@@@@@@@@@ saved22 ");
							}
							
							}
					    	
					}
					
					new FXFormCommonUtilities().closeForm(updateButton);
					

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