package com.ets.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 25-07-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of DepartmentUnit Class Description: Entity class
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 */

@Entity
@Table(name = "department_unit")

public class DepartmentUnit {

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

	private SimpleObjectProperty<Division> division = new SimpleObjectProperty<Division>(this, "division");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "division_id")
	public Division getDivision() {
		return division.get();
	}

	public void setDivision(Division division) {
		this.division.set(division);
	}

	public SimpleObjectProperty<Division> divisionProperty() {
		return division;
	}

	private StringProperty supervisor = new SimpleStringProperty(this, "supervisor");

	@Column(name = "supervisor")
	public String getSupervisor() {
		return supervisor.get();
	}

	public void setSupervisor(String supervisor) {
		this.supervisor.set(supervisor);
	}

	public StringProperty supervisorProperty() {
		return supervisor;
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
    private List<CompanyProtocol> companyProtocol ;
	
	@OneToMany(fetch = FetchType.EAGER , mappedBy="departmentUnit" , cascade=CascadeType.ALL)
	public List<CompanyProtocol> getCompanyProtocol() {
		return companyProtocol;
	}

	public void setCompanyProtocol(List<CompanyProtocol> companyProtocol) {
		this.companyProtocol = companyProtocol;
	}
	public DepartmentUnit() {

	}

}
