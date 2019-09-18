package com.ets.controller.gui.company;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 23-06-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CompanyEditController Class
 *Description: GUI Controller class
 *Copyright 2017 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2017 @Eclipse Technoconsulting Global Pvt. Ltd.

*/

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
import com.ets.controller.entity.carrier.CarrierEntityController;
import com.ets.controller.entity.company.CompanyEntityController;
import com.ets.controller.entity.companyOptionalProtocolActivity.CompanyOptionalProtocolActivityEntityController;
import com.ets.controller.entity.companyProtocol.CompanyProtocolEntityController;
import com.ets.controller.entity.companyStandardProtocolActivity.CompanyStandardProtocolActivityEntityController;
import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.controller.entity.laboratory.LaboratoryEntityController;
import com.ets.controller.entity.naicsCode.NaicsCodeEntityController;
import com.ets.controller.entity.sicCode.SicCodeEntityController;
import com.ets.controller.entity.tpa.TpaEntityController;
import com.ets.controller.gui.Laboratories.LaboratoryViewController;
import com.ets.controller.gui.billingAccounts.BillingAccountInputController;
import com.ets.controller.gui.billingAccounts.BillingAccountViewController;
import com.ets.controller.gui.carriers.CarrierViewController;
import com.ets.controller.gui.companyProtocol.CompanyOptionalProtocolActivityInputController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolInputController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolViewController;
import com.ets.controller.gui.companyProtocol.CompanyStandardProtocolActivityInputController;
import com.ets.controller.gui.contact.ContactInputController;
import com.ets.controller.gui.contact.ContactViewController;
import com.ets.controller.gui.mcoTpaBillPreview.McoTpaBillViewController;
import com.ets.controller.gui.naicsCode.NaicsCodeViewController;
import com.ets.controller.gui.sicCode.SicCodeViewController;
import com.ets.model.Address;
import com.ets.model.BillingAccount;
import com.ets.model.Carrier;
import com.ets.model.Company;
import com.ets.model.CompanyOptionalProtocolActivity;
import com.ets.model.CompanyProtocol;
import com.ets.model.CompanyStandardProtocolActivity;
import com.ets.model.Contact;
import com.ets.model.Laboratory;
import com.ets.model.NAICSCode;
import com.ets.model.SICCode;
import com.ets.model.Tpa;
import com.ets.utils.DateConvert;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import net.sf.jasperreports.engine.util.ValuePropertiesWrapperComparator;

public class CompanyEditController implements Initializable {
	
	@FXML
    private TextField companyId;

    @FXML
    private TextField empServsBillAC;

    @FXML
    private Button billingAccount;

    @FXML
    private TextField companyName;

    @FXML
    private TextField localAddress;

    @FXML
    private TextField city;

    @FXML
    private TextField state;

    @FXML
    private TextField zip;

    @FXML
    private TextField county;

    @FXML
    private TextField telephone;

    @FXML
    private TextField ext;

    @FXML
    private TextField fax;

    @FXML
    private TextField email;

    @FXML
    private TextField secureFax;

    @FXML
    private TextField mainContact;

    @FXML
    private Button mainContactButtonEdit;

    @FXML
    private TextField aliasName;

    @FXML
    private ChoiceBox<String> countryChoiceBox;

    @FXML
    private TextField carrierTextField;

    @FXML
    private Button carrierButton;

    @FXML
    private TextField carrierPolicyno;

    @FXML
    private DatePicker CarrierExpireDate;

    @FXML
    private DatePicker carrierEffectiveDate;

    @FXML
    private TextField carrierContactNameText;

    @FXML
    private Button contactNameBtn;

    @FXML
    private TextField tpaTextField;

    @FXML
    private Button tpaButton;

    @FXML
    private DatePicker tpaExpireDate;

    @FXML
    private TextField tpaPolicyno;

    @FXML
    private DatePicker tpaEffectiveDate;

    @FXML
    private TextField laboratoryText;

    @FXML
    private TextField clinicalPolicyText;

    @FXML
    private ChoiceBox<String> clinicalLaboratoryContactLevelChoiceBox;

