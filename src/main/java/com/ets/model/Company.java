package com.ets.model;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *Original Author:Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 06-07-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Company Class
 *Description: Entity class
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

// New Code for hibernate persistence using Javafx Properties added on 22-01-2016 @Author Indronil Chaudhuri
// Property accessor technique

@Entity
@Table(name = "company")

public class Company {
	/***************
	 * Column property ( 1 )
	 *****************************************/

	private IntegerProperty id = new SimpleIntegerProperty(this, "id");

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id.get();
	}

	public void setId(Integer id) {
		this.id.set(id);
	}

	public IntegerProperty idProperty() {
		return this.id;
	}

	/***************
	 * Column property ( 2 )
	 *****************************************/

	private SimpleObjectProperty<Address> address = new SimpleObjectProperty<Address>(this, "address");

	@OneToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST , CascadeType.REFRESH , CascadeType.DETACH , CascadeType.REMOVE})
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return address.get();
	}

	public void setAddress(Address address) {
		this.address.set(address);
	}

	public SimpleObjectProperty<Address> addressProperty() {
		return address;
	}

	/***************
	 * Column property ( 3 )
	 *****************************************/
	private StringProperty aliasName = new SimpleStringProperty(this, "aliasName");

	@Column(name = "alias_name")
	public String getAliasName() {
		return aliasName.get();
	}

	public void setAliasName(String aliasName) {
		this.aliasName.set(aliasName);
	}

	public StringProperty aliasNameProperty() {
		return aliasName;
	}

	/***************
	 * Column property ( 4 )
	 *****************************************/

	private StringProperty name = new SimpleStringProperty(this, "name");

	@Column(name = "name")
	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public StringProperty nameProperty() {
		return name;
	}

	// Collumn 5

	private StringProperty code = new SimpleStringProperty(this, "code");

	@Column(name = "code")
	public String getCode() {
		return code.get();
	}

	public void setCode(String code) {
		this.code.set(code);
	}

	public StringProperty codeProperty() {
		return code;
	}
	
	
	private StringProperty mainContact = new SimpleStringProperty(this, "mainContact");

	@Column(name = "mainContact")
	public String getMainContact() {
		return mainContact.get();
	}

	public void setMainContact(String mainContact) {
		this.mainContact.set(mainContact);
	}

	public StringProperty mainContactProperty() {
		return mainContact;
	}
	
	
	
	
	private SimpleObjectProperty<BillingAccount> billingAccount = new SimpleObjectProperty<BillingAccount>(this, "billingAccount");

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "billing_ac_id")
	public BillingAccount getBillingAccount() {
		return billingAccount.get();
	}

	public void setBillingAccount(BillingAccount billingAccount) {
		this.billingAccount.set(billingAccount);
	}

	public SimpleObjectProperty<BillingAccount> billingAccountProperty() {
		return billingAccount;
	}
	
	/*private SimpleObjectProperty<Contact> contact = new SimpleObjectProperty<Contact>(this, "contact");

	@ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST , CascadeType.REFRESH , CascadeType.DETACH , CascadeType.REMOVE})
	@JoinColumn(name = "contact_id")
	public Contact getContact() {
		return contact.get();
	}

	public void setContact(Contact contact) {
		this.contact.set(contact);
	}

	public SimpleObjectProperty<Contact> contactProperty() {
		return contact;
	}*/
	
	
	private SimpleObjectProperty<Carrier> carrier = new SimpleObjectProperty<Carrier>(this, "carrier");

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "carrier_id")
	public Carrier getCarrier() {
		return carrier.get();
	}

	public void setCarrier(Carrier carrier) {
		this.carrier.set(carrier);
	}

	public SimpleObjectProperty<Carrier> carrierProperty() {
		return carrier;
	}
	
	private StringProperty policyNo = new SimpleStringProperty(this, "policyNo");

	@Column(name = "policy_no")
	public String getPolicyNo() {
		return policyNo.get();
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo.set(policyNo);
	}

	public StringProperty policyNoProperty() {
		return policyNo;
	}
	
	private ObjectProperty<Date> policyEffectiveDate = new SimpleObjectProperty<Date>();

	@Column(name = "policy_effective_date")
	@Temporal(TemporalType.DATE)
	public Date getPolicyEffectiveDate() {
		
		return policyEffectiveDate.get();
		
	}

	public void setPolicyEffectiveDate(Date policyEffectiveDate) {
		
		this.policyEffectiveDate.set(policyEffectiveDate);
		
	}

	public ObjectProperty<Date> policyEffectiveDateProperty() {
		
		return this.policyEffectiveDate;
		
	}
	
	private ObjectProperty<Date> policyExpiryDate = new SimpleObjectProperty<Date>();

	@Column(name = "policy_expiry_date")
	@Temporal(TemporalType.DATE)
	public Date getPolicyExpiryDate() {
		return policyExpiryDate.get();
	}

	public void setPolicyExpiryDate(Date policyExpiryDate) {
		this.policyExpiryDate.set(policyExpiryDate);
	}

	public ObjectProperty<Date> policyExpiryDateProperty() {
		return this.policyExpiryDate;
	}
	
	private SimpleObjectProperty<Tpa> tpa = new SimpleObjectProperty<Tpa>(this, "tpa");

	@ManyToOne(fetch=FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinColumn(name = "tpa_id")
	public Tpa getTpa() {
		return tpa.get();
	}

	public void setTpa(Tpa tpa) {
		this.tpa.set(tpa);
	}

	public SimpleObjectProperty<Tpa> tpaProperty() {
		return tpa;
	}
	
	private StringProperty tpaPolicyNo = new SimpleStringProperty(this, "tpaPolicyNo");

	@Column(name = "tpa_policy_no")
	public String getTpaPolicyNo() {
		return tpaPolicyNo.get();
	}

	public void setTpaPolicyNo(String tpaPolicyNo) {
		this.tpaPolicyNo.set(tpaPolicyNo);
	}

	public StringProperty tpaPolicyNoProperty() {
		return tpaPolicyNo;
	}
	
	private ObjectProperty<Date> tpaEffectiveDate = new SimpleObjectProperty<Date>();

	@Column(name = "tpa_effective_date")
	@Temporal(TemporalType.DATE)
	public Date getTpaEffectiveDate() {
		
		return tpaEffectiveDate.get();
		
	}

	public void setTpaEffectiveDate(Date tpaEffectiveDate) {
		
		this.tpaEffectiveDate.set(tpaEffectiveDate);
		
	}

	public ObjectProperty<Date> tpaEffectiveDateProperty() {
		
		return this.tpaEffectiveDate;
		
	}
	
	private ObjectProperty<Date> tpaExpiryDate = new SimpleObjectProperty<Date>();

	@Column(name = "tpa_expiry_date")
	@Temporal(TemporalType.DATE)
	public Date getTpaExpiryDate() {
		return tpaExpiryDate.get();
	}

	public void setTpaExpiryDate(Date tpaExpiryDate) {
		this.tpaExpiryDate.set(tpaExpiryDate);
	}

	public ObjectProperty<Date> tpaExpiryDateProperty() {
		return this.tpaExpiryDate;
	}
	
	private SimpleObjectProperty<Laboratory> laboratory = new SimpleObjectProperty<Laboratory>(this, "laboratory");

	@ManyToOne( fetch=FetchType.LAZY ,cascade = CascadeType.ALL)
	@JoinColumn(name = "laboratory_id")
	public Laboratory getLaboratory() {
		return laboratory.get();
	}

	public void setLaboratory(Laboratory laboratory) {
		this.laboratory.set(laboratory);
	}

	public SimpleObjectProperty<Laboratory> laboratoryProperty() {
		return laboratory;
	}
	
	private StringProperty laboratoryContact = new SimpleStringProperty(this, "laboratoryContact");

	@Column(name = "laboratory_contact")
	public String getLaboratoryContact() {
		return laboratoryContact.get();
	}

	public void setLaboratoryContact(String laboratoryContact) {
		this.laboratoryContact.set(laboratoryContact);
	}

	public StringProperty laboratoryContactProperty() {
		return laboratoryContact;
	}
	
	private ObjectProperty<Date> laboratoryEffectiveDate = new SimpleObjectProperty<Date>();

	@Column(name = "laboratory_effective_date")
	@Temporal(TemporalType.DATE)
	public Date getLaboratoryEffectiveDate() {
		
		return laboratoryEffectiveDate.get();
		
	}

	public void setLaboratoryEffectiveDate(Date laboratoryEffectiveDate) {
		
		this.laboratoryEffectiveDate.set(laboratoryEffectiveDate);
		
	}

	public ObjectProperty<Date> laboratoryEffectiveDateProperty() {
		
		return this.laboratoryEffectiveDate;
		
	}
	
	private ObjectProperty<Date> laboratoryExpiryDate = new SimpleObjectProperty<Date>();

	@Column(name = "laboratory_expiry_date")
	@Temporal(TemporalType.DATE)
	public Date getLaboratoryExpiryDate() {
		return laboratoryExpiryDate.get();
	}

	public void setLaboratoryExpiryDate(Date laboratoryExpiryDate) {
		this.laboratoryExpiryDate.set(laboratoryExpiryDate);
	}

	public ObjectProperty<Date> laboratoryExpiryDateProperty() {
		return this.laboratoryExpiryDate;
	}
	
	private StringProperty laboratoryContactLevel = new SimpleStringProperty(this, "laboratoryContactLevel");

	@Column(name = "laboratory_contact_level")
	public String getLaboratoryContactLevel() {
		return laboratoryContactLevel.get();
	}

	public void setLaboratoryContactLevel(String laboratoryContactLevel) {
		this.laboratoryContactLevel.set(laboratoryContactLevel);
	}

	public StringProperty laboratoryContactLevelProperty() {
		return laboratoryContactLevel;
	}
	
	private SimpleObjectProperty<Tpa> clinicalTpa = new SimpleObjectProperty<Tpa>(this, "clinicalTpa");

	@ManyToOne(fetch=FetchType.LAZY ,cascade = CascadeType.MERGE)
	@JoinColumn(name = "clinical_tpa_id")
	public Tpa getClinicalTpa() {
		return clinicalTpa.get();
	}

	public void setClinicalTpa(Tpa clinicalTpa) {
		this.clinicalTpa.set(clinicalTpa);
	}

	public SimpleObjectProperty<Tpa> clinicalTpaProperty() {
		return clinicalTpa;
	}
	
	private StringProperty clinicalTpaPolicyNo = new SimpleStringProperty(this, "clinicalTpaPolicyNo");

	@Column(name = "clinical_tpa_policy_no")
	public String getClinicalTpaPolicyNo() {
		return clinicalTpaPolicyNo.get();
	}

	public void setClinicalTpaPolicyNo(String clinicalTpaPolicyNo) {
		this.clinicalTpaPolicyNo.set(clinicalTpaPolicyNo);
	}

	public StringProperty clinicalTpaPolicyNoProperty() {
		return clinicalTpaPolicyNo;
	}
	
	private ObjectProperty<Date> clinicalTpaEffectiveDate = new SimpleObjectProperty<Date>();

	@Column(name = "clinical_tpa_effective_date")
	@Temporal(TemporalType.DATE)
	public Date getClinicalTpaEffectiveDate() {
		
		return clinicalTpaEffectiveDate.get();
		
	}

	public void setClinicalTpaEffectiveDate(Date clinicalTpaEffectiveDate) {
		
		this.clinicalTpaEffectiveDate.set(clinicalTpaEffectiveDate);
		
	}

	public ObjectProperty<Date> clinicalTpaEffectiveDateProperty() {
		
		return this.clinicalTpaEffectiveDate;
		
	}
	
	private ObjectProperty<Date> clinicalTpaExpiryDate = new SimpleObjectProperty<Date>();

	@Column(name = "clinical_tpa_expiry_date")
	@Temporal(TemporalType.DATE)
	public Date getClinicalTpaExpiryDate() {
		return clinicalTpaExpiryDate.get();
	}

	public void setClinicalTpaExpiryDate(Date clinicalTpaExpiryDate) {
		this.clinicalTpaExpiryDate.set(clinicalTpaExpiryDate);
	}

	public ObjectProperty<Date> clinicalTpaExpiryDateProperty() {
		return this.clinicalTpaExpiryDate;
	}
	
	
	private StringProperty clinicalContactLevel = new SimpleStringProperty(this, "clinicalContactLevel");

	@Column(name = "clinical_contact_level")
	public String getClinicalContactLevel() {
		return clinicalContactLevel.get();
	}

	public void setClinicalContactLevel(String clinicalContactLevel) {
		this.clinicalContactLevel.set(clinicalContactLevel);
	}

	public StringProperty clinicalContactLevelProperty() {
		return clinicalContactLevel;
	}
	
	private List<CompanyProtocol> companyProtocol ;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="company" , cascade=CascadeType.ALL,orphanRemoval=true)
	public List<CompanyProtocol> getCompanyProtocol() {
		return companyProtocol;
	}

	public void setCompanyProtocol(List<CompanyProtocol> companyProtocol) {
		this.companyProtocol = companyProtocol;
	}

	
	private List<Contact> contact;
	@OneToMany(fetch = FetchType.LAZY , mappedBy="company" ,cascade=CascadeType.ALL,orphanRemoval=true)
	
	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}
	
	private List<Patient> patient;
	@OneToMany(fetch = FetchType.LAZY , mappedBy="company" , cascade=CascadeType.ALL)
	
	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	// Collumn 6

	/*private StringProperty employeeType = new SimpleStringProperty(this, "employeeType");

	@Column(name = "employee_type")
	public String getEmployeeType() {
		return employeeType.get();
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType.set(employeeType);
	}

	public StringProperty employeeTypeProperty() {
		return employeeType;
	}*/

	// Collumn 7

	

	

	// Column 14

	/*private StringProperty typeCode = new SimpleStringProperty(this, "typeCode");

	@Column(name = "type_code")
	public String getTypeCode() {
		return typeCode.get();
	}

	public void setTypeCode(String typeCode) {
		this.typeCode.set(typeCode);
	}

	public StringProperty typeCodeProperty() {
		return typeCode;
	}*/
	
	

	
	// Column 12
			/*private SimpleBooleanProperty selfInsured = new SimpleBooleanProperty(this, "selfInsured");

			@Column(name = "self_insured")
			public boolean getSelfInsured() {
				return selfInsured.get();
			}

			public void setSelfInsured(boolean selfInsured) {
				this.selfInsured.set(selfInsured);
			}

			public BooleanProperty selfInsuredProperty() {
				return selfInsured;
			}*/

	// Column 12
	/*private SimpleBooleanProperty inactive = new SimpleBooleanProperty(this, "inactive");

	@Column(name = "inactive")
	public boolean getInactive() {
		return inactive.get();
	}

	public void setInactive(boolean inactive) {
		this.inactive.set(inactive);
	}

	public BooleanProperty inactiveProperty() {
		return inactive;
	}*/

	/*
	 * ######################## End of Column Definitions
	 * ############################
	 */
	
	/*// Column 8
	private SimpleObjectProperty<Region> region = new SimpleObjectProperty<Region>(this, "region");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "region_id")
	public Region getRegion() {
		return region.get();
	}

	public void setRegion(Region region) {
		this.region.set(region);
	}

	public SimpleObjectProperty<Region> regionProperty() {
		return region;
	}

	// Column 9
	private SimpleObjectProperty<Complex> complex = new SimpleObjectProperty<Complex>(this, "complex");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "complex_id")
	public Complex getComplex() {
		return complex.get();
	}

	public void setComplex(Complex complex) {
		this.complex.set(complex);
	}

	public SimpleObjectProperty<Complex> complexProperty() {
		return complex;
	}

	// Column 10
	private SimpleObjectProperty<District> district = new SimpleObjectProperty<District>(this, "district");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "district_id")
	public District getDistrict() {
		return district.get();
	}

	public void setDistrict(District district) {
		this.district.set(district);
	}

	public SimpleObjectProperty<District> districtProperty() {
		return district;
	}
*/
	// Column 11

	/*private SimpleObjectProperty<SICCode> sicCode = new SimpleObjectProperty<SICCode>(this, "sicCode");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sic_code_id")
	public SICCode getSicCode() {
		return sicCode.get();
	}

	public void setSicCode(SICCode sicCode) {
		this.sicCode.set(sicCode);
	}

	public SimpleObjectProperty<SICCode> sicCodeProperty() {
		return sicCode;
	}*/

	// Column 12

	/*private SimpleObjectProperty<NAICSCode> naicsCode = new SimpleObjectProperty<NAICSCode>(this, "naicsCode");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "naics_code_id")
	public NAICSCode getNaicsCode() {
		return naicsCode.get();
	}

	public void setNaicsCode(NAICSCode naicsCode) {
		this.naicsCode.set(naicsCode);
	}

	public SimpleObjectProperty<NAICSCode> naicsCodeProperty() {
		return naicsCode;
	}*/

	// Column 13

	/*private StringProperty federalId = new SimpleStringProperty(this, "federalId");

	@Column(name = "federal_id")
	public String getFederalId() {
		return federalId.get();
	}

	public void setFederalId(String federalId) {
		this.federalId.set(federalId);
	}

	public StringProperty federalIdProperty() {
		return federalId;
	}*/

	public Company() {

	}

}