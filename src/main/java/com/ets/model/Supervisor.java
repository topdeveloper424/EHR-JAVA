package com.ets.model;



import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.CascadeType;
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

/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 17-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Supervisor Class
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
@Table(name = "supervisor")

public class Supervisor {

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

	/***************
	 * Column property ( 3 )
	 *****************************************/

	private StringProperty fisrtName = new SimpleStringProperty(this, "fisrtName");

	@Column(name = "fisrtName")
	public String getFisrtName() {
		return fisrtName.get();
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName.set(fisrtName);
	}

	public StringProperty fisrtNameProperty() {
		return fisrtName;
	}

	/***************
	 * Column property ( 4 )
	 *****************************************/

	private StringProperty middleName = new SimpleStringProperty(this, "middleName");

	@Column(name = "middleName")
	public String getMiddleName() {
		return middleName.get();
	}

	public void setMiddleName(String middleName) {
		this.middleName.set(middleName);
	}

	public StringProperty middleNameProperty() {
		return middleName;
	}

	/***************
	 * Column property ( 5 )
	 *****************************************/

	private StringProperty lastName = new SimpleStringProperty(this, "lastName");

	@Column(name = "lastName")
	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}

	/***************
	 * Column property ( 6 )
	 *****************************************/

	private StringProperty listingName = new SimpleStringProperty(this, "listingName");

	@Column(name = "listingName")
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
	 * Column property ( 7 )
	 *****************************************/

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

	/***************
	 * Column property ( 9 )
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

	// Column 10
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

	public Supervisor() {

	}

}
