package com.ets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "carrier_rule")

public class CarrierRule {
	
	/***************
	 * Column property ( 1 )
	 *****************************************/

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
	
	/***************
	 * Column property ( 2 )
	 *****************************************/

	private  StringProperty authPhone = new SimpleStringProperty(this,"authPhone");
	
	@Column(name = "auth_phone")
	public  String getAuthPhone(){
		return authPhone.get();
	}
	
	public void setAuthPhone(String authPhone){
		this.authPhone.set(authPhone);
	}
	
	public StringProperty authPhoneProperty(){
		return authPhone;
	}
	
	
	/***************
	 * Column property ( 3 )
	 *****************************************/

	private  StringProperty authContact = new SimpleStringProperty(this,"authContact");
	
	@Column(name = "auth_contact")
	public  String getAuthContact(){
		return authContact.get();
	}
	
	public void setAuthContact(String authContact){
		this.authContact.set(authContact);
	}
	
	public StringProperty authContactProperty(){
		return authContact;
	}
	
	/***************
	 * Column property ( 4 )
	 *****************************************/

	private  SimpleBooleanProperty authReq = new SimpleBooleanProperty(
			this, "authReq");

	@Column(name = "auth_req")
	public  boolean getAuthReq() {
		return authReq.get();
	}

	public  void setAuthReq(boolean authReq) {
		this.authReq.set(authReq);
	}

	public BooleanProperty authReqProperty() {
		return authReq;
	}
	
	private  SimpleBooleanProperty excludeXray = new SimpleBooleanProperty(
			this, "excludeXray");

	@Column(name = "exclude_xray")
	public  boolean getExcludeXray() {
		return excludeXray.get();
	}

	public  void setExcludeXray(boolean excludeXray) {
		this.excludeXray.set(excludeXray);
	}

	public BooleanProperty excludeXrayProperty() {
		return excludeXray;
	}
	
	private  SimpleBooleanProperty excludeSupplies = new SimpleBooleanProperty(
			this, "excludeSupplies");

	@Column(name = "exclude_supplies")
	public  boolean getExcludeSupplies() {
		return excludeSupplies.get();
	}

	public  void setExcludeSupplies(boolean excludeSupplies) {
		this.excludeSupplies.set(excludeSupplies);
	}

	public BooleanProperty excludeSuppliesProperty() {
		return excludeSupplies;
	}
	
	
	private  SimpleBooleanProperty excludeMed = new SimpleBooleanProperty(
			this, "excludeMed");

	@Column(name = "exclude_med")
	public  boolean getExcludeMed() {
		return excludeMed.get();
	}

	public  void setExcludeMed(boolean excludeMed) {
		this.excludeMed.set(excludeMed);
	}

	public BooleanProperty excludeMedProperty() {
		return excludeMed;
	}
	
	

	public CarrierRule() {
		
	}

}
