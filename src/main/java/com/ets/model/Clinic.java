package com.ets.model;

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
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 17-05-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Clinic Class
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

@Entity
@Table(name = "clinic")

public class Clinic {

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
	
	private List<ClinicSchedule> clinicSchedule;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="clinic")
	public List<ClinicSchedule> getClinicSchedule() {
		return clinicSchedule;
	}

	public void setClinicSchedule(List<ClinicSchedule> clinicSchedule) {
		this.clinicSchedule = clinicSchedule;
	}

	private List<Clinician> clinician;
	
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="homeClinic")
	public List<Clinician> getClinician() {
		return clinician;
	}

	public void setClinician(List<Clinician> clinician) {
		this.clinician = clinician;
	}



	private StringProperty code = new SimpleStringProperty(this, "code");

	
	
	
	
	
	
	
	
	private SimpleObjectProperty<PatientName> patientName= new SimpleObjectProperty<PatientName>(this, "patientName");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_name")
	public PatientName getPatientName() {
		return patientName.get();
	}

	public void setPatientName(PatientName patientName) {
		this.patientName.set(patientName);
	}

	public SimpleObjectProperty<PatientName> patientNameProperty() {
		return patientName;
	}
	
	
	
	
	
	
	
	
	
	
	
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

	private StringProperty primaryServiceType = new SimpleStringProperty(this, "primaryServiceType");

	@Column(name = "primary_service_type")
	public String getPrimaryServiceType() {
		return primaryServiceType.get();
	}

	public void setPrimaryServiceType(String primaryServiceType) {
		this.primaryServiceType.set(primaryServiceType);
	}

	public StringProperty primaryServiceTypeProperty() {
		return primaryServiceType;
	}

	private SimpleObjectProperty<Address> address = new SimpleObjectProperty<Address>(this, "address");

	@OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
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
	
	private SimpleObjectProperty<Contact> contact = new SimpleObjectProperty<Contact>(this, "contact");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contact_id")
	public Contact getContact() {
		return contact.get();
	}

	public void setContact(Contact contact) {
		this.contact.set(contact);
	}

	public SimpleObjectProperty<Contact> contactProperty() {
		return contact;
	}
	
	
	private List<InventoryOutGo> inventoryOutGo;
	

	@OneToMany(cascade=CascadeType.ALL,mappedBy="clinic",fetch=FetchType.LAZY)
	public List<InventoryOutGo> getInventoryOutGo() {
		return inventoryOutGo;
	}

	public void setInventoryOutGo(List<InventoryOutGo> inventoryOutGo) {
		this.inventoryOutGo = inventoryOutGo;
	}



	private StringProperty federalTaxIdNo = new SimpleStringProperty(this, "federalTaxIdNo");

	@Column(name = "federal_tax_id_no")
	public String getFederalTaxIdNo() {
		return federalTaxIdNo.get();
	}

	public void setFederalTaxIdNo(String federalTaxIdNo) {
		this.federalTaxIdNo.set(federalTaxIdNo);
	}

	public StringProperty federalTaxIdNoProperty() {
		return federalTaxIdNo;
	}
	
	/*// Column 5
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

		// Column 6
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

		// Column 7
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

	private StringProperty medicareIdNo = new SimpleStringProperty(this, "medicareIdNo");

	@Column(name = "medicare_id_no")
	public String getMedicareIdNo() {
		return medicareIdNo.get();
	}

	public void setMedicareIdNo(String medicareIdNo) {
		this.medicareIdNo.set(medicareIdNo);
	}

	public StringProperty medicareIdNoProperty() {
		return medicareIdNo;
	}

	private StringProperty npiNo = new SimpleStringProperty(this, "npiNo");

	@Column(name = "npi_no")
	public String getNpiNo() {
		return npiNo.get();
	}

	public void setNpiNo(String npiNo) {
		this.npiNo.set(npiNo);
	}

	public StringProperty npiNoProperty() {
		return npiNo;
	}

	private StringProperty cliaNo = new SimpleStringProperty(this, "cliaNo");

	@Column(name = "clia_no")
	public String getCliaNo() {
		return cliaNo.get();
	}

	public void setCliaNo(String cliaNo) {
		this.cliaNo.set(cliaNo);
	}

	public StringProperty cliaNoProperty() {
		return cliaNo;
	}

	private SimpleBooleanProperty inactive = new SimpleBooleanProperty(this, "inactive");

	@Column(name = "inactive")
	public boolean getInactive() {
		return inactive.get();
	}

	public void setInactive(boolean inactive) {
		this.inactive.set(inactive);
	}

	public BooleanProperty inactiveProperty() {
		return inactive;
	}
	
	private List<UserAccount> userAccounts;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="clinic" , cascade=CascadeType.ALL)
	public List<UserAccount> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(List<UserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}

	public Clinic() {

	}

}
