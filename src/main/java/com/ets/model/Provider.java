package com.ets.model;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Provider Class
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "provider")

public class Provider {

	/***************
	 * Column property ( 1 )
	 *****************************************/

	private IntegerProperty id = new SimpleIntegerProperty(this, "id");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	// Column 2
		private StringProperty firstName = new SimpleStringProperty(this, "firstName");

		@Column(name = "first_name")
		public String getFirstName() {
			return firstName.get();
		}

		public void setFirstName(String firstName) {
			this.firstName.set(firstName);
		}

		public StringProperty firstNameProperty() {
			return firstName;
		}

		// Column 3
		private StringProperty middleName = new SimpleStringProperty(this, "middleName");

		@Column(name = "middle_name")
		public String getMiddleName() {
			return middleName.get();
		}

		public void setMiddleName(String middleName) {
			this.middleName.set(middleName);
		}

		public StringProperty middleNameProperty() {
			return middleName;
		}

		// Column 4
		private StringProperty lastName = new SimpleStringProperty(this, "lastName");

		@Column(name = "last_name")
		public String getLastName() {
			return lastName.get();
		}

		public void setLastName(String lastName) {
			this.lastName.set(lastName);
		}

		public StringProperty lastNameProperty() {
			return lastName;
		}
		
		// Column 5
			private StringProperty suffix = new SimpleStringProperty(this, "suffix");

			@Column(name = "suffix")
			public String getSuffix() {
				return suffix.get();
			}

			public void setSuffix(String suffix) {
				this.suffix.set(suffix);
			}

			public StringProperty suffixProperty() {
				return suffix;
			}

			private SimpleObjectProperty<Clinic> clinic = new SimpleObjectProperty<Clinic>(this, "clinic");

			@OneToOne(fetch = FetchType.EAGER)
			@JoinColumn(name = "clinic_id")
			public Clinic getClinic() {
				return clinic.get();
			}

			public void setClinic(Clinic clinic) {
				this.clinic.set(clinic);
			}

			public SimpleObjectProperty<Clinic> clinicProperty() {
				return clinic;
			}

	/***************
	 * Column property ( 4 )
	 *****************************************/

	private StringProperty npi = new SimpleStringProperty(this, "npi");

	@Column(name = "npi")
	public String getNpi() {
		return npi.get();
	}

	public void setNpi(String npi) {
		this.npi.set(npi);
	}

	public StringProperty npiProperty() {
		return npi;
	}

	/***************
	 * Column property ( 3 )
	 *****************************************/

	private StringProperty providerType = new SimpleStringProperty(this, "providerType");

	@Column(name = "provider_type")
	public String getProviderType() {
		return providerType.get();
	}

	public void setProviderType(String providerType) {
		this.providerType.set(providerType);
	}

	public StringProperty providerTypeProperty() {
		return providerType;
	}

	/***************
	 * Column property ( 4 )
	 *****************************************/

	private StringProperty credential = new SimpleStringProperty(this, "credential");

	@Column(name = "credential")
	public String getCredential() {
		return credential.get();
	}

	public void setCredential(String credential) {
		this.credential.set(credential);
	}

	public StringProperty credentialProperty() {
		return credential;
	}

	/***************
	 * Column property ( 5 )
	 *****************************************/

	private StringProperty listingName = new SimpleStringProperty(this, "listingName");

	@Column(name = "listing_name")
	public String getListingName() {
		return listingName.get();
	}

	public void setListingName(String listingName) {
		this.listingName.set(listingName);
	}

	public StringProperty listingNameProperty() {
		return listingName;
	}

	/***************
	 * Column property ( 6 )
	 *****************************************/

	private StringProperty federalId = new SimpleStringProperty(this, "federalId");

	@Column(name = "federal_id")
	public String getFederalId() {
		return federalId.get();
	}

	public void setFederalId(String federalId) {
		this.federalId.set(federalId);
	}

	public StringProperty federalIdProperty() {
		return federalId;
	}

