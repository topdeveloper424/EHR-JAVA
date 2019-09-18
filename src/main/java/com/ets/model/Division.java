package com.ets.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
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
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 17-02-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of Division Class Description: Entity class Copyright
 * 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 */
@Entity
@Table(name = "division")

public class Division {

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

	private StringProperty descrip = new SimpleStringProperty(this, "descrip");

	@Column(name = "descrip")
	public String getDescrip() {
		return descrip.get();
	}

	public void setDescrip(String descrip) {
		this.descrip.set(descrip);
	}

	public StringProperty descripProperty() {
		return descrip;
	}

	/***************
	 * Column property ( 4 )
	 *****************************************/

	private StringProperty manager = new SimpleStringProperty(this, "manager");

	@Column(name = "manager")
	public String getManager() {
		return manager.get();
	}

	public void setManager(String manager) {
		this.manager.set(manager);
	}

	public StringProperty managerProperty() {
		return manager;
	}

	/***************
	 * Column property ( 5 )
	 *****************************************/

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

	/*
	 * private StringProperty telephone = new SimpleStringProperty(this,
	 * "telephone");
	 * 
	 * @Column(name = "telephone") public String getTelephone() { return
	 * telephone.get(); }
	 * 
	 * public void setTelephone(String telephone) {
	 * this.telephone.set(telephone); }
	 * 
	 * public StringProperty telephoneProperty() { return telephone; }
	 * 
	 *//***************
		 * Column property (6 )
		 *****************************************/
	/*
	 * 
	 * private StringProperty ext = new SimpleStringProperty(this, "ext");
	 * 
	 * @Column(name = "ext") public String getExt() { return ext.get(); }
	 * 
	 * public void setExt(String ext) { this.ext.set(ext); }
	 * 
	 * public StringProperty extProperty() { return ext; }
	 * 
	 * 
	 *//***************
		 * Column property ( 7 )
		 *****************************************/
	/*
	 * 
	 * private StringProperty fax = new SimpleStringProperty(this, "fax");
	 * 
	 * @Column(name = "fax") public String getFax() { return fax.get(); }
	 * 
	 * public void setFax(String fax) { this.fax.set(fax); }
	 * 
	 * public StringProperty faxProperty() { return fax; }
	 * 
	 * 
	 *//***************
		 * Column property ( 8 )
		 *****************************************//*
												 * 
												 * private StringProperty email
												 * = new
												 * SimpleStringProperty(this,
												 * "email");
												 * 
												 * @Column(name = "email")
												 * public String getEmail() {
												 * return email.get(); }
												 * 
												 * public void setEmail(String
												 * email) {
												 * this.email.set(email); }
												 * 
												 * public StringProperty
												 * emailProperty() { return
												 * email; }
												 */

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
	
	
	private List<DepartmentUnit> departmentunit;

	@OneToMany(fetch = FetchType.LAZY , mappedBy="division" , cascade=CascadeType.ALL)
	public List<DepartmentUnit> getDepartmentunit() {
		return departmentunit;
	}

	public void setDepartmentunit(List<DepartmentUnit> departmentunit) {
		this.departmentunit = departmentunit;
	}

	public Division() {

	}

	

}
