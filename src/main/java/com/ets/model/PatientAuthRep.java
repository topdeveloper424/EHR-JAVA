package com.ets.model;

import java.util.List;

import javax.persistence.CascadeType;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientAuthRep Class
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "patient_auth_rep")

public class PatientAuthRep {
	
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
			
			private StringProperty gender = new SimpleStringProperty(this, "gender");

			@Column(name = "gender")
			public String getGender() {
				return gender.get();
			}

			public void setGender(String gender) {
				this.gender.set(gender);
			}

			public StringProperty genderProperty() {
				return gender;
			}

	public PatientAuthRep() {
		
	}
	
	private List<RepresentRelation> repReltn;
	@OneToMany(fetch = FetchType.LAZY, mappedBy= "rep",cascade=CascadeType.ALL)
    public List<RepresentRelation> getRepReltn() {
		return repReltn;
	}

	public void setRepReltn(List<RepresentRelation> repReltn) {
		this.repReltn = repReltn;
	}
	

}