	// Column 7
	private SimpleObjectProperty<Address> address = new SimpleObjectProperty<Address>(this, "address");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
	 * Column property ( 8 )
	 *****************************************/

	private SimpleBooleanProperty providerIsMro = new SimpleBooleanProperty(this, "providerIsMro");

	@Column(name = "provider_is_mro")
	public boolean getProviderIsMro() {
		return providerIsMro.get();
	}

	public void setProviderIsMro(boolean providerIsMro) {
		this.providerIsMro.set(providerIsMro);
	}

	public BooleanProperty providerIsMroProperty() {
		return providerIsMro;
	}

	/***************
	 * Column property ( 9 )
	 *****************************************/

	private StringProperty licenseState = new SimpleStringProperty(this, "licenseState");

	@Column(name = "license_state")
	public String getLicenseState() {
		return licenseState.get();
	}

	public void setLicenseState(String licenseState) {
		this.licenseState.set(licenseState);
	}

	public StringProperty licenseStateProperty() {
		return licenseState;
	}

	/***************
	 * Column property ( 10 )
	 *****************************************/

	private StringProperty classCode = new SimpleStringProperty(this, "classCode");

	@Column(name = "class_code")
	public String getClassCode() {
		return classCode.get();
	}

	public void setClassCode(String classCode) {
		this.classCode.set(classCode);
	}

	public StringProperty classCodeProperty() {
		return classCode;
	}

	/***************
	 * Column property ( 11 )
	 *****************************************/

	private StringProperty deaId = new SimpleStringProperty(this, "deaId");

	@Column(name = "dea_id")
	public String getDeaId() {
		return deaId.get();
	}

	public void setDeaId(String deaId) {
		this.deaId.set(deaId);
	}

	public StringProperty deaIdProperty() {
		return deaId;
	}

	// Column 12
	private ObjectProperty<Date> deaIdEffectiveDate = new SimpleObjectProperty<Date>();

	@Column(name = "dea_id_effective_date")
	@Temporal(TemporalType.DATE)
	public Date getDeaIdEffectiveDate() {
		return deaIdEffectiveDate.get();
	}

	public void setDeaIdEffectiveDate(Date deaIdEffectiveDate) {
		this.deaIdEffectiveDate.set(deaIdEffectiveDate);
	}

	public ObjectProperty<Date> deaIdEffectiveDateProperty() {
		return this.deaIdEffectiveDate;
	}

	// Column 13
	private ObjectProperty<Date> deaIdExpiryDate = new SimpleObjectProperty<Date>();

	@Column(name = "dea_id_expiry_date")
	@Temporal(TemporalType.DATE)
	public Date getDeaIdExpiryDate() {
		return deaIdExpiryDate.get();
	}

	public void setDeaIdExpiryDate(Date deaIdExpiryDate) {
		this.deaIdExpiryDate.set(deaIdExpiryDate);
	}

	public ObjectProperty<Date> deaIdExpiryDateProperty() {
		return this.deaIdExpiryDate;
	}

	/***************
	 * Column property ( 14 )
	 *****************************************/

	private StringProperty deaLicenseNo = new SimpleStringProperty(this, "deaLicenseNo");

	@Column(name = "dea_license_no")
	public String getDeaLicenseNo() {
		return deaLicenseNo.get();
	}

	public void setDeaLicenseNo(String deaLicenseNo) {
		this.deaLicenseNo.set(deaLicenseNo);
	}

	public StringProperty deaLicenseNoProperty() {
		return deaLicenseNo;
	}

	// Column 15
	private ObjectProperty<Date> deaLicenseEffectiveDate = new SimpleObjectProperty<Date>();

	@Column(name = "dea_license_effective_date")
	@Temporal(TemporalType.DATE)
	public Date getDeaLicenseEffectiveDate() {
		return deaLicenseEffectiveDate.get();
	}

	public void setDeaLicenseEffectiveDate(Date deaLicenseEffectiveDate) {
		this.deaLicenseEffectiveDate.set(deaLicenseEffectiveDate);
	}

