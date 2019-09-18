package com.ets.model;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientDrivingLicense Class
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "patient_driving_license")

public class PatientDrivingLicense {

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
	
	// Column 2
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
	
	// Column 2
		private StringProperty licenseClass = new SimpleStringProperty(this, "licenseClass");

		@Column(name = "license_class")
		public String getLicenseClass() {
			return licenseClass.get();
		}

		public void setLicenseClass(String licenseClass) {
			this.licenseClass.set(licenseClass);
		}

		public StringProperty licenseClassProperty() {
			return licenseClass;
		}
		
		// Column 2
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
				
				// Column 12
				private ObjectProperty<Date> licenseExpiry = new SimpleObjectProperty<Date>();

				@Column(name = "license_expiry")
				@Temporal(TemporalType.DATE)
				public Date getLicenseExpiry() {
					
					return licenseExpiry.get();
					
				}

				public void setLicenseExpiry(Date licenseExpiry) {
					
					this.licenseExpiry.set(licenseExpiry);
					
				}

				public ObjectProperty<Date> licenseExpiryProperty() {
					
					return this.licenseExpiry;
					
				}
				
				// Column 2
				private StringProperty cdlOrClp = new SimpleStringProperty(this, "cdlOrClp");

				@Column(name = "cdl_or_clp")
				public String getCdlOrClp() {
					return cdlOrClp.get();
				}

				public void setCdlOrClp(String cdlOrClp) {
					this.cdlOrClp.set(cdlOrClp);
					
				}

				public StringProperty cdlOrClpProperty() {
					return cdlOrClp;
				}
				
				/***************
				 * Column property ( 4 )
				 *****************************************/

				/*private  SimpleBooleanProperty intraStateOnly = new SimpleBooleanProperty(
						this, "intraStateOnly");

				@Column(name = "intra_state_only")
				public  boolean getIntraStateOnly() {
					return intraStateOnly.get();
				}

				public  void setIntraStateOnly(boolean intraStateOnly) {
					this.intraStateOnly.set(intraStateOnly);
				}

				public BooleanProperty intraStateOnlyProperty() {
					return intraStateOnly;
				}
	*/
	public PatientDrivingLicense() {
		
	}

}
