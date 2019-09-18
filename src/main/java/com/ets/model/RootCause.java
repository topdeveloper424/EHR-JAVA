package com.ets.model;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RootCause Class
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

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "root_cause")

public class RootCause {
	
	private  IntegerProperty id = new SimpleIntegerProperty(this, "id");

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

	
	private  StringProperty cause = new SimpleStringProperty(this, "cause");

	@Column(name = "cause")
	public  String getCause() {
		return cause.get();
	}

	public  void setCause(String cause) {
		this.cause.set(cause);
	}

	public StringProperty causeProperty() {
		return cause;
	}
	
	private  StringProperty descrp = new SimpleStringProperty(this,
			"descrp");

	@Column(name = "descrp")
	public  String getDescrp() {
		return descrp.get();
	}

	public  void setDescrp(String descrp) {
		this.descrp.set(descrp);
	}

	public StringProperty descrpProperty() {
		return descrp;
	}
	
	private  StringProperty wc10Code = new SimpleStringProperty(this,
			"wc10Code");

	@Column(name = "wc10_code")
	public  String getWc10Code() {
		return wc10Code.get();
	}

	public  void setWc10Code(String wc10Code) {
		this.wc10Code.set(wc10Code);
	}

	public StringProperty wc10CodeProperty() {
		return wc10Code;
	}


	private  SimpleBooleanProperty inactive = new SimpleBooleanProperty(
			this, "inactive");

	@Column(name = "inactive")
	public  boolean getInactive() {
		return inactive.get();
	}

	public  void setInactive(boolean inactive) {
		this.inactive.set(inactive);
	}

	public BooleanProperty inactiveProperty() {
		return inactive;
	}

	public RootCause() {
		
	}
	
}