	public ObjectProperty<Date> deaLicenseEffectiveDateProperty() {
		return this.deaLicenseEffectiveDate;
	}

	// Column 16
	private ObjectProperty<Date> deaLicenseExpiryDate = new SimpleObjectProperty<Date>();

	@Column(name = "dea_license_expiry_date")
	@Temporal(TemporalType.DATE)
	public Date getDeaLicenseExpiryDate() {
		return deaLicenseExpiryDate.get();
	}

	public void setDeaLicenseExpiryDate(Date deaLicenseExpiryDate) {
		this.deaLicenseExpiryDate.set(deaLicenseExpiryDate);
	}

	public ObjectProperty<Date> deaLicenseExpiryDateProperty() {
		return this.deaLicenseExpiryDate;
	}

	/***************
	 * Column property ( 17 )
	 *****************************************/

	private StringProperty speciality = new SimpleStringProperty(this, "speciality");

	@Column(name = "speciality")
	public String getSpeciality() {
		return speciality.get();
	}

	public void setSpeciality(String speciality) {
		this.speciality.set(speciality);
	}

	public StringProperty specialityProperty() {
		return speciality;
	}

	/*// Column 18
	private ObjectProperty<Date> medGrpEffectiveDt = new SimpleObjectProperty<Date>();

	@Column(name = "med_grp_effective_dt")
	@Temporal(TemporalType.DATE)
	public Date getMedGrpEffectiveDt() {
		return medGrpEffectiveDt.get();
	}

	public void setMedGrpEffectiveDt(Date medGrpEffectiveDt) {
		this.medGrpEffectiveDt.set(medGrpEffectiveDt);
	}

	public ObjectProperty<Date> medGrpEffectiveDtProperty() {
		return this.medGrpEffectiveDt;
	}

	// Column 19
	private ObjectProperty<Date> medGrpTermDt = new SimpleObjectProperty<Date>();

	@Column(name = "med_grp_term_dt")
	@Temporal(TemporalType.DATE)
	public Date getMedGrpTermDt() {
		return medGrpTermDt.get();
	}

	public void setMedGrpTermDt(Date medGrpTermDt) {
		this.medGrpTermDt.set(medGrpTermDt);
	}

	public ObjectProperty<Date> medGrpTermDtProperty() {
		return this.medGrpTermDt;
	}*/

	/***************
	 * Column property ( 20 )
	 *****************************************/

	private StringProperty medicalType = new SimpleStringProperty(this, "medicalType");

	@Column(name = "medical_type")
	public String getMedicalType() {
		return medicalType.get();
	}

	public void setMedicalType(String medicalType) {
		this.medicalType.set(medicalType);
	}

	public StringProperty medicalTypeProperty() {
		return medicalType;
	}

	/***************
	 * Column property ( 21 )
	 *****************************************/

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
	
	private List<ProviderSchException> providerSchExceptions;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="provider" , cascade=CascadeType.ALL)
	public List<ProviderSchException> getProviderSchExceptions() {
		return providerSchExceptions;
	}

	public void setProviderSchExceptions(List<ProviderSchException> providerSchExceptions) {
		this.providerSchExceptions = providerSchExceptions;
	}
	
	private List<ProviderSchedule> providerSchedules;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="provider" , cascade=CascadeType.ALL)
	public List<ProviderSchedule> getProviderSchedules() {
		return providerSchedules;
	}

	public void setProviderSchedules(List<ProviderSchedule> providerSchedules) {
		this.providerSchedules = providerSchedules;
	}
	
    private List<ProviderSchRecurException> providerSchRecurExceptions;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="provider" ,orphanRemoval=true)
	
	public List<ProviderSchRecurException> getProviderSchRecurException() {
		return providerSchRecurExceptions;
	}

	public void setProviderSchRecurException(List<ProviderSchRecurException> providerSchRecurExceptions) {
		this.providerSchRecurExceptions = providerSchRecurExceptions;
		
	}
	
	private List<Patient> patients;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="pcp" , cascade=CascadeType.ALL)
	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
