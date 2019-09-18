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
@Table(name = "referal_provider")

public class ReferalProvider {
	
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
	 * Column property ( 5 )
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
	
	
	// Column 6
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
		
		
		/***************
		 * Column property ( 9 )
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
		 * Column property ( 10 )
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
		
		/***************
		 * Column property ( 11 )
		 *****************************************/

		private StringProperty referType = new SimpleStringProperty(this, "referType");

		@Column(name = "refer_type")
		public String getReferType() {
			return referType.get();
		}

		public void setReferType(String referType) {
			this.referType.set(referType);
		}

		public StringProperty referTypeProperty() {
			return referType;
		}
		
		/***************
		 * Column property ( 11 )
		 *****************************************/

		private StringProperty refProviderType = new SimpleStringProperty(this, "refProviderType");

		@Column(name = "ref_provider_type")
		public String getRefProviderType() {
			return refProviderType.get();
		}

		public void setRefProviderType(String refProviderType) {
			this.refProviderType.set(refProviderType);
		}

		public StringProperty refProviderTypeProperty() {
			return refProviderType;
		}
		
		

		/***************
		 * Column property ( 12 )
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
		 * Column property ( 13 )
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
		 * Column property ( 14 )
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

		// Column 15
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

		// Column 16
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
		
	/*	// Column 18
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
		}
		*/
		
		
		
		private List<PatientVisit> patientVisits ;
		@OneToMany(fetch = FetchType.LAZY , mappedBy="referredBy" , cascade=CascadeType.ALL)
		public List<PatientVisit> getPatientVisits() {
			return patientVisits;
		}

		public void setPatientVisits(List<PatientVisit> patientVisits) {
			this.patientVisits = patientVisits;
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


	public ReferalProvider() {
		
	}

}
