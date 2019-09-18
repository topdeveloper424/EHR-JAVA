package com.ets.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

/**
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 12-09-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of Clinician Class Description: Entity class
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 */

@Entity
@Table(name="clinician")


public class Clinician {

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

	// Collumn 3

	private StringProperty type = new SimpleStringProperty(this, "type");

	@Column(name = "type")
	public String getType() {
		return type.get();
	}

	public void setType(String type) {
		this.type.set(type);
	}

	public StringProperty typeProperty() {
		return type;
	}

	// Column 4
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

	// Column 5
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

	// Column 6
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

	// Column 7
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
	
	// Column 7
		private StringProperty blockSchedule = new SimpleStringProperty(this, "blockSchedule");

		@Column(name = "block_schedule")
		public String getBlockSchedule() {
			return blockSchedule.get();
		}

		public void setBlockSchedule(String blockSchedule) {
			this.blockSchedule.set(blockSchedule);
		}

		public StringProperty blockScheduleProperty() {
			return blockSchedule;
		}

	// Column 7
	private StringProperty lookupName = new SimpleStringProperty(this, "lookupName");

	@Column(name = "lookup_name")
	public String getLookupName() {
		return lookupName.get();
	}

	public void setLookupName(String lookupName) {
		this.lookupName.set(lookupName);
	}

	public StringProperty lookupNameProperty() {
		return lookupName;
	}

	// Column 8

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

	// Collumn 9

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

	// Collumn 10

	private StringProperty licenseNo = new SimpleStringProperty(this, "licenseNo");

	@Column(name = "license_no")
	public String getLicenseNo() {
		return licenseNo.get();
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo.set(licenseNo);
	}

	public StringProperty licenseNoProperty() {
		return licenseNo;
	}

	// Column 11
	private ObjectProperty<Date> licenseEffectiveDate = new SimpleObjectProperty<Date>();

	@Column(name = "dea_license_effective_date")
	@Temporal(TemporalType.DATE)
	public Date getLicenseEffectiveDate() {
		return licenseEffectiveDate.get();
	}

	public void setLicenseEffectiveDate(Date licenseEffectiveDate) {
		this.licenseEffectiveDate.set(licenseEffectiveDate);
	}

	public ObjectProperty<Date> licenseEffectiveDateProperty() {
		return this.licenseEffectiveDate;
	}

	// Column 12
	private ObjectProperty<Date> licenseExpiryDate = new SimpleObjectProperty<Date>();

	@Column(name = "dea_license_expiry_date")
	@Temporal(TemporalType.DATE)
	public Date getLicenseExpiryDate() {
		return licenseExpiryDate.get();
	}

	public void setLicenseExpiryDate(Date licenseExpiryDate) {
		this.licenseExpiryDate.set(licenseExpiryDate);
	}

	public ObjectProperty<Date> licenseExpiryDateProperty() {
		return this.licenseExpiryDate;
	}

	// Column 13
	private StringProperty caohcNo = new SimpleStringProperty(this, "caohcNo");

	@Column(name = "caohc_no")
	public String getCaohcNo() {
		return caohcNo.get();
	}

	public void setCaohcNo(String caohcNo) {
		this.caohcNo.set(caohcNo);
	}

	public StringProperty caohcNoProperty() {
		return caohcNo;
	}

	// Column 14
	private SimpleObjectProperty<Clinic> homeClinic = new SimpleObjectProperty<Clinic>(this, "homeClinic");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "home_clinic_id")
	public Clinic getHomeClinic() {
		return homeClinic.get();
	}

	public void setHomeClinic(Clinic homeClinic) {
		this.homeClinic.set(homeClinic);
	}

	public SimpleObjectProperty<Clinic> homeClinicProperty() {
		return homeClinic;
	}

	// Column 15

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

	public Clinician() {

	}

}
