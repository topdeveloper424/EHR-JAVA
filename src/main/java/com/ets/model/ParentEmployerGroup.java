package com.ets.model;

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

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 17-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ParentEmployerGroup Class
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
@Table(name = "parent_employer_group")

public class ParentEmployerGroup {

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

	private StringProperty localAddress = new SimpleStringProperty(this, "localAddress");

	@Column(name = "local_address")
	public String getLocalAddress() {
		return localAddress.get();
	}

	public void setlocalAddress(String localAddress) {
		this.localAddress.set(localAddress);
	}

	public StringProperty localAddressProperty() {
		return localAddress;
	}

	private StringProperty fein = new SimpleStringProperty(this, "fein");

	@Column(name = "fein")
	public String getFein() {
		return fein.get();
	}

	public void setFein(String fein) {
		this.fein.set(fein);
	}

	public StringProperty feinProperty() {
		return fein;
	}

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

	private SimpleObjectProperty<SICCode> sicCode = new SimpleObjectProperty<SICCode>(this, "sicCode");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sic_code_id")
	public SICCode getSicCode() {
		return sicCode.get();
	}

	public void setSicCode(SICCode sicCode) {
		this.sicCode.set(sicCode);
	}

	public SimpleObjectProperty<SICCode> sicCodeProperty() {
		return sicCode;
	}

	private SimpleObjectProperty<NAICSCode> naicsCode = new SimpleObjectProperty<NAICSCode>(this, "naicsCode");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "naics_code_id")
	public NAICSCode getNaicsCode() {
		return naicsCode.get();
	}

	public void setNaicsCode(NAICSCode naicsCode) {
		this.naicsCode.set(naicsCode);
	}

	public SimpleObjectProperty<NAICSCode> naicsCodeProperty() {
		return naicsCode;
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

	public ParentEmployerGroup() {
		// TODO Auto-generated constructor stub
	}

}
