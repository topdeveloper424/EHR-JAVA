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
 *File Creation Date: 25-03-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Pharmacy Class
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
@Table(name = "pharmacy")

public class Pharmacy {

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

	/***************
	 * Column property ( 4 )
	 *****************************************/

	private StringProperty localAddress = new SimpleStringProperty(this, "localAddress");

	@Column(name = "local_address")
	public String getLocalAddress() {
		return localAddress.get();
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress.set(localAddress);
	}

	public StringProperty localAddressProperty() {
		return localAddress;
	}

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
	 * Column property ( 13 )
	 *****************************************/

	private StringProperty contact = new SimpleStringProperty(this, "contact");

	@Column(name = "contact")
	public String getContact() {
		return contact.get();
	}

	public void setContact(String contact) {
		this.contact.set(contact);
	}

	public StringProperty contactProperty() {
		return contact;
	}

	/***************
	 * Column property ( 13 )
	 *****************************************/

	private StringProperty instruction = new SimpleStringProperty(this, "instruction");

	@Column(name = "instruction")
	public String getInstruction() {
		return instruction.get();
	}

	public void setInstruction(String instruction) {
		this.instruction.set(instruction);
	}

	public StringProperty instructionProperty() {
		return instruction;
	}

	/***************
	 * Column property ( 14 )
	 *****************************************/

	private SimpleBooleanProperty openHour = new SimpleBooleanProperty(this, "openHour");

	@Column(name = "open_hour")
	public boolean getOpenHour() {
		return openHour.get();
	}

	public void setOpenHour(boolean openHour) {
		this.openHour.set(openHour);
	}

	public BooleanProperty openHourProperty() {
		return openHour;
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

	public Pharmacy() {

	}

}