    @FXML
    private DatePicker clinicalLaboratoryExpireDate;

    @FXML
    private Button laboratoryBtn;

    @FXML
    private DatePicker clinicalLaboratoryEffectiveDate;

    @FXML
    private TextField ClinicalContactTpaText;

    @FXML
    private TextField ClinicalContactTpaPolicyNumberText;

    @FXML
    private DatePicker ClinicalContactTpaExpireDate;

    @FXML
    private Button clinicalTpaBtn;

    @FXML
    private DatePicker ClinicalContactTpaEffectiveDate;

    @FXML
    private ChoiceBox<String> clinicalTpaContactLevelChoiceBox;

    @FXML
    private Button CompanyContactsBtnEdit;

    @FXML
    private Button compantProtocolBtn;

    @FXML
    private Button updateBtn;

    @FXML
    private Button cancelBtn;

	    
	    
	    private CompanyViewController companyViewController;
	    	    
	    public void setCompanyViewController(CompanyViewController companyViewController) {
			this.companyViewController = companyViewController;
			
		}

		public static Company company = new Company();
	    
		public void setCompany(Company company) {
			this.company = company;
						
			city.setText(company.addressProperty().getValue().getCity());
			state.setText(company.addressProperty().getValue().getState());
			zip.setText(company.addressProperty().getValue().getZip());
			countryChoiceBox.setValue(company.addressProperty().getValue().getCountry());
			county.setText(company.addressProperty().getValue().getCounty());
			telephone.setText(company.addressProperty().getValue().getPhone());
			ext.setText(company.addressProperty().getValue().getExt());
			fax.setText(company.addressProperty().getValue().getFax());
			email.setText(company.addressProperty().getValue().getEmail());
			secureFax.setText(company.addressProperty().getValue().getSecureFax());
			companyId.setText(company.getCode());
			carrierPolicyno.setText(company.getPolicyNo());
			localAddress.setText(company.getAddress().getLocalAddress());
			clinicalPolicyText.setText(company.getLaboratoryContact());
			clinicalTpaContactLevelChoiceBox.setValue(company.getClinicalContactLevel());
			clinicalLaboratoryContactLevelChoiceBox.setValue(company.getLaboratoryContactLevel());
			mainContact.setText(company.getMainContact());
			if(company.getLaboratory() != null){
				
				laboratoryText.setText(company.getLaboratory().getCode());
				
			}
			if(company.getTpa() != null){
				
				ClinicalContactTpaText.setText(company.getTpa().getCode());
				tpaTextField.setText(company.getTpa().getCode());
			}
			
			if(company.getCarrier() != null){
				
				carrierTextField.setText(company.getCarrier().getCode());	
			}
			
			
			
			//carrierContactNameText.setText(company.getCarrier().getCode());
			
            Date dateClinicalTpa = company.getClinicalTpaEffectiveDate();
            
			if(dateClinicalTpa != null){
				LocalDate localDate2 = new DateConvert().dateToLocalDate(dateClinicalTpa);
				ClinicalContactTpaEffectiveDate.setValue(localDate2);
			
			}
			
             Date datelabEffect = company.getLaboratoryEffectiveDate();
			
			
			if(datelabEffect != null){
				LocalDate localDate2 = new DateConvert().dateToLocalDate(datelabEffect);
				clinicalLaboratoryEffectiveDate.setValue(localDate2);
			
			}
            Date datelabExp = company.getLaboratoryExpiryDate();
			
			
			if(datelabExp != null){
				LocalDate localDate2 = new DateConvert().dateToLocalDate(datelabExp);
			clinicalLaboratoryExpireDate.setValue(localDate2);
			
			}
			//ClinicalContactTpaPolicyNumberText.setText(company.set);
			
			Date date2 = company.getPolicyEffectiveDate();
			
			
			if(date2 != null){
				
				 LocalDate localDate2 = new DateConvert().dateToLocalDate(date2);
									
				 carrierEffectiveDate.setValue(localDate2);
				
			}
			
			companyName.setText(company.getName());
			/*if(company.getSelfInsured() == true){
				
				selfInsuredCheckBox.setSelected(true);
			}*/
			
			Date date1 = company.getPolicyExpiryDate();
			
			if(date1 != null){
				
				 LocalDate localDate1 = new DateConvert().dateToLocalDate(date1);
									
				 CarrierExpireDate.setValue(localDate1);
				
			}
			
			Date date = company.getPolicyEffectiveDate();
			
			if(date != null){
				
				 LocalDate localDate2 = new DateConvert().dateToLocalDate(date);
									
				 carrierEffectiveDate.setValue(localDate2);
				
			}
									
			tpaPolicyno.setText(company.getTpaPolicyNo());
			
			Date date3 = company.getTpaEffectiveDate();
			if(date3 != null){
				
				 LocalDate localDate3 = new DateConvert().dateToLocalDate(date3);
									
				 tpaEffectiveDate.setValue(localDate3);
				
			}
			
			Date date4 = company.getTpaExpiryDate();
			if(date4 != null){
				
				 LocalDate localDate4 = new DateConvert().dateToLocalDate(date4);
									
				 tpaExpireDate.setValue(localDate4);
				
			}
			
			/*if(company.getContact() != null){
				
				mainContact.setText(Integer.toString(company.contactProperty().getValue().getId()));
			}*/
			
			if(company.getBillingAccount() != null){
				
				empServsBillAC.setText(company.billingAccountProperty().getValue().getCode());
			}
			
			if(company.getCarrier() != null){
				
				carrierTextField.setText(company.carrierProperty().getValue().getCode());
				
			}
			
			if(company.getTpa() != null){
				
				tpaTextField.setText(company.tpaProperty().getValue().getCode());
				
			}
			/*if(.getSicCode() != null){
				
				sicCodeText.setText(company.sicCodeProperty().getValue().getCode());
				
			}
			
			if(company.getNaicsCode() != null){
				
				naicsCodeText.setText(company.naicsCodeProperty().getValue().getCode());
				
			}*/
			
			
			/*if(company.getInactive() == true){
				
				inactiveCheckBox.setSelected(true);
			}*/
			
			aliasName.setText(company.getAliasName());
						
			
			
		}
		
