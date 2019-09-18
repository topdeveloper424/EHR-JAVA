package com.ets.model;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientAddlContactInfo Class
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "patient_addl_contact_info")

public class PatientAddlContactInfo {

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
		private StringProperty fatherName = new SimpleStringProperty(this, "fatherName");

		@Column(name = "father_name")
		public String getFatherName() {
			return fatherName.get();
		}

		public void setFatherName(String fatherName) {
			this.fatherName.set(fatherName);
		}

		public StringProperty fatherNameProperty() {
			return fatherName;
		}
	
		// Column 2
				private StringProperty patientType = new SimpleStringProperty(this, "patientType");

				@Column(name = "patient_type")
				public String getPatientType() {
					return patientType.get();
				}

				public void setPatientType(String patientType) {
					this.patientType.set(patientType);
				}

				public StringProperty patientTypeProperty() {
					return patientType;
				}
				
				// Column 2
				private StringProperty motherName = new SimpleStringProperty(this, "motherName");

				@Column(name = "mother_name")
				public String getMotherName() {
					return motherName.get();
				}

				public void setMotherName(String motherName) {
					this.motherName.set(motherName);
				}

				public StringProperty motherNameProperty() {
					return motherName;
				}
				
				// Column 2
				private StringProperty relation = new SimpleStringProperty(this, "relation");

				@Column(name = "relation")
				public String getRelation() {
					return relation.get();
				}

				public void setRelation(String relation) {
					this.relation.set(relation);
				}

				public StringProperty relationProperty() {
					return relation;
				}
				
				// Column 2
				private StringProperty maidenName = new SimpleStringProperty(this, "maidenName");

				@Column(name = "maiden_name")
				public String getMaidenName() {
					return maidenName.get();
				}

				public void setMaidenName(String maidenName) {
					this.maidenName.set(maidenName);
				}

				public StringProperty maidenNameProperty() {
					return maidenName;
				}
				
				// Column 2
				private StringProperty emergencyContact = new SimpleStringProperty(this, "emergencyContact");

				@Column(name = "emergency_contact")
				public String getEmergencyContact() {
					return emergencyContact.get();
				}

				public void setEmergencyContact(String emergencyContact) {
					this.emergencyContact.set(emergencyContact);
				}

				public StringProperty emergencyContactProperty() {
					return emergencyContact;
				}
				
								
				// Column 2
				private StringProperty nextOfKinName = new SimpleStringProperty(this, "nextOfKinName");

				@Column(name = "next_of_kin_name")
				public String getNextOfKinName() {
					return nextOfKinName.get();
				}

				public void setNextOfKinName(String nextOfKinName) {
					this.nextOfKinName.set(nextOfKinName);
				}

				public StringProperty nextOfKinNameProperty() {
					return nextOfKinName;
				}
				
				/*// Column 2
				private StringProperty patientCity = new SimpleStringProperty(this, "patientCity");

				@Column(name = "patient_city")
				public String getPatientCity() {
					return patientCity.get();
				}

				public void setPatientCity(String patientCity) {
					this.patientCity.set(patientCity);
				}

				public StringProperty patientCityProperty() {
					return patientCity;
				}
				
				// Column 2
				private StringProperty patientState = new SimpleStringProperty(this, "patientState");

				@Column(name = "license_state")
				public String getPatientState() {
					return patientState.get();
				}

				public void setPatientState(String patientState) {
					this.patientState.set(patientState);
					
				}

				public StringProperty patientStateProperty() {
					return patientState;
				}
				
				// Column 2
				private StringProperty patientZip = new SimpleStringProperty(this, "patientZip");

				@Column(name = "patient_zip")
				public String getPatientZip() {
					return patientZip.get();
				}

				public void setPatientZip(String patientZip) {
					this.patientZip.set(patientZip);
				}

				public StringProperty patientZipProperty() {
					return patientZip;
				}*/
				
				
				// Column 13
				private SimpleObjectProperty<Address> address = new SimpleObjectProperty<Address>(this, "address");

				@OneToOne(fetch = FetchType.EAGER)
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
	public PatientAddlContactInfo() {
		
	}

}