		public void setContact(Contact contact){
			
			mainContact.setText(contact.getFullName());
			
		}
		
		public void setbillingAccount(String code){
			
			empServsBillAC.setText(code);
		}
		
		public void setTpa(String code){
			
			tpaTextField.setText(code);
		}
		
		public void setCarrier(String code){
			
			carrierTextField.setText(code);
		}
		
		

		FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<String> list2 = new ArrayList<String>();

		list2.add("USA");
		list2.add("Canada");
		list2.add("Mexico");
		
       
		ObservableList countrylList = FXCollections.observableList(list2);
		countryChoiceBox.getItems().clear();
		countryChoiceBox.setItems(countrylList);
		
		
		List<String> list1 = new ArrayList<String>();

		list1.add("None");
		list1.add("Lab Level");
		list1.add("Company Level");
		list1.add("Employer Level");

		ObservableList contractLevelList = FXCollections.observableList(list1);
		clinicalLaboratoryContactLevelChoiceBox.getItems().clear();
		clinicalLaboratoryContactLevelChoiceBox.setItems(contractLevelList);
		
		clinicalTpaContactLevelChoiceBox.getItems().clear();
		clinicalTpaContactLevelChoiceBox.setItems(contractLevelList);
		
		
		updateBtn.setOnAction((event) -> {
			

			Address address = new Address();
			
			address.setlocalAddress(localAddress.getText());
			address.setCity(city.getText());
			address.setState(state.getText());
			address.setZip(zip.getText());
			address.setCountry(countryChoiceBox.getSelectionModel().getSelectedItem());
			address.setCounty(county.getText());
			address.setPhone(telephone.getText());
			address.setExt(ext.getText());
			address.setFax(fax.getText());
			address.setEmail(email.getText());
			address.setSecureFax(secureFax.getText());
			
			new AddressEntityController().add(address);
			
			//Company company = new Company();
			
			company.setCode(companyId.getText());
			company.setName(this.companyName.getText());
			company.setAliasName(this.aliasName.getText());
			company.setAddress(address);
			
			if(empServsBillAC.getText().length() > 0){
				
				//BillingAccount billingAccount = new BillingAccountEntityController().viewByCode(empServsBillAC.getText());
				company.setBillingAccount(BillingAccountInputController.billingAccount2);
				
			}

			if(mainContact.getText()!=null?mainContact.getText().length() > 0:false){
				
				company.setMainContact(mainContact.getText());
				
				
				
				/*Contact contact = new ContactEntityController().viewById(Integer.parseInt(mainContact.getText()));
				company.setContact(contact);
				*/
			}
			
			
			
			if(carrierTextField.getText().isEmpty()){
				
				System.out.println("Carrier is Empty");
				
			}else{
				Carrier carrier = new CarrierEntityController().viewByCode(carrierTextField.getText());
				company.setCarrier(carrier);
			}
			
			company.setPolicyNo(this.carrierPolicyno.getText());
			
			//carrierContactNameText
			
			LocalDate localDate1 = CarrierExpireDate.getValue();
			
			if(localDate1 != null){
			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
									
			company.setPolicyExpiryDate(date1);
			}
			
			
			LocalDate localDate2 = carrierEffectiveDate.getValue();
			
			if(localDate2 != null){
			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
			company.setPolicyEffectiveDate(date2);
			}
		     
			//company.setSelfInsured(selfInsuredCheckBox.isSelected());
			
			
			if(tpaTextField.getText().length() > 0){
				
				Tpa tpa = new TpaEntityController().viewByCode(tpaTextField.getText());
				company.setTpa(tpa);
				
			}
			
			company.setTpaPolicyNo(tpaPolicyno.getText());
			
			LocalDate localDate3 = tpaExpireDate.getValue();
			if(localDate3 != null){
				Date date3 = Date.from(localDate3.atStartOfDay(ZoneId.systemDefault()).toInstant());
				company.setTpaExpiryDate(date3);
			}
			
							
			LocalDate localDate4=tpaEffectiveDate.getValue();
			if(localDate4 != null){
			Date date4=Date.from(localDate4.atStartOfDay(ZoneId.systemDefault()).toInstant());
			company.setTpaEffectiveDate(date4);
			}
			
		
			
			if(laboratoryText.getText().length() > 0){
				Laboratory laboratory = new LaboratoryEntityController().viewByCode(laboratoryText.getText());
				company.setLaboratory(laboratory);
			}
			
			company.setLaboratoryContact(clinicalPolicyText.getText());
			company.setLaboratoryContactLevel(clinicalLaboratoryContactLevelChoiceBox.getSelectionModel().getSelectedItem());
			
			LocalDate localDate5=clinicalLaboratoryEffectiveDate.getValue();
			if(localDate5 != null){
			Date date5=Date.from(localDate5.atStartOfDay(ZoneId.systemDefault()).toInstant());
			company.setLaboratoryEffectiveDate(date5);
			}
			
			LocalDate localDate6=clinicalLaboratoryExpireDate.getValue();
			if(localDate6 != null){
			Date date6=Date.from(localDate6.atStartOfDay(ZoneId.systemDefault()).toInstant());
			company.setLaboratoryExpiryDate(date6);
			}
			
			
			if(ClinicalContactTpaText.getText().length() > 0){
				
				Tpa clinicalTpa = new TpaEntityController().viewByCode(tpaTextField.getText());
				company.setClinicalTpa(clinicalTpa);
				
			}
			
			company.setClinicalTpaPolicyNo(clinicalPolicyText.getText());
			
			LocalDate localDate7=clinicalLaboratoryExpireDate.getValue();
			if(localDate7 != null){
			Date date7=Date.from(localDate7.atStartOfDay(ZoneId.systemDefault()).toInstant());
			company.setClinicalTpaExpiryDate(date7);
			}
			
			LocalDate localDate8 = ClinicalContactTpaEffectiveDate.getValue();
			if(localDate8 != null){
			Date date8=Date.from(localDate8.atStartOfDay(ZoneId.systemDefault()).toInstant());
			company.setClinicalTpaEffectiveDate(date8);
			}
											
			
			company.setClinicalContactLevel(clinicalTpaContactLevelChoiceBox.getSelectionModel().getSelectedItem());
			
			
			
			
			
			
			/*try{
			
			Integer integer = Integer.parseInt(mainContact.getText());
			
			if(integer.SIZE > 0){
				
				Contact contact = new ContactEntityController().viewById(Integer.parseInt(mainContact.getText()));
				company.setContact(contact);
				
			}
			
			}catch(NumberFormatException e){
				
				 System.out.println("not a number");
				
			}*/
			
			
			
			
			
			
			
			
			
			/*if(sicCodeText.getText().isEmpty()){
				
				System.out.println("SIC code is Empty");
				
			}else{
				
				SICCode sicCode = new SicCodeEntityController().viewByCode(sicCodeText.getText());
				company.setSicCode(sicCode);
				
			}*/
			
			/*if(naicsCodeText.getText().isEmpty()){
				
				System.out.println("NAICS code is Empty");
				
			}else{
				
				NAICSCode naicsCode = new NaicsCodeEntityController().viewByCode(naicsCodeText.getText());
				company.setNaicsCode(naicsCode);
				
			}*/
			
			//company.setInactive(inactiveCheckBox.isSelected());
			
			

			new CompanyEntityController().addCompany(company);
			
			Company companyObj = company;
			Contact contact = new Contact();
			contact.setCompany(company);
			
			for (Contact contact2 : ContactInputController.contactList) {
				
				contact2.setCompany(company);
				System.out.println("contact2 "+contact2.getCompany().getName() +"%%%%%%%"+contact2.getFirstName());
				new ContactEntityController().saveOrUpdate(contact2);
				
			}
			
			/*System.out.println("Company protocol Size is :--------" +CompanyProtocolInputController.companyProtocolList.size());
			System.out.println("sizes are "+CompanyProtocolInputController.companyProtocolListIndexing.size()
			+" "+CompanyProtocolViewController.listOfcompanyStandardProtocolActivityList.size()+
			" "+CompanyProtocolViewController.listOfCompanyOptionalProtocolActivityList.size());
		    int sizeOfAll = CompanyProtocolInputController.companyProtocolListIndexing.size();
			System.out.println("############## size "+sizeOfAll);
			for(int i=0;i<sizeOfAll;i++){
				
				CompanyProtocol	 companyProtocol1 = CompanyProtocolInputController.companyProtocolListIndexing.get(i);
				companyProtocol1.setCompany(companyObj);
				new CompanyProtocolEntityController().saveCompanyProtocol(companyProtocol1);
				
					List<CompanyStandardProtocolActivity> companyStdProtocolList  = CompanyProtocolViewController.listOfcompanyStandardProtocolActivityList.get(i);
					for (CompanyStandardProtocolActivity stdProto : companyStdProtocolList) {
						stdProto.setCompanyProtocol(companyProtocol1);
						
						new CompanyStandardProtocolActivityEntityController().saveCompanyStandardProtocolActivity(stdProto);
					}
				
					List<CompanyOptionalProtocolActivity> companyOptProtocolList  = CompanyProtocolViewController.listOfCompanyOptionalProtocolActivityList.get(i);
					for (CompanyOptionalProtocolActivity optProto : companyOptProtocolList) {
						optProto.setCompanyProtocol(companyProtocol1);
						
						new CompanyOptionalProtocolActivityEntityController().saveCompanyOptionalProtocolActivity(optProto);
					}
			}*/
			
			
			/*CompanyProtocol companyProtocol = new CompanyProtocol();
			for(CompanyProtocol companyProtocol1 : CompanyProtocolInputController.companyProtocolList){
				
				companyProtocol.setAboveAmount(companyProtocol1.getAboveAmount());
				companyProtocol.setCity(companyProtocol1.getCity());
				companyProtocol.setCompany(company);
				companyProtocol.setDepartmentUnit(companyProtocol1.getDepartmentUnit());
				companyProtocol.setDescription(companyProtocol1.getDescription());
				companyProtocol.setEmailResult(companyProtocol1.getEmailResult());
				companyProtocol.setFaxResult(companyProtocol1.getFaxResult());
				//companyProtocol.setId(id);
				companyProtocol.setInstruction(companyProtocol1.getInstruction());
				companyProtocol.setJobClass(companyProtocol1.getJobClass());
				companyProtocol.setMailAddress(companyProtocol1.getMailAddress());
				companyProtocol.setNameOrDepartment(companyProtocol1.getNameOrDepartment());
				
				companyProtocol.setOverrideminute(companyProtocol1.getOverrideminute());
				companyProtocol.setPhone(companyProtocol1.getPhone());
				companyProtocol.setPhoneNumber(companyProtocol1.getPhoneNumber());
				companyProtocol.setProtocolType(companyProtocol1.getProtocolType());
				companyProtocol.setPtOt(companyProtocol1.getPtOt());
				companyProtocol.setReferrals(companyProtocol1.getReferrals());
				companyProtocol.setReportResult(companyProtocol1.getReportResult());
				companyProtocol.setState(companyProtocol1.getState());
				companyProtocol.setUserFormName(companyProtocol1.getUserFormName());
				companyProtocol.setVisitCategory(companyProtocol1.getVisitCategory());
				companyProtocol.setZip(companyProtocol1.getZip());
				
				new CompanyProtocolEntityController().saveCompanyProtocol(companyProtocol);
			}
			
			for(CompanyStandardProtocolActivity companyStandardProtocolActivity : CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList){
				
				companyStandardProtocolActivity.setCompanyProtocol(companyProtocol);
				
				new CompanyStandardProtocolActivityEntityController().saveCompanyStandardProtocolActivity(companyStandardProtocolActivity);
			}
			
			for(CompanyOptionalProtocolActivity companyOptionalProtocolActivity : CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList){
				
				companyOptionalProtocolActivity.setCompanyProtocol(companyProtocol);
				
				new CompanyOptionalProtocolActivityEntityController().saveCompanyOptionalProtocolActivity(companyOptionalProtocolActivity);
			}
			*/
			
			
		    companyViewController.refreshCompany();
		    
		   
			/*if(ContactInputController.contactList.size() > 0){
				ContactInputController.contactList = new ArrayList<Contact>();
			}
			*/
			if(CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList.size() > 0){
				CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList = new ArrayList<CompanyStandardProtocolActivity>();
			}
			
			if(CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList.size() > 0){
				CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList = new ArrayList<CompanyOptionalProtocolActivity>();
			}
			CompanyProtocolInputController.companyProtocolList=new ArrayList<CompanyProtocol>();
			CompanyProtocolViewController.listOfcompanyStandardProtocolActivityList = new ArrayList<List<CompanyStandardProtocolActivity>>();	
			CompanyProtocolViewController.listOfCompanyOptionalProtocolActivityList = new ArrayList<List<CompanyOptionalProtocolActivity>>();	
			CompanyProtocolInputController.companyProtocolListIndexing=new ArrayList<CompanyProtocol>(); 
			ContactInputController.contactList = new ArrayList<Contact>();
			company =new Company();
			new FXFormCommonUtilities().closeForm(updateBtn);
			

			
		});
		
		
		
		
		billingAccount.setOnAction((event) -> {
			try {
				BillingAccount billingAccount = new BillingAccount();
				Address address = new Address();
				address.setlocalAddress(localAddress.getText());
				address.setCity(city.getText());
				address.setState(state.getText());
				address.setZip(zip.getText());
				address.setCountry(countryChoiceBox.getSelectionModel().getSelectedItem());
				address.setPhone(telephone.getText());
				address.setFax(fax.getText());
				address.setEmail(email.getText());
				
				billingAccount.setAddress(address);
				billingAccount.setCode(companyId.getText());
				billingAccount.setName(companyName.getText());
				billingAccount.setMainContact(mainContact.getText());
				
				
				String formName = formPath.context.getMessage("AddBillingAccounts", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddBillingAccounts", null, Locale.US);
				formPath.closeApplicationContext();
				
				BillingAccountInputController billingAccountInputController = 
				  (BillingAccountInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				billingAccountInputController.setCompanyEditController(this, billingAccount);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		/*billingAccount.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("BillingAccounts", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.BillingAccounts", null, Locale.US);
				formPath.closeApplicationContext();
				
				BillingAccountViewController billingAccountViewController = 
				  (BillingAccountViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				billingAccountViewController.setCompanyEditController(this);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
		mainContactButtonEdit.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("ViewContact", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewContact", null, Locale.US);
				formPath.closeApplicationContext();
				ContactViewController contactViewController =
				 (ContactViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				contactViewController.setCompanyEditController(this,mainContactButtonEdit);
				System.out.println("company id ***"+company.getId());
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		CompanyContactsBtnEdit.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("ViewContact", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewContact", null, Locale.US);
				formPath.closeApplicationContext();
				ContactViewController contactViewController =
				 (ContactViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				contactViewController.setCompanyEditController(this,CompanyContactsBtnEdit);
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		carrierButton.setOnAction((event) -> {
			try {
				// Load Third Party Details Entry form .

				String formName = formPath.context.getMessage("Carrier", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Carrier", null, Locale.US);
				formPath.closeApplicationContext();
				CarrierViewController carrierViewController =
				(CarrierViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				carrierViewController.setCompanyEditController(this);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		tpaButton.setOnAction((event) -> {
			try {
				

				String formName = formPath.context.getMessage("MCOOrTPA", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MCOOrTPA", null, Locale.US);
				formPath.closeApplicationContext();
				McoTpaBillViewController tpaBillViewController = 
				(McoTpaBillViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				tpaBillViewController.setCompanyEditController(this, tpaButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		clinicalTpaBtn.setOnAction((event) -> {
			try {
				

				String formName = formPath.context.getMessage("MCOOrTPA", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MCOOrTPA", null, Locale.US);
				formPath.closeApplicationContext();
				McoTpaBillViewController tpaBillViewController = 
				(McoTpaBillViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				tpaBillViewController.setCompanyEditController(this, clinicalTpaBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		laboratoryBtn.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("Laboratory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Laboratory", null, Locale.US);
				formPath.closeApplicationContext();
				
				LaboratoryViewController laboratoryViewController =
				(LaboratoryViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				
				laboratoryViewController.setCompanyEditController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		compantProtocolBtn.setOnAction((event) -> {
			
			try {
				
				String formName = formPath.context.getMessage("ViewProtocol", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewProtocol", null, Locale.US);
				formPath.closeApplicationContext();
				
				CompanyProtocolViewController companyProtocolViewController =
				(CompanyProtocolViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				//companyProtocolViewController.setCompanyInputController(this, company);
				companyProtocolViewController.setCompanyEditController(this,company,compantProtocolBtn);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		/*sicButton.setOnAction((event) -> {
			try {
				// Load SIC Code Details Form .

				String formName = formPath.context.getMessage("SICCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SICCode", null, Locale.US);
				formPath.closeApplicationContext();
				SicCodeViewController sicCodeViewController = (SicCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				sicCodeViewController.setCompanyEditController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		naicsButton.setOnAction((event) -> {
			try {
				// Load NAICS Code Details form .

				String formName = formPath.context.getMessage("NAICSCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NAICSCode", null, Locale.US);
				formPath.closeApplicationContext();
				NaicsCodeViewController naicsCodeViewController = (NaicsCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				naicsCodeViewController.setCompanyEditController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
		// Centralised Form cancel
				cancelBtn.setOnAction((event) -> {
					try {
						CompanyProtocolInputController.companyProtocolList=new ArrayList<CompanyProtocol>();
						CompanyProtocolInputController.companyProtocolListIndexing=new ArrayList<CompanyProtocol>();
						company =new Company();
						CompanyProtocolViewController.listOfcompanyStandardProtocolActivityList = new ArrayList<List<CompanyStandardProtocolActivity>>();	
						CompanyProtocolViewController.listOfCompanyOptionalProtocolActivityList = new ArrayList<List<CompanyOptionalProtocolActivity>>();	
						ContactInputController.contactList = new ArrayList<Contact>();
						new FXFormCommonUtilities().closeForm(cancelBtn);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
	}

}
